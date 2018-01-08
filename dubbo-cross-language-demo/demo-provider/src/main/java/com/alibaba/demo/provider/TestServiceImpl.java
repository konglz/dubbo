package com.alibaba.demo.provider;

import java.util.Map;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.demo.api.DepartmentReq;
import com.alibaba.dubbo.demo.api.NameReq;
import com.alibaba.dubbo.demo.api.TestReq;
import com.alibaba.dubbo.demo.api.TestRes;
import com.alibaba.dubbo.demo.api.TestService;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = TestService.class, protocol = {"dubbo", "jsonrpc"})
public class TestServiceImpl implements TestService {

    @Override
    public TestRes invokeVoid() {
        return newResult("void");
    }

    @Override
    public TestRes invokeSingleString(String single) {
        return newResult(single);
    }

    @Override
    public TestRes invokeSingleInteger(Integer num) {
        return newResult(num);
    }

    @Override
    public TestRes invokeSingleInt(int num) {
        return newResult(num);
    }

    @Override
    public TestRes invokeSingleFloat(Float num) {
        return newResult(num);
    }

    @Override
    public TestRes invokeSingleFlo(float num) {
        return newResult(num);
    }

    @Override
    public TestRes invokeSingleBoolean(Boolean bool) {
        return newResult(bool);
    }

    @Override
    public TestRes invokeSingleBool(boolean bool) {
        return newResult(bool);
    }

    @Override
    public TestRes invokeArray(String[] values) {
        return newResult(StringUtils.join(values, ","));
    }

    @Override
    public TestRes invokeMap(Map<String, String> map) {
        return newResult(map);
    }

    @Override
    public TestRes invokeStringAndArray(String single, String[] values) {
        return newResult(single + "|" + StringUtils.join(values, ","));
    }

    @Override
    public TestRes invokeObjectAndString(TestReq req, String single) {
        return newResult(single + "|" + req.toString());
    }

    @Override
    public TestRes invokeArrayAndObjectAndString(String[] values, TestReq req, String single) {
        return newResult(single + "|" + StringUtils.join(values, "," + "|" + req.toString()));
    }

    @Override
    public TestRes invokeMapAndObjectAndArrayAndString(Map<String, String> map, TestReq req, String[] values,
            String single) {
        return newResult(map.toString() + "|" + req.toString() + "|" + StringUtils.join(values, "," + "|" + req.toString()));
    }

    @Override
    public TestRes invokeObject(TestReq req) {
        return newResult(req);
    }

    @Override
    public TestRes invokeObjects(TestReq req, NameReq nameReq, DepartmentReq departmentReq) {
        return newResult(req.toString() + "|" + nameReq + "|" + departmentReq);
    }

    private static TestRes newResult(Object o) {
        TestRes res = new TestRes();
        res.setContent((o != null ? o.toString() : "") + "|" + System.currentTimeMillis());
        return res;
    }
}
