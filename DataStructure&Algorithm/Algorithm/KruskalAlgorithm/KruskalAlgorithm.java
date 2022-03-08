package KruscalAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Collections;

public class KruskalAlgorithm {
	
	//path-compression, union-by-rank 를 위한 hashmap parent, rank 
	HashMap<String, String> parent = new HashMap<String, String>();
	HashMap<String, Integer> rank = new HashMap<String, Integer>();
	
	public String find(String node) {
		//path compression 기법 - recursion으로 parent node 연결 
		if(parent.get(node)!= node) {
			parent.put(node, find(parent.get(node)));
		}
		return parent.get(node);
	}
	
	public void union(String nodeV, String nodeU) {
		//find함수 먼저 실행해 중복 방지 
		String root1 = find(nodeV);
		String root2 = find(nodeU);
		
		//union-by-rank
		if(rank.get(root1)>rank.get(root2)) {
			//root1 랭크 > root2 랭크 : root2를 root1트리에 붙이기 
			parent.put(root2, root1);
		}else {
			parent.put(root1, root2);
			
			//rank가 같은 경우 : 한쪽 트리 랭크 1증가한 후, 다른 트리 붙이기 
			if(rank.get(root1)== rank.get(root2)) {
				rank.put(root2, rank.get(root2)+1);
			}
		}
	}
	
	//초기화 함수
	public void makeSet(String node) {
		parent.put(node, node);
		rank.put(node, 0);
	}
	
	public ArrayList<Edge> kruskalFunc(ArrayList<String> vetices, ArrayList<Edge> edges){
		
		ArrayList<Edge> mst = new ArrayList<Edge>();
		Edge currentEdge;
		//1. 초기화 
		for(int index=0; index<vetices.size(); index++) {
			this.makeSet(vetices.get(index));
		}
		
		//2. 간선 weight 기반 Sorting 
		Collections.sort(edges);
		
		for(int index=0; index<edges.size(); index++) {
			currentEdge = edges.get(index);
			if(this.find(currentEdge.nodeV)!= this.find(currentEdge.nodeV)) {
				this.union(currentEdge.nodeV, currentEdge.nodeU);
				mst.add(currentEdge);
			}
		}
		return mst;
	}

	public static void main(String[] args) {
		
		//Graph 생성 

		ArrayList<String> vetices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
		ArrayList<Edge> edges = new ArrayList<Edge>();
		
		edges.add(new Edge(7, "A", "B"));
		edges.add(new Edge(5, "A", "D"));
		edges.add(new Edge(7, "B", "A"));
		edges.add(new Edge(8, "B", "C"));
		edges.add(new Edge(9, "B", "D"));
		edges.add(new Edge(7, "B", "E"));
		edges.add(new Edge(8, "C", "B"));
		edges.add(new Edge(5, "C", "E"));
		edges.add(new Edge(5, "D", "A"));
		edges.add(new Edge(9, "D", "B"));
		edges.add(new Edge(7, "D", "E"));
		edges.add(new Edge(6, "D", "F"));
		edges.add(new Edge(7, "E", "B"));
		edges.add(new Edge(5, "E", "C"));
		edges.add(new Edge(7, "E", "D"));
		edges.add(new Edge(8, "E", "F"));
		edges.add(new Edge(9, "E", "G"));
		edges.add(new Edge(6, "F", "D"));
		edges.add(new Edge(8, "F", "E"));
		edges.add(new Edge(11, "F", "G"));
		edges.add(new Edge(9, "G", "E"));
		edges.add(new Edge(11, "G", "F"));
		
		//크루스칼 알고리즘으로 최장신장트리 찾기 
		
		KruskalAlgorithm kObject = new KruskalAlgorithm();
		
		System.out.println("Kruskal algorithm : "+kObject.kruskalFunc(vetices,edges));
	}

}
