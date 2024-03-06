package com.example.designpattern.logics.StreamAPIs;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamJoining {

    public static void main(String[] args) {

        List<DummyObject> stringList = Arrays.asList(new DummyObject("12121","3432"),new DummyObject("564574","hghghhf"));

        //Using joining function
        String string = stringList.stream().map(x->x.getLastName()).collect(Collectors.joining("|"));
        System.out.println(string);

        //Using reduce function
        Optional<String> reducedString = stringList.stream().map(x->x.getLastName()).reduce((x, y)-> x+y);
        System.out.println(reducedString);

    }

}
class DummyObject {

    private String firstName ;
    private String lastName ;

    public DummyObject(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
