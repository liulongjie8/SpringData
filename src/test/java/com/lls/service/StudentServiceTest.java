package com.lls.service;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentServiceTest {
    private ApplicationContext ctx = null;

    private StudentService service = null;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext("bean.xml");
        service = ctx.getBean(StudentService.class);
    }

    @Test
    public void testUpdate(){
        service.update("zhangsan1",1);
    }


    @After
    public void destory(){
        ctx = null;
        service=null;
    }


}
