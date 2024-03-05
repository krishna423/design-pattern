package com.example.designpattern;

import com.example.designpattern.LLDPractice.HashMap.Node;
import com.example.designpattern.Practice.Employee;

import java.util.*;

public class ListOperations {

    //integer array 0,1,2,1,0
    // 0,1,2 -> map(0,)  0(n) + o(n)
    //
    public static void main(String[] args) {
        // 0, 1,

        //ArrayList
        List<Integer> list = new ArrayList<>(10);
        List<Integer> list2 = Arrays.asList(1,2,3,5);
        List<String> strings = List.of("foo", "bar", "baz");
        List<Integer> linklist = new LinkedList<>();
        //Search -> For get(index), foreach, Iterator, Stream

        int[] array = new int[10];
        int[] array2 = {1,2,4,5};
        Node[] array3 = {new Node<>(1,2),new Node<>(4,5)};
        int[][] matrix = new int[10][10];
        int[][] matrix2 = {{1,2,3},{3,4,5},{6,7,8,9,10}};
        // For [i], Foreach , stream

        System.out.println("Array elemenst : ");
        for(int i=0;i<matrix2.length;i++){
            for(int j=0;j<matrix2[i].length;j++){
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println("");
        }


        System.out.println("\nStack element");
        Stack<Integer> st = new Stack<Integer>();
        st.push(111);
        st.push(22);
        st.push(8);
        st.push(12345);

        while (!st.empty()){

            System.out.print(st.pop() + " ");
        }

        System.out.println("\n\nQueue element : ");


        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(111);
        queue.add(22);
        queue.add(8);
        queue.add(12345);


        while (!queue.isEmpty()){
            System.out.print(queue.poll()+ " ");
        }



        PriorityQueue<Employee> priorityQueue = new PriorityQueue<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if(Objects.equals(o1.getId(), o2.getId())){
                    return o1.getSalary().compareTo(o2.getSalary());
                }
                return o1.getId().compareTo(o2.getId());
            }
        });



        PriorityQueue<Employee> priorityQueue1 = new PriorityQueue<>((e1, e2)->
             e1.getId() != e2.getId() ? e1.getId().compareTo(e2.getId()) : e1.getSalary().compareTo(e2.getSalary()));

        priorityQueue1.add(new Employee(12,"krishna","adsmmmm",1212));
        priorityQueue1.add(new Employee(127,"askrishna","33ammmm",212));
        priorityQueue1.add(new Employee(12,"zzkrishna","123mmmm",712));
        priorityQueue1.add(new Employee(121,"asdakrishna","m445mmm",12));

        System.out.println("\n\nPriority queue element");

        while (!priorityQueue1.isEmpty()){
            System.out.print(priorityQueue1.poll()+" ");
        }










    }
}
