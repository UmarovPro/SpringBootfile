package uz.mohirdev.lesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.mohirdev.lesson.entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

