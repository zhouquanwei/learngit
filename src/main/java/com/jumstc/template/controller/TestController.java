package com.jumstc.template.controller;

import com.jumstc.platform.common.base.BaseResult;
import com.jumstc.platform.common.base.LogTypeEnum;
import com.jumstc.platform.common.util.JsonUtil;
import com.jumstc.template.aspect.MethodLogger;
import com.jumstc.template.client.AtfFeignClient;
import com.jumstc.template.dto.request.SaveCompanyDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Desc
 * 
 * @author 张云和
 * @date 2020/5/20 11:23 上午
 */
@RestController
@Slf4j
public class TestController {

    @Resource
    private AtfFeignClient atfFeignClient;

    @GetMapping("test/save")
    public void test(@RequestBody SaveCompanyDTO saveCompanyDTO) {

        BaseResult baseResult = atfFeignClient.save(new SaveCompanyDTO());
        log.info("result = {}", JsonUtil.toString(baseResult));
    }

    @GetMapping("get")
    @MethodLogger(logType = LogTypeEnum.RESPONSE)
    public BaseResult get(String code) {

        return atfFeignClient.get(code);
    }
}
