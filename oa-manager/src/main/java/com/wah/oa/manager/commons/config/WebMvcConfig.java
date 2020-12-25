package com.wah.oa.manager.commons.config;

import com.wah.oa.manager.commons.utils.message.converter.Gson2HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport{

    private Charset utf8 = Charset.forName("utf-8");

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.add(new Gson2HttpMessageConverter(utf8));
        converters.add(new StringHttpMessageConverter(utf8));
    }
}
