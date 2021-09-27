package com.sertsev.money_transfer_api_act.services;

import com.sertsev.money_transfer_api_act.domains.Account;
import com.sertsev.money_transfer_api_act.domains.Transfer;
import com.sertsev.money_transfer_api_act.dto.TransferRequest;
import com.sertsev.money_transfer_api_act.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransferRepository transferRepository;

    public Transfer transferMoney(TransferRequest transferRequest) throws Exception {
        Account senderAccount = accountService.getAccountById(transferRequest.getSenderId());

        if (senderAccount == null) {
            throw new Exception();
        }

        Account receiverAccount = accountService.getAccountById(transferRequest.getReceiverId());

        if (receiverAccount == null) {
            throw new Exception();
        }

        if (transferRequest.getSenderId().equals(transferRequest.getReceiverId())) {
            throw new Exception();
        }

        if (senderAccount.getBalance() >= transferRequest.getAmount()) {
            // logic
            double newSenderBalance = senderAccount.getBalance() - transferRequest.getAmount();
            accountService.updateBalance(senderAccount, newSenderBalance);

            double newReceiverBalance = receiverAccount.getBalance() + transferRequest.getAmount();
            accountService.updateBalance(receiverAccount, newReceiverBalance);

            Transfer transfer = Transfer.builder()
                    .senderAccount(senderAccount)
                    .receiverAccount(receiverAccount)
                    .amount(transferRequest.getAmount())
                    .reason(transferRequest.getReason())
                    .status("SUCCESSFUL")
                    .build();

            transferRepository.save(transfer);
            return transfer;

        } else {
            throw new Exception();
        }
    }

    public Iterable<Transfer> getAllTransfers() {

        return transferRepository.findAll();
    }

}
