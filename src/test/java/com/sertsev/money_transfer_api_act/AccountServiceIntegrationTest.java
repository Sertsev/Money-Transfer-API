package com.sertsev.money_transfer_api_act;


import com.sertsev.money_transfer_api_act.domains.Account;
import com.sertsev.money_transfer_api_act.services.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class AccountServiceIntegrationTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void checkingUnderAge() {
        Account account = Account.builder()
                .firstName("Abera")
                .middleName("Alemu")
                .lastName("Lemma")
                .dateOfBirth(LocalDate.of(2020, 5, 12))
                .pin(2555)
                .email("sertseshewa@gmail.com")
                .phoneNumber("+12545685")
                .build();

        Account returnedAccount = accountService.createAccount(account);

        assertThat(returnedAccount).isNull();
    }

    @Test
    public void checkingWrongPinReturnsNull() {
        Account account = Account.builder()
                .firstName("Abera")
                .middleName("Alemu")
                .lastName("Lemma")
                .dateOfBirth(LocalDate.of(2000, 5, 12))
                .pin(255)
                .email("sertseshewa@gmail.com")
                .phoneNumber("+12545685")
                .build();

        Account returnedAccount = accountService.createAccount(account);

        assertThat(returnedAccount).isNull();
    }
}