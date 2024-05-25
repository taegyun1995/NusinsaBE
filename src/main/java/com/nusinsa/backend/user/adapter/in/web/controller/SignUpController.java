package com.nusinsa.backend.user.adapter.in.web.controller;

import com.nusinsa.backend.user.adapter.in.web.response.SignUpResponse;
import com.nusinsa.backend.user.application.port.in.SignUpCommand;
import com.nusinsa.backend.user.application.port.in.SignUpUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class SignUpController {

    private final SignUpUseCase useCase;

    public SignUpController(SignUpUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signUp(
            @RequestHeader("user-agent") final String userAgent,
            @RequestBody final SignUpCommand command
    ) {
        SignUpResponse response = useCase.signUp(userAgent, command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}