package com.jumstc.template.client;

import com.jumstc.platform.common.base.BaseResult;
import com.jumstc.template.client.hystrix.AtfFeignClientFallback;
import com.jumstc.template.dto.request.SaveCompanyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Desc
 *
 * @author 张云和
 * @date 2020/6/2 8:55 上午
 */
@FeignClient(name = "atf-ms", fallbackFactory = AtfFeignClientFallback.class)
public interface AtfFeignClient {

    /**
     * 接口DOC注释
     * 
     * @param saveCompanyDTO
     * @return
     */
    @PostMapping("/api/did/save-company-did")
    BaseResult<String> save(@RequestBody SaveCompanyDTO saveCompanyDTO);

    /**
     * 接口DOC注释
     * 
     * @param param
     * @return
     */
    @GetMapping(value = "/api/did/query-company-dids")
    BaseResult get(@RequestParam(value = "companyCode") String param);
}