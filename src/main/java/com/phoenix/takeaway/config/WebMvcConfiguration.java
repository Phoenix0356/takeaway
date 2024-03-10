package com.phoenix.takeaway.config;


//import com.phoenix.takeaway.intercepter.JwtTokenAdminInterceptor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 配置类，注册web层相关组件
// */
//@Configuration
//@Slf4j
//public class WebMvcConfiguration extends WebMvcAutoConfiguration {
//
//    @Autowired
//    private JwtTokenAdminInterceptor jwtTokenAdminInterceptor;
//
//    /**
//     * 注册自定义拦截器
//     *
//     * @param registry
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        log.info("开始注册自定义拦截器...");
//        registry.addInterceptor(jwtTokenAdminInterceptor)
//                .addPathPatterns("/admin/**")
//                .excludePathPatterns("/admin/employee/login");
//    }

//    /**
//     * 通过knife4j生成接口文档
//     * @return
//     */
//    @Bean
//    public Docket docket() {
//        ApiInfo apiInfo = new ApiInfoBuilder()
//                .title("苍穹外卖项目接口文档")
//                .version("2.0")
//                .description("苍穹外卖项目接口文档")
//                .build();
//        Docket docket = new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.sky.controller"))
//                .paths(PathSelectors.any())
//                .build();
//        return docket;
//    }

//    /**
//     * 设置静态资源映射
//     * @param registry
//     */
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//}
