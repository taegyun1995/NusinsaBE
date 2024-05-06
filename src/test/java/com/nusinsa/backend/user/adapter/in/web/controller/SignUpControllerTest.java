package com.nusinsa.backend.user.adapter.in.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nusinsa.backend.user.application.port.in.SignUpCommand;
import com.nusinsa.backend.user.application.port.in.SignUpUseCase;
import com.nusinsa.backend.user.domain.LoginId;
import com.nusinsa.backend.user.domain.Password;
import com.nusinsa.backend.user.domain.UserName;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

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
    @DisplayName("POST /api/v1/signup => (200) Success")
    void successCaseUserSignUp() throws JsonProcessingException {
        given()
                .contentType(ContentType.JSON)
                .body(objectMapper.writeValueAsString(getSignCommand()))
                .when()
                .post("/api/v1/signup")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .log()
                .ifValidationFails(LogDetail.ALL);

        verify(sut, times(1)).signUp(any(), any());
    }

    public SignUpCommand getSignCommand() {
        return new SignUpCommand(
                new LoginId("test id"),
                new Password("test pw"),
                new UserName("test name")
        );
    }

}