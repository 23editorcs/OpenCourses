package model;

public abstract class Employee {
    public static final double BASE_WAGE = 10.00;
    protected String name;
    protected int age;
    protected double hoursWorked;
    protected boolean atWork;

    public Employee(int age, String name) {
        this.age = age;
        hoursWorked = 0;
        this.name = name;
        atWork = false;
    }

    // getters
    public String getName() { return name; }

    public int getAge() { return age; }

    public double getHoursWorked() { return hoursWorked; }

    public boolean isAtWork() { return atWork; }

    // MODIFIES: this
    // EFFECTS: adds hours to the hoursWorked field
    public void logHoursWorked(double hours) {
        hoursWorked += hours;
    }

    // EFFECTS: sets isRegisterOpen to true, and updates atWork to reflect that this Cashier is
    //          now at work
    public abstract void startWork(double hours);

    // EFFECTS: sets isRegisterOpen to false and updates atWork to reflect that this Cashier is
    //          no longer at work
    public abstract void leaveWork();

    // EFFECTS: computes wages for the day
    public double computeWage() {
        return (hoursWorked * (Cashier.CASHIER_WAGE + BASE_WAGE));
    }
}
