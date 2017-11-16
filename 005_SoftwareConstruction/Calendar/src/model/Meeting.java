package model;

import java.util.ArrayList;
import java.util.List;

public class Meeting extends Event {
    private List<String> attendees;
    private List<String> emails;

    public Meeting(Date d, Time t, String l) {
        super(d, t, l);
        attendees = new ArrayList<>();
        emails = new ArrayList<>();
    }

    // getters

    public List<String> getEmails() {
        return emails;
    }

    public List<String> getAttendees() {
        return attendees;
    }

    // methods
    public void addAttendee(String name, String email) {
        attendees.add(name);
        emails.add(email);
    }

    public void removeAttendee(String name) {
        int index = attendees.indexOf(name);
        emails.remove(index);
        attendees.remove(name);
    }

    public boolean sendInvitation() {
        for (String e: emails) {
            System.out.println("Dear, "+e+". Please join our meeting.");
        }
        return true;
    }
}
