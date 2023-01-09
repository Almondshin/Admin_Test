package com.admin_test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * 프로젝트 작업 시 사용할 Bean을 정의하는 클래스
 * DataSource : 데이터베이스에 대한 연결을 나타내는 빈
 * JdbcTemplate : JDBC 데이터베이스 작업을 쉽게 해주는 유틸리티 클래스
 * TransactionManager : 데이터베이스 또는 기타 리소스ㅜ에 대한 트랜잭션을 관리하는 빈
 * HttpInvokerProxyFactoryBean : Spring HttpInvoker를 사용하여 HTTP를 통해 서비스에 접근하기 위한 프록시를 생성하는 빈
 * JmsTemplate : JMS(Java Message Service) 대상 작업을 위한 유틸리티 클래스
 * ScheulerFactoryBean : Quartz 스케줄링 라이브러리를 사용하여 작업 스케줄링을 위한 Scheduler를 생성하는 빈
 * */
@Configuration
@ComponentScan(basePackages = "com.admin_test")
public class RootConfig {

}
