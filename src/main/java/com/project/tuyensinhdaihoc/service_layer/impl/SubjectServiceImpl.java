package com.project.tuyensinhdaihoc.service_layer.impl;

import com.project.tuyensinhdaihoc.data_access_layer.model.Subject;
import com.project.tuyensinhdaihoc.data_access_layer.repository.SubjectRepo;
import com.project.tuyensinhdaihoc.service_layer.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepo subjectRepo;

    @Autowired
    public SubjectServiceImpl(SubjectRepo subjectRepo) {
        this.subjectRepo = subjectRepo;
    }


    public List<Subject> findFiveSubject() {
        return subjectRepo.findTop5();
    }
}
