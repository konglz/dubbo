package com.alibaba.demo.provider;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.ServiceBean;
import com.alibaba.dubbo.demo.api.TestService;

public class AppLauncher {

    private static final String APPLICATION_NAME = "demo-provider";
    private static final String PROTOCOL_NAME = "dubbo";
    private static final int PROTOCOL_PORT = 20880;
    private static final String REGISTRY_ADDRESS = "zookeeper://10.18.3.28:2181";


    public static ApplicationConfig applicationConfig() {
        ApplicationConfig appConfig = new ApplicationConfig();
        appConfig.setName(APPLICATION_NAME);
        return appConfig;
    }

    public static ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(PROTOCOL_NAME);
        protocolConfig.setPort(PROTOCOL_PORT);
        return protocolConfig;
    }

    public static RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(REGISTRY_ADDRESS);
        registryConfig.setCheck(true);
        return registryConfig;
    }


    public static void main(String[] args) throws Exception {
        //Prevent to get IPV6 address,this way only work in debug mode
        //But you can pass use -Djava.net.preferIPv4Stack=true,then it work well whether in debug mode or not
        System.setProperty("java.net.preferIPv4Stack", "true");

        ApplicationConfig applicationConfig = applicationConfig();
        ProtocolConfig protocolConfig = protocolConfig();
        RegistryConfig registryConfig = registryConfig();

        TestServiceImpl testServiceImpl = new TestServiceImpl();
        ServiceBean<TestService> serviceConfig = new ServiceBean<>();
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setInterface(TestService.class);
        serviceConfig.setRef(testServiceImpl);
        serviceConfig.export();

        System.in.read(); // press any key to exit
    }

}