package com.springsecurity.ssia_ch2_ex2.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProjectConfigTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("인증 없이 /hello 호출시 unauthorized 반환 하는가?")
    public void helloUnauthenticated() throws Exception {
        mvc.perform(get("/ch2-ex2/hello"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("인증 후 /hello 호출시 ok 반환 하는가?")
    @WithUserDetails("john")    // 해당 사용자 이름으로 UserDetails 객체를 로드(마치 사용자가 인증된 것 처럼 실행)
    public void helloAuthenticated() throws Exception {
        mvc.perform(get("/ch2-ex2/hello"))
                .andExpect(status().isOk());
    }
}