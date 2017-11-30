package com.project.tuyensinhdaihoc.data_access_layer.repository;

import com.project.tuyensinhdaihoc.data_access_layer.model.UniversalPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversalPointRepo extends JpaRepository<UniversalPoint, Integer> {

    List<UniversalPoint> findAll();

    List<UniversalPoint> findById(Integer id);

    @Query("SELECT DISTINCT up.blockName FROM UniversalPoint up")
    List<String> findAllBlockName();

    List<UniversalPoint> findByBlockName(String blockName);
}