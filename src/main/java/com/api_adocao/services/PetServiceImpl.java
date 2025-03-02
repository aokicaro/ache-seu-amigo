package com.api_adocao.services;

import com.api_adocao.dtos.PetDTO;
import com.api_adocao.models.Pet;
import com.api_adocao.models.Users;
import com.api_adocao.repositories.PetRepository;
import com.api_adocao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(UUID id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found"));
    }

    @Override
    public Pet createPet(PetDTO petDTO) {

        Users user = userRepository.findById(petDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        Pet pet = new Pet();
        pet.setName(petDTO.getName());
        pet.setAgeYears(petDTO.getAgeYears());
        pet.setAgeMonths(petDTO.getAgeMonths());
        pet.setGender(petDTO.getGender());
        pet.setPhotoUrl(petDTO.getPhotoUrl());
        pet.setAddress(petDTO.getAddress());
        pet.setLatitude(petDTO.getLatitude());
        pet.setLongitude(petDTO.getLongitude());
        pet.setDescription(petDTO.getDescription());
        pet.setAdopted(petDTO.isAdopted());
        pet.setPhone(petDTO.getPhone());
        pet.setUser(user);

        return petRepository.save(pet);
    }

    @Override
    public Pet updatePet(UUID id, Pet pet) {
        Pet existingPet = getPetById(id);
        existingPet.setName(pet.getName());
        existingPet.setAgeYears(pet.getAgeYears());
        existingPet.setAgeMonths(pet.getAgeMonths());
        existingPet.setGender(pet.getGender());
        existingPet.setPhotoUrl(pet.getPhotoUrl());
        existingPet.setAddress(pet.getAddress());
        existingPet.setLatitude(pet.getLatitude());
        existingPet.setLongitude(pet.getLongitude());
        existingPet.setDescription(pet.getDescription());
        existingPet.setAdopted(pet.isAdopted());
        existingPet.setPhone(pet.getPhone());
        existingPet.setUser(pet.getUser());
        return petRepository.save(existingPet);
    }

    @Override
    public void deletePet(UUID id) {
        petRepository.deleteById(id);
    }

    @Override
    public List<Pet> getAvailablePets() {
        return petRepository.findByAdopted(false);
    }

    @Override
    public List<Pet> getAdoptedPets() {
        return petRepository.findByAdopted(true);
    }

    @Override
    public List<Pet> getPetsNearby(double latitude, double longitude, double radiusInMeters) {
        return petRepository.findPetsNearby(latitude, longitude, radiusInMeters);
    }
}
