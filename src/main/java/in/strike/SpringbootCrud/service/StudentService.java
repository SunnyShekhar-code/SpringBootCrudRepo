package in.strike.SpringbootCrud.service;

import org.springframework.stereotype.Component;

import in.strike.SpringbootCrud.entity.Student;
import in.strike.SpringbootCrud.repository.StudentRepo;

@Component
public class StudentService {
     private StudentRepo studentRepo;
    public StudentService(StudentRepo studentRepo){
        this.studentRepo=studentRepo;
    }

   

    public Student createStudent(Student student){
        System.out.println("inside studentService");
        Student newStudent=studentRepo.registerStudent(student);
        System.out.println("ecxit studentService");

        return newStudent;
    }


    
}
