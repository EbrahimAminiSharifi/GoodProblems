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
public class graphInput {

    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<ArrayList<Integer>> lstAdj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            lstAdj.add(new ArrayList());
        }
        for (int i = 0; i < m; i++) {
            int node = sc.nextInt();
            int edge = sc.nextInt();
            lstAdj.get(node - 1).add(edge-1);
        }
        
        System.out.println(lstAdj);
    }
    
}
