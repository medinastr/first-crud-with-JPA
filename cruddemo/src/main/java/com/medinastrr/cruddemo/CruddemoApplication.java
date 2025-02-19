package com.medinastrr.cruddemo;

import com.medinastrr.cruddemo.dao.StudentDAO;
import com.medinastrr.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// this will be executed after the Spring Beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {     // custom code
//			createStudent(studentDAO);
//			readStudent(studentDAO);
//			queryStudents(studentDAO);
//			queryStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student.");
		Student studentTemp = new Student("Johny", "Fernandez", "johny2024f@gmail.com");

		// save the student object
		System.out.println("Saving the student.");
		studentDAO.save(studentTemp);

		// display id of the saved student
		System.out.println("Saved student successfully. ID: " + studentTemp.getId());
	}

	void readStudent(StudentDAO studentDAO) {
		// create, save and display ID of the new student
		Student student = new Student("Maria", "Rodrigues de Souza", "maria2024r@gmail.com");
		studentDAO.save(student);
		System.out.println("ID of new student: " + student.getId());

		// retrieve student based on the id: primary key
		Student temp = studentDAO.findById(student.getId());

		// display the student
		System.out.println("Found the student: " + temp);
	}

	void queryStudents(StudentDAO studentDAO) {
		// get list of students
		List<Student> students = studentDAO.findAll();

		// display list of students
		for(Student s : students) {
			System.out.println(s);
		}
	}
	void queryStudentsByLastName(StudentDAO studentDAO) {
		// get list of students and display it
		List<Student> students = studentDAO.findByLastName("Rodrigues de Souza");
		for(Student s : students) {
			System.out.println(s);
		}
	}

	void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id: primary key
		int id = 2;
		Student student = studentDAO.findById(id);

		// change student firstName
		student.setFirstName("Pedro");

		// update student and display the updated student
		studentDAO.update(student);
		System.out.println("Updated student: " + student);
	}

	void deleteStudent(StudentDAO studentDAO) {
		int id = 3;
		studentDAO.delete(id);
	}

	void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int rowsDeleted = studentDAO.deleteAll();
		System.out.println("Rows deleted: " + rowsDeleted);
	}
}
