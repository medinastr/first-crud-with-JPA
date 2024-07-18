package com.medinastrr.cruddemo;

import com.medinastrr.cruddemo.dao.StudentDAO;
import com.medinastrr.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// this will be executed after the Spring Beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {     // custom code
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student.");
		Student studentTemp = new Student("Gabriel", "Menezes Assis", "gabriel2024m@gmail.com");

		// save the student object
		System.out.println("Saving the student.");
		studentDAO.save(studentTemp);

		// display id of the saved student
		System.out.println("Saved student successfully. ID: " + studentTemp.getId());
	}

}
