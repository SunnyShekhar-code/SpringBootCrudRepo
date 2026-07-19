package in.strike.SpringbootCrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import in.strike.SpringbootCrud.entity.Student;
import in.strike.SpringbootCrud.repository.StudentRepo;

@Service
public class StudentService {
    private StudentRepo studentRepo;
    public StudentService(StudentRepo studentRepo){
        this.studentRepo=studentRepo;
    }

   

    public Student createStudent(Student reqstudent){
       
        Student newStudent=studentRepo.save(reqstudent);
        return newStudent;
    }

    public Student getStudent(Long id){

        Optional<Student> response= studentRepo.findById(id);
        // Optional<Student> response= StudentRepo.getReferenceById(id);
        // Student response= StudentRepo.getReferenceById(id);
        if(response.isEmpty()) return null;

        Student responseStudent=response.get();
        return responseStudent;
    }

    public List<Student> getAllStudent(){
        List<Student> studentlist=studentRepo.findAll();
        return studentlist;
    }

    public Student updateStudent(long id, Student reqStudent){

        Student existingStudent=getStudent(id);
        if(existingStudent==null) return null;

        existingStudent.setAge(reqStudent.getAge());
        existingStudent.setName(reqStudent.getName());
        existingStudent.setRoll(reqStudent.getRoll());
        existingStudent.setSubject(reqStudent.getSubject());

        Student updatedStudent=studentRepo.save(existingStudent);

        return updatedStudent;
    }

    public boolean deleteStudent(long id){

        boolean response=studentRepo.existsById(id);

        if(!response) return false;

        studentRepo.deleteById(id);
        return true;
    }


    
}
