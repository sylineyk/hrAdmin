package com.hong.admin.dao.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import java.sql.SQLException;

/**
 * 默认主服务主要就是@Primary 注解，多数据源一定要配置
 *
 * @author paker
 */
@Configuration
@ConfigurationProperties("env.datasource")
@MapperScan(basePackages = {"com.chouguanjia.admin.security.dao", "com.chouguanjia.admin.dao.mapper"}, sqlSessionFactoryRef = EnvDatasoureConfig.SQL_SESSION_FACTORY_NAME)
@EnableTransactionManagement
public class EnvDatasoureConfig {

    public static final String SQL_SESSION_FACTORY_NAME = "infoSessionFactory";

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String url;

    @NotNull
    private String driverClassName;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Bean(name = "infoDatasource")
    @Primary
    public DataSource infoEnvDatasource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "infoTransactionManager")
    @Primary
    public DataSourceTransactionManager dcTransactionManager() throws SQLException {
        return new DataSourceTransactionManager(infoEnvDatasource());
    }

    @Bean(name = EnvDatasoureConfig.SQL_SESSION_FACTORY_NAME)
    @Primary
    public SqlSessionFactory dcSqlSessionFactory(@Qualifier("infoDatasource") DataSource infoDatasource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(infoDatasource);

        // 添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sessionFactory.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return sessionFactory.getObject();
    }

}