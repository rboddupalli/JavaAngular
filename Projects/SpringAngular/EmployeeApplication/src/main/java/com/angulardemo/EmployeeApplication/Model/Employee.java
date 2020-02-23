package com.angulardemo.EmployeeApplication.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	private long id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String gender;
	private Date doj;
	private String  department;
	private boolean active;
	
	
<<<<<<< HEAD
	public Employee(String firstName, String lastName, String emailId,
			String gender, Date dob, String department, boolean active) {
=======
	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName, String emailId,
			String gender, Date doj, String department, boolean active) {
>>>>>>> f5577b17559e1cca5b65a7aa6f4d1c8d0f82ddef
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.gender = gender;
<<<<<<< HEAD
		this.doj = dob;
		this.department = department;
		this.active = active;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailId=" + emailId
				+ ", gender=" + gender + ", dob=" + doj + ", department="
				+ department + ", active=" + active + "]";
	}



	public Employee() {
		
=======
		this.doj = doj;
		this.department = department;
		this.active = active;
>>>>>>> f5577b17559e1cca5b65a7aa6f4d1c8d0f82ddef
	}
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "email_address", nullable = false)
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Column(name = "gender", nullable = false)
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "date_of_join", nullable = false)
	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
<<<<<<< HEAD
		this.doj = doj;
=======
		this.dob = doj;
>>>>>>> f5577b17559e1cca5b65a7aa6f4d1c8d0f82ddef
	}

	@Column(name = "department", nullable = false)
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;

	}


<<<<<<< HEAD
	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
=======
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailId=" + emailId
				+ ", gender=" + gender + ", doj=" + doj + ", department="
				+ department + "]";
>>>>>>> f5577b17559e1cca5b65a7aa6f4d1c8d0f82ddef
	}

		
}
