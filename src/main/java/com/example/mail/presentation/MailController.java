package com.example.mail.presentation;

import com.example.mail.domain.auth.dto.VerificationReqDto;
import com.example.mail.domain.auth.service.AuthCodeService;
import com.example.mail.domain.mail.dto.MailReqDto;
import com.example.mail.domain.mail.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mail")
public class MailController {
    private final MailService mailService;
    private final AuthCodeService authCodeService;

    @PostMapping
    public void sendAuthCode(@RequestBody MailReqDto mailReqDto){
        mailService.sendCodeToMailAndAuthCodeSave(mailReqDto);
    }

    @PostMapping("/verify")
    public void authCodeVerify(@RequestBody VerificationReqDto request){
        authCodeService.verifyCode(request);
    }
}
