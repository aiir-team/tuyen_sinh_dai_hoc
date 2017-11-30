package com.project.tuyensinhdaihoc.data_access_layer.repository;

import com.project.tuyensinhdaihoc.data_access_layer.model.UniversityDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityDetailRepo extends JpaRepository<UniversityDetail, Integer> {

    @Query("SELECT DISTINCT ud.branchName FROM UniversityDetail ud")
    List<String> findAllDistinctBranchName();

    @Query("SELECT DISTINCT ud.univName FROM UniversityDetail ud")
    List<String> findAllDistinctUniversityName();

    @Query("SELECT DISTINCT ud.geographic FROM UniversityDetail ud")
    List<String> findAllDistinctUniversityGeographic();

    @Query("SELECT DISTINCT ud.univCode, ud.univName FROM UniversityDetail ud GROUP BY ud.univName, ud.univCode")
    List<Object> findDistinctByUnivCodeAndUnivName();

    List<UniversityDetail> findByUnivCode(String univCode);

    List<UniversityDetail> findAllByUnivLevelAndGeographicAndCombinationCodeAndTotalScoreLessThan
            (String univLevel, String city, String combCode, Double totalScore);

    @Query("SELECT ud FROM UniversityDetail ud WHERE ud.univLevel = ?1 AND ud.geographic = ?2")
    List<UniversityDetail> findAllByUnivLevelAndGeographic(String univLevel, String city);

    List<UniversityDetail> findByUnivLevelLike(String uniType);

    @Query("SELECT ud FROM UniversityDetail ud WHERE ud.univLevel LIKE CONCAT('%',:universityLevel,'%')")
    List<UniversityDetail> findUniversityDetailByUnivType(@Param("universityLevel") String uniType);


    @Query("SELECT ud FROM UniversityDetail ud WHERE ud.univCode LIKE CONCAT('%',:universityCode,'%')")
    List<UniversityDetail> findUniversityDetailByUnivCode(@Param("universityCode") String unicode);

    @Query("SELECT ud FROM UniversityDetail ud WHERE ud.univName LIKE CONCAT('%',:universityName,'%')")
    List<UniversityDetail> findUniversityDetailByUnivName(@Param("universityName") String uniName);


    @Query("SELECT ud FROM UniversityDetail ud WHERE ud.typeAdmission LIKE CONCAT('%',:typeadmission,'%')")
    List<UniversityDetail> findUniversityDetailByTypeAdmission(@Param("typeadmission") String typeadmission);
}

