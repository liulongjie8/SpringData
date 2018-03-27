# SpringData
Spring Data Jpa Repository 实现的两种方式：

1 StudentRepository 继承 Repository 接口 实现  -->Repository<Student, Integer>
2 StudentRepository 利用注解RepositoryDefinition实现 -->@RepositoryDefinition(domainClass = Student.class,idClass = Integer.class)

注意： Repository 为标记接口【接口里面没有任何方法定义的接口称为标记接口，例如 序列化接口】
