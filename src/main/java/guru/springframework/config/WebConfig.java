package guru.springframework.config;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Configuration
public class WebConfig {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

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
