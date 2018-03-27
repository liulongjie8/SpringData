# SpringData

Spring Data Jpa Repository 实现的两种方式：

1 StudentRepository 继承 Repository 接口 实现  -->Repository<Student, Integer>
2 StudentRepository 利用注解RepositoryDefinition实现 -->@RepositoryDefinition(domainClass = Student.class,idClass = Integer.class)

注意： Repository 为标记接口【接口里面没有任何方法定义的接口称为标记接口，例如 序列化接口】


Repository 自接口：

  1> CrudRepository 通用的CRUD操作
       options:
                    a>findOne(ID args);  return T   根据ID获取实体类对象
                    b>findALl(); return Iterable<T> 获取所有的实体类对象
                    c>findAll(Iterable<ID> args); return Iterable<T> 根据IDS获取实体类对象
                    d>long count(); 获取总条数
                    e>void delete(ID var1);根据ID删除对象
                    f>void delete(T var1); 根据实体类对象删除
                    g>void delete(Iterable<? extends T> var1);
                    h>void deleteAll();
  2> PagingAndSortingRepository 继承了CRUDRepository，实现了分页排序的相关方法
        options:
                  a>Iterable<T> findAll(Sort var1);
                  b>Page<T> findAll(Pageable var1);
  3> JapRepository 继承了PagingAndSortingRepository 实现了Jpa规范相关的方法


Spring Data 查询方法名称的定义规则：

         Keyword             Sample                              SQL  
         And                 findByLastnameAndFirstname          where x.lastname =? and x.firstname = ?
         Or                  findByLastnameOrFirstname           where x.lastname = ? or x.firstname = ?
         Between             findByStartDateBetween              where x.startDate between ? and ? 
         LessThan            ---------------------                 ---------------------
         -------             ---------------------                 ---------------------
         
         
 @Query 查询注解：
 
      eg: 获取最大ID的Student
      
       @Query("select o from Student  o  where id=(select  max(id) from Student)")
       public Student findByMaxId();
       
       其中 select ｏ　from  Student中的 Student 为类型  o为对象别名
       
    @Query("select o from Student  o  where id=(select  max(id) from Student)")
    public Student findByMaxId();

    @Query("select o from Student  o where o.name=?1 and o.age=?2")
    public List<Student> findList(String name, String age);

    @Query("select o from Student  o where o.name=:name and o.age=:age")
    public List<Student> findList2(@Param("name") String name, @Param("age") String age);

    @Query("select o from Student  o  where o.name like %?1%")
    public Student findByLikeName(String name);
    
     @Query 实现原生态查询  
     @Query(nativeQuery = true, value = "select count(1) from  student")
     public Integer getCount(); ---->     此时的 student 为数据库表名
    
     
    @Modifying       -必须支持事务
    @Query("update Student o  set  o.name= :name where o.id= :id")
    public void update(@Param("id") Integer id,@Param("name")  String name); 

   
