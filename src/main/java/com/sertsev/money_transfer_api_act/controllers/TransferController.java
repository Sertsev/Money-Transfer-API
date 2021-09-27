package com.sertsev.money_transfer_api_act.controllers;

import com.sertsev.money_transfer_api_act.domains.Transfer;
import com.sertsev.money_transfer_api_act.dto.TransferRequest;
import com.sertsev.money_transfer_api_act.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @Autowired
    private TransferService transferService;

    @GetMapping("/api/transfer/list")
    public Iterable<Transfer> getAllTransfers() {
        return transferService.getAllTransfers();
    }

    @PostMapping("/api/transfer")
    public Transfer transferMoney(@RequestBody TransferRequest transferRequest) throws Exception {
        return transferService.transferMoney(transferRequest);
    }
}