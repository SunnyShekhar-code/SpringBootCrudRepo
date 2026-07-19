package in.strike.SpringbootCrud.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.strike.SpringbootCrud.entity.Student;
import in.strike.SpringbootCrud.service.StudentService;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

        
        Student newStudent= studentService.createStudent(student);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }

    // get api
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student response= studentService.getStudent(id);
        if(response==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // get app
    @GetMapping("/getall")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> response= studentService.getAllStudent();

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student reqStudent){
        // System.out.println("update api");
        Student resposestudent=studentService.updateStudent(id,reqStudent);
        // Student resposestudent=null;

        if(resposestudent==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(resposestudent);
        
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable Long id){

        boolean response= studentService.deleteStudent(id);
        if(!response) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
        
    }

    
}
