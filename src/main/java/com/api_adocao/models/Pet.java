package com.api_adocao.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int ageYears;

    @Column(nullable = false)
    private int ageMonths;

    @Column(nullable = false)
    private String gender;

    private String photoUrl;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    private String description;

    @Column(nullable = false)
    private boolean adopted;

    @Column(nullable = false)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
