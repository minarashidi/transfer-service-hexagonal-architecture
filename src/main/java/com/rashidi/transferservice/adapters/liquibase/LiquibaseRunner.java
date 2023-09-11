package com.rashidi.transferservice.adapters.liquibase;

import javax.sql.DataSource;
import org.apache.commons.lang3.StringUtils;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class LiquibaseRunner {

  @Profile("liquibase")
  @EnableConfigurationProperties(LiquibaseProperties.class)
  @Configuration
  static class LiquibaseConfig {

    @Bean
    @LiquibaseDataSource
    DataSource liquibaseDataSource(LiquibaseProperties properties) {
      var dataSource = new PGSimpleDataSource();

      dataSource.setUser(properties.user());
      if (StringUtils.isNotBlank(properties.password())) {
        dataSource.setPassword(properties.password());
      }
      dataSource.setUrl(properties.url());

      return dataSource;
    }
  }

  @ConfigurationProperties("spring.liquibase")
  record LiquibaseProperties(
      boolean enabled,
      String user,
      String password,
      String url) {

  }
}
