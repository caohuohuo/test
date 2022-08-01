package com.vaccination.config;

import org.springframework.context.annotation.Bean;

/**
 * OrderByConfiguration
 * 6/30/21
 *
 * @Author xiaoguang
 */
public class DefaultOrderByConfiguration {

    @Bean
    public Marker eurekaServerMarkerBean() {
        return new Marker();
    }

    class Marker {

    }
}
