package com.project.tuyensinhdaihoc.service_layer;

import com.project.tuyensinhdaihoc.data_access_layer.model.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();

    List<Contact> search(String q);

    Contact findOne(Integer id);

    void save(Contact contact);

    void delete(Integer id);
}
