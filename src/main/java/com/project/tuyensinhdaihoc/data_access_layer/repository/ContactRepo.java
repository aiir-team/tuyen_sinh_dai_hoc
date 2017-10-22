package com.project.tuyensinhdaihoc.data_access_layer.repository;

import com.project.tuyensinhdaihoc.data_access_layer.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer> {

    List<Contact> findByNameContaining(String q);
}
