package com.jumstc.template.aspect;

import com.jumstc.platform.common.base.LogTypeEnum;
import com.jumstc.platform.common.util.JsonUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * AOP日志处理类
 *
 * @author 张云和
 * @date 2020/5/18 1:41 下午
 */
@Aspect
@Component
public class LoggerHandler {
    /**
     * 切点 --- 包含HttpLogger注解
     */
    @Pointcut("@annotation(com.jumstc.template.aspect.MethodLogger)")
    protected void methodLogger() {}

    @Around("methodLogger()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        Signature signature = joinPoint.getSignature();
        MethodSignature msg = (MethodSignature)signature;
        Object target = joinPoint.getTarget();
        // 获取注解标注的方法
        Method method = target.getClass().getMethod(msg.getName(), msg.getParameterTypes());

        Logger log = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
        String methodName = joinPoint.getSignature().getName();
        // 通过方法获取注解
        MethodLogger methodLogger = method.getAnnotation(MethodLogger.class);
        // 是否打印入参数
        if (methodLogger.logType().equals(LogTypeEnum.FULL)
            || methodLogger.logType().equals(LogTypeEnum.REQUEST_PARAM)) {
            String args = JsonUtil.toString(joinPoint.getArgs());
            log.info("method: {}, args: {}", methodName, args);
        }

        Object result = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        if (methodLogger.logType().equals(LogTypeEnum.REQUEST_PARAM)) {
            // 不打印出参数，针对列表类型的不打印
            log.info("method: {}, 耗时: {}", methodName, elapsedTime);
        } else {
            log.info("method: {}, result: {}, 耗时: {}ms", methodName, JsonUtil.toString(result), elapsedTime);
        }
        return result;
    }
}
