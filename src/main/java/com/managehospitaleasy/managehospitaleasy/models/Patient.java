package com.managehospitaleasy.managehospitaleasy.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter@Setter
@AllArgsConstructor // constructors having all arguments
@NoArgsConstructor // constructors having all non arguments
@Entity
@Builder

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    private String name;


    private String gender ;



    private String age ;


}
