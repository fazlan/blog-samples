package org.fazlan.blogger.sample.domain.repo;

import org.fazlan.blogger.sample.domain.DomainTestConfig;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;

@java.lang.annotation.Documented
@java.lang.annotation.Inherited
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@ActiveProfiles("int")
@SpringApplicationConfiguration(classes = DomainTestConfig.class)
public @interface RepositoryIntegration {
}
