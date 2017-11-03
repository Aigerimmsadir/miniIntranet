package ex2;

import java.io.Serializable;

public class Instructor implements Serializable {
	private String firstName;
	private String lastName;
	private String department;
	private String email;
	
	public Instructor(String a,String b,String c,String d) {
		firstName =a;
		lastName = b;
		department = c;
		email = d;
	}
	
	String getFirstName() {
		return firstName;
	}
	void setFirstName(String firstName) {
		this.firstName =firstName;
	}
	String getLastName() {
		return lastName;
	}
	void setLastName(String lastName) {
		this.lastName = lastName;
	}
	String getDepartment() {
		return department;
	}
	void setDepartment(String department) {
		this.department = department;
	}
	String getEmail() {
		return email;
	}
	void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "Instructor "+ firstName+" "+lastName+" works in "+department+" and the email is "+email;
	}
	public boolean equals(Object o) {
		Instructor i1 = (Instructor) o;
		if(i1.firstName==firstName && i1.lastName==lastName && i1.department==department && i1.email ==email) return true;
		return false;
	}
}
