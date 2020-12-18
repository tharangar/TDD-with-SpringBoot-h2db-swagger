package biz.nable.sampath.oc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.context.annotation.ComponentScan;
//import biz.nable.sampath.oc.config.SpringBootAppH2db;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@ComponentScan("com.baeldung.h2db.demo.server")
@ComponentScan("biz.nable.sampath.oc")
@EnableJpaRepositories("biz.nable.sampath.oc.db.repositories")
@EntityScan("biz.nable.sampath.oc.db.entity")
public class SpringBootWebApplication extends SpringBootServletInitializer {
	
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
        //SpringBootAppH2db sb = new SpringBootAppH2db();
        //SpringApplication.run(SpringBootAppH2db.class, args);
    }
    
}
