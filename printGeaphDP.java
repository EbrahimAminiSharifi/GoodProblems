/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author moghaleb
 */
public class printGeaphDP {

    public static List<ArrayList<Integer>> lstAdj = new ArrayList<ArrayList<Integer>>();
    public static List<Boolean> lstVisited = new ArrayList<Boolean>();
    public static Map<Integer, Integer> MapTime = new HashMap<>();

    static List<Integer> Nodes;

    public static void traverse1(int startNode) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);
        while (stack.size() > 0) {
            int currentNode = stack.pop();
            System.out.println(Nodes.get(currentNode));
            List<Integer> lstChilderen = lstAdj.get(currentNode);
            for (int i = 0; i < lstChilderen.size(); i++) {
                if (!lstVisited.get(lstChilderen.get(i))) {
                    lstVisited.set(lstChilderen.get(i), Boolean.TRUE);
                    stack.push(lstChilderen.get(i));
                }
            }

        }

    }

    public static List<Integer> findParent(int nodeIndex) {
        List<Integer> lstResult = new ArrayList<>();
        for (int i = 0; i < lstAdj.size(); i++) {
            for (int j = 0; j < lstAdj.get(i).size(); j++) {
                if (lstAdj.get(i).get(j) == nodeIndex) {
                    lstResult.add(i);
                }
            }
        }
        return lstResult;
    }

    public static boolean isVisted(List<Integer> nodes) {
        Boolean result = false;
        for (int i = 0; i < nodes.size(); i++) {
            result |= lstVisited.indexOf(nodes.get(i)) > -1;
        }
        return result;
    }

    public static void topologicalSort(int startNode) {
        int currentNode;
        Stack<Integer> stack = new Stack<>();
        int time = 1;

        stack.push(startNode);
        time++;
        MapTime.put(startNode, time);

        while (!stack.isEmpty()) {
            currentNode = stack.pop();
            time++;

            //has parent
            System.out.println(Nodes.get(currentNode));
            //has child
            for (int i = lstAdj.get(currentNode).size() - 1; i >= 0; i--) {

                if (!lstVisited.get(lstAdj.get(currentNode).get(i))) {
                    stack.push(lstAdj.get(currentNode).get(i));
                    time++;
                    MapTime.put(lstAdj.get(currentNode).get(i), time);
                    lstVisited.set(lstAdj.get(currentNode).get(i), Boolean.TRUE);

                }
            }

        }
    }

    public static void traverseBFS(int startNode) {
        int currentNode;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            System.out.println(Nodes.get(currentNode));

            for (int i = 0; i < lstAdj.get(currentNode).size(); i++) {

                if (!lstVisited.get(lstAdj.get(currentNode).get(i))) {
                    queue.add(lstAdj.get(currentNode).get(i));
                    lstVisited.set(lstAdj.get(currentNode).get(i), Boolean.TRUE);
                }
            }
        }
    }

    public static void traverseDFS(int startNode) {
        int currentNode;
        Stack<Integer> stack = new Stack<>();
        stack.add(startNode);
        while (!stack.isEmpty()) {
            currentNode = stack.pop();
            System.out.println(Nodes.get(currentNode));
            for (int i = lstAdj.get(currentNode).size() - 1; i >= 0; i--) {
                if (!lstVisited.get(lstAdj.get(currentNode).get(i))) {
                    stack.push(lstAdj.get(currentNode).get(i));
                    lstVisited.set(lstAdj.get(currentNode).get(i), Boolean.TRUE);
                }
            }
        }
    }

    public static void main(String[] args) {
        lstAdj = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lstAdj.add(new ArrayList());
            lstVisited.add(false);
            
        }
        Nodes = Arrays.asList(1, 2, 3, 4, 5, 6);

        lstAdj.get(0).add(1); //1->2
        lstAdj.get(0).add(2); //1->3
        lstAdj.get(1).add(5); //2->6
        lstAdj.get(2).add(3); //3->4
        lstAdj.get(2).add(1); //3->2
        lstAdj.get(2).add(4); //3->5
        lstAdj.get(4).add(3); //5->4
        topologicalSort(0);
        
        int min = -1;
        for (Map.Entry<Integer, Integer> entry : MapTime.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+" ->"+value);
            
        }

        

    }

}
