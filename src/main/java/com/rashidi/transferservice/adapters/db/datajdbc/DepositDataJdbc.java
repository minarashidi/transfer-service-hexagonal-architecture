package com.rashidi.transferservice.adapters.db.datajdbc;

import com.rashidi.transferservice.adapters.db.datajdbc.entity.DepositEntity;
import org.springframework.data.repository.CrudRepository;

public interface DepositDataJdbc extends BaseDataJdbc, CrudRepository<DepositEntity, Long> {

}
