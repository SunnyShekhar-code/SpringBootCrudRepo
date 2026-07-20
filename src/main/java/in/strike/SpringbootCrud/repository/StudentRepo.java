package in.strike.SpringbootCrud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import in.strike.SpringbootCrud.entity.Student;


public interface StudentRepo extends JpaRepository<Student,Long> {

    Optional<Student> findByIdAndDeletedIsFalse(long id);
    List<Student> findByDeletedIsFalse();
    boolean existsByIdAndDeletedIsFalse(long id);



    // findBy + fieldName + condition

   
    
}
