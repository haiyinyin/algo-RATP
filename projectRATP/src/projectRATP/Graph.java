package projectRATP;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.HashMap;
import java.util.Stack;
public class Graph {
	private final int N; // the order of the graph (number of nodes)
	private int M; // the size of the graph (the number of edges)
	//private List<Integer>[] adj;
	private Map<Integer, List<Integer>> Adjacency_List;
	private Map<String, List<String>> Adjacency_List_s;
	private List<String> station;
	
	
    // 生存已经会见过的所在
    private List<String> visitedVertex;
    
    
    // 生存最短路径
    private Map<String, String> path;
	
	
	//构造函数
	public Graph(int N) throws IOException {
		this.N = N;
		Adjacency_List = new HashMap<Integer, List<Integer>>();
		
	}
	
	public Graph(List<String> list) throws IOException {
		station=list;
		this.N = list.size();
		Adjacency_List_s = new HashMap<String, List<String>>();
		for(int i=0;i<N;i++){
			String num;
			num=list.get(i);
			Adjacency_List_s.put(num, new LinkedList<String>());			
		}
		visitedVertex=new LinkedList<String>();
		path=new HashMap<String, String>() ;
		
	}
	

	public void addEdge(int u, int v) {

		LinkedList<Integer> slist = (LinkedList<Integer>) Adjacency_List.get(u);
		for (int i = 0; i <N; i++) {
			if (!slist.contains(v)) {
				slist.add(v);
			}
		}
		/*
		LinkedList<Integer> dlist = (LinkedList<Integer>) Adjacency_List.get(v);
		for (int i = 0; i <= N; i++) {
			if (!dlist.contains(u)) {
				dlist.add(u);
			}
		}
		*/
	}
	
	public void addEdgeString(String u, String v) {

		LinkedList<String> slist = (LinkedList<String>) Adjacency_List_s.get(u);
		for (int i = 0; i <N; i++) {
			if (!slist.contains(v)) {
				slist.add(v);
			}
		}
		/*
		LinkedList<Integer> dlist = (LinkedList<Integer>) Adjacency_List.get(v);
		for (int i = 0; i <= N; i++) {
			if (!dlist.contains(u)) {
				dlist.add(u);
			}
		}
		*/
	}
		
		public void print() {
		
			System.out.println("Adjacency List of the graph ");
			
				//System.out.println(Adjacency_List_s);
				for(int i=0;i<N;i++){
					System.out.print(station.get(i));
					System.out.print(":" );
					String num=station.get(i);
					System.out.println(Adjacency_List_s.get(num));
				}

		
		

	}
	

	    
	    public  Map<String, String> BFS(String sourceVertex) {
	    	System.out.print("BFS: ");
	        Queue<String> queue = new LinkedList<String>();        
	        // 标志起点
	        visitedVertex.add(sourceVertex);
	        // 起点入列
	        queue.add(sourceVertex);
	        while (false == queue.isEmpty()) {
	        //for(int i=0;i<2;i++){
	            String ver = queue.poll();
	            //System.out.println("queue 2:" + queue);
	            List<String> toBeVisitedVertex = Adjacency_List_s.get(ver);
	            for (String v : toBeVisitedVertex) {
	                if (false == visitedVertex.contains(v)) {
	                    visitedVertex.add(v);
	                    path.put(v, ver);
	                    queue.add(v);                   
	                }
	                
	            }	          
	        
	        }
	        return path;
	    }
	    
	    public Stack<String> findPathTo(String vertex,String sourceVertex) {
	    	
	    	Stack<String> stack = new Stack<String>();
	    	stack.add(vertex);	    	
	    	Map<String, String> shortestPath=new HashMap<String,String>();
	    	shortestPath=BFS(sourceVertex);
	    	String location = shortestPath.get(vertex) ;

	    	if(location!=null){
	    	 for (location = shortestPath.get(vertex) ; false == location.equals(sourceVertex) ; location = shortestPath.get(location)) {
	             stack.push(location);
	         }
	    	}
	         stack.push(sourceVertex);
	         return stack;
	    	
	    	
	    }
	    
	    
		
}

