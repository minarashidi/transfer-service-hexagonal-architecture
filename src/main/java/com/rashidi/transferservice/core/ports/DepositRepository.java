package com.rashidi.transferservice.core.ports;

import com.rashidi.transferservice.core.model.Deposit;

public interface DepositRepository {

  Deposit save(Deposit deposit);
}
