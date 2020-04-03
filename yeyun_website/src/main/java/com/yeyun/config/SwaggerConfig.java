package com.yeyun.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2     //开启swagger-ui
public class SwaggerConfig {


    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */
    @Bean
    public Docket restApi1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("1、公共de接口")
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yeyun.controller"))
                .paths(Predicates.or(PathSelectors.regex("/common.*"),
                        PathSelectors.regex("/login.*"),
                        PathSelectors.regex("/Verify.*"),
                        PathSelectors.regex("/public.*")))
                .build();
    }

    @Bean
    public Docket restApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("2、业务员de接口")
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yeyun.controller"))
                .paths(PathSelectors.regex("/salesman.*"))
                .build();
    }

    @Bean
    public Docket restApi3() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("3、主管de接口")
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yeyun.controller"))
                .paths(PathSelectors.regex("/supervisor.*"))
                .build();
    }

    @Bean
    public Docket restApi4() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("4、分管领导de接口")
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yeyun.controller"))
                .paths(PathSelectors.regex("/leader.*"))
                .build();
    }

    @Bean
    public Docket restApi5() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("5、客服de接口")
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yeyun.controller"))
                .paths(PathSelectors.regex("/staff.*"))
                .build();
    }

    @Bean
    public Docket restApi6() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("6、运营de接口")
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yeyun.controller"))
                .paths(PathSelectors.regex("/operations.*"))
                .build();
    }
}
