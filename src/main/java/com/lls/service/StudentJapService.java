package com.lls.service;

import com.lls.entity.Student;
import com.lls.repository.StudentJapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentJapService {

    @Autowired
    private StudentJapRepository repository;


    public Student findById(Integer id){
        return repository.getOne(id);
    }

    public List<Student> findAll(){
        return repository.findAll();
    }

}
