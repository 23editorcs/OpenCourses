package model;

public class Event extends Entry {
    Reminder reminder;

    public Event(Date d, Time t, String l) {
        super(d, t, l);
    }

    // getters
    public Reminder getReminder() {
        return reminder;
    }

    //methods
    public void setReminder(Date d, Time t, String l, String n) {
        reminder = new Reminder(d, t, l);
        reminder.setNote(n);
    }
}
