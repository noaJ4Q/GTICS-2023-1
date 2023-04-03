package com.example.clase.Entities.DB;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Region")
@Getter
@Setter
public class Region {

    @Id
    @Column(name = "RegionID", nullable = false)
    private String id;

    @Column(name = "RegionDescription", nullable = false)
    private String description;
}
