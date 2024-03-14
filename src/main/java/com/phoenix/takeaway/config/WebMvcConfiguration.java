package com.phoenix.takeaway.config;


import com.phoenix.takeaway.intercepter.JwtTokenAdminInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 配置类，注册web层相关组件
 */

@Slf4j
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private  JwtTokenAdminInterceptor jwtTokenAdminInterceptor;



    /**
     * 注册自定义拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("开始注册自定义拦截器...");
        registry.addInterceptor(jwtTokenAdminInterceptor)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/employee/login");
    }

//    /**
//     * 通过knife4j生成接口文档
//     * @return
//     */
//    @Bean
//    public Docket docket() {
//        System.out.println("准备生成接口文档");
//        ApiInfo apiInfo = new ApiInfoBuilder()
//                .title("take away")
//                .version("2.0")
//                .description("take away")
//                .build();
//        Docket docket = new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.phoenix.takeaway.controller"))
//                .paths(PathSelectors.any())
//                .build();
//        return docket;
//    }

    /**
     * 设置静态资源映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("start to config static resource mapping");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
