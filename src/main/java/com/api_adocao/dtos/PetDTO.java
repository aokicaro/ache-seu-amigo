package com.api_adocao.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class PetDTO {
    // Getters e Setters
    private String name;
    private int ageYears;
    private int ageMonths;
    private String gender;
    private String photoUrl;
    private String address;
    private Double latitude;
    private Double longitude;
    private String description;
    private boolean adopted;
    private String phone;
    private UUID userId;

}
