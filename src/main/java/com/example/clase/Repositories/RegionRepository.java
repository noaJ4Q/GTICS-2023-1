package com.example.clase.Repositories;

import com.example.clase.Entities.DB.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
    List<Region> findByDescription(String description);
    @Query(nativeQuery = true, value = "select * from Region where RegionDescription like %?1%")
    List<Region> findByDescriptionGeneral(String description);
}
