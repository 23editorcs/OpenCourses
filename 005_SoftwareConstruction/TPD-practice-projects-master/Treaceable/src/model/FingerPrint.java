package model;

public class FingerPrint implements Traceable {

    private Person person;
    private String location;

    public FingerPrint(Person p, String loc) {
        this.person = p;
        this.location = loc;
    }

    // getter
    public Person getPerson() {
        return person;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public Object getTrace() {
        return person;
    }

    @Override
    public void track() {
        System.out.println("Tracking..." + person.getName() +" !!!");
    }
}
