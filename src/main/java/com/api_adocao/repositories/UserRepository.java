package com.api_adocao.repositories;

import com.api_adocao.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {
}
