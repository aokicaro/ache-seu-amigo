package com.api_adocao.services;

import com.api_adocao.models.Users;
import com.api_adocao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users updateUser(UUID id, Users user) {
        Users existingUser = getUserById(id);
        existingUser.setCpfCnpj(user.getCpfCnpj());
        existingUser.setName(user.getName());
        existingUser.setAddress(user.getAddress());
        existingUser.setPhone(user.getPhone());
        existingUser.setPhotoUrl(user.getPhotoUrl());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setGoogleId(user.getGoogleId());
        existingUser.setLatitude(user.getLatitude());
        existingUser.setLongitude(user.getLongitude());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public Users findByCpfCnpj(String cpfCnpj) {
        return userRepository.findByCpfCnpj(cpfCnpj)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
