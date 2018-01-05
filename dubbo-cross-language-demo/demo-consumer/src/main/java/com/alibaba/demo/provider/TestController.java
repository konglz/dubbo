package com.alibaba.demo.provider;

import javax.annotation.Resource;

import com.alibaba.dubbo.demo.api.TestReq;
import com.alibaba.dubbo.demo.api.TestRes;
import com.alibaba.dubbo.demo.api.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping(value = "/")
    public String goTest(String content) {
        TestReq req = new TestReq();
        req.setContent(content);
        TestRes res = testService.doTest(req);
        return res.getContent();
    }
}
