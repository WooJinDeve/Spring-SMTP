package com.example.mail.domain.auth.repository;

import com.example.mail.domain.auth.domain.AuthCode;
import com.example.mail.global.exception.NoSuchException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthCodeRepository extends JpaRepository<AuthCode, Long> {

    void deleteByAuthSerialNumber(String authSerialNumber);

    Optional<AuthCode> findByAuthSerialNumber(String authSerialNumber);

    default AuthCode getByAuthSerialNumber(String authSerialNumber){
        return findByAuthSerialNumber(authSerialNumber)
                .orElseThrow(NoSuchException::new);
    }

    boolean existsByAuthSerialNumber(String authSerialNumber);

    default void validateExistByAuthSerialNumber(String authSerialNumber){
        if (!existsByAuthSerialNumber(authSerialNumber))
            throw new NoSuchException();
    }
}
