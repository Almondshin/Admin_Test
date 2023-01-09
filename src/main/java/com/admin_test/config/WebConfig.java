package com.admin_test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/*
 * Spring MVC 프로젝트에 관련된 설정을 하는 클래스
 * @Configuration 은 설정파일을 만들기위한 어노테이션 또는 Bean을 등록하기 위한 어노테이션이다.
 * 상기의 어노테이션을 사용하면 가시적으로 설정파일이다를 알 수 있다.
 *
 * 아래의 매개변수에 클래스를 설정해주는 것 만으로도 설정파일인 것을 알 수 있는데 왜 @Configuration을 사용할까?
 * ApplicationContext ac = new AnnotationConfigApplicationContext(xxx.class);
 *
 * @Configuration은 단순히 Bean을 등록하기 위한 어노테이션이 아니다.
 *  1. Bean을 등록할 때 싱글톤이 되도록 보장해준다 => 만들어진 객체는 다시 생성하지 않는다.
 *     => (CGLIB라는 바이트코드 조작 라이브러리를 사용해서 설정파일을 상속받은 임의의 클래스를 만들고 그것을 Spring Bean으로 등록했기 때문에,
 *        임의의 클래스를 통해서 싱글톤이 되는 것을 유지해준다)
 *  2. 스프링 컨테이너에서 Bean을 관리할 수 있게 된다.
 * */
@Configuration
/*
 * @Controller 어노테이션이 세팅되어 있는 클래스를 Controller로 등록해준다.
 * [참고 블로그](https://mangkyu.tistory.com/176)
 * @Enable
 * */
@EnableWebMvc
/*
 * 스캔할 패키지 지정
 * */
@ComponentScan(basePackages = {"com.admin_test.controller"})
public class WebConfig implements WebMvcConfigurer {

    /*
     * Controller의 매서드가 반환하는 jsp의 이름 앞/뒤의 경로와 확장자를 붙혀주도록 설정한다.
     * (prefix / suffix 설정)
     * */
    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    /*
     * 정적 파일의 경로를 매핑한다.
     * resources 설정을 하는 이유?
     * 디스패처 서블릿이 모든 요청을 처리하다보니, 리소스파일(image, js, css, html)또한 컨트롤러로 넘겨버리는 문제가 있다.
     * 이 때 resource 태그를 사용해서 처리를 할 수 가 있는데, 전략은 다음과 같다.
     * 디스패처 서블릿이 해당 요청에 대한 컨트롤러를 찾을 수 없다면
     * 2차적으로 resources에 설정한 경로를 탐색하여 해당 자원을 찾게 된다.
     * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/**").addResourceLocations("/resources/");
    }
}