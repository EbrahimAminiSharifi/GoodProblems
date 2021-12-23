/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;


//public class cycleDetection {
// A Java Program to detect cycle in a graph
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class cycleDetection {
	
	private final int V;
	private final List<List<Integer>> adj;

	public cycleDetection(int V)
	{
		this.V = V;
		adj = new ArrayList<>(V);
		
		for (int i = 0; i < V; i++)
			adj.add(new LinkedList<>());
	}
	
	
	private boolean isCyclicUtil(int i, boolean[] visited,
									boolean[] recStack)
	{
		
		// Mark the current node as visited and
		// part of recursion stack
		if (recStack[i])
			return true;

		if (visited[i])
			return false;
			
		visited[i] = true;

		recStack[i] = true;
		List<Integer> children = adj.get(i);
		
		for (Integer c: children)
			if (isCyclicUtil(c, visited, recStack))
				return true;
				
		recStack[i] = false;

		return false;
	}

	private void addEdge(int source, int dest) {
		adj.get(source).add(dest);
	}

	
	private boolean isCyclic()
	{
		
	
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];
		
		
	
		for (int i = 0; i < V; i++)
			if (isCyclicUtil(i, visited, recStack))
				return true;

		return false;
	}

	// Driver code
	public static void main(String[] args)
	{
		cycleDetection graph = new cycleDetection(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(2, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 1);
		graph.addEdge(4, 3);
		graph.addEdge(1, 5);
		
		if(graph.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't "
									+ "contain cycle");
	}
}

// This code is contributed by Sagar Shah.


