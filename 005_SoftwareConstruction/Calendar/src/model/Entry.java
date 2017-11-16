package model;

public abstract class Entry {
    Date date;
    Time time;
    String label;
    boolean isRepeated;
    int dayInterval;
    int hourInterval;
    int minInterval;

    public Entry(Date d, Time t, String l) {
        date = d;
        time = t;
        label = l;
        isRepeated = false;
    }

    // getters

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public String getLabel() {
        return label;
    }

    public boolean isRepeated() {
        return isRepeated;
    }


    // methods
    public void setRepeated() {
        isRepeated = true;
    }

    public void setIntervals(int day, int hour, int min) {
        if (isRepeated) {
        dayInterval = day;
        hourInterval = hour;
        minInterval = min;
        }
    }

    public int getDayInterval() {
        return dayInterval;
    }

    public int getHourInterval() {
        return hourInterval;
    }

    public int getMinInterval() {
        return minInterval;
    }
}
