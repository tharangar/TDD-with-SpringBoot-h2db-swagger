package biz.nable.sampath.oc.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"biz.nable.sampath.oc.db.entity"})
@EnableJpaRepositories(basePackages = {"biz.nable.sampath.oc.db.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
