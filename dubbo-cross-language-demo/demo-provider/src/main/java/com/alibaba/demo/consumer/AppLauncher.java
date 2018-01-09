package com.alibaba.demo.consumer;

import com.alibaba.boot.dubbo.annotation.EnableDubboConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.boot.system.EmbeddedServerPortFileWriter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
@EnableAutoConfiguration
@EnableDubboConfiguration
@ComponentScan(basePackageClasses = {AppLauncher.class})
public class AppLauncher {
//
//    private static final String APPLICATION_NAME = "demo-provider";
//    private static final String PROTOCOL_NAME = "dubbo";
//    private static final int PROTOCOL_PORT = 20880;
//    private static final String ZOOKEEPER_REGISTRY_ADDRESS = "zookeeper://10.18.3.28:2181";
//    private static final String REDIS_REGISTRY_ADDRESS = "redis://10.18.3.28:6379";
//
//
//    private static ApplicationConfig applicationConfig() {
//        ApplicationConfig appConfig = new ApplicationConfig();
//        appConfig.setName(APPLICATION_NAME);
//        appConfig.setLogger("slf4j");
//        return appConfig;
//    }
//
//    private static ProtocolConfig dubboProtocol() {
//        ProtocolConfig protocolConfig = new ProtocolConfig();
//        protocolConfig.setName(PROTOCOL_NAME);
//        protocolConfig.setPort(PROTOCOL_PORT);
//        return protocolConfig;
//    }
//
//    private static ProtocolConfig httpProtocol() {
//        ProtocolConfig protocolConfig = new ProtocolConfig();
//        protocolConfig.setName("jsonrpc");
//        protocolConfig.setContextpath("/dubbo");
////        protocolConfig.setCodec("json");
//        protocolConfig.setServer("servlet");
////        protocolConfig.setSerialization("json");
//        protocolConfig.setPort(23767);
//        return protocolConfig;
//    }
//
//    private static RegistryConfig zookeeperRegistry() {
//        RegistryConfig registryConfig = new RegistryConfig();
//        registryConfig.setProtocol("zookeeper");
//        registryConfig.setAddress(ZOOKEEPER_REGISTRY_ADDRESS);
//        registryConfig.setCheck(true);
//        return registryConfig;
//    }
//
//    private static RegistryConfig redisRegistry() {
//        RegistryConfig registryConfig = new RegistryConfig();
//        registryConfig.setProtocol("redis");
//        registryConfig.setAddress(REDIS_REGISTRY_ADDRESS);
//        registryConfig.setCheck(true);
//        return registryConfig;
//    }
//
//    private static MonitorConfig monitorConfig() {
//        MonitorConfig monitorConfig = new MonitorConfig();
//        monitorConfig.setProtocol("registry");
//        return monitorConfig;
//    }
//
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean() {
//        com.alibaba.dubbo.remoting.http.servlet.DispatcherServlet dubboServlet = new com.alibaba.dubbo.remoting.http.servlet.DispatcherServlet();
//        return new ServletRegistrationBean(dubboServlet, "/dubbo/*");
//    }


    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(AppLauncher.class).run(args);
        context.addApplicationListener(new ApplicationPidFileWriter());
        context.addApplicationListener(new EmbeddedServerPortFileWriter());

        //Prevent to get IPV6 address,this way only work in debug mode
        //But you can pass use -Djava.net.preferIPv4Stack=true,then it work well whether in debug mode or not
        System.setProperty("java.net.preferIPv4Stack", "true");

//        ApplicationConfig applicationConfig = applicationConfig();
//
//        List<RegistryConfig> registryConfigs = new LinkedList<>();
//        registryConfigs.add(zookeeperRegistry());
//        registryConfigs.add(redisRegistry());
//
//        List<ProtocolConfig> protocolConfigs = new LinkedList<>();
//        protocolConfigs.add(dubboProtocol());
//        protocolConfigs.add(httpProtocol());
//
//        TestServiceImpl testServiceImpl = new TestServiceImpl();
//        ServiceBean<TestService> serviceConfig = new ServiceBean<>();
//        serviceConfig.setApplication(applicationConfig);
//        serviceConfig.setProtocols(protocolConfigs);
//        serviceConfig.setRegistries(registryConfigs);
//        serviceConfig.setInterface(TestService.class);
//        serviceConfig.setRef(testServiceImpl);
//        serviceConfig.setMonitor(monitorConfig());
//        serviceConfig.export();
//
//        System.in.read();
    }

}