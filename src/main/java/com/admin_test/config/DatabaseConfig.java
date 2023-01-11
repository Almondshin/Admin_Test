package com.admin_test.config;/*
package com.admin_test.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
*/
/*
 * Spring 프레임워크의 어노 테이션 기반 트랜잭션 관리를 사용할 수 있도록 한다.
 * <tx:annotation-driven>
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
public class DatabaseConfig {

    @Autowired
    ApplicationContext applicationContext;


/**
     * DataSource 설정
     * <bean id="dataSource"
     *  class="org.springframework.jdbc.datasource.DriverManagerDataSource">
     *  <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver" />
     *  <property name="url" value="jdbc:oracle:thin:@localhost:1521:xe" />
     *  <property name="username" value="intercast" />
     *  <property name="password" value="pass123!" />
     * </bean>
     *
     * @return
     */

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql//localhost:3306/test");
//        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root123");
        return dataSource;
    }




/**
     * TransactionManager설정
     *
     * <bean id="transactionManager"
     *  class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
     *  <property name="dataSource" ref="dataSource"></property>
     * </bean>
     *
     * @return
     *//*

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }



    */
/**
     * SqlSessionFactory 설정
     *
     * <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
     *  <property name="dataSource" ref="dataSource" />
     *  <property name="configLocation" value="classpath:mybatis/configuration.xml" />
     * <property name="mapperLocations" value="classpath:mybatis/mappers/** /*.xml" />
     * </bean>
     *
     * @param dataSource
     * @param applicationContext
     * @return
     * @throws IOException
     *//*

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return factoryBean.getObject();
    }

    */
/**
     * SqlSessionTemplate 설정
     *
     * <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
     *  <constructor-arg ref="sqlSessionFactory" />
     * </bean>
     *
     * @param sqlSessionFactory
     * @return
     */
/*
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }*/
}

