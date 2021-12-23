/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

// A Java program to print topological
// sorting of a graph using indegrees
import java.util.*;

// Class to represent a graph
class topologicalSort {
    // No. of vertices

    int V;

    // An Array of List which contains
    // references to the Adjacency List of
    // each vertex
    List<Integer> adj[];
    // Constructor

    public topologicalSort(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void topologicalSort() {

        int indegree[] = new int[V];

        for (int i = 0; i < V; i++) {
            ArrayList<Integer> temp
                    = (ArrayList<Integer>) adj[i];
            for (int node : temp) {
                indegree[node]++;
            }
        }

        Queue<Integer> q
                = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int cnt = 0;

        Vector<Integer> topOrder = new Vector<Integer>();
        while (!q.isEmpty()) {

            int u = q.poll();
            topOrder.add(u);

            for (int node : adj[u]) {

                if (--indegree[node] == 0) {
                    q.add(node);
                }
            }
            cnt++;
        }

        if (cnt != V) {
            System.out.println(
                    "There exists a cycle in the graph");
            return;
        }
        for (int i : topOrder) {
            System.out.print(i + " ");
        }
    }
}
// Driver program to test above functions

class Main {

    public static void main(String args[]) {
        // Create a graph given in the above diagram
        topologicalSort g = new topologicalSort(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(4, 3);
        g.addEdge(1, 5);
        System.out.println(
                "Following is a Topological Sort");
        g.topologicalSort();
    }
}
