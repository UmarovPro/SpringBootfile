package uz.mohirdev.lesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.mohirdev.lesson.entity.PostData;
@Repository
public interface PostDataRepository extends JpaRepository<PostData, Long> {
}
