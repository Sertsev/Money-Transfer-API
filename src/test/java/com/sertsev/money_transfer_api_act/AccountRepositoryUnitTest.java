package com.sertsev.money_transfer_api_act;

import com.sertsev.money_transfer_api_act.repositories.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryUnitTest {

    @MockBean
    private AccountRepository accountRepository;

    @Before
    public void setup() {
        given(accountRepository.count())
        .willReturn(3L);
    }

    @Test
    public void ShouldReturnTheCountOfAccountsInTheDB() {
        long count = accountRepository.count();

        assertThat(count).isEqualTo(3L);
    }
}















