package ex1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Grades {

	int max=0;
	Map<String, Integer> grades;

	public	 Grades () {
		grades = new TreeMap<String,Integer>();
	}
	
	
	public void addMark(String line) {
		if(line!=null) {
		String[] strArr = line.split(" ");
		String name = strArr[0]+" "+strArr[1];
		Integer score = Integer.parseInt(strArr[2]);
		if(score>max) max = score;
		grades.put(name, score);
		}
	}
	
	
	public Map<String, Integer> getGrades(){
		return grades;
	}
	
	
}
