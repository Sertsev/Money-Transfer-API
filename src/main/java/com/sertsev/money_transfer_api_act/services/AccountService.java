package com.sertsev.money_transfer_api_act.services;

import com.sertsev.money_transfer_api_act.domains.Account;
import com.sertsev.money_transfer_api_act.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        //calling the account repository
        LocalDate today = LocalDate.now();
        LocalDate birthDay = account.getDateOfBirth();
        Period period = Period.between(birthDay, today);

        if (period.getYears() < 15)
        {
            return null;
        }

        if (account.getPin() < 1000) {
            return null;
        }

        return accountRepository.save(account);
    }

    public Iterable<Account> allAccount() {
        return accountRepository.findAll();
    }


}













