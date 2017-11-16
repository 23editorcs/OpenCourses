package ui;

import model.*;

public class Main {
    public static void main(String[] args) {
        // set up calendar
        Date today = new Date(16, 11,2017);
        String myEmail = "nguyenphuquy2303@gmail.com";
        Calendar c1 = new Calendar(today, myEmail);

        // set up entries
        Time t1 = new Time(1, 50);
        Time t2 = new Time(5, 20);
        Time t3 = new Time(15, 10);
        Time t4 = new Time(20, 59);


        Entry r1 = new Reminder(today, t1,"Wake up");

        Entry e2 = new Event(today, t2, "breakfast");

        Entry m3 = new Meeting(today, t3, "java");
        Meeting m4 = new Meeting(today, t4, "deeplearning");

        // add entry methods
        c1.addEntry("Reminder", r1);
        c1.addEntry("Event", e2);
        c1.addEntry("Meeting", m3);
        c1.addEntry("Meeting", m4);

        // run methods
        m4.sendInvitation();
        System.out.println(c1.getAccount());
        System.out.println(c1.getToday());
        System.out.println(c1.getEntries());
        System.out.println(c1.getEntryByName("java"));
        c1.getMeetings();
        c1.removeEntry(m3);
        c1.getMeetings();
    }
}
