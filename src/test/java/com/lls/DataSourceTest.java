package com.lls;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.sql.DataSource;
public class DataSourceTest {

    private ApplicationContext ctx = null;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext("bean.xml");
    }


    @Test
    public void testDataSource() {
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        Assert.assertNotNull(dataSource);
    }

    @Test
    public void testEntiryManagerFactory(){

    }


    @After
    public void destory() {
        ctx = null;
    }

}
