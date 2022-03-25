package com.alwa.autoconfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:/parameter-defaults.properties")
public class ParameterDefaultsAutoConfiguration {

}
