package me.piguy.inholland.sisyphus.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import me.piguy.inholland.sisyphus.model.Role;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.security.PublicKey;
import java.util.Date;
import java.util.List;

@Component
public class JwtProvider {

    private JwtKeyProvider keyProvider;
    private UserDetailsService userDetailsService;

    public JwtProvider(JwtKeyProvider keyProvider, UserDetailsService userDetailsService) {
        this.keyProvider = keyProvider;
        this.userDetailsService = userDetailsService;
    }

    public String createToken(String email, List<Role> roles) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 3600000);

        return Jwts.builder()
                .subject(email)
                .claim("auth", roles.stream().map(Role::name).toList())
                .issuedAt(now)
                .expiration(expiration)
                .signWith(keyProvider.getPrivateKey())
                .compact();
    }

    public Authentication getAuthentication(String token) {

        PublicKey publicKey = keyProvider.getPublicKey();
        try {
            Claims claims =
                    (Jwts.parser().verifyWith(publicKey).build().parseSignedClaims(token).getPayload());
            String username = claims.getSubject();
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
        } catch (JwtException | IllegalArgumentException e) {
            throw new JwtException(e.getMessage());
        }
    }
}
