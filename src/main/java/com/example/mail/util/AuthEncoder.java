package com.example.mail.util;

import com.example.mail.global.exception.InvalidateException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class AuthEncoder {
    public String encode(final String Text){
        return BCrypt.hashpw(Text, BCrypt.gensalt());
    }

    public boolean compare(final String Text, final String encodeText){
        if (!BCrypt.checkpw(Text, encodeText))
            throw new InvalidateException();
        return true;
    }
}
