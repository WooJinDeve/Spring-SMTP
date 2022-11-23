package com.example.mail.domain.auth.dto;

import com.example.mail.domain.mail.domain.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VerificationReqDto {
    private Email email;
    public String code;

    @Builder
    public VerificationReqDto(Email email, String code) {
        this.email = email;
        this.code = code;
    }
}
