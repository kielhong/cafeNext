package net.kiel.cafe.config;

import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import(PropertyConfig.class)
@EnableTransactionManagement
public class RepositoryConfig {
    @Value("${datasource.driverClassName}") private String datasourceDriverClassName;
    @Value("${datasource.url}") private String datasourceUrl;
    @Value("${datasource.username}") private String datasourceUserName;
    @Value("${datasource.password}") private String datasourcePassword;
    @Value("${datasource.initialSize}") private Integer datasourceInitialSize;
    @Value("${datasource.maxActive}") private Integer datasourceMaxActive;
    @Value("${datasource.maxIdle}") private Integer datasourceMaxIdle;
    @Value("${datasource.minIdle}") private Integer datasourceMinIdle;
    @Value("${datasource.validationQuery}") private String validationQuery;
    @Value("${datasource.testWhileIdle}") private Boolean testWhileIdle;
    @Value("${datasource.minEvictableIdleTimeMillis}") private Integer minEvictableIdleTimeMillis;
    @Value("${datasource.timeBetweenEvictionRunsMillis}") private Integer timeBetweenEvictionRunsMillis;
    
    @Value("${hibernate.dialect}") private String hibernateDialect;
    @Value("${hibernate.driverClass}") private String hibernateDriverClass;
    @Value("${hibernate.show_sql}") private String hibernateShowSql;
    @Value("${hibernate.format_sql}") private String hibernateFormatSql;
    
    
    @Bean
    public DataSource dataSource() {
        DataSource datasource = new DataSource();
        datasource.setDriverClassName(datasourceDriverClassName);
        datasource.setUrl(datasourceUrl);
        datasource.setUsername(datasourceUserName);
        datasource.setPassword(datasourcePassword);
        datasource.setInitialSize(datasourceInitialSize);
        datasource.setMaxActive(datasourceMaxActive);
        datasource.setMaxIdle(datasourceMaxIdle);
        datasource.setMinIdle(datasourceMinIdle);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        
        return datasource;
    }
    
    // hibernate sessionFactory
    @Bean 
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());
        sessionFactory.setPackagesToScan(new String[] {"net.kiel.cafe.entity"});
        
        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory().getObject());
        
        return txManager;
    }
    
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
    @SuppressWarnings("serial")
    Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.connection.driver_class", hibernateDriverClass);
                setProperty("hibernate.dialect", hibernateDialect);
                setProperty("hibernate.show_sql", hibernateShowSql);
                setProperty("hibernate.format_sql", hibernateFormatSql);
                setProperty("hibernate.globally_quoted_identifiers", "true");
            }
        };
    }
}