package com.hbo.secretmanagement.secretmanagement.dto;

public class SecretDto {

    private final String secret;

    public SecretDto(final String secret) {
        this.secret = secret;
    }

    public String getSecret() {
        return secret;
    }
}
