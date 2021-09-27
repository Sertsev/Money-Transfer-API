package com.sertsev.money_transfer_api_act;


import com.sertsev.money_transfer_api_act.domains.Account;
import com.sertsev.money_transfer_api_act.domains.Transfer;
import com.sertsev.money_transfer_api_act.dto.TransferRequest;
import com.sertsev.money_transfer_api_act.services.AccountService;
import com.sertsev.money_transfer_api_act.services.TransferService;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class TransferServiceIntegrationTest {

    @Autowired
    private TransferService transferService;

    @Autowired
    private AccountService accountService;

    //Happy path test
    @Test
    public void shouldTransferMoneyFromOneValidAccountToAnother() throws Exception {

        // given
        TransferRequest transferRequest = TransferRequest.builder()
                .senderId(1L)
                .receiverId(2L)
                .amount(100.0)
                .reason("gift")
                .build();

        // when
        Transfer transfer = transferService.transferMoney(transferRequest);

        // then
        assertEquals(transfer.getAmount(), transferRequest.getAmount());
        assertNotNull(transfer.getId());
        assertEquals(transfer.getStatus(), "SUCCESSFUL");

        Account senderAccount = accountService.getAccountById(1L);
        Account receiverAccount = accountService.getAccountById(2L);

        assert senderAccount.getBalance() == 100.0;
        assert receiverAccount.getBalance() == 150.0;
    }

//    @Test
//    public void shouldFailIfTransferAmountIsGreaterThanAccountBalance() throws Exception {
//
//        //given
//        TransferRequest transferRequest = TransferRequest.builder()
//                .senderId(1L)
//                .receiverId(2L)
//                .amount(100.0)
//                .reason("gift")
//                .build();
//
//        //when
//        Transfer transfer = transferService.transferMoney(transferRequest);
//    }
}
