package guru.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import guru.springframework.h2db.SpringBootAppH2db;


@SpringBootApplication
public class SpringBootWebApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
        //SpringBootAppH2db sb = new SpringBootAppH2db();
        //SpringApplication.run(SpringBootAppH2db.class, args);
    }
    
}
