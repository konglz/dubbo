package com.alibaba.demo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.demo.api.TestReq;
import com.alibaba.dubbo.demo.api.TestRes;
import com.alibaba.dubbo.demo.api.TestService;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = TestService.class, protocol = {"dubbo", "jsonrpc"})
public class TestServiceImpl implements TestService {

    @Override
    public TestRes doTest(TestReq req) {
        TestRes res = new TestRes();
        res.setContent(req.getContent() + "|" + System.currentTimeMillis());
        return res;
    }
}
