package model;

public class Reminder extends Entry {
    private String note;

    public Reminder(Date d, Time t, String l) {
        super(d, t, l);
    }

    // getters
    public String getNote() {
        return note;
    }

    // methods
    public void setNote(String note) {
        this.note = note;
    }
}
