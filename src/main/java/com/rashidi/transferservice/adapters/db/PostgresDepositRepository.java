package com.rashidi.transferservice.adapters.db;

import com.rashidi.transferservice.adapters.db.datajdbc.DepositDataJdbc;
import com.rashidi.transferservice.adapters.db.datajdbc.entity.DepositEntity;
import com.rashidi.transferservice.adapters.db.exception.RepositoryException;
import com.rashidi.transferservice.core.model.Deposit;
import com.rashidi.transferservice.core.ports.DepositRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class PostgresDepositRepository implements DepositRepository {

  private DepositDataJdbc depositDataJdbc;

  @Override
  public Deposit save(Deposit deposit) {
    try {
      var depositEntity = DepositEntity.fromDeposit(deposit);
      var savedDepositEntity = depositDataJdbc.save(depositEntity);
      return savedDepositEntity.toDeposit();
    } catch (RuntimeException e) {
      log.warn("Cannot save deposit={}", deposit);
      throw new RepositoryException("Cannot save deposit.", e);
    }
  }
}
