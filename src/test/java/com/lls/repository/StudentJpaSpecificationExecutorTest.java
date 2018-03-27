package com.lls.repository;

import com.lls.entity.Student;
import com.lls.service.StudentPagingAndSortingRepositoryService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.persistence.criteria.*;
import java.util.List;

public class StudentJpaSpecificationExecutorTest  {

    private ApplicationContext ctx;

    private StudentJpaSpecificationExecutor  service;

    @Before
    public void init(){
        ctx = new ClassPathXmlApplicationContext("bean.xml");
        service = ctx.getBean(StudentJpaSpecificationExecutor.class);
    }

    @After
    public void destory(){
        ctx=null;
        service = null;
    }
    @Test
    public void testPageSort(){
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Pageable page = new PageRequest(0,5,new Sort(order));

        Specification<Student> specification = new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<String> path = root.get("name");
                Predicate p = cb.equal(path,"zhangwo");
                return p;
            }
        };

        Page<Student> pages = service.findAll( specification, page);

        List<Student> students = pages.getContent();
        for(Student student : students){
            System.out.println("id:" + student.getId() + ", name:" + student.getName() + ", age:" + student.getAge());
        }
    }

    @Test
    public void testPageSort2(){
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Pageable page = new PageRequest(0,5,new Sort(order));

        Specification<Student> specification = new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<String> name = root.get("name");
                Path<Integer> id = root.get("id");
                query.where(cb.ge(id,200), cb.like(name,"zhang"));
                return null;
            }
        };

        Page<Student> pages = service.findAll( specification, page);

        List<Student> students = pages.getContent();
        for(Student student : students){
            System.out.println("id:" + student.getId() + ", name:" + student.getName() + ", age:" + student.getAge());
        }
    }

}
