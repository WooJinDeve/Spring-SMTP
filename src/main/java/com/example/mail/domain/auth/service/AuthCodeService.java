package com.example.mail.domain.auth.service;

import com.example.mail.domain.auth.domain.AuthCode;
import com.example.mail.domain.auth.dto.VerificationReqDto;
import com.example.mail.domain.auth.repository.AuthCodeRepository;
import com.example.mail.util.AuthEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthCodeService {
    private final AuthEncoder authEncoder;
    private final AuthCodeRepository authCodeRepository;

    @Transactional
    public void createAuthCodeAndSave(String authSerialNumber, String authCodeText){
        authCodeRepository.deleteByAuthSerialNumber(authSerialNumber);
        AuthCode authCode = AuthCode.of(authCodeText, authSerialNumber);
        authCodeRepository.save(authCode);
    }

    public void verifyCode(VerificationReqDto verificationReqDto){
        String authSerialNumber = authEncoder.encode(verificationReqDto.getEmail().getEmail());
        AuthCode authCode = authCodeRepository.getByAuthSerialNumber(authSerialNumber);
        authCode.verify(verificationReqDto.getCode());
        authCode.verifyTime(LocalDateTime.now());
    }
}
