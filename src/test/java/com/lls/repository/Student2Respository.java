package com.lls.repository;

import com.lls.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * SpringData 采用注解实现SpringData Jpa
 */
@RepositoryDefinition(domainClass = Student.class,idClass = Integer.class)
public interface Student2Respository {

    public Student findById(Integer id);

    @Query("select o from Student  o  where id=(select  max(id) from Student)")
    public Student findByMaxId();

    @Query("select o from Student  o where o.name=?1 and o.age=?2")
    public List<Student> findList(String name, String age);

    @Query("select o from Student  o where o.name=:name and o.age=:age")
    public List<Student> findList2(@Param("name") String name, @Param("age") String age);

    @Query("select o from Student  o  where o.name like %?1%")
    public Student findByLikeName(String name);

    @Query(nativeQuery = true, value = "select count(1) from  student")
    public Integer getCount();

    @Modifying
    @Query("update Student o  set  o.name= :name where o.id= :id")
    public void update(@Param("id") Integer id,@Param("name")  String name);

}
