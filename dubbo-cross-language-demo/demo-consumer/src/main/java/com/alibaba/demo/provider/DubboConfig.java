package com.alibaba.demo.provider;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.ReferenceBean;
import com.alibaba.dubbo.demo.api.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig {

    private static final String APPLICATION_NAME = "demo-consumer";
    private static final String PROTOCOL_NAME = "dubbo";
    private static final int PROTOCOL_PORT = 20880;
    private static final String REGISTRY_ADDRESS = "zookeeper://10.18.3.28:2181";

    @Bean
    public static ApplicationConfig applicationConfig() {
        ApplicationConfig appConfig = new ApplicationConfig();
        appConfig.setName(APPLICATION_NAME);
        return appConfig;
    }

    @Bean
    public static ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(PROTOCOL_NAME);
        protocolConfig.setPort(PROTOCOL_PORT);
        return protocolConfig;
    }

    @Bean
    public static RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(REGISTRY_ADDRESS);
        registryConfig.setCheck(true);
        return registryConfig;
    }

    @Bean
    public static MonitorConfig monitorConfig() {
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");
        return monitorConfig;
    }

    @Bean
    public static TestService testService(ApplicationConfig applicationConfig, RegistryConfig registryConfig) {
        ReferenceBean<TestService> referenceBean = new ReferenceBean<>();
        referenceBean.setApplication(applicationConfig);
        referenceBean.setRegistry(registryConfig);
        referenceBean.setInterface(TestService.class);
        referenceBean.setMonitor(monitorConfig());
        return referenceBean.get();
    }
}
