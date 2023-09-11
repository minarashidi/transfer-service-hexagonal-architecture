package com.rashidi.transferservice.adapters.db.datajdbc;

import com.rashidi.transferservice.adapters.db.datajdbc.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDataJdbc extends BaseDataJdbc, CrudRepository<CustomerEntity, Long> {

}
