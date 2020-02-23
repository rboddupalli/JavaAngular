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
	
	
	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName, String emailId,
			String gender, Date doj, String department, boolean active) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.gender = gender;
		this.doj = doj;
		this.department = department;
		this.active = active;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailId=" + emailId
				+ ", gender=" + gender + ", doj=" + doj + ", department="
				+ department + ", active=" + active + "]";
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
		this.doj = doj;
	}

	@Column(name = "department", nullable = false)
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;

	}


	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;		
	}
}
