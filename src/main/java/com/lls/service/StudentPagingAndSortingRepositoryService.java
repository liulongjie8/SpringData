package com.lls.service;

import com.lls.entity.Student;
import com.lls.repository.StudentPagingAndSortingRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentPagingAndSortingRepositoryService {

    @Autowired
    private StudentPagingAndSortingRepositroy repository;

    public Page page(Integer size, Integer num){
        Pageable page = new PageRequest(num, size);
        return  repository.findAll(page);
    }

    public Page pageSort(Integer size, Integer num){
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Pageable page = new PageRequest(num,size,new Sort(order));
        return repository.findAll(page);
    }

}
