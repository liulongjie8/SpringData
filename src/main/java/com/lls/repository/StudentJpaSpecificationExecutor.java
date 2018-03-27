package com.lls.repository;

import com.lls.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentJpaSpecificationExecutor extends JpaSpecificationExecutor<Student> ,JpaRepository<Student, Integer> {

}
