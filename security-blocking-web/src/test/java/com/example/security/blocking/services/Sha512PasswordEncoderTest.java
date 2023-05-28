package com.example.security.blocking.services;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Sha512PasswordEncoderTest {

    @Test
    void encode() {
        var encoded = new Sha512PasswordEncoder().encode("test");
        assertThat(encoded).isEqualTo("ee26b0dd4af7e749aa1a8ee3c1ae9923f618980772e473f8819a5d494edb27ac185f8a0e1d5f84f88bc887fd67b143732c34cc5fa9ad8e6f57f5028a8ff");
    }
}