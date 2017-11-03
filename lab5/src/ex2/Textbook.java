package ex2;

import java.io.Serializable;

public class Textbook implements Serializable  {

	
	private String isbn;
	private String title;
	private String author;
	
	public Textbook(String isbn,String title,String author) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}
	
	
	String getIsbn() {
		return isbn;
	}
	void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	String getTitle() {
		return title;
	}
	void setTitle(String title) {
		this.title = title;
	}
	String getAuthor() {
		return author;
	}
	void setAuthour(String author) {
		this.author = author;
	}
	
	public String toString() {
		return "The book called "+title+" was written by "+author+" and its ISBN is "+isbn;
	}
	public boolean equals(Object o) {
		Textbook t1 = (Textbook) o;
		if(t1.title==title && t1.author==author && t1.isbn==isbn) return true;
		return false;
	}
}
