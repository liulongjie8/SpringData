package com.lls.repository;

import com.lls.entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.RepositoryDefinition;

public interface StudentPagingAndSortingRepositroy  extends PagingAndSortingRepository<Student,Integer>{

}
