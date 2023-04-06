package com.example.clase.Entities.DB;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RegionID")
    private int id;
    @Column(name = "RegionDescription")
    private String description;
}
