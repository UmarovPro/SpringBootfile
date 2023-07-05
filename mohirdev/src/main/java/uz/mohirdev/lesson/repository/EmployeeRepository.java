package uz.mohirdev.lesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.mohirdev.lesson.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
   // @Query("select e from Employee e")
   // @Query("select e from Employee e where e.name = 'Shodmon 1'") server tarafidan ma'lumot kiritish
    @Query("select e from Employee e where e.name = :name and e.lastName = :lastName")
    List<Employee> findAll(@Param("name") String name,
                           @Param("lastName") String lastName);

    List<Employee> findAllByNameAndLastName(String name, String lastName);

    @Query(value = "SELECT * from employee e where e.last_name = :name", nativeQuery = true)
    List<Employee> findAll(@Param("name") String name);
    //List<Employee> findAllByNameLike(String name);
    List<Employee> findAllByNameStartingWithOrderByIdDesc(String name);

    @Query("select e from Employee e where UPPER(e.name)" +
            "like upper(concat('%',:name, '%')) order by e.id desc ")
    List<Employee> findAllByNameLikeJPQL(@Param("name") String name);

    @Query(value = "SELECT * FROM employee e Where e.name like %:name% ORDER by id desc", nativeQuery = true)
    List<Employee> findAllByNameLikeNative(@Param("name")String name);

 List<Employee> findAllByNameStartingWith(String name);

    Employee save(Employee employee);
}
