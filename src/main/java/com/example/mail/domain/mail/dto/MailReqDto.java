package com.example.mail.domain.mail.dto;

import com.example.mail.domain.mail.domain.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MailReqDto {

    private Email emailEntity;

    public MailReqDto(Email emailEntity) {
        this.emailEntity = emailEntity;
    }
}
