package com.managehospitaleasy.managehospitaleasy.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;

    private Double amount;

    @Enumerated(EnumType.STRING) // it creates a type of table column is string of enum (if i put enumarated only then all the properties become maped with a number.(starting from 0)
    private BillStatus status;

}
