package com.example.designpattern.logics.Collection;

import org.apache.catalina.LifecycleState;

import java.util.*;

public class CollectionQuickRecap {


    public static void main(String[] args) {

        Collection<Integer> collection = new ArrayList<>();

        /* List
        *No Hashing
        *duplicates allowed,
        *search O(n) , add O(1) ,Insertion order preserved
        */
        List<Integer> arrayList = new ArrayList<>(); //Backed by Array
        List<Integer> linklist = new LinkedList<>(); //Backed by DLL
        Vector<Integer> vector = new Vector<>();     //Backed by Array
        Stack<Integer> stack = new Stack<>();        //Backed by Vector(Array)


        /*Set (Map behaves same as set)
        *Hashing (HashTable)
        *duplicates not allowed,
        *search,add time ,Insertion order differ
        */

        //Search,add O(1)-O(n), No order preserved
        Map<Integer,Integer> unorderedMap = new HashMap<>();                      //Backed by hashTable
        Set<Integer> unorderedSet = new HashSet<>();                              //Backed by hashTable

        //Search,add O(1)-O(n), Insertion order preserved
        Map<Integer,Integer> insertionOrderPreservedMap = new LinkedHashMap<>();  //Backed by hashTable with DLL
        Set<Integer> insertionOrderPreservedSet = new LinkedHashSet<>();          //Backed by hashTable with DLL


        //Search,add - log(n), Ordered set
        Map<Integer,Integer> orderedMap = new TreeMap<>();                        //Backed by AVL-Tree
        Set<Integer> orderedSet = new TreeSet<>();                                //Backed by AVL-Tree




        //Queue
        Queue<Integer> queue = new LinkedList<>();                                //ArrayDequeue or Linklist
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();            //Heap created by Array n->(2n-1,2n)



        //add
        System.out.println("Testing add function");
        collection.add(1);
        arrayList.add(1);
        linklist.add(1);
        vector.add(1);
        stack.add(1);

        unorderedMap.put(1,1);
        insertionOrderPreservedMap.put(1,1);
        orderedMap.put(1,1);

        unorderedSet.add(1);
        insertionOrderPreservedSet.add(1);
        orderedSet.add(1);

        queue.add(1);
        priorityQueue.add(1);





        // size
        System.out.println("Testing size function");
        System.out.println(collection.size());
        System.out.println(arrayList.size());
        System.out.println(linklist.size());
        System.out.println(vector.size());
        System.out.println(stack.size());

        System.out.println(unorderedMap.size());
        System.out.println(insertionOrderPreservedMap.size());
        System.out.println(orderedMap.size());

        System.out.println(insertionOrderPreservedSet.size());
        System.out.println(unorderedSet.size());
        System.out.println(orderedSet.size());

        System.out.println(queue.size());
        System.out.println(priorityQueue.size());


        //contains
        System.out.println("Testing contains function");
        System.out.println(collection.contains(1));
        System.out.println(linklist.contains(1));
        System.out.println(vector.contains(1));
        System.out.println(stack.contains(1));

        System.out.println(unorderedMap.containsKey(1));
        System.out.println(insertionOrderPreservedMap.containsKey(1));
        System.out.println(orderedMap.containsKey(1));

        System.out.println(insertionOrderPreservedSet.contains(1));
        System.out.println(unorderedSet.contains(1));
        System.out.println(orderedSet.contains(1));

        System.out.println(queue.contains(1));
        System.out.println(priorityQueue.contains(1));





        //Get
        System.out.println("Testing get function");
        System.out.println(collection.iterator().next());
        System.out.println(linklist.get(0));
        System.out.println(vector.get(0));
        System.out.println(stack.get(0));  //System.out.println(stack.pop());

        System.out.println(unorderedMap.get(1));
        System.out.println(insertionOrderPreservedMap.get(1));
        System.out.println(orderedMap.get(1));

        System.out.println(unorderedSet.iterator().next());
        System.out.println(insertionOrderPreservedSet.iterator().next());
        System.out.println(orderedSet.iterator().next());

        System.out.println(queue.peek());
        System.out.println(priorityQueue.peek());



        //add
        collection.add(2);
        arrayList.add(2);
        linklist.add(2);
        vector.add(2);
        stack.add(2);

        unorderedMap.put(2,2);
        insertionOrderPreservedMap.put(2,2);
        orderedMap.put(2,2);

        unorderedSet.add(2);
        insertionOrderPreservedSet.add(2);
        orderedSet.add(2);

        queue.add(2);
        priorityQueue.add(2);




        //For loop
        //Get
        System.out.println("Testing loop function");
        System.out.println("\nTesting list loop function");
        collection.forEach(System.out::print);
        System.out.println();

        linklist.forEach(System.out::print);
        System.out.println();

        vector.forEach(System.out::print);
        System.out.println();

        stack.forEach(System.out::print);
        System.out.println();

        System.out.println("\nTesting map loop function");
        unorderedMap.forEach((x,y)-> System.out.print( x+y));
        System.out.println();

        insertionOrderPreservedMap.forEach((x,y)-> System.out.print( x+y));
        System.out.println();

        orderedMap.forEach((x,y)-> System.out.print( x+y));
        System.out.println();

        System.out.println("\nTesting set loop function");
        unorderedSet.forEach(System.out::print);
        System.out.println();

        insertionOrderPreservedSet.forEach(System.out::print);
        System.out.println();

        orderedSet.forEach(System.out::print);
        System.out.println();

        System.out.println("\nTesting queue loop function");
        queue.forEach(System.out::print);
        System.out.println();

        priorityQueue.forEach(System.out::print);






    }
}
