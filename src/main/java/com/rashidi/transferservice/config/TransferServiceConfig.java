package com.rashidi.transferservice.config;

import com.rashidi.transferservice.adapters.db.PostgresDepositRepository;
import com.rashidi.transferservice.adapters.db.PostgresCustomerRepository;
import com.rashidi.transferservice.adapters.db.datajdbc.BaseDataJdbc;
import com.rashidi.transferservice.adapters.db.datajdbc.DepositDataJdbc;
import com.rashidi.transferservice.adapters.db.datajdbc.CustomerDataJdbc;
import com.rashidi.transferservice.core.DefaultDepositService;
import com.rashidi.transferservice.core.CustomerService;
import com.rashidi.transferservice.core.ports.DepositRepository;
import com.rashidi.transferservice.core.ports.DepositService;
import com.rashidi.transferservice.core.ports.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableJdbcRepositories(basePackageClasses = {BaseDataJdbc.class})
@EnableConfigurationProperties()
@Slf4j
public class TransferServiceConfig {

  // Service Beans
  @Bean
  public DepositService depositService(DepositRepository depositTransferRepository, CustomerService endUserService) {
    return new DefaultDepositService(depositTransferRepository, endUserService);
  }

  @Bean
  public CustomerService customerService(CustomerRepository endUserRepository) {
    return new CustomerService(endUserRepository);
  }

  // Repository Beans
  @Bean
  DepositRepository depositTransferRepository(DepositDataJdbc depositTransferDataJdbc) {
    return new PostgresDepositRepository(depositTransferDataJdbc);
  }

  @Bean
  public CustomerRepository customerRepository(CustomerDataJdbc customerDataJdbc) {
    return new PostgresCustomerRepository(customerDataJdbc);
  }
}
