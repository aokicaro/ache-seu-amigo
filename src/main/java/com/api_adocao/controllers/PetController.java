package com.api_adocao.controllers;

import com.api_adocao.dtos.PetDTO;
import com.api_adocao.models.Pet;
import com.api_adocao.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        List<Pet> pets = petService.getAllPets();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable UUID id) {
        Pet pet = petService.getPetById(id);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody PetDTO petDTO) {
        Pet savedPet = petService.createPet(petDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable UUID id, @RequestBody Pet pet) {
        Pet updatedPet = petService.updatePet(id, pet);
        return new ResponseEntity<>(updatedPet, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable UUID id) {
        petService.deletePet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/available")
    public ResponseEntity<List<Pet>> getAvailablePets() {
        List<Pet> availablePets = petService.getAvailablePets();
        return new ResponseEntity<>(availablePets, HttpStatus.OK);
    }

    @GetMapping("/adopted")
    public ResponseEntity<List<Pet>> getAdoptedPets() {
        List<Pet> adoptedPets = petService.getAdoptedPets();
        return new ResponseEntity<>(adoptedPets, HttpStatus.OK);
    }

    @GetMapping("/nearby")
    public ResponseEntity<List<Pet>> getPetsNearby(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam double radiusInMeters) {
        List<Pet> nearbyPets = petService.getPetsNearby(latitude, longitude, radiusInMeters);
        return new ResponseEntity<>(nearbyPets, HttpStatus.OK);
    }
}
