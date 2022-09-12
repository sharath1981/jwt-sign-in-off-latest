package com.ryana.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@ConfigurationProperties(prefix = "rsa")
public record RSAKeyPair(RSAPublicKey publickey, RSAPrivateKey privatekey) {
}
