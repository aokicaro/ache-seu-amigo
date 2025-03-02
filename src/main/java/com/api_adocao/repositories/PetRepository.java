package com.api_adocao.repositories;

import com.api_adocao.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PetRepository extends JpaRepository<Pet, UUID> {

    // Buscar pets por status (adopted ou não)
    List<Pet> findByAdopted(boolean adopted);

    // Buscar pets não adotados (adopted = false)
    default List<Pet> findAvailablePets() {
        return findByAdopted(false);
    }

    // Buscar pets adotados (adopted = true)
    default List<Pet> findAdoptedPets() {
        return findByAdopted(true);
    }


    @Query(value = """
        SELECT * FROM pet
        WHERE adopted = false
        AND earth_distance(
            ll_to_earth(:latitude, :longitude),
            ll_to_earth(latitude, longitude)
        ) <= :radiusInMeters
        """, nativeQuery = true)
    List<Pet> findPetsNearby(
            @Param("latitude") double latitude,
            @Param("longitude") double longitude,
            @Param("radiusInMeters") double radiusInMeters
    );
}