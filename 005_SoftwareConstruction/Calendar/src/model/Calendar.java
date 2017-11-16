package model;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private Date today;
    private String account;
    private List<Entry> entries;

    public Calendar(Date d, String email) {
        today = d;
        account = email;
        entries = new ArrayList<>();
    }

    // getters

    public Date getToday() {
        return today;
    }

    public String getAccount() {
        return account;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public Entry getSoonestEntry() {
        Entry soonest = entries.get(0);
        for (Entry e: entries) {
            int soonestHour = soonest.getTime().getHour();
            int soonestMin = soonest.getTime().getMinute();
            int eHour = e.getTime().getHour();
            int eMin = e.getTime().getMinute();

           if (eHour < soonestHour) {
               soonest = e;
           }
           else if (eHour == soonestHour) {
               if (eMin < soonestMin) {
                   soonest = e;
               }
           }
        }
        return soonest;
    }

    public boolean getEntryByName(String l) {

        for (Entry e: entries) {
            if (e.getLabel() == l) {
                System.out.println(e);
            }
        }
        return true;
    }

    public boolean getMeetings() {
        for (Entry e: entries) {
            if (e.getClass() == Meeting.class) {
                System.out.println(e);
            }
        }
        return true;
    }

    // methods
    public void addEntry(String type, Entry e) {
        entries.add(e);
    }

    public void removeEntry(Entry e) {
        entries.remove(e);
    }
}
