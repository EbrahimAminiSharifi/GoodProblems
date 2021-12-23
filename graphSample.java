/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class graphSample {

    static List<ArrayList<Integer>> lstAdj = new ArrayList<ArrayList<Integer>>();
    static List<Boolean> lstVisited = new ArrayList<Boolean>();
    static List<Integer> lstDeepCount = new ArrayList<>();
    static int count = 0;

    public static int longestLine(int nodeid, int count) {

        for (int i : lstAdj.get(nodeid)) {
            count = longestLine(i, 0);
            lstDeepCount.add(count);
        }
        return ++count;
    }

    

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        lstAdj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            lstAdj.add(new ArrayList());
        }
        for (int i = 0; i < m; i++) {
            int node = sc.nextInt();
            int edge = sc.nextInt();

            lstAdj.get(node - 1).add(edge - 1);
        }

        longestLine(0, 0);
        System.out.println(Collections.max(lstDeepCount) + 1);

    }

}
