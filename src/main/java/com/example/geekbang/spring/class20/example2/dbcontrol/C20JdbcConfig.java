package com.example.geekbang.spring.class20.example2.dbcontrol;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：多数据源间切换之谜
 * @author: gao wei
 * @create: 2022-02-09 11:45
 */
@Configuration
public class C20JdbcConfig {
    /*
     *数据源一
     */
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;
    /*
     *数据源二
     */
    @Value("${card.driver}")
    private String cardDriver;
    @Value("${card.url}")
    private String cardUrl;
    @Value("${card.username}")
    private String cardUsername;
    @Value("${card.password}")
    private String cardPassword;
    @Autowired
    @Qualifier("dataSourceCard")
    private DataSource dataSourceCard;
    @Autowired
    @Qualifier("dataSourceCore")
    private DataSource dataSourceCore;


    //@Bean(name = "dataSource")
    //public DataSource createDataSource() {
    //    DriverManagerDataSource ds = new DriverManagerDataSource();
    //    ds.setDriverClassName(driver);
    //    ds.setUrl(url);
    //    ds.setUsername(username);
    //    ds.setPassword(password);
    //    return ds;
    //}
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


    @Bean(name = "transactionManager")
    public PlatformTransactionManager createTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean(name = "dataSourceCore")
    public DataSource createCoreDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    @Bean(name = "dataSourceCard")
    public DataSource createCardDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(cardDriver);
        ds.setUrl(cardUrl);
        ds.setUsername(cardUsername);
        ds.setPassword(cardPassword);
        return ds;
    }

    @Bean(name = "dataSource")
    public MyDataSource createDataSource() {
        MyDataSource myDataSource = new MyDataSource();
        Map map = new HashMap<>();
        map.put("core", dataSourceCore);
        map.put("card", dataSourceCard);
        myDataSource.setTargetDataSources(map);
        myDataSource.setDefaultTargetDataSource(dataSourceCore);
        return myDataSource;
    }
    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory( DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("com.example.geekbang.spring.class20.*"));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean("sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
