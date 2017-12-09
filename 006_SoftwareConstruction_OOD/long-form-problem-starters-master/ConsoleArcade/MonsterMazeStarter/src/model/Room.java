package model;

import java.util.ArrayList;
import java.util.List;

public class Room extends Choice{

    private List<Choice> choices;
    private int id;
    private String optionMessage;

    public Room(int id) {
        optionMessage = "Enter Room " + id + ".";
        this.id = id;
        choices = new ArrayList<>();
    }

    //EFFECTS: prints a message representing this possible next choice
    public void printOptionMessage() {
        System.out.println(optionMessage);
    }

    //EFFECTS: prints all possible next choices
    public void printOutcome() {
        System.out.println("You are now in Room " + id + ".\n");
        System.out.println("You have the following options: ");

        int counter = 1;

        for (Choice m: choices) {
            System.out.print("\tOption " + counter + ": ");
            m.printOptionMessage();
            counter++;
        }
    }

    //MODIFIES: this
    //EFFECTS: adds m to next possible monsters
    public void addChoice(Choice m) {
        choices.add(m);
    }

    //getters for gameplay
    public Choice getChoice(int i) throws Exception {
        if (i > (choices.size())) { throw new Exception(); }
        return choices.get(i-1);
    }

}
