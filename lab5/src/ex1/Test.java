package ex1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


public class Test {
	
	public static <String, Integer extends Comparable<Integer>> Map<String, Integer> sortByValues(final Map<String, Integer> map) {
	    Comparator<String> valueComparator =  new Comparator<String>() {
	        public int compare(String k1, String k2) {
	            int compare = map.get(k2).compareTo(map.get(k1));
	            if (compare == 0) return 1;
	            else return compare;
	        }
	    };
	    Map<String, Integer> sortedByValues = new TreeMap<String, Integer>(valueComparator);
	    sortedByValues.putAll(map);
	    return sortedByValues;
	}
	
	public static char toLetter(int best, Integer a) {
		if(a>=best-10) return 'A';
		else if(a>=best-20) return 'B';
		else if(a>=best-30) return 'C';
		else if(a>=best-40) return 'D';
		else return 'F';
	}
	
public static void main(String[] args) throws IOException {

	Grades g = new Grades();
	int n=1;
	BufferedReader br = null;
	BufferedWriter bw = null;
	try {
		
		
		br = new BufferedReader(new FileReader("C:\\Users\\Lenovo\\eclipse-workspace\\lab5\\bin\\ex1\\scores.txt"));
		bw = new BufferedWriter(new FileWriter("C:\\Users\\Lenovo\\eclipse-workspace\\lab5\\bin\\ex1\\grades.txt"));
		StringBuilder sb = new StringBuilder();
	    String line = br.readLine();
	    g.addMark(line);
	    while (line != null) {
	        sb.append(line);
	        sb.append(System.lineSeparator());
	        line = br.readLine(); 
	        g.addMark(line);
	    }
	} 
	catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	finally {
	   if(br!=null) br.close();
	}
	
	
	 Map< String,Integer> map = sortByValues(g.getGrades());
	 Iterator it = map.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        bw.write(n+")"+(pair.getKey() + " - " + toLetter(g.max,(Integer) pair.getValue()))+"\n");
	        n++;
	        it.remove(); 
	 }
	   	 
	    
	    bw.close();
	
}
}
