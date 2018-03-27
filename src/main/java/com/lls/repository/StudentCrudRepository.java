package com.lls.repository;

import com.lls.entity.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * 利用CRUDRepositroy实现
 */
public interface StudentCrudRepository extends CrudRepository<Student,Integer>{

}
