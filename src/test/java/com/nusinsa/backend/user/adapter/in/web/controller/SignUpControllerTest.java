package com.nusinsa.backend.user.adapter.in.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nusinsa.backend.user.adapter.in.web.controller.signUp.SignUpController;
import com.nusinsa.backend.user.application.port.in.signUp.SignUpCommand;
import com.nusinsa.backend.user.application.port.in.signUp.SignUpUseCase;
import com.nusinsa.backend.user.domain.LoginId;
import com.nusinsa.backend.user.domain.Password;
import com.nusinsa.backend.user.domain.UserName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SignUpController.class)
class SignUpControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private SignUpUseCase sut;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("POST /api/v1/signup => (200) OK")
    void 회원가입_성공() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/signup")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(getSignCommand())))
                .andExpect(status().isOk());

        verify(sut, times(1)).signUp(any(), any());
    }

    @Test
    @DisplayName("POST /api/v1/signup => (400) Bad Request")
    void 회원가입_실패() throws Exception {
        String invalidJson = "{\"loginId\":null,\"password\":null,\"userName\":null}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/signup")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(invalidJson))
                .andExpect(status().isBadRequest());

        verify(sut, times(0)).signUp(any(), any());
    }

    public SignUpCommand getSignCommand() {
        return new SignUpCommand(
                new LoginId("test id"),
                new Password("test pw"),
                new UserName("test name")
        );
    }

}