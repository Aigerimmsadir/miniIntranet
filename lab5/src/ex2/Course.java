package ex2;

import java.io.Serializable;

public class Course implements Serializable {
	String courseTitle;
	Instructor instructor;
	Textbook textbook;
	
	
	public Course(String courseTitle,String a,String b,String c,String d,String isbn,String title,String author) {
		this.courseTitle = courseTitle;
		instructor = new Instructor(a,b,c,d);
		textbook = new Textbook(isbn,title,author);
	}
	//publuc Course(String a,Instructor b,Textbook )
	public String toString() {
		return "This course's title is "+courseTitle+",instructor is "+instructor.getLastName()+" and required textbook is "+textbook.getTitle();
	}
}
