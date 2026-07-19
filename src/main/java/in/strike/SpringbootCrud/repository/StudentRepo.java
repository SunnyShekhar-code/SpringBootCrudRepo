package in.strike.SpringbootCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import in.strike.SpringbootCrud.entity.Student;


public interface StudentRepo extends JpaRepository<Student,Long> {

   
    
}
