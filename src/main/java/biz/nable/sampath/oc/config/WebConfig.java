package biz.nable.sampath.oc.config;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


//for interceptor
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

//for Actuator
import biz.nable.sb.cor.common.filter.RequestResponseLoggingInterceptor;
import com.google.common.base.Predicates;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class WebConfig {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	// Intercepter can change request if we wants. Hear we use it for logging
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate(
				new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new RequestResponseLoggingInterceptor());
		restTemplate.setInterceptors(interceptors);

		return restTemplate;
	}

	// Request Filter will filter the incomming requests
	@Bean
	public CommonsRequestLoggingFilter logFilter() {
		CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
		filter.setIncludeQueryString(true);
		filter.setIncludeQueryString(true);
		filter.setIncludePayload(true);
		filter.setMaxPayloadLength(10000);
		filter.setIncludeHeaders(true);
		filter.setAfterMessagePrefix("REQUEST DATA : ");
		return filter;
	}

	
	// Actuator configurations. // If we put this in SwaggerConfig file these will also can be seen from it
	@Bean
	public Docket api() {
		String groupName = "Actuatorr";
	    return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.any())
	            // Bellow lines used to avoide seeing some default controlles. This can be used to to prevent seeing some controller configurations.
	            .paths(Predicates.not(PathSelectors.regex("(/actuator/health.*|/error)")))
	            .paths(Predicates.not(PathSelectors.regex("(/actuator.*)")))
	            .paths(Predicates.not(PathSelectors.regex("(/lombok.*)")))
	            .paths(Predicates.not(PathSelectors.regex("(/error.*)")))
	            .paths(Predicates.not(PathSelectors.regex("(/WF.*)")))
	            .paths(Predicates.not(PathSelectors.regex("(/rules.*)")))
	            .paths(Predicates.not(PathSelectors.regex("(/getAssignmentData.*)")))
	            .paths(Predicates.not(PathSelectors.regex("(/wfapproval.*)")))
	            .build()
	            .groupName(groupName);
	}
	
	
	// h2 console
    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        this.initDb();
        return registrationBean;
    }
    
    
    
    @PostConstruct
    private void initDb() {
        System.out.println(String.format("****** Creating user table: %s, and Inserting test data ******", "user"));

        String sqlStatements[] = {
            "drop table users if exists",
            "create table users(id serial,fname varchar(255),uname varchar(255),pword varchar(255))",
            "insert into users(fname, uname, pword) values('Eugen','Paraschiv', 'password')",
            "insert into users(fname, uname, pword) values('test','test', 'test')",
            "insert into users(fname, uname, pword) values('Scott','Tiger', 'password')"
        };

        Arrays.asList(sqlStatements).stream().forEach(sql -> {
            System.out.println(sql);
            try {
            jdbcTemplate.execute(sql);
            }catch(Exception e) {
            	e.printStackTrace();
            }
        });

        System.out.println(String.format("****** Fetching from table: %s ******", "Users"));
        jdbcTemplate.query("select id,fname,uname,pword from users",
            new RowMapper<Object>() {
                @Override
                public Object mapRow(ResultSet rs, int i) throws SQLException {
                    System.out.println(String.format("id:%s,fname:%s,uname:%s",
                        rs.getString("id"),
                        rs.getString("fname"),
                        rs.getString("uname")));
                    return null;
                }
            });
    }

}
