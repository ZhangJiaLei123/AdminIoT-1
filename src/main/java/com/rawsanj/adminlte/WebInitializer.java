package com.rawsanj.adminlte;

/**
 * Created by snikitin on 23.02.18.
 */
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class WebInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootAdminLteTemplateWithSpringSecurityApplication.class);
    }

}
