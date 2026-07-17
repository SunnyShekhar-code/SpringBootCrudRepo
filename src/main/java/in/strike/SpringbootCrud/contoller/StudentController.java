package in.strike.SpringbootCrud.contoller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.strike.SpringbootCrud.entity.Student;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @PostMapping("/create")
    public void createStudent(@RequestBody Student student){

        System.out.println("Student created");
        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student.getRoll());
        System.out.println(student.getSubject());

    }


    @GetMapping("{id}")
    public void getStudent(){
        System.out.println("student detail fetched");
    }

    @GetMapping("/all")
    public void getAllStudent(){
        System.out.println("get all student record");
    }

    @PutMapping("/update/{id}")
    public void updateStudent(){
        System.out.println("Student record updated");
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(){
        System.out.println("Stuudent record deleted (soft delete)");
    }

    
}
