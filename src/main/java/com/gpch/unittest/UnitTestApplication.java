package com.gpch.unittest;

import com.gpch.unittest.model.Student;
import com.gpch.unittest.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class UnitTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnitTestApplication.class, args);
    }

    @Bean
    public CommandLineRunner setup(StudentService studentService) {
        return (args) -> {
            studentService.createStudent(Student.builder().name("Name 1").lastName("Last Name 1").active(false).build());
            studentService.createStudent(Student.builder().name("Name 2").lastName("Last Name 2").active(true).build());
            studentService.createStudent(Student.builder().name("Name 3").lastName("Last Name 3").active(false).build());
            studentService.createStudent(Student.builder().name("Name 4").lastName("Last Name 4").active(true).build());
            studentService.createStudent(Student.builder().name("Name 5").lastName("Last Name 5").active(true).build());
            studentService.createStudent(Student.builder().name("Name 6").lastName("Last Name 6").active(true).build());
            log.info("The sample data has been generated");
        };
    }
}
