package service;

import domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import repository.StudentRepository;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.core.Is;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest{
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void whenBringStudentName_returnRiot(){
        Student student = mock(Student.class);
        when(student.getName()).thenReturn("Riot");
        assertThat(student.getName(), Is.is("Riot"));
    }

    @Test
    public void whenBringStudentNum_haveToReturnZero(){
        Student student = mock(Student.class);

        when(student.getName()).thenReturn("Zero");
        assertThat(student.getName(), Is.is("Zero"));
    }

    // 2. 챔피언 이름으로 야스오를 저장하면, doThrow를 사용하여 Exception이 발생하도록 테스트 하세요.
    @Test(expected = IllegalArgumentException.class)
    public void 챔피언이름으로_야스오를저장하면_Exception(){
        Student Student = mock(Student.class);

        doThrow(new IllegalArgumentException()).when(Student).setName(eq("야스오"));
        Student.setName("야스오");
    }


}