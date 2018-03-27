package com.lls.repository;

import com.lls.entity.Student;
import org.springframework.data.repository.Repository;

public interface StudentRepository extends Repository<Student,Integer>{

    public Student findByName(String name);

}
