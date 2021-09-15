package com.sertsev.money_transfer_api_act.controllers;

import com.sertsev.money_transfer_api_act.domains.Account;
import com.sertsev.money_transfer_api_act.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/api/account/create")
    public Account createAccount(@RequestBody Account account){
        //call service class
        return accountService.createAccount(account);
    }

    @GetMapping("/api/account/list")
    public Iterable<Account> listAccount() {
        return accountService.allAccount();
    }
}
