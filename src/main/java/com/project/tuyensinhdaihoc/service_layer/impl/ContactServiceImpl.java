package com.project.tuyensinhdaihoc.service_layer.impl;

import com.project.tuyensinhdaihoc.data_access_layer.model.Contact;
import com.project.tuyensinhdaihoc.data_access_layer.repository.ContactRepo;
import com.project.tuyensinhdaihoc.service_layer.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepo contactRepo;

    @Autowired
    public ContactServiceImpl(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    @Override
    public List<Contact> findAll() {
        return contactRepo.findAll();
    }

    @Override
    public List<Contact> search(String q) {
        return contactRepo.findByNameContaining(q);
    }

    @Override
    public Contact findOne(Integer id) {
        return contactRepo.findOne(id);
    }

    @Override
    public void save(Contact contact) {
        contactRepo.save(contact);
    }

    @Override
    public void delete(Integer id) {
        contactRepo.delete(id);
    }
}
