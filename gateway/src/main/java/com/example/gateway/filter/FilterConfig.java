package com.example.gateway.filter;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

/**
 * Created by fengdongdong on 2019/2/25
 */
@Configuration
public class FilterConfig {
    @Bean
    @Order(-1)
    public GlobalFilter a() {
        return (exchange, chain) -> {
            System.out.println("first pre filter");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.out.println("third post filter");
            }));
        };
    }

    @Bean
    @Order(0)
    public GlobalFilter b() {
        return (exchange, chain) -> {
            System.out.println("second pre filter");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.out.println("second post filter");
            }));
        };
    }

    @Bean
    @Order(1)
    public GlobalFilter c() {
        return (exchange, chain) -> {
            System.out.println("third pre filter");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.out.println("first post filter");
            }));
        };
    }
}
