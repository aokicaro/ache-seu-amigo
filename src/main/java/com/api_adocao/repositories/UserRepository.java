package com.api_adocao.repositories;

import com.api_adocao.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {
    // Buscar usuário por email
    Optional<Users> findByEmail(String email);

    // Buscar usuário por CPF/CNPJ
    Optional<Users> findByCpfCnpj(String cpfCnpj);
}
