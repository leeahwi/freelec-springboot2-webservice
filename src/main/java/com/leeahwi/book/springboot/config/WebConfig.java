package com.leeahwi.book.springboot.config;


import com.leeahwi.book.springboot.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final LoginUserArgumentResolver loginUserArgumentResolver;


    /**
     * HandlerMethodArgumentResolver는 WebMvcConfigurer의 addArgumentResolvers를 통해 추가해야함
     * @param argumentResolvers initially an empty list
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers){

        argumentResolvers.add(loginUserArgumentResolver);
    }


}
