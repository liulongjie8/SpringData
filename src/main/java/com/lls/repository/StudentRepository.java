package com.lls.repository;

import com.lls.entity.Student;
import org.springframework.data.repository.Repository;

/**
 * Spring Data 继承接口实现SpringData Jpa
 */
public interface StudentRepository extends Repository<Student,Integer>{

    public Student findByName(String name);

}
