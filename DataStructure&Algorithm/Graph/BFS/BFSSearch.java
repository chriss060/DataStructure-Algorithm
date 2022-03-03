package BFS;
import java.util.HashMap;
import java.util.ArrayList;

public class BFSSearch {
	
	public ArrayList<String> bfsFunc(HashMap<String, ArrayList<String>> graph,String startNode){
		
		// 2개의 큐로 BFS 구현 		
		ArrayList<String> visited = new ArrayList<String>();
		ArrayList<String> needVisit = new ArrayList<String>();
		
		needVisit.add(startNode);
		
		while(needVisit.size()>0) {
			String node = needVisit.remove(0);
			
			if(!visited.contains(node)) { //노드가 visited큐에 없다
				visited.add(node); //해당 노드 visited에 추
				needVisit.addAll(graph.get(node)); //해당 노드와 연결된 노드 needVisited에 추가 
			}
		}
		return visited;
	}

	public static void main(String[] args) {
		//그래프 예제 불러오기 
		Graph BFS = new Graph();
		
		BFSSearch Bfs = new BFSSearch();
		System.out.println("BFS Search : "+Bfs.bfsFunc(BFS.graph, "A"));

	}

}
