package model;

import java.util.LinkedList;
import java.util.List;

public class CellPhone implements Traceable {

    private String number;
    private List<Call> listOfCall;
    private Person person;
    private String location;

    public CellPhone(String number, Person person) {
        this.number = number;
        this.person = person;
        listOfCall = new LinkedList<>();
    }

    // getters
    public Person getPerson() {
        return person;
    }
    public String getNumber() {
        return number;
    }
    public List<Call> getListOfCall() {
        return listOfCall;
    }

    // methods
    public void call(CellPhone out) {
        Call outCall = new Call(out);
        listOfCall.add(outCall);
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public Object getTrace() {
        return this;
    }

    @Override
    public void track() {
        this.location = "New York";
        System.out.println("Tracking..." + number +" !!!");
    }
}
