package BFS;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

	HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>(){{
		put("A", new ArrayList<String>(Arrays.asList("B","C")));
		put("B", new ArrayList<String>(Arrays.asList("A","D")));
		put("C", new ArrayList<String>(Arrays.asList("A","G","H","I")));
		put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
		put("E", new ArrayList<String>(Arrays.asList("D")));
		put("F", new ArrayList<String>(Arrays.asList("D")));
		put("G", new ArrayList<String>(Arrays.asList("C")));
		put("H", new ArrayList<String>(Arrays.asList("C")));
		put("I", new ArrayList<String>(Arrays.asList("C", "J")));
		put("J", new ArrayList<String>(Arrays.asList("I")));
		
	}};
	
	
}
