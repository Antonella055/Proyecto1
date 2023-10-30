/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import static org.apache.commons.math3.stat.inference.TestUtils.g;


/**
 *
 * @author luciano
 */
public class Kosajaru {
    private int V;
    private LinkedList<Integer> adj[];

    // Create a graph
    Kosajaru(int s) {
        V = s;
        adj = new LinkedList[s];
        for (int i = 0; i < s; ++i)
            adj[i] = new LinkedList();
    }

    // Add edge
    void addEdge(int s, int d) {
        adj[s].add(d);
    }

    // DFS
    void DFSUtil(int s, boolean visitedVertices[], List<List<Integer>> stronglyConnectedEdges) {
        visitedVertices[s] = true;

        Iterator<Integer> i = adj[s].iterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visitedVertices[n]) {
                List<Integer> edge = new ArrayList<>();
                edge.add(s);
                edge.add(n);
                stronglyConnectedEdges.add(edge);
                DFSUtil(n, visitedVertices, stronglyConnectedEdges);
            }
        }
    }

    // Transpose the graph
    Kosajaru Transpose() {
        Kosajaru g = new Kosajaru(V);
        for (int s = 0; s < V; s++) {
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
                g.adj[i.next()].add(s);
        }
        return g;
    }

    void fillOrder(int s, boolean visitedVertices[], Stack stack) {
        visitedVertices[s] = true;

        Iterator<Integer> i = adj[s].iterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visitedVertices[n])
                fillOrder(n, visitedVertices, stack);
        }
        stack.push(new Integer(s));
    }

    // Find strongly connected edges
    List<List<Integer>> findStronglyConnectedEdges() {
        Stack stack = new Stack();

        boolean visitedVertices[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visitedVertices[i] = false;

        for (int i = 0; i < V; i++)
            if (visitedVertices[i] == false)
                fillOrder(i, visitedVertices, stack);

        Kosajaru gr = Transpose();

        for (int i = 0; i < V; i++)
            visitedVertices[i] = false;

        List<List<Integer>> stronglyConnectedEdges = new ArrayList<>();
        while (stack.empty() == false) {
            int s = (int) stack.pop();

            if (visitedVertices[s] == false) {
                gr.DFSUtil(s, visitedVertices, stronglyConnectedEdges);
            }
        }

        return stronglyConnectedEdges;
    }
public static String ValidarKosa(int i, int j, List<List<Integer>> vertices){
    LinkedList[][] Lista = new LinkedList[i][j];
    
    for (List<Integer> country : vertices) {
        if(Lista.toString().contains(country.toString())){
            System.out.println(Lista.toString() +" " +country.toString());
            return "strokeColor=green";
            
        }
        else{
            return "strokeColor=black";
        }
            
        }
        return "strokeColor=black";
    
    }
        public static void InputKosajaru(int[][] matrizAdyacencia, List<List<Integer>> vertices) {
        Kosajaru g = new Kosajaru(matrizAdyacencia.length);
        for (List<Integer> country : vertices) {
            int a = country.get(0);
            int b = country.get(1);
            g.addEdge(a, b);
        }

        List<List<Integer>> stronglyConnectedEdges = g.findStronglyConnectedEdges();
        System.out.println("Aristas fuertemente conectadas:");
        for (List<Integer> edge : stronglyConnectedEdges) {
            System.out.println(edge.get(0) + " -> " + edge.get(1));
            
        }
    }
        
        public static List<List<Integer>> RetornaKosa(int[][] matrizAdyacencia, List<List<Integer>> vertices){
            Kosajaru g = new Kosajaru(matrizAdyacencia.length);
        for (List<Integer> country : vertices) {
            int a = country.get(0);
            int b = country.get(1);
            g.addEdge(a, b);
        }


        List<List<Integer>> stronglyConnectedEdges = g.findStronglyConnectedEdges();
        return stronglyConnectedEdges;
        }
}




