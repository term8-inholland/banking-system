package me.piguy.inholland.sisyphus.security;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.Certificate;

@Component
@Getter
public class JwtKeyProvider {

    @Value("inholland.p12")
    private String keystore;

    @Value("${jwt.key-store-password}")
    private String keystorePassword;

    @Value("${jwt.key-alias}")
    private String keyAlias;

    private Key privateKey;

    private PublicKey publicKey;

    @PostConstruct
    protected void init() {
        // Generate a key pair
        try {
            ClassPathResource resource = new ClassPathResource(keystore);
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(resource.getInputStream(), keystorePassword.toCharArray());
            privateKey = keyStore.getKey(keyAlias, keystorePassword.toCharArray());
            Certificate certificate = keyStore.getCertificate(keyAlias);
            publicKey = certificate.getPublicKey();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
