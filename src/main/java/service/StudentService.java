package service;

import domain.Student;
import repository.StudentRepository;

import java.util.List;

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository mockStudents) {
        this.studentRepository= mockStudents;
    }

    public List<Student> showAllStudents() {
        return studentRepository.showAll();
    }

    public Student findByStudentNum(int studentNum)
    {
        Student student = studentRepository.findByStudentNum(studentNum);
        return student;
    }

    public void addStudent(Student student)
    {
        Student addStudent = new Student(student.getName(), student.getStudentNum(), student.getAge(), student.getGender(), student.getSchoolName());
        studentRepository.addStudent(addStudent);
        return;
    }


}
