package com.example.designpattern.logics.Coding.BinarySearch;



import java.util.*;
import java.util.stream.Collectors;

public class TaskScheduler {

    static int leastInterval(int N, int K, char tasks[]) {
        // code here
        PriorityQueue<Pair<Character,Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Pair<Character, Integer>>() {
            @Override
            public int compare(Pair<Character, Integer> o1, Pair<Character, Integer> o2) {
                if(o1.getValue() > o2.getValue()){
                    return -1;
                }else if (o1.getValue() < o2.getValue()) {
                    return 1;
                }else{
                    return 0;
                }
            }
        });

        HashMap<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int v = map.getOrDefault(tasks[i],0);
            v++;
            map.put(tasks[i], v );
        }

        for(Map.Entry<Character,Integer> mapEntry : map.entrySet()){
            //System.out.println( mapEntry.getKey()+ " " +mapEntry.getValue());
            priorityQueue.add(new Pair<>(mapEntry.getKey(), mapEntry.getValue()));
        }

        List<Pair<Character,Integer>> list = new ArrayList<>();
        //List<Pair<Character,Integer>> ansList =new ArrayList<>();
        int ans = 0;
        Pair<Character,Integer> pair = null;
        int count=0;
        while(!priorityQueue.isEmpty()){

            int i=1;
            count=0;
            list.clear();
            // ansList.clear();

            while(i<=K+1 && !priorityQueue.isEmpty()){
                count++;
                i++;
                pair = priorityQueue.poll();
                pair.setValue( pair.getValue()-1);
                if(pair.getValue()>0){
                    list.add(pair);
                }


            }
            // System.out.println("Original Array : " + list + " Ans  " + ans) ;


            if(!list.isEmpty()){
                ans = ans+ (K+1);
                // System.out.println("Adding element in PQ "  + list);
                priorityQueue.addAll(list);

            }else{
                ans = ans+ count;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
//        int K = 3;
//        char task[ ] = {'A', 'A', 'A', 'B', 'B', 'B'};

//        int K=2;
//        char task[ ] = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};

//        int K = 10;
//        char task[ ] = {'A', 'A', 'A'};

        int K=14;
        char task[]= {'J','P','R','E','P','G','G','X','R','P','N','R','V','Y','S','T','M','W','C','Y','S','Y','Y','C','Q','P','E','V','I','K','E','F','F','M','Z','N','I','M','K','K','A','S','V','W','S','R','E','N','Z','K','Y','C','X','F','X','T','L','S','G','Y','P','S','F','A','D','P','O','O','E','F','X','Z','B','C','O','E','J','U','V','P','V','A','B','O','Y','G','P','O','E','Y','L','F','P','B','N','P','L','J','V','R','V','I','P','Y','A','M','Y','E','H','W','Q','N','Q','R','Q','P','M','X','U','J','J','L','O','O','V','A','O','W','U','X','W','H','M','S','N','C','B','X','C','O','K','S','F','Z','K','V','A','T','X','D','K','N','L','Y','J','Y','H','F','I','X','J','S','W','N','K','K','U','F','N','U','X','X','Z','R','Z','B','M','N','M','G','Q','O','O','K','E','T','L','Y','H','N','K','O','A','U','G','Z','Q','R','C','D','D','I','U','T','E','I','O','J','W','A','Y','Y','Z','P','V','S','C','M','P','S','A','J','L','F','V','G','U','B','F','A','A','O','V','L','Z','Y','L','N','T','R','K','D','C','P','W','S','R','T','E','S','J','W','H','D','I','Z','C','O','B','Z','C','N','F','W','L','Q','I','J','T','V','D','W','V','X','H','R','C','B','L','D','V','G','Y','L','W','G','B','U','S','B','M','B','O','R','X','T','L','H','C','S','M','P','X','O','H','G','M','G','N','K','E','U','F','D','X','O','T','O','G','B','G','X','P','E','Y','A','N','F','E','T','C','U','K','E','P','Z','S','H','K','L','J','U','G','G','G','E','K','J','D','Q','Z','J','E','N','P','E','V','Q','G','X','I','E','P','J','S','R','D','Z','J','A','Z','U','J','L','L','C','H','H','B','F','Q','M','K','I','M','W','Z','O','B','I','W','Y','B','X','D','U','U','N','F','S','K','S','R','S','R','T','E','K','M','Q','D','C','Y','Z','J','E','E','U','H','M','S','R','Q','C','O','Z','I','J','I','P','F','I','O','N','E','E','D','D','P','S','Z','R','N','A','V','Y','M','M','T','A','T','B','D','Z','Q','S','O','E','M','U','V','N','P','P','P','S','U','A','C','B','A','Z','U','X','M','H','E','C','T','H','L','E','G','R','P','U','N','K','D','M','B','P','P','W','E','Q','T','G','J','O','P','A','R','M','O','W','Z','D','Q','Y','O','X','Y','T','J','B','B','H','A','W','D','Y','D','C','P','R','J','B','X','P','H','O','O','H','P','K','W','Q','Y','U','H','R','Q','Z','H','N','B','N','F','U','V','Q','N','Q','Q','L','R','Z','J','P','X','I','O','G','V','L','I','E','X','D','Z','U','Z','O','S','R','K','R','U','S','V','O','J','B','R','Z','M','W','Z','P','O','W','K','J','I','L','E','F','R','A','A','M','D','I','G','P','N','P','U','U','H','G','X','P','Q','N','J','W','J','M','W','A','X','X','M','N','S','N','H','H','L','Q','Q','R','Z','U','D','L','T','F','Z','O','T','C','J','T','N','Z','X','U','G','L','S','D','S','M','Z','C','N','O','C','K','V','F','A','J','F','R','M','X','O','T','H','O'};


        System.out.println(leastInterval(task.length,K,task));
    }

    static class Pair<K,V>{
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

}


