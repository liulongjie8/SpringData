package com.lls.service;

import com.lls.entity.Student;
import com.lls.repository.StudentPagingAndSortingRepositroy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public class StudentPagingAndSortingRepositoryServiceTest {

    private ApplicationContext ctx;

    private StudentPagingAndSortingRepositoryService service;

    @Before
    public void init(){
        ctx = new ClassPathXmlApplicationContext("bean.xml");
        service = ctx.getBean(StudentPagingAndSortingRepositoryService.class);
    }

    @After
    public void destory(){
        ctx=null;
        service = null;
    }

    @Test
    public void testPage(){
        Page<Student> pages = service.page(5,1);
        System.out.println(pages.getTotalPages());
        System.out.println(pages.getSize());
        List<Student> students = pages.getContent();
        for(Student student : students){
            System.out.println("id:" + student.getId() + ", name:" + student.getName() + ", age:" + student.getAge());
        }
    }

    @Test
    public void testPageSort(){
        Page<Student> pages = service.pageSort(5,0);
        System.out.println(pages.getTotalPages());
        System.out.println(pages.getSize());
        System.out.println(pages.getTotalElements());
        List<Student> students = pages.getContent();
        for(Student student : students){
            System.out.println("id:" + student.getId() + ", name:" + student.getName() + ", age:" + student.getAge());
        }
    }

}
