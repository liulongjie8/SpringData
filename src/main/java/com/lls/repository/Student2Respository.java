package com.lls.repository;

import com.lls.entity.Student;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * SpringData 采用注解实现SpringData Jpa
 */
@RepositoryDefinition(domainClass = Student.class,idClass = Integer.class)
public interface Student2Respository {

    public Student findById(Integer id);

}
