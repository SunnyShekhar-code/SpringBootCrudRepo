package in.strike.SpringbootCrud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import in.strike.SpringbootCrud.entity.Student;


public interface StudentRepo extends JpaRepository<Student,Long> {

    Optional<Student> findByIdAndDeletedIsFalse(long id);
    List<Student> findAllAndDeletedIsFalse();
    boolean existsByIdAndDeletedIsFalse(long id);

   
    
}
