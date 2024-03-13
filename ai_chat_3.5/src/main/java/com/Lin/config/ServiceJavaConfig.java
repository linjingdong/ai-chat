package com.Lin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Description 业务层
 * @Date 2023/12/5 22:35
 * @Author Lin
 * @Version 1.0
 */
@EnableTransactionManagement
@EnableAspectJAutoProxy
@Configuration
@ComponentScan({"com.Lin.service","com.Lin.mod","com.Lin.pojo"})
public class ServiceJavaConfig {
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
