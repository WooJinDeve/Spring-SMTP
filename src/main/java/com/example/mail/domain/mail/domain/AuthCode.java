package com.example.mail.domain.mail.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Entity
public class AuthCode {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
}
