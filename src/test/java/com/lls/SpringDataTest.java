package com.lls;

import com.lls.entity.Student;
import com.lls.repository.Student2Respository;
import com.lls.repository.StudentRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringDataTest {

    private ApplicationContext ctx = null;

    private StudentRepository repository = null;

    private Student2Respository student2Respository = null;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext("bean.xml");
        repository = ctx.getBean(StudentRepository.class);
        student2Respository = ctx.getBean(Student2Respository.class);
    }

    @Test
    public void testFindByName() {
        Student student = repository.findByName("zhangsan");
        Assert.assertNotNull(student);
        System.out.println("id:" + student.getId() + ", name:" + student.getName() + ", age:" + student.getAge());
    }

    @Test
    public void testFindById(){
        Student student = student2Respository.findById(1);
        Assert.assertNotNull(student);
        System.out.println("id:" + student.getId() + ", name:" + student.getName() + ", age:" + student.getAge());
    }

    @Test
    public void testFindByMaxId(){
        Student student = student2Respository.findByMaxId();
        Assert.assertNotNull(student);
        System.out.println("id:" + student.getId() + ", name:" + student.getName() + ", age:" + student.getAge());
    }

    @Test
    public void testFindList(){
       List<Student> students = student2Respository.findList("zhangsan","1");
        for(Student student: students){
            System.out.println("id:" + student.getId() + ", name:" + student.getName() + ", age:" + student.getAge());
        }

    }

    @Test
    public void testFindList2(){
        List<Student> students = student2Respository.findList2("zhangsan","1");
        for(Student student: students){
            System.out.println("id:" + student.getId() + ", name:" + student.getName() + ", age:" + student.getAge());
        }
    }


    @Test
    public void testFindByLikeName(){
        Student student = student2Respository.findByLikeName("zhang");
        Assert.assertNotNull(student);
        System.out.println("id:" + student.getId() + ", name:" + student.getName() + ", age:" + student.getAge());
    }

    @Test
    public void testGetCount(){
        Integer count = student2Respository.getCount();
        Assert.assertNotNull(count);
        System.out.println(count);
    }


    @After
    public void destory() {
        ctx = null;
        repository = null;
        student2Respository=null;
    }


}
