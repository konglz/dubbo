package com.alibaba.dubbo.demo.api;

import com.googlecode.jsonrpc4j.JsonRpcParam;

public interface TestService {

    TestRes doTest(@JsonRpcParam("req") TestReq req);

}
