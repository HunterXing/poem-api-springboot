package com.aiit.webapi.config;

import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.extension.incrementer.H2KeyGenerator;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xingheng
 * @Description: mybatis-plus配置类
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * 注入主键生成器
     * */
    @Bean
    public IKeyGenerator keyGenerator() {
        return new H2KeyGenerator();
    }
    /**
     * 分页插件 */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
