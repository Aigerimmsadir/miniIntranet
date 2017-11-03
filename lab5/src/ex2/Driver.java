package ex2; 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.Scanner; 

public class Driver { 
	static List<Course> availableCourses = new ArrayList<Course>(); 
	static List<Textbook> library = new ArrayList<Textbook>(); 
	static List<Instructor> instructors = new ArrayList<Instructor>();

	//serialization/deserialisation
	
	public static List<Course> deserializeC() throws IOException, ClassNotFoundException{ 
		FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\lab5\\bin\\ex2\\Course.out"); 
		ObjectInputStream oin =new ObjectInputStream(fis); 
		List<Course> list = (List<Course>)oin.readObject(); 
		return list; 
	} 
	public static List<Textbook> deserializeT() throws IOException, ClassNotFoundException{ 
		FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\lab5\\bin\\ex2\\Textbook.out"); 
		ObjectInputStream oin =new ObjectInputStream(fis); 
		List<Textbook> list = (List<Textbook>)oin.readObject(); 
		return list; 
	} 
	public static List<Instructor> deserializeI() throws IOException, ClassNotFoundException{ 
		FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\lab5\\bin\\ex2\\Instructor.out"); 
		ObjectInputStream oin =new ObjectInputStream(fis); 
		List<Instructor> list = (List<Instructor>)oin.readObject(); 
		return list; 
	} 
	
	public static void SerializeT(List<Textbook> l) throws IOException { 
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Lenovo\\eclipse-workspace\\lab5\\bin\\ex2\\Textbook.out"); 
		ObjectOutputStream oos = new ObjectOutputStream(fos); 
		oos.writeObject(l); 
		oos.flush(); 
		oos.close(); 
	} 
	public static void SerializeC(List<Course> l) throws IOException { 
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Lenovo\\eclipse-workspace\\lab5\\bin\\ex2\\Course.out"); 
		ObjectOutputStream oos = new ObjectOutputStream(fos); 
		oos.writeObject(l); 
		oos.flush(); 
		oos.close(); 
	} 
	public static void SerializeI(List<Instructor> l) throws IOException { 
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Lenovo\\eclipse-workspace\\lab5\\bin\\ex2\\Instructor.out"); 
		ObjectOutputStream oos = new ObjectOutputStream(fos); 
		oos.writeObject(l); 
		oos.flush(); 
		oos.close(); 
	} 
	
	
	
	//user mode 
	public static void printListOfCourses() throws ClassNotFoundException, IOException { 
	
		List<Course> desCourses = deserializeC(); 
		
		for(int i =0;i<desCourses.size();i++) { 
		System.out.println(i+") "+ desCourses.get(i).courseTitle); 
		} 
	} 
	public static void printLibrary() throws IOException, ClassNotFoundException { 
	
		List<Textbook> desLibrary = deserializeT(); 
		for(int i =0;i<desLibrary.size();i++) { 
		System.out.println(i+") "+desLibrary.get(i).getTitle()); 
		} 
	} 
	public static void printCourseInfo() throws IOException, ClassNotFoundException{ 
	
		List<Course> desCourses = deserializeC(); 
		
		for(int i =0;i<desCourses.size();i++) { 
			System.out.println((i+1)+") Selected course: "+ desCourses.get(i).courseTitle); 
			System.out.println("About course: "+ desCourses.get(i)); 
			System.out.println("About instructor: "+ desCourses.get(i).instructor); 
			System.out.println("Textbook required: "+ desCourses.get(i).textbook+"\n"); 
		} 
	}
	public static void printInstructors() throws ClassNotFoundException, IOException {
		List<Instructor> desInstructors = deserializeI();
		System.out.println("List of instructors below:");
		for(Instructor i : desInstructors) {
			System.out.println(i);
		}	
	} 
	public static void printListOfInstructors() throws ClassNotFoundException, IOException { 
		List<Instructor> desInstructors = deserializeI();
		System.out.println("List of instructors below:");
		for(Instructor i : desInstructors) {
			System.out.println(i.getLastName());
		}	
	} 
	//admin mode
	
	static String login = "root"; 
	static String password = "me"; 
	
	public static void addCourse(Course c) throws IOException, ClassNotFoundException { 
		availableCourses.add(c);
	} 
	public static void addTextbook(Textbook t) throws IOException, ClassNotFoundException { 

		library.add(t);
		
	} 
	public static void addInstructor(Instructor i) throws IOException, ClassNotFoundException {
		instructors.add(i);
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException { 
		FileWriter fw = new FileWriter("C:\\Users\\Lenovo\\eclipse-workspace\\lab5\\bin\\ex2\\admin.txt",true); 
		BufferedReader bw = new BufferedReader( new FileReader("C:\\Users\\Lenovo\\eclipse-workspace\\lab5\\bin\\ex2\\admin.txt"));
		int hash=password.hashCode(); ;
		if(bw.readLine()==null) {
			fw.write(login+"\n"); 
		
			fw.append(hash+"\n"); 
		}
		
		System.out.println("Select your mode:\nPress 1 to select USER mode \nPress 2 to select ADMIN mode"); 
		Scanner sc = new Scanner(System.in); //sc.close(); 
		int m = sc.nextInt(); 
		
		//user
		if(m == 1) {
			System.out.println("Press 1 to view all available courses\nPress 2 to view all textbooks in the library" 
			+ "\nPress 3 to view detailed information about courses\nPress 4 to view list of all instructors"); 
			m=sc.nextInt(); 
			if(m == 1) printListOfCourses(); 
			else if(m== 2) printLibrary(); 
			else if(m==3) printCourseInfo(); 
			else if(m==4) printInstructors();
		} 
		//admin
		else if(m== 2) { 
			System.out.println("Please enter your login and password:"); 
			String l = sc.next(); 
			String p = sc.next(); 
			if(l.equals(login)&& p.hashCode()==hash) { 
				if(p.equals(password)) { 
					
				System.out.println("Select material to add"); 
				String ch = sc.next(); 
				LocalDateTime now = LocalDateTime.now(); 
				if(ch.equals("Course")){ 
					System.out.println("please enter title of the course");
					String title = sc.next();
					Instructor i =null;
					Textbook t = null;
					System.out.println("Please select instructor or press 0 to enter info");
					printListOfInstructors();
					m = sc.nextInt();
					if(m==0) {
						System.out.println("Please enter instructor's name,surname,department and e-mail");
						i = new Instructor(sc.next(),sc.next(),sc.next(),sc.next());
						addInstructor(i);
					}else	i = deserializeI().get(m-1);
				
				
					System.out.println("Please select textbook or press 0 to enter info");
					printLibrary();
					m = sc.nextInt();
				
					if(m==0) {
						System.out.println("please enter isbn of textbook,its title and author's surname");
						t = new Textbook(sc.next(),sc.next(),sc.next());
						addTextbook(t);
					} else t = deserializeT().get (m-1);
					
					Course c = new Course(title,i.getFirstName(),i.getLastName(),i.getDepartment(),i.getEmail(),t.getIsbn(),t.getTitle(),t.getAuthor()); 
					addCourse(c); 
					String report = "admin added new course "+c.courseTitle+"\n"; 
					fw.append(now+" "+report); 
				} 
				else if (ch.equals("Textbook")) { 
					System.out.println("please enter the isbn,title and author of the book"); 
					Textbook t =new Textbook(sc.next(),sc.next(),sc.next()); 
					addTextbook(t); 
					String report = "admin added new textbook "+t.getTitle()+"\n"; 
					fw.append(now+" "+report); 
				} 
		
		
		
				} 
			} 
		} 
		
		
		//serialize all
		try { 
			List<Textbook> desTextbooks = (List<Textbook>)deserializeT(); 
			for(Textbook t: library)
				desTextbooks.add(t); 
			SerializeT(desTextbooks); 
		}catch(FileNotFoundException e) { 
			SerializeT(library); 
		} 
		try { 
			List<Course> desCourses = deserializeC(); 
			for(Course c1 : availableCourses)
				desCourses.add(c1); 
			SerializeC(desCourses); 
		}catch(FileNotFoundException e) { 
			SerializeC(availableCourses); 
		}
		try { 
			List<Instructor> desInstructors = deserializeI(); 
			for(Instructor i1 : instructors)
				desInstructors.add(i1); 
			SerializeI(desInstructors); 
		}catch(FileNotFoundException e) { 
			SerializeI(instructors); 
		}
		
		
		fw.close(); 

	}

}