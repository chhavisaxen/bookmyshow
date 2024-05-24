package com.bookmyshow.config;

import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPICustomizer {

    //This is used to ensure the operationId is always the method name irrespective of whether the openapi generator finds similar named functions during generation.
    //Because of this the openapi generator will not generate method names like create4, create5 and so on.
    @Bean
    public OperationCustomizer operationIdCustomizer() {
        return (operation, handlerMethod) -> {
            operation.setOperationId(String.format("%s", handlerMethod.getMethod().getName()));
            return operation;
        };
    }
}