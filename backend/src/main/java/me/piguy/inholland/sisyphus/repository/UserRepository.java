package me.piguy.inholland.sisyphus.repository;

import me.piguy.inholland.sisyphus.model.BankUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<BankUser, UUID> {
}
