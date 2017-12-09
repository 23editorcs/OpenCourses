package model;

public abstract class Choice {
    protected String optionMessage;


    public void printOptionMessage() {
        System.out.println(optionMessage);
    }
    public abstract void printOutcome();
}
