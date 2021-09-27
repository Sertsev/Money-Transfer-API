package com.sertsev.money_transfer_api_act.repositories;

import com.sertsev.money_transfer_api_act.domains.Transfer;
import org.springframework.data.repository.CrudRepository;

public interface TransferRepository extends CrudRepository<Transfer, Long> {}