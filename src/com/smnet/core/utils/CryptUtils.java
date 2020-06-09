package com.smnet.core.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by Molaro, S. on 25.10.2017.
 * <p>
 * Dependency: commons-codec
 */
public class CryptUtils {

    /**
     * Generate SecretKey
     *
     * @param password
     * @return
     */
    public static SecretKey generateKey(String password) {

        try {

            DESKeySpec keySpec = new DESKeySpec(password.getBytes(StandardCharsets.UTF_8));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            return keyFactory.generateSecret(keySpec);

        } catch (InvalidKeyException | InvalidKeySpecException | NoSuchAlgorithmException e) {

            System.out.println(e.getMessage());

        }
        return null;
    }

    /**
     * Encrypt text
     *
     * @param text
     * @param key
     * @return
     */
    public static String encrypt(String text, SecretKey key) {

        Base64 base64 = new Base64();

        try {

            byte[] clearText = text.getBytes(StandardCharsets.UTF_8);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return new String(base64.encode(cipher.doFinal(clearText)), StandardCharsets.UTF_8);

        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | BadPaddingException
                | IllegalBlockSizeException e) {

            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Decrypt text
     *
     * @param text
     * @param secret
     * @return
     */
    public static String decrypt(String text, SecretKey secret) {

        try {

            Base64 base64 = new Base64();
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, secret);
            return new String((cipher.doFinal(base64.decode(text.getBytes()))), StandardCharsets.UTF_8);

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException
                | InvalidKeyException e) {

            System.out.println(e.getMessage());
        }

        return null;
    }

    public static String encryptMD5(String text) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(text.getBytes());
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }
}
