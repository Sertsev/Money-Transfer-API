package com.sertsev.money_transfer_api_act;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
public class AccountControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void controllerTest() throws Exception {

        String payload = "{\n" +
                "    \"firstName\": \"Sertse\",\n" +
                "    \"middleName\": \"Shewa\",\n" +
                "    \"lastName\": \"Assefa\",\n" +
                "    \"phoneNumber\": \"0924486144\",\n" +
                "    \"email\": \"sertseshvewa@gmail.com\",\n" +
                "    \"dateOfBirth\": \"2000-01-01\",\n" +
                "    \"pin\": 2553\n" +
                "}";

        mockMvc.perform(
                post("/api/account/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"firstName\": \"Sertse\",\n" +
                        "    \"middleName\": \"Shewa\",\n" +
                        "    \"lastName\": \"Assefa\",\n" +
                        "    \"phoneNumber\": \"0924486144\",\n" +
                        "    \"email\": \"sertseshvewa@gmail.com\",\n" +
                        "    \"dateOfBirth\": \"2000-01-01\",\n" +
                        "    \"pin\": 2553\n" +
                        "}"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Ignore
    public void shouldFailBecauseNameIsEmpty() throws Exception {

        String payload = "{\n" +
                "    \"middleName\": \"Shewa\",\n" +
                "    \"lastName\": \"Assefa\",\n" +
                "    \"phoneNumber\": \"0924486144\",\n" +
                "    \"email\": \"sertseshvewa@gmail.com\",\n" +
                "    \"dateOfBirth\": \"2000-05-12\",\n" +
                "    \"pin\": 2553\n" +
                "}";

        mockMvc.perform(
                post("/api/account/create")
                        .contentType("application/json")
                        .content(payload)
        )
                .andDo(print())
                .andExpect(status().isOk());
    }
}
