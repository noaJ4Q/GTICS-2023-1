package com.example.clase.Repositories;

import com.example.clase.Entities.DB.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Integer> {
    List<Shipper> findByCompanyName(String companyName);
}
