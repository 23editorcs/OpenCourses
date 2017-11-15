package model;

import java.util.ArrayList;
import java.util.List;

public class MyProfile {

    private String name;
    private int age;
    private String currentLocation;
    private String workPlace;
    private List<MyProfile> friendsList;
    private List<Event> upcomingEvents;

    public MyProfile(String nm, int age, String locn, String work) {
        name = nm;
        this.age = age;
        currentLocation = locn;
        workPlace = work;
        friendsList = new ArrayList<>();
        upcomingEvents = new ArrayList<>();
    }

    // getters
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getCurrentLocation() {
        return currentLocation;
    }
    public String getWorkPlace() {
        return workPlace;

    }
    public int upcomingEventNum() {
        return upcomingEvents.size();

    }
    public List<MyProfile> getFriendsList() {
        return friendsList;
    }
    public List<Event> getEventList() {
        return upcomingEvents;
    }

    // REQUIRES: f is not already in friendsList
    // MODIFIES: this
    // EFFECTS: consumes a MyProfile object, a friend f, and adds it to the friendsList
    public void addFriend(MyProfile f) {
        friendsList.add(f);
    }

    // MODIFIES: this
    // EFFECTS: removes a friend with the given name from this. If removal is successful, return true, else
    //          return false
    public boolean unFriend(String nm) {
        for (MyProfile f: friendsList){
            if (f.getName() == nm){
                friendsList.remove(f);
                return true;
            }
        }
        return false;
    }

    // REQUIRES: ev is not in upcomingEvents
    // MODIFIES: this
    // EFFECTS: adds the given event to the list of upcoming events
    public void addEvent(Event ev) {
        upcomingEvents.add(ev);
    }

    // MODIFIES: this
    // EFFECTS: removes an event with the given name. If removal is successful, return true, else return false
    public boolean removeEvent(String nm) {
        for (Event e: upcomingEvents){
            if (e.getName() == nm){
                upcomingEvents.remove(e);
                return true;
            }
        }
        return false;
    }

    // EFFECTS: returns the number of events that are at the current location of this person
    public int eventNumNearMe() {
        int numberEvents = 0;
        for (Event e: upcomingEvents){
            if (e.getLocation() == currentLocation){
                numberEvents += 1;
            }
        }
        return numberEvents;
    }

    // EFFECTS: returns the number of events of the given type et
    public int specificEventType(EventType et) {
        int numberEvents = 0;
        for (Event e: upcomingEvents){
            if (e.getEventType() == et){
                numberEvents += 1;
            }
        }
        return numberEvents;
    }

    // EFFECTS: prints events of  type et to the console
    //          Hint: is there a method you have already written that you can use?
    public void printEventSchedule(EventType et) {
        for (Event e: upcomingEvents){
            if (e.getEventType() == et){
                System.out.println(e);
            }
        }
    }

    // EFFECTS: prints out the list of friends that this MyProfile has
    public void printFriendNames() {
        for (MyProfile f: friendsList){
            System.out.println(f.getName());
        }
    }

    // EFFECTS: prints out the names of friends who live at the same location associated with this profile
    public void printFriendsNearMe() {
        for (MyProfile f: friendsList){
            if (f.getCurrentLocation() == currentLocation){
                System.out.println(f.getName());
            }
        }
    }

    // EFFECTS: produces true if this profile has a friend with the given name,
    //          OR if any of this profile's friends has a friend with the given name
    //          Hint: use recursion!
    public boolean canFindPerson(String name) {
        if (friendsList.size() == 0){
            return false;
        }
        else {
            for (MyProfile f: friendsList){
                if (f.getName() == name){
                    return true;
                }
                else if (f.canFindPerson(name) == true) {
                    return true;
                }
            }
        }
        return false;
    }
}
