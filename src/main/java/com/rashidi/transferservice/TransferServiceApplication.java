package com.rashidi.transferservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class TransferServiceApplication {

  public static void main(final String[] args) {
    SpringApplication.run(TransferServiceApplication.class, args);
  }
}
