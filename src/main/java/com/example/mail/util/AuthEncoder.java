package com.example.mail.util;

import com.example.mail.global.exception.InvalidateException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class AuthEncoder {
    public String encode(final String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean compare(final String password, final String encodePassword){
        if (!BCrypt.checkpw(password, encodePassword))
            throw new InvalidateException();
        return true;
    }
}
