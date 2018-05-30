package com.zen;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class CryptoHelper {
    public static String sha256(String text) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(text.getBytes(StandardCharsets.UTF_8));
        byte[] hash = digest.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < hash.length; i++)
            sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
        return sb.toString().toUpperCase();
    }
}
