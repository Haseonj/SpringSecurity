package com.springsecurity.ssia_ch2_ex5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("유효한 자격 증명으로 /hello 호출시 ok 반환 하는가")
    public void helloAuthenticatingWithValidUser() throws Exception {
        mvc.perform(get("/hello")
                .with(httpBasic("john", "12345")))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("잘못된 자격 증명으로 /hello 호출시 unauthorized 반환 하는가")
    public void helloAuthenticatingWithInvalidUser() throws Exception {
        mvc.perform(get("/hello")
                .with(httpBasic("mary", "12345")))
                .andExpect(status().isUnauthorized());
    }


}
