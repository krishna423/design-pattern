package com.example.designpattern.company;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NewRelic_DirectedGraph_EachNode_Cycle_length_minimum {


    public static void main(String[] args) {
        int n=4;
        int m = 4;
        int [] source = {1,2,3,4};
        int [] dest = {2,3,1,3};
        int [] w = {5,10,15,20};

        fun(n,m,source,dest,w);

    }

    static void fun(int input1, int input2, int[] input3, int[] input4, int[] input5) {

        List<List<Node>> adjList = getAdjList(input1, input2, input3, input4, input5);
        int n = adjList.size();


        for (int i = 1; i < n; i++) {
            System.out.println(dijkstra(adjList, i));
        }


    }


    static int dijkstra(List<List<Node>> adjList, int source) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>(
                (first, second) -> {
                    if (first.w > second.w) {
                        return 1;
                    } else if (first.w == second.w) {
                        return 0;
                    } else {
                        return -1;
                    }

                }
        );

        int n = adjList.size();
        int[] distance = new int[n];

        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        List<Node> neighbours = adjList.get(source);
        if (neighbours == null) {
            return -1;
        }

        for (int i = 0; i < neighbours.size(); i++) {
            pq.add(neighbours.get(i));
            Node node = neighbours.get(i);
            distance[node.dest] = node.w;
        }


        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (current.dest == source) {
                return distance[source];
            }

            neighbours = adjList.get(current.dest);
            if (neighbours == null) {
                continue;
            }

            Node adj;
            int d;
            int step;
            for (int i = 0; i < neighbours.size(); i++) {
                adj = neighbours.get(i);
                d = adj.dest;
                step = adj.w;
                if (distance[d] > distance[current.dest] + step) {
                    distance[d] = distance[current.dest] + step;
                    pq.add(adj);
                }
            }
        }


        return -1;
    }

    static List<List<Node>> getAdjList(int n, int edges, int[] source, int[] dest, int[] weight) {
        List<List<Node>> adjList = new ArrayList(n + 1);

        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<Node>());
        }

        for (int i = 0; i < edges; i++) {
            List<Node> temp = adjList.get(source[i]);
            temp.add(new Node(dest[i], weight[i]));
        }

        return adjList;
    }

    static class Node {
        int dest, w;

        Node(int dest, int w) {
            this.dest = dest;
            this.w = w;
        }

        public String toString() {
            return "{ " + dest + " " + w + " } ";
        }

    }
}