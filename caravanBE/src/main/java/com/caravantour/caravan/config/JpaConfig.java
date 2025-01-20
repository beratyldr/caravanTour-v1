package com.caravantour.caravan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.caravantour.caravan.repository.jpa")
public class JpaConfig {
}