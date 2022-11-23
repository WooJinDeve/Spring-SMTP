package com.example.mail.domain.mail.service;

import com.example.mail.domain.auth.service.AuthCodeService;
import com.example.mail.domain.mail.domain.Email;
import com.example.mail.domain.mail.dto.MailReqDto;
import com.example.mail.util.AuthCodeGenerator;
import com.example.mail.util.AuthEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final AuthCodeGenerator authCodeGenerator;
    private final AuthEncoder authEncoder;
    private final MailSender mailSender;
    private final AuthCodeService authCodeService;

    public void sendCodeToMailAndAuthCodeSave(MailReqDto mailReqDto){
        String serialNumber = authEncoder.encode(mailReqDto.getEmailEntity().getEmail());
        String authCodeText = authCodeGenerator.codeGenerator();
        authCodeService.createAuthCodeAndSave(serialNumber, authCodeText);
        sendCodeToMail(mailReqDto.getEmailEntity(), authCodeText);
    }

    private void sendCodeToMail(Email email, String authCodeText){
        mailSender.sender(email.getEmail(), authCodeText);
    }

}
