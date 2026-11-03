package com.example.designpattern.LLDPractice.HashMap.InternalWOrking;

import java.util.*;

public class TestEqualsAndHashCodeMethods {
     /* Java Collection Comparison:
     *
     * 1. HASH-BASED COLLECTIONS (hashCode() + equals())
     *    - HashSet
     *    - LinkedHashSet
     *    - HashMap
     *    - LinkedHashMap
     *    - Hashtable -- ThreadSafe - Legacy
     *    - ConcurrentHashMap -- Threadsafe
     *
     *    hashCode() -> Identifies the bucket.
     *    equals()   -> Checks logical equality / duplicate keys or elements.
     *
     * 2. SORTED COLLECTIONS (compareTo() / compare())
     *    - TreeSet
     *    - TreeMap
     *    - PriorityQueue
     *
     *    compareTo() / compare() -> Maintains sorting order.
     *    For TreeSet and TreeMap, result 0 means duplicate element/key.
     *
     * 3. LIST COLLECTIONS
     *    - ArrayList
     *    - LinkedList
     *   No duplicate checking
     */

    public static void main(String[] args) {

        EmployeeWithEqualsOnly employeeWithEqualsOnly1 = new EmployeeWithEqualsOnly("krishna",1);
        EmployeeWithEqualsOnly employeeWithEqualsOnly2 = new EmployeeWithEqualsOnly("krishna",1);

        EmployeeWithEqualsAndHashCode employeeWithEqualsAndHashCode1 = new EmployeeWithEqualsAndHashCode("krishna",1);
        EmployeeWithEqualsAndHashCode employeeWithEqualsAndHashCode2 = new EmployeeWithEqualsAndHashCode("krishna",1);


        validateEqualsMethod(employeeWithEqualsOnly1, employeeWithEqualsOnly2, employeeWithEqualsAndHashCode1, employeeWithEqualsAndHashCode2);
        validateHashCode(employeeWithEqualsOnly1, employeeWithEqualsOnly2, employeeWithEqualsAndHashCode1, employeeWithEqualsAndHashCode2);

    }


    static void validateEqualsMethod(EmployeeWithEqualsOnly employeeWithEqualsOnly1, EmployeeWithEqualsOnly employeeWithEqualsOnly2,
                                     EmployeeWithEqualsAndHashCode employeeWithEqualsAndHashCode1, EmployeeWithEqualsAndHashCode employeeWithEqualsAndHashCode2){
        System.out.println("-----------Validating Equals method---------------------------");
        System.out.println(employeeWithEqualsOnly1.equals(employeeWithEqualsOnly2));
        System.out.println(employeeWithEqualsAndHashCode1.equals(employeeWithEqualsAndHashCode2));

    }

    static void validateHashCode(EmployeeWithEqualsOnly employeeWithEqualsOnly1, EmployeeWithEqualsOnly employeeWithEqualsOnly2,
                                 EmployeeWithEqualsAndHashCode employeeWithEqualsAndHashCode1, EmployeeWithEqualsAndHashCode employeeWithEqualsAndHashCode2){

        Set<EmployeeWithEqualsOnly> employeeWithEqualsOnlyList = new HashSet<>();

        employeeWithEqualsOnlyList.add(employeeWithEqualsOnly1);
        employeeWithEqualsOnlyList.add(employeeWithEqualsOnly2);

        Set<EmployeeWithEqualsAndHashCode> employeeWithEqualsAndHashCodeList = new HashSet<>();
        employeeWithEqualsAndHashCodeList.add(employeeWithEqualsAndHashCode1);
        employeeWithEqualsAndHashCodeList.add(employeeWithEqualsAndHashCode2);

        System.out.println("-------Validating hashcode for EmployeeWithEqualsOnly -----------------------------");
        System.out.println(employeeWithEqualsOnly1.hashCode());
        System.out.println(employeeWithEqualsOnly2.hashCode());
        
        System.out.println("------------Validating hashcode for EmployeeWithEqualsAndHashCode ------------------- ");
        System.out.println(employeeWithEqualsAndHashCode1.hashCode());
        System.out.println(employeeWithEqualsAndHashCode2.hashCode());

        System.out.println("------------calculating size of both type objects ------------------- ");
        System.out.println(employeeWithEqualsOnlyList.size());
        System.out.println(employeeWithEqualsAndHashCodeList.size());



    }







    static class EmployeeWithEqualsOnly {
        String name ;
        int EmpId;

        public EmployeeWithEqualsOnly(String name, int empId) {
            this.name = name;
            EmpId = empId;
        }


        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass())
                return false;

            EmployeeWithEqualsOnly that = (EmployeeWithEqualsOnly) o;
            return EmpId == that.EmpId && Objects.equals(name, that.name);
        }
    }


    static class EmployeeWithEqualsAndHashCode {
        String name ;
        int EmpId;

        public EmployeeWithEqualsAndHashCode(String name, int empId) {
            this.name = name;
            EmpId = empId;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass())
                return false;
            EmployeeWithEqualsAndHashCode that = (EmployeeWithEqualsAndHashCode) o;
            return EmpId == that.EmpId && Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, EmpId);
        }
    }
}
