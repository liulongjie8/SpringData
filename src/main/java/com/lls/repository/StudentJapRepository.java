package com.lls.repository;

import com.lls.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJapRepository extends JpaRepository<Student,Integer> {

}
