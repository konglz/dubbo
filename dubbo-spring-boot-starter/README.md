# Dubbo Spring Boot Starter

## 如何使用
1. 在 Spring Boot 项目中加入```dubbo-spring-boot-starter```依赖

    ```Maven```
    ```xml
    <dependency>
       <groupId>com.alibaba</groupId>
       <artifactId>dubbo-spring-boot-starter</artifactId>
       <version>2.5.8</version>
    </dependency>
    ```
    ```Gradle```
    ```xml
    compile 'com.alibaba:dubbo-spring-boot-starter:2.5.8'
    ```
2. 添加配置
    
    ```xml
    spring:
        dubbo:
            scanPackage: com.alibaba.dubbo.demo
            protocol:
                name: dubbo
            registry:
                regProtocol: zookeeper
                address: 127.0.0.1:2181
            service:
                group: wsd-java
                module: wsd-java
                application: dubbo-demo-server
            referer:
                group: wsd-java
                module: wsd-java
                application: dubbo-demo-client
                check: false
 
 3. 导出和消费
 
    服务端：参照测试包下面的 [SuggestServiceImpl.java](https://github.com/konglz/dubbo/blob/master/dubbo-spring-boot-starter/src/test/java/com/alibaba/dubbo/demo/server/SuggestServiceImpl.java)
 
    客户端: 参照测试包下面的 [SuggestController.java](https://github.com/konglz/dubbo/blob/master/dubbo-spring-boot-starter/src/test/java/com/alibaba/dubbo/demo/client/SuggestController.java)

## 设计目的

* 减少引入dubbo时关注的pom依赖

* 将dubbo的配置文件统一化

* 将dubbo与spring boot监控体系打通

## 演示
克隆项目，运行```test```包内的```AppLauncher```。

## 参考

[Spring Boot Reference](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)