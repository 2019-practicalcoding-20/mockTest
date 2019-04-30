package repository;

import domain.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> showAll();

    Student findByStudentNum(int studentNum);

    void addStudent(Student student);

}
