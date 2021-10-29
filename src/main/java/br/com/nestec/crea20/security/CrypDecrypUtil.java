package br.com.nestec.crea20.security;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class CrypDecrypUtil implements PasswordEncoder {
    final static String chave = "0123456789abcdef";
    private static SecretKey key;

    public static String encriptografarString(final String data) {

        byte[] decodedKey = Base64.getDecoder().decode(chave);

        try {
            Cipher cipher = Cipher.getInstance("AES");
            key = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cipherText = cipher.doFinal(data.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(cipherText);
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro enquanto encriptografava os daddos ", e);
        }

    }

    public static String decriptografarString( final String encryptedString) {

        byte[] decodedKey = Base64.getDecoder().decode(chave);

        try {
            Cipher cipher = Cipher.getInstance("AES");
            key = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] cipherText = cipher.doFinal(Base64.getDecoder().decode(encryptedString));
            return new String(cipherText);
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro enquanto descriptografava os dados ", e);
        }
    }

    @Override
    public String encode(CharSequence rawPassword) {
        byte[] decodedKey = Base64.getDecoder().decode(chave);
        try {
            Cipher cipher = Cipher.getInstance("AES");
            key = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cipherText = cipher.doFinal(rawPassword.toString().getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(cipherText);
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro enquanto encriptografava os daddos ", e);
        }
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String decPassword = decriptografarString(encodedPassword);
        return decPassword.equals(rawPassword.toString());
    }
}
