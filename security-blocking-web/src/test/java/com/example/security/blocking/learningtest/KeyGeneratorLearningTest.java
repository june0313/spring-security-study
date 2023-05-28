package com.example.security.blocking.learningtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.keygen.KeyGenerators;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class KeyGeneratorLearningTest {
    @Test
    void string() {
        var keyGenerator = KeyGenerators.string();
        var salt = keyGenerator.generateKey();
        System.out.println("salt : " + salt);
    }

    @Test
    @DisplayName("secureRandom - Generate different key")
    void bytesKeyGenerator() {
        var bytesKeyGenerator = KeyGenerators.secureRandom(16);

        var key1 = bytesKeyGenerator.generateKey();
        var key2 = bytesKeyGenerator.generateKey();
        var length = bytesKeyGenerator.getKeyLength();

        System.out.println(Arrays.toString(key1));
        System.out.println(Arrays.toString(key2));
        System.out.println(length);

        assertThat(key1).isNotEqualTo(key2);
    }

    @Test
    @DisplayName("shard - Generate same key")
    void bytesKeyGenerator2() {
        var bytesKeyGenerator = KeyGenerators.shared(16);
        var key1 = bytesKeyGenerator.generateKey();
        var key2 = bytesKeyGenerator.generateKey();

        System.out.println(Arrays.toString(key1));
        System.out.println(Arrays.toString(key2));

        assertThat(key1).isEqualTo(key2);
    }
}
