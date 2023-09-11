package com.rashidi.transferservice.core;

import com.rashidi.transferservice.core.ports.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
public class CustomerService {

  private final CustomerRepository repository;

  public CustomerService(CustomerRepository repository) {
    this.repository = repository;
  }

  public void validateCustomer(long id) {
    repository.validateCustomer(id);
  }

}
