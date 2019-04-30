package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    public String name;
    public int studentNum;
    public int age;
    public String gender;
    public String schoolName;
    //public int grade;
}
