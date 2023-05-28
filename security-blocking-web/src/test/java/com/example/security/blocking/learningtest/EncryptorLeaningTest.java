package com.example.security.blocking.learningtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

import static org.assertj.core.api.Assertions.assertThat;

public class EncryptorLeaningTest {
    @Test
    void standard() {
        String salt = KeyGenerators.string().generateKey();
        String password = "secret";
        String valueToEncrypt = "HELLO";

        // standard uses 256 bit AES encryption
        BytesEncryptor bytesEncryptor = Encryptors.standard(password, salt);
        byte[] encrypted = bytesEncryptor.encrypt(valueToEncrypt.getBytes());
        byte[] decrypted = bytesEncryptor.decrypt(encrypted);

        assertThat(valueToEncrypt).isEqualTo(new String(decrypted));
    }

    @Test
    void stronger() {
        String salt = KeyGenerators.string().generateKey();
        String password = "secret";
        String valueToEncrypt = "HELLO";

        BytesEncryptor bytesEncryptor = Encryptors.stronger(password, salt);
        byte[] encrypted = bytesEncryptor.encrypt(valueToEncrypt.getBytes());
        byte[] decrypted = bytesEncryptor.decrypt(encrypted);

        assertThat(valueToEncrypt).isEqualTo(new String(decrypted));
    }

    @Test
    void dummyTextEncryptor() {
        String valueToEncrypt = "HELLO";

        TextEncryptor dummyTextEncryptor = Encryptors.noOpText();
        String encrypted = dummyTextEncryptor.encrypt(valueToEncrypt);

        assertThat(encrypted).isEqualTo("HELLO");
    }

    @Test
    void text() {
        String salt = KeyGenerators.string().generateKey();
        String password = "secret";
        String valueToEncrypt = "HELLO";

        TextEncryptor textEncryptor = Encryptors.text(password, salt);

        String encrypted = textEncryptor.encrypt(valueToEncrypt);
        String decrypted = textEncryptor.decrypt(encrypted);

        assertThat(valueToEncrypt).isEqualTo(decrypted);
    }

    @Test
    @DisplayName("text() - Encrypted result may different with same input.")
    void text2() {
        String salt = KeyGenerators.string().generateKey();
        String password = "secret";
        String valueToEncrypt = "HELLO";

        TextEncryptor textEncryptor = Encryptors.text(password, salt);

        String encrypted1 = textEncryptor.encrypt(valueToEncrypt);
        String encrypted2 = textEncryptor.encrypt(valueToEncrypt);

        System.out.println(encrypted1);
        System.out.println(encrypted2);

        String decrypted1 = textEncryptor.decrypt(encrypted1);
        String decrypted2 = textEncryptor.decrypt(encrypted1);

        assertThat(decrypted1).isEqualTo(decrypted2);
    }
}
