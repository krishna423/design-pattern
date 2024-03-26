package com.example.designpattern.logics.Coding;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GasStation {

    public static double findSmallestMaxDist(int stations[],int K) {
        // code here
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if( o1.dist > o2.dist ){
                return -1;
            }else if(o1.dist == o2.dist) {
                return 0;
            }else {
                return 1;
            }
        });

        int n = stations.length;

        int d = 0;
        for (int i = 1; i < n; i++) {
            d = stations[i]-stations[i-1];
            priorityQueue.add(new Node(d,i-1,0));
        }


        for (int i =0; i < K; i++) {
            Node currentNode = priorityQueue.poll();
            double dist = (double) currentNode.dist;
            int blockStartPosition = currentNode.blockStartPosition;
            int noOfNewElements = currentNode.noOfNewElements;

            System.out.println( dist + " " + blockStartPosition + " " + noOfNewElements + " size " + priorityQueue.size() );

            noOfNewElements++;
            dist = (stations[blockStartPosition+1] - stations[blockStartPosition])/ (double) (noOfNewElements+1);
            double ndist = ( (int)( dist*1000 ))/1000.00;
            System.out.println("new distance : " + dist + " " + ndist);
            priorityQueue.add(new Node(ndist,blockStartPosition,noOfNewElements));
        }

        return priorityQueue.poll().dist;
    }

    static class  Node{
        private double dist;
        private int blockStartPosition;
        private int noOfNewElements;

        public Node(double dist, int blockStartPosition, int noOfNewElements) {
            this.dist = dist;
            this.blockStartPosition = blockStartPosition;
            this.noOfNewElements = noOfNewElements;
        }
    }


    public static void main(String[] args) {
        int [] stations = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int K = 9999;
        System.out.println(findSmallestMaxDist(stations,K));

    }
}
