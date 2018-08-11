package com.gpch.unittest.service;

import com.gpch.unittest.model.Student;
import com.gpch.unittest.repository.StudentRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class StudentServiceTest {

    @Mock
    private StudentRepository mockStudentRepository;

    private StudentService studentServiceUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        studentServiceUnderTest = new StudentService(mockStudentRepository);

        final Student student1 =
                Student.builder()
                        .id(1)
                        .name("student 1")
                        .lastName("Last Name 1")
                        .active(true)
                        .build();

        Mockito.when(mockStudentRepository.findById(1))
                .thenReturn(Optional.of(student1));
    }

    @Test
    public void testGetStudentById() {

        // Run the test
        final Student result = studentServiceUnderTest.getStudentById(1);

        // Verify the results
        assertEquals("student 1", result.getName());
        assertEquals(true, result.isActive());

    }

}
