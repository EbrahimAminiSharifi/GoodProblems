/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author moghaleb
 */
public class printGraph {

    static List<ArrayList<Integer>> lstAdj = new ArrayList<ArrayList<Integer>>();
    static List<Boolean> lstVisited = new ArrayList<Boolean>();

    public static void print(int node) {

        lstAdj.get(node).forEach((i) -> {
            if (!lstVisited.get(i)) {
                print(i);
            }
        });
        lstVisited.set(node, Boolean.TRUE);
        System.out.println(node + 1);
    }

    public static void main(String[] args) {

        lstAdj = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lstAdj.add(new ArrayList());
            lstVisited.add(false);
        }

        lstAdj.get(0).add(1);
        lstAdj.get(0).add(2);
        lstAdj.get(1).add(5);
        lstAdj.get(2).add(3);
        lstAdj.get(2).add(1);
        lstAdj.get(2).add(5);
        lstAdj.get(5).add(4);

        print(0);

    }

}
