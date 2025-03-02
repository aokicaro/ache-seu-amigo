package com.api_adocao.services;

import com.api_adocao.models.Users;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<Users> getAllUsers();
    Users getUserById(UUID id);
    Users createUser(Users user);
    Users updateUser(UUID id, Users user);
    void deleteUser(UUID id);
    Users findByEmail(String email);
    Users findByCpfCnpj(String cpfCnpj);
}
