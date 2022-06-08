package com.jumstc.template.client.hystrix;

import com.jumstc.platform.common.base.BaseResult;
import com.jumstc.platform.common.exception.ServiceException;
import com.jumstc.platform.common.util.FeignUtil;
import com.jumstc.template.client.AtfFeignClient;
import com.jumstc.template.dto.request.SaveCompanyDTO;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 异常熔断处理
 * 
 * @author 张云和
 * @date 2020/5/20 11:00 上午
 */
@Component
@Slf4j
public class AtfFeignClientFallback implements FallbackFactory<AtfFeignClient> {

    @Override
    public AtfFeignClient create(Throwable throwable) {
        log.error("调用ATF失败：", throwable);
        return new AtfFeignClient() {
            @Override
            public BaseResult<String> save(SaveCompanyDTO saveCompanyDTO) {
                ServiceException serviceException = FeignUtil.decodeFeignException("调用ATF保存业务公司信息", throwable);
                return BaseResult.createFailResult(serviceException.getMsg(), serviceException.getCode());
            }

            @Override
            public BaseResult get(@RequestParam String param) {
                ServiceException serviceException = FeignUtil.decodeFeignException("调用ATF获取务公司信息", throwable);
                return BaseResult.createFailResult(serviceException.getMsg(), serviceException.getCode());
            }
        };
    }
}
