package me.piguy.inholland.sisyphus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "BANK_USER")
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue
    private UUID userId;

    private String name;
    private String password; /* HASHED */

    @CreationTimestamp
    private Timestamp registrationDate;

    private boolean active = false;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
