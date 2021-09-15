package com.sertsev.money_transfer_api_act.repositories;


import com.sertsev.money_transfer_api_act.domains.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {}















