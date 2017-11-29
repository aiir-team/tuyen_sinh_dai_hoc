package com.project.tuyensinhdaihoc.data_access_layer.repository;

import com.project.tuyensinhdaihoc.data_access_layer.model.Combination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CombinationRepo extends JpaRepository<Combination, Integer> {

    List<Combination> findAll();

    @Query(value = "SELECT cb FROM Combination cb WHERE cb.idSub1 IN (?1, ?2, ?3) AND cb.idSub2 IN (?1, ?2, ?3) AND cb.idSub3 IN (?1, ?2, ?3)")
    List<Combination> findByIdSub1AndIdSub2AndIdSub3(Integer id1, Integer id2, Integer id3);

    @Query("SELECT ud.geographic FROM UniversityDetail ud")
    List<Combination> findBy(String x1, String x2, String x3);
}