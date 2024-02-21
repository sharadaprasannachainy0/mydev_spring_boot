package com.sharada.cruddemo;

import com.sharada.cruddemo.dao.StudentDAO;
import com.sharada.cruddemo.entity.Student;
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

	// Define new Bean for CommandLineRunner, required for our command line application.
	// CommandLineRunner is from the Spring framework. Executed after the Spring Beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
			//createStudent(studentDAO);

			createMultipleStudent(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsBylastname(studentDAO);

			//updateStudent(studentDAO);

			// updateAllStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteALlStudents(studentDAO);
		};
	}

	private void updateAllStudent(StudentDAO studentDAO) {

		System.out.println("Updating all students ...");
		int numRowsUpdated = studentDAO.updateAll();
	}

	private void deleteALlStudents(StudentDAO studentDAO) {
		System.out.println("Dleteing all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Dleted rows count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;
		System.out.println("Deleting the student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting the student with id : " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to: "Scooby"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Scooby");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsBylastname(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("potter");

		// display list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display the list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Harry","Potter","harry@luv2code.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student: Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		//Display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student ...");
		Student tempStudent1 = new Student("John","Doe", "jhon@luv2code.com");
		Student tempStudent2 = new Student("Mary","Smith", "mary@luv2code.com");
		Student tempStudent3 = new Student("Rock","Doe", "rock@luv2code.com");
		Student tempStudent4 = new Student("Sharada","Chainy", "sharada@luv2code.com");

		// save student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);


		// display id of the saved student
		System.out.println("Saved student: Generated id: " + tempStudent3.getId());

	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student ...");
		Student tempStudent = new Student("Paul","Doe", "paul@luv2code.com");

		// save student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student: Generated id: " + tempStudent.getId());

	}

}
