package ex1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class TestB {
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		 FileWriter fr = null;
	
		Set<Integer> s = new HashSet<Integer>();
		try {
			
			
			br = new BufferedReader(new FileReader("C:\\Users\\Lenovo\\eclipse-workspace\\lab5\\bin\\ex1\\scores.txt"));
			fr = new FileWriter("C:\\Users\\Lenovo\\eclipse-workspace\\lab5\\bin\\ex1\\grades.txt",true);
			StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		   
		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine(); 
		        if (line!=null) {
		        String[] splitted = line.split(" ");
		        s.add(Integer.parseInt(splitted[splitted.length-1]));
		        }
		    }
		} 
		catch (FileNotFoundException e) {
		    e.printStackTrace();
		}
		finally {
		   if(br!=null) br.close();
		}

		Integer min = (Integer) s.toArray()[0];
		Integer max =(Integer) s.toArray()[s.size()-1];		
		Integer avg = (min+max)/2;
		 fr.write("Average - "+avg+"\n");
		fr.write("Maximum - "+max+"\n"); 
		fr.write("Minimum - "+min+"\n");
		 
		
		fr.close();
	}
}
