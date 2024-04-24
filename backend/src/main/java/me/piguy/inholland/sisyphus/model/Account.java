package me.piguy.inholland.sisyphus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue
    private UUID accountId;

    @ManyToOne
    private BankUser owner;

    private double balance;
    private double minimumBalance;
    private double dailyLimit;
}
