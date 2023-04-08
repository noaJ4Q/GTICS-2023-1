package com.example.clase.Repositories;

import com.example.clase.Entities.DB.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Integer> {
    List<Shipper> findByCompanyName(String companyName);

    @Query(nativeQuery = true, value = "select * from Shippers where CompanyName like %?1%")
    List<Shipper> findByCompanyNameGeneral(String companyName);
}
