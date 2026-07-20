package in.strike.SpringbootCrud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        reqstudent.setDeleted(false);
        Student newStudent=studentRepo.save(reqstudent);
        return newStudent;
    }

    public Student getStudent(Long id){

        Optional<Student> response= studentRepo.findByIdAndDeletedIsFalse(id);
      
        if(response.isEmpty()) return null;

        Student responseStudent = response.get();
        // if(responseStudent.isDeleted()) return null;
        return responseStudent;
    }

    public List<Student> getAllStudent(){
        List<Student> studentlist=studentRepo.findAllAndDeletedIsFalse();
        // List<Student> responselist= new ArrayList<>();
        // for(Student student:studentlist){
        //     if(!student.isDeleted()) responselist.add(student);
        // }
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

        boolean response=studentRepo.existsByIdAndDeletedIsFalse(id);
        if(!response) return false;


        // Student student=getStudent(id); 
        // if(student==null || student.isDeleted()) return false;

        studentRepo.deleteById(id);
        return true;
    }

    public boolean softDeleteStudent(long id){
        Student existingStudent= getStudent(id);
        if(existingStudent==null) return false;

        existingStudent.setDeleted(true);
        studentRepo.save(existingStudent);
        return true;
    }


    
}
