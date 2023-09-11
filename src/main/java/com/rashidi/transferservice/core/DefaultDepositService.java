package com.rashidi.transferservice.core;

import com.rashidi.transferservice.core.model.Deposit;
import com.rashidi.transferservice.core.ports.DepositRepository;
import com.rashidi.transferservice.core.ports.DepositService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultDepositService implements DepositService {

  private final DepositRepository depositRepository;
  private final CustomerService customerService;

  public DefaultDepositService(DepositRepository depositRepository, CustomerService customerService) {
    this.depositRepository = depositRepository;
    this.customerService = customerService;
  }

  @Override
  public Deposit add(Deposit deposit) {
    customerService.validateCustomer(deposit.customerId());
    return depositRepository.save(deposit);
  }
}
