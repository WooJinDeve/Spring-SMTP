package com.example.mail.domain.auth.domain;

import com.example.mail.global.exception.InvalidateException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = PROTECTED)
public class AuthCode {
    private static final Long EXPIRED_TIME = 10L;

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String code;

    private String authSerialNumber;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createAt;

    @LastModifiedDate
    private LocalDateTime updateAt;

    @Builder
    public AuthCode(String code, String authSerialNumber, LocalDateTime createAt, LocalDateTime updateAt) {
        this.code = code;
        this.authSerialNumber = authSerialNumber;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    @Builder
    public AuthCode(String code, String authSerialNumber) {
        this.code = code;
        this.authSerialNumber = authSerialNumber;
    }

    public static AuthCode of(String code, String authSerialNumber) {
        return AuthCode.builder()
                .code(code)
                .authSerialNumber(authSerialNumber)
                .build();
    }

    public void verify(String code){
        if (!this.code.equals(code))
            throw new InvalidateException();
    }

    public void verifyTime(LocalDateTime currentTime){
        LocalDateTime expireTime = this.updateAt.plusMonths(EXPIRED_TIME);
        if(currentTime.isAfter(expireTime))
            throw new InvalidateException();
    }
}
