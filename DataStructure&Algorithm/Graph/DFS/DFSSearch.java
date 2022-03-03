package DFS;

import java.util.HashMap;
import java.util.ArrayList;

public class DFSSearch {
	
	public ArrayList<String> dfsFunc(HashMap<String, ArrayList<String>>graph, String startNode){
		
		ArrayList<String> visited = new ArrayList<String>();
		ArrayList<String> needVisit = new ArrayList<String>();
		
		needVisit.add(startNode);
		
		while(needVisit.size()>0) {
			
			//DFS는 stack으로 구현, 마지막노드 pop
			String node = needVisit.remove(needVisit.size()-1);
			
			if(!visited.contains(node)) {
				visited.add(node);
				needVisit.addAll(graph.get(node));
			}
		}
		return visited;
	}

	public static void main(String[] args) {
		// 기존 그래프 샘플 불러오기 
		Graph Dobject= new Graph();
		
		DFSSearch dfs= new DFSSearch();
		System.out.println("DFS Search: "+ dfs.dfsFunc( Dobject.graph, "A"));

	}

}
