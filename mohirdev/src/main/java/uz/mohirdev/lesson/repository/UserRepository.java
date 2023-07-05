package uz.mohirdev.lesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.mohirdev.lesson.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLogin(String login);
    User findByLogin(String Login);
}
