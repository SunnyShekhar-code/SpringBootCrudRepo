package in.strike.SpringbootCrud.repository;

import in.strike.SpringbootCrud.entity.Student;

public class StudentRepo {

    public Student registerStudent(Student student){

        // interact withh db , for now i am createing fakke student
         System.out.println("inside studentRepo");
        Student newStudent = new Student();
        newStudent.setName(student.getName());
        newStudent.setAge(student.getAge());
        newStudent.setRoll(student.getRoll());
        newStudent.setSubject(student.getSubject());
         System.out.println("exit studentRepo");
        return newStudent;


    }
    
}
