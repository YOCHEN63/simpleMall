package com.oliver.simplemall.utils;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.UUID;

@Component
public class Token {

    private final Base64.Decoder decoder = Base64.getDecoder();

    private final Base64.Encoder encoder = Base64.getEncoder();

    private byte[] textByte(String text) {
        return text.getBytes(StandardCharsets.UTF_8);
    }

    public String createToken() {
        String token = UUID.randomUUID().toString();
        return new String(encoder.encodeToString(textByte(token)));
    }

    public Boolean verify(Timestamp createTime) {
        Date d = new Date(createTime.getTime());
        Timestamp expireTime = new Timestamp(d.getTime() + 5 * 60 * 1000);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        return now.before(expireTime);
    }
}
