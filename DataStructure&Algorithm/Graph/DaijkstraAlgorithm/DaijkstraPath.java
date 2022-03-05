package DijkstraPath;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraPath {
	
	public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>>graph, String start){
		
		//필요한 변수 선언 
		Edge edgeNode, adjacentNode;
		String currentNode, adjacent;
		int currentDistance, weight, distance;
		ArrayList<Edge> nodeList;
		
		//각 노드들 사이의 거리를 저장할 distances hashmap
		HashMap<String, Integer> distances = new HashMap<String, Integer>();
		//Integer.MAX_VALUE로 초기화
		for(String key: graph.keySet()) {
			distances.put(key, Integer.MAX_VALUE);
		}
		distances.put(start, 0);
		
		//우선순위 큐
		PriorityQueue<Edge>priorityQueue = new PriorityQueue<Edge>();
		//시작노드 추가
		priorityQueue.add(new Edge(distances.get(start), start));
		
		//다익스트라 알고리즘 
		while(priorityQueue.size()>0) {
			
			edgeNode = priorityQueue.poll();
			currentDistance = edgeNode.distance;
			currentNode = edgeNode.vertex;
			
			if(distances.get(currentNode)<currentDistance) {
				continue;
			}
			
			nodeList = graph.get(currentNode);
			for(int index=0; index<nodeList.size(); index++) {
				
				adjacentNode = nodeList.get(index);
				adjacent= adjacentNode.vertex;
				weight = adjacentNode.distance;
				distance = currentDistance + weight;
				
				if(distance<distances.get(adjacent)) { //인접노드까지 거리를 최단거리로 업데이트 
					distances.put(adjacent, distance);
					priorityQueue.add(new Edge(distance, adjacent));
				}
				
			}
		}
		return distances;
	}

	public static void main(String[] args) {
		// Graph HashMap
		HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
		graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
		graph.put("B", new ArrayList<Edge>());
		graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
		graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
		graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
		graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));
		
		//다익스트라 객체 선언
		DijkstraPath dObject = new DijkstraPath();
		System.out.println("Dijkstra Path Algoritm: "+dObject.dijkstraFunc(graph, "A"));
		
		

	}

}
