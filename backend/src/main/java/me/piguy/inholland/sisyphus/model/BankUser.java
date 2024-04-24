package me.piguy.inholland.sisyphus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class BankUser {
    @Id
    @GeneratedValue
    private UUID userId;

    private String name;
    private String password; /* HASHED */

    @CreationTimestamp
    private Timestamp registrationDate;

    private boolean active = false;

    public BankUser(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
