package com.lls.service;

import com.lls.repository.Student2Respository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StudentService {

    @Autowired
    private Student2Respository student2Respository;


    @Transactional
    public void update(String name, Integer id){
        student2Respository.update(id, name);
    }

}
