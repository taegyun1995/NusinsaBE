package com.nusinsa.backend.user.adapter.in.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nusinsa.backend.user.application.port.in.SignUpCommand;
import com.nusinsa.backend.user.application.port.in.SignUpUseCase;
import com.nusinsa.backend.user.domain.LoginId;
import com.nusinsa.backend.user.domain.Password;
import com.nusinsa.backend.user.domain.UserName;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SignUpControllerTest {

    ObjectMapper objectMapper;

    @MockBean
    SignUpUseCase sut;

    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("POST /api/v1/signup => (201) Created")
    void 회원가입_성공() throws JsonProcessingException {
        given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(objectMapper.writeValueAsString(getSignCommand()))
                .when()
                .post("/api/v1/signup")
                .then()
                .log().all()
                .statusCode(HttpStatus.CREATED.value());

        verify(sut, times(1)).signUp(any(), any());
    }

    @Test
    @DisplayName("POST /api/v1/signup => (400) Bad Request")
    void 회원가입_실패() {
        String invalidJson = "{\"loginId\":null,\"password\":null,\"userName\":null}";

        given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(invalidJson)
                .when()
                .post("/api/v1/signup")
                .then()
                .log().all()
                .statusCode(HttpStatus.BAD_REQUEST.value());

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
