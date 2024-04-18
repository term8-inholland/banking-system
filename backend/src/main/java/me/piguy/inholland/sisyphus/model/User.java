package me.piguy.inholland.sisyphus.model;

import java.util.UUID;

public record User(UUID id, String first_name, String last_name, String password) {
}
