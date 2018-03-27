package com.lls.service;
import com.lls.entity.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class StudentCrudRepositoryTest {

    private ApplicationContext ctx;

    private StudentCrudService service;

    @Before
    public void init(){
        ctx = new ClassPathXmlApplicationContext("bean.xml");
        service = ctx.getBean(StudentCrudService.class);
    }

    @After
    public void destory(){
        ctx=null;
        service = null;
    }

    @Test
    public void testSave(){
        Student student = new Student();
        student.setAge("20");
        student.setName("zhangwo");
        service.save(student);

    }

    @Test
    public void testFindAll(){
        List<Student> students = service.findAll();
        for(Student student: students){
            System.out.println("id:" + student.getId() + ", name:" + student.getName() + ", age:" + student.getAge());
        }
    }

    @Test
    public void testFindById(){
        Student student = service.findById(5);
        System.out.println("id:" + student.getId() + ", name:" + student.getName() + ", age:" + student.getAge());
    }

   @Test
    public void testSaveList(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("test1", "test1"));
        students.add(new Student("test2", "test2"));
        students.add(new Student("test3", "test3"));
        students.add(new Student("test4", "test4"));
        students.add(new Student("test5", "test5"));
        service.save(students);
    }

}
