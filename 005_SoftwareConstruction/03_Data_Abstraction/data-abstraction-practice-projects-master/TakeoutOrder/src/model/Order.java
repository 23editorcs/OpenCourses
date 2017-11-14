package model;

import java.util.List;

public class Order {
    // variables
    private String custName;
    private int ticketNumber;
    private List<Integer> comboId;
    private boolean completed;
    private String instruction;
    private double price;

    public Order(String custName, int ticketNumber, List<Integer> comboId){
        this.ticketNumber = ticketNumber;
        this.custName = custName;
        this.comboId = comboId;
        calPrice();
        completed = false;
    }

    // getters
    public String getCustName(){ return custName; }
    public int getTicketNumber() { return ticketNumber; }
    public List<Integer> getComboId() {
        return comboId;
    }
    public boolean isCompleted() {
        return completed;
    }
    public String getInstruction() {
        return instruction;
    }
    public double getPrice() {
        return price;
    }

    // methods

    // MODIFIES: this
    // EFFECTS: calculate the price of a the order
    private void calPrice(){
       for (int comboid: getComboId()){
           switch(comboid){
               case 1:
                   price += 10.0;
                   break;
               case 2:
                   price += 9.5;
                   break;
               case 3:
                   price += 11.0;
                   break;
               case 4:
                   price += 7.5;
                   break;
               case 5:
                   price += 8.0;
                   break;
               default:
                   price = price;
                   break;
           }
       }
    }

    // MODIFIES: this
    // EFFECTS: turn completeted to true
    public void completed() {
        completed = true;
    }

    // MODIFES: this
    // EFFECTS: set a new instruction
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    // EFFECTS: print a receipt to customer
    public String printReceipt() {
        return "Your order number: " + getTicketNumber() +
                " price: " + getPrice() + " is ready";
    }

    // EFFECTS: print a message to kitchen to cook
    public String kitchenInstruction(){
        String comboList = new String();
        for (int comboid: getComboId()){
            comboList.concat(" ").concat(foodType(comboid));
        }
        return getTicketNumber() + " Combo: " + comboList + " Instruction: "
                + getInstruction();
    }

    // EFFECTS: conver combo ids to food type
    private String foodType(int comboid){
        switch(comboid){
            case 1: return "Salad";
            case 2: return "Pasts";
            case 3: return "Pizza";
            case 4: return "Tacos";
            case 5: return "Sandwich";
            default: return "Soup";
        }
    }
}
