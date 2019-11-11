package com.mine.consumer.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置
 * Created by jiangqd on 2019/3/21.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.mine.consumer.controller";

    @Bean
    public Docket buildDocket() {
        boolean enable = true;
        //拉取配置文件以确定该运行环境是否建立swagger文档接口显示
        /*String env = System.getProperty("process.profile");
        if (env != null && (env.equals("ceshi113"))) {
            enable = true;
        }*/
        return new Docket(DocumentationType.SWAGGER_2)
            .genericModelSubstitutes(DeferredResult.class)
            .useDefaultResponseMessages(false)
            .forCodeGeneration(false)
            .apiInfo(buildApiInf())
            .select()
            .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
            .paths(PathSelectors.any())
            .build().enable(enable);
    }

    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder()
            .title("服务接口文档")
            .description("服务功能描述")
            .termsOfServiceUrl("服务地址")
            .contact("作者")
            .version("版本")
            .build();
    }

}
