package me.piguy.inholland.sisyphus.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "BANK_USER")
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue
    private UUID userId;

    private String email;
    private String password; /* HASHED */

    @CreationTimestamp
    private Timestamp registrationDate;

    private boolean active = false;

    @ElementCollection(fetch = jakarta.persistence.FetchType.EAGER)
    private List<Role> roles;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
