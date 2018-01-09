package com.alibaba.demo.consumer;

import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Constants;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.config.annotation.ServiceMethod;
import com.alibaba.dubbo.demo.api.DepartmentReq;
import com.alibaba.dubbo.demo.api.NameReq;
import com.alibaba.dubbo.demo.api.TestReq;
import com.alibaba.dubbo.demo.api.TestRes;
import com.alibaba.dubbo.demo.api.TestService;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import org.springframework.stereotype.Component;

@Component
@Path("tests")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service(interfaceClass = TestService.class, protocol = {Constants.PROTOCOL_DUBBO, Constants.PROTOCOL_REST})
public class TestServiceImpl implements TestService {

    @ServiceMethod(timeout = 1)
    @POST
    @Path("invokeVoid")
    @Override
    public TestRes invokeVoid() {
        return newResult("void");
    }

    @POST
    @Path("invokeSingleString")
    @Override
    public TestRes invokeSingleString(String single) {
        return newResult(single);
    }

    @POST
    @Path("invokeSingleInteger")
    @Override
    public TestRes invokeSingleInteger(Integer num) {
        return newResult(num);
    }

    @POST
    @Path("invokeSingleInt")
    @Override
    public TestRes invokeSingleInt(int num) {
        return newResult(num);
    }

    @POST
    @Path("invokeSingleFloat")
    @Override
    public TestRes invokeSingleFloat(Float num) {
        return newResult(num);
    }

    @POST
    @Path("invokeSingleFlo")
    @Override
    public TestRes invokeSingleFlo(float num) {
        return newResult(num);
    }

    @POST
    @Path("invokeSingleBoolean")
    @Override
    public TestRes invokeSingleBoolean(Boolean bool) {
        return newResult(bool);
    }

    @POST
    @Path("invokeSingleBool")
    @Override
    public TestRes invokeSingleBool(boolean bool) {
        return newResult(bool);
    }

    @POST
    @Path("invokeArray")
    @Override
    public TestRes invokeArray(String[] values) {
        return newResult(StringUtils.join(values, ","));
    }

    @POST
    @Path("invokeMap")
    @Override
    public TestRes invokeMap(Map<String, String> map) {
        return newResult(map);
    }

    @POST
    @Path("invokeStringAndArray")
    @Override
    public TestRes invokeStringAndArray(String single, String[] values) {
        return newResult(single + "|" + StringUtils.join(values, ","));
    }

    @POST
    @Path("invokeObjectAndString")
    @Override
    public TestRes invokeObjectAndString(TestReq req, String single) {
        return newResult(single + "|" + req.toString());
    }

    @POST
    @Path("invokeArrayAndObjectAndString")
    @Override
    public TestRes invokeArrayAndObjectAndString(String[] values, TestReq req, String single) {
        return newResult(single + "|" + StringUtils.join(values, "," + "|" + req.toString()));
    }

    @POST
    @Path("invokeMapAndObjectAndArrayAndString")
    @Override
    public TestRes invokeMapAndObjectAndArrayAndString(Map<String, String> map, TestReq req, String[] values,
            String single) {
        return newResult(
                map.toString() + "|" + req.toString() + "|" + StringUtils.join(values, "," + "|" + req.toString()));
    }

    @POST
    @Path("invokeObject")
    @Override
    public TestRes invokeObject(TestReq req) {
        return newResult(req);
    }

    @POST
    @Path("invokeObjects")
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
