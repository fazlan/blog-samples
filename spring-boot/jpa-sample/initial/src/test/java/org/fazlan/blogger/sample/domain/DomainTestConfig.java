package org.fazlan.blogger.sample.domain;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.fazlan.blogger.sample.domain.repo")
@EntityScan(basePackages = "org.fazlan.blogger.sample.domain.entity")
@Import({ DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class DomainTestConfig {
}