package com.api_adocao.services;

import com.api_adocao.dtos.PetDTO;
import com.api_adocao.models.Pet;

import java.util.List;
import java.util.UUID;

public interface PetService {
    List<Pet> getAllPets();
    Pet getPetById(UUID id);
    Pet createPet(PetDTO pet);
    Pet updatePet(UUID id, Pet pet);
    void deletePet(UUID id);
    List<Pet> getAvailablePets();
    List<Pet> getAdoptedPets();
    List<Pet> getPetsNearby(double latitude, double longitude, double radiusInMeters);
}
