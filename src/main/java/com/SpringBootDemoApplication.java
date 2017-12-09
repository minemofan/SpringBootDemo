package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * Titel	启动类
 * Description
 * 名称 	说明
 * spring-boot-starter 	核心 POM，包含自动配置支持、日志库和对 YAML 配置文件的支持。
 * spring-boot-starter-amqp 	通过 spring-rabbit 支持 AMQP。
 * spring-boot-starter-aop 	包含 spring-aop 和 AspectJ 来支持面向切面编程（AOP）。
 * spring-boot-starter-batch 	支持 Spring Batch，包含 HSQLDB。
 * spring-boot-starter-data-jpa 	包含 spring-data-jpa、spring-orm 和 Hibernate 来支持 JPA。
 * spring-boot-starter-data-mongodb 	包含 spring-data-mongodb 来支持 MongoDB。
 * spring-boot-starter-data-rest 	通过 spring-data-rest-webmvc 支持以 REST 方式暴露 Spring Data 仓库。
 * spring-boot-starter-jdbc 	支持使用 JDBC 访问数据库。
 * spring-boot-starter-security 	包含 spring-security。
 * spring-boot-starter-test 	包含常用的测试所需的依赖，如 JUnit、Hamcrest、Mockito 和 spring-test 等。
 * spring-boot-starter-velocity 	支持使用 Velocity 作为模板引擎。
 * spring-boot-starter-web 	支持 Web 应用开发，包含 Tomcat 和 spring-mvc。
 * spring-boot-starter-websocket 	支持使用 Tomcat 开发 WebSocket 应用。
 * spring-boot-starter-ws 	支持 Spring Web Services。
 * spring-boot-starter-actuator 	添加适用于生产环境的功能，如性能指标和监测等功能。
 * spring-boot-starter-remote-shell 	添加远程 SSH 支持。
 * spring-boot-starter-jetty 	使用 Jetty 而不是默认的 Tomcat 作为应用服务器。
 * spring-boot-starter-log4j 	添加 Log4j 的支持。
 * spring-boot-starter-logging 	使用 Spring Boot 默认的日志框架 Logback。
 * spring-boot-starter-tomcat 	使用 Spring Boot 默认的 Tomcat 作为应用服务器。
 *
 *
 *  =====================================================================================
 * @ComponentScan	扫描包；如果不加上@ComponentScan，自动扫描该controller，那么该Controller
 *  				就不会被spring扫描到，更不会装入spring容器中。
 * @SpringBootApplication	一个@SpringbootApplication相当于@Configuration,@EnableAutoConfiguration和 @ComponentScan 并具有他们的默认属性值
 * @Configuration可理解为用spring的时候xml里面的<beans>标签；是 Spring 3.X 后提供的注解，用于取代 XML 来配置 Spring。
 *
 */
@RestController
@SpringBootApplication
@ComponentScan(basePackages = {"com.example.holle"
		,"com.example.prop","com.common.prop"
		,"com.core.dao.mapper.model","com.core.controller"})
@Configuration
@EnableSwagger2
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Bean
	public Docket createApi(){
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.zzp.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title("API文档")
				.description("API使用即参数定义")
				.termsOfServiceUrl("http://blog.csdn.net/qq_31001665")
				.contact("ZZP")
				.version("0.1")
				.build();
	}

	/**
	 * Description  大神级响应
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String helloWorld(){
		return "Hello World";
	}
}
