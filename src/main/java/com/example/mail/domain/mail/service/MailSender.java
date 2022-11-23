package com.example.mail.domain.mail.service;

public interface MailSender {
    void sender(String email, String authCode);
}
