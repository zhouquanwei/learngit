package com.jumstc.template.aspect;

import com.jumstc.platform.common.base.LogTypeEnum;

import java.lang.annotation.*;

/**
 * controller层日志打印注解
 *
 * @author 张云和
 * @date 2020/5/18 1:41 下午
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MethodLogger {

    /**
     * 日志打印类型， 默认请求日志全部打印
     * 
     * @return
     */
    LogTypeEnum logType() default LogTypeEnum.FULL;

}
