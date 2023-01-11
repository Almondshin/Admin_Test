package com.admin_test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*톰캣은 시작할 때 WebApplicationInitializer 구현 클래스를 찾아서 기본 설정을 한다.*/
@Configuration
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Bean을 정의하는 클래스를 지정한다.
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class, DatabaseConfig.class};
    }

    /**/
    @Override
    protected Class<?>[] getServletConfigClasses() { return new Class<?>[]{WebConfig.class}; }

    /*
    * DispathcerServlet에 매핑할 요청 주소를 세팅한다.
    * */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
