package com.lls.service;

import com.lls.entity.Student;
import com.lls.repository.StudentCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentCrudService {

    @Autowired
    private StudentCrudRepository repository;

    /**
     * 保存Student
     * @param student
     * @return
     */
    @Transactional
    public Student save(Student student){
        repository.save(student);
        return student;
    }

    /**
     * 保存Students集合
     * @param students
     */
    @Transactional
    public void save(List<Student> students){
        repository.save(students);
    }


    /**
     * 获取全部实体对象
     * @return
     */
    public List<Student> findAll(){
        return (List<Student>) repository.findAll();
    }

    /**
     * 根据ID获取实体对象
     * @param id
     * @return
     */
    public Student findById(Integer id){
        return  repository.findOne(id);
    }


}
