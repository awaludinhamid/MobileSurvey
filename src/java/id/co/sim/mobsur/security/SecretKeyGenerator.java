/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.security;

import com.sun.jersey.core.util.Base64;
import java.io.IOException;
import java.security.Key;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @created Apr 16, 2013
 * @author awal
 */
public class SecretKeyGenerator {

    private SecretKeyGenerator() {
    }

    public static SecretKeyGenerator getInstance() {
        return SecretKeyGeneratorHolder.INSTANCE;
    }

    private static class SecretKeyGeneratorHolder {
        private static final SecretKeyGenerator INSTANCE = new SecretKeyGenerator();
    }

    public String encrypt (String text) {
        String encryptedText = "";
        try {
            //System.out.println("Text: " + text);
            // convert text string to byte[]
            byte[] byteText = text.getBytes();
            // encrypt text
            Cipher cipher = getCipher(Cipher.ENCRYPT_MODE);
            encryptedText = new String(Base64.encode(cipher.doFinal(byteText)));
            //System.out.println("Text encrypt: " + encryptedText);
        } catch (Exception x) {
            System.out.println(x);
        }
        return encryptedText;
    }

    public String decrypt (String encryptedText) {
        String decryptedText = "";
        try {
            //System.out.println("Text: " + encryptedText);
            // convert text string to byte[]
            byte[] byteText = encryptedText.getBytes();
            // decrypt encrypted text
            Cipher cipher = getCipher(Cipher.DECRYPT_MODE);
            decryptedText = new String(cipher.doFinal(Base64.decode(byteText)));
            //System.out.println("Text decrypt: " + decryptedText);
        } catch (Exception x) {
            System.out.println(x);
        }
        return decryptedText;
    }

    private Cipher getCipher(int mode) throws Exception {
        // get properties
        Properties prop = new Properties();
        try {
            prop.load(SecretKeyGenerator.class.getClassLoader()
                    .getResourceAsStream("authentication.properties"));
        } catch(IOException ioe) {
            System.out.println("Failed to load properties file");
        }
        String key = prop.getProperty("sk.key");
        String algo = prop.getProperty("sk.algo");
        String cipherInfo = prop.getProperty("sk.cipherInfo");
        // create algo key
        byte[] keyBytes = key.getBytes();
        Key secretKey = new SecretKeySpec(keyBytes, algo);
        // create encryption instance
        Cipher cipher = Cipher.getInstance(cipherInfo);
        cipher.init(mode, secretKey);
        return cipher;
    }
 }