package com.sertsev.money_transfer_api_act;


import com.sertsev.money_transfer_api_act.domains.Account;
import com.sertsev.money_transfer_api_act.repositories.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.AutoConfigureDataJdbc;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class AccountRepositoryIntegrationTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void shouldCreateAnAccountInDB() {

        // with builder pattern
        Account account = Account.builder()
                .firstName("Alex")
                .middleName("Sisay")
                .lastName("Asiasa")
                .email("email@email.com")
                .phoneNumber("12524685468")
                .pin(4223)
                .dateOfBirth(LocalDate.of(2002,2,25))
                .build();

        Account savedAccount = accountRepository.save(account);
        assertThat(savedAccount).isNotNull();
        assertThat(savedAccount.getId()).isEqualTo(1);
        assertThat(savedAccount.getFirstName()).isEqualTo(account.getFirstName());
    }

}
