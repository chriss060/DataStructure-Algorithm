package PrimAlgorithm;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimAlgorithm {
	
	public ArrayList<path> improvedPrimFunc(HashMap<String, HashMap<String, Integer>> graph, String startNode){
		
		ArrayList<path> mst = new ArrayList<path>(); //최소 비용 신장트리 mst 
		PriorityQueue<Edge> keys = new PriorityQueue<Edge>();
		HashMap<String, Edge> keysObjects = new HashMap<String, Edge>();		
		HashMap<String, String> mstPath = new HashMap<String, String>();
		
		Integer totalWeight = 0;
		HashMap <String, Integer> linkedEdges;
		Edge edgeObject, poppedEdge, linkedEdge;
		
		
		for(String key : graph.keySet()) {
			// 정점 초기화 : 특정 정점의 key 값은 0, 이외의 정점들은 MAX_VALUE 로 
			if(key== startNode) {
				edgeObject = new Edge(key,0);
				mstPath.put(key,key);
			}else {
				edgeObject = new Edge(key, Integer.MAX_VALUE);
				mstPath.put(key, null);
			}
			keys.add(edgeObject);
			keysObjects.put(key, edgeObject);
		}
		
		while(keys.size()>0) {
			poppedEdge = keys.poll();
			keysObjects.remove(poppedEdge.node);
			mst.add(new path(mstPath.get(poppedEdge.node),poppedEdge.node, poppedEdge.weight));
			
			totalWeight += poppedEdge.weight;
			linkedEdges = graph.get(poppedEdge.node);
			for(String adjacent : linkedEdges.keySet()) {
				if(keysObjects.containsKey(adjacent)) {
					linkedEdge = keysObjects.get(adjacent);
					
					if(linkedEdges.get(adjacent)<linkedEdge.weight) {
						linkedEdge.weight = linkedEdges.get(adjacent);
						mstPath.put(adjacent, poppedEdge.node);
						
						keys.remove(linkedEdge);
						keys.add(linkedEdge);
					}
				}
			}
		}
		
		System.out.println(totalWeight);
		return mst;
		
		}

	public static void main(String[] args) {
		// graph 구조화 
		HashMap<String, HashMap<String, Integer>> mygraph = new HashMap<String, HashMap<String, Integer>>();

		HashMap<String, Integer> edges;
		edges = new HashMap<String, Integer>();
		edges.put("B", 7);
		edges.put("D", 5);
		mygraph.put("A", edges);

		edges = new HashMap<String, Integer>();
		edges.put("A", 7);
		edges.put("D", 9);
		edges.put("C", 8);
		edges.put("E", 7);
		mygraph.put("B", edges);

		edges = new HashMap<String, Integer>();
		edges.put("B", 8);
		edges.put("E", 5);
		mygraph.put("C", edges);

		edges = new HashMap<String, Integer>();
		edges.put("A", 5);
		edges.put("B", 9);
		edges.put("E", 7);
		edges.put("F", 6);
		mygraph.put("D", edges);

		edges = new HashMap<String, Integer>();
		edges.put("B", 7);
		edges.put("C", 5);
		edges.put("D", 7);
		edges.put("F", 8);
		edges.put("G", 9);
		mygraph.put("E", edges);

		edges = new HashMap<String, Integer>();
		edges.put("D", 6);
		edges.put("E", 8);
		edges.put("G", 11);
		mygraph.put("F", edges);

		edges = new HashMap<String, Integer>();
		edges.put("E", 9);
		edges.put("F", 11);
		mygraph.put("G", edges);


		PrimAlgorithm pObject = new PrimAlgorithm();
		pObject.improvedPrimFunc(mygraph, "A");

	}

}
