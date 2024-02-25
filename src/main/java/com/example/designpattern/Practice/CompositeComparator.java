package com.example.designpattern.Practice;

import java.util.Comparator;

public class CompositeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        if(e1.getId().compareTo(e2.getId()) != 0){
            return e1.getId().compareTo(e2.getId());
        } else{

           if(e1.getFirstName().compareTo(e2.getFirstName()) != 0){
                return e1.getFirstName().compareTo(e2.getFirstName());
            } else {

               if(e1.getLastName().compareTo(e2.getLastName()) != 0){
                   return e1.getLastName().compareTo(e2.getLastName());
               } else {
                   return e1.getFirstName().compareTo(e2.getFirstName());
               }
           }
        }
    }
}
