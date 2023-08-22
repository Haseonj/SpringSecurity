package com.springsecurity.ssia_ch2_ex1.controller;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("인증 하지 않고 /hello 호출시 unauthorized를 반환하는가")
    public void helloUnauthenticated() throws Exception {
        mvc.perform(get("/hello"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("withMockUser 사용하여 /hello 호출시 ok 반환하는가?")
    @WithMockUser
    public void helloAuthenticated() throws Exception {
        mvc.perform(get("/hello"))
                .andExpect(content().string("Hello!"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("가짜 유저를 만들어 인증하고 /hello 호출시 ok 반환하는가?")
    public void helloAuthenticatedWithUser() throws Exception {
        mvc.perform(get("/hello")
                .with(user("mary")))
                .andExpect(content().string("Hello!"))
                .andExpect(status().isOk());
    }
}
