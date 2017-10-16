package com.hong.admin.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by syline on 2017/7/8.
 */
//@Configuration
public class MvcConfigurer extends WebMvcConfigurerAdapter
        implements EmbeddedServletContainerCustomizer {
//
//    @Bean
//    public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
//        return new ByteArrayHttpMessageConverter();
//    }


    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
    }
}
