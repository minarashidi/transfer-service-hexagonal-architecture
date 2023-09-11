package com.rashidi.transferservice.adapters.db;

import com.rashidi.transferservice.adapters.db.datajdbc.CustomerDataJdbc;
import com.rashidi.transferservice.adapters.db.exception.RepositoryException;
import com.rashidi.transferservice.core.model.ErrorCode;
import com.rashidi.transferservice.core.ports.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class PostgresCustomerRepository implements CustomerRepository {

  private CustomerDataJdbc customerDataJdbc;

  @Override
  public void validateCustomer(long id) {
    var customerEntityOptional = customerDataJdbc.findById(id);
    customerEntityOptional.orElseThrow(() -> {
      log.error(String.format("customer with id %s doesn't exist.", id));
      return new RepositoryException(ErrorCode.CUSTOMER_DOES_NOT_EXIST, "Customer not found");
    });
  }
}
