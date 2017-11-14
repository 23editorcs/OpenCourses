package ui;

import model.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // List<Integer> c1 = new ArrayList<>(Arrays.asList(1,2));
        Order o1 = new Order("Quy", 65, Arrays.asList(1,2));

        List<Order> orders = new ArrayList<>();
        orders.add(o1);

        o1.completed();

        for(Order o: orders){
            if(o.isCompleted()){
                System.out.println(o.printReceipt());
            }
            else {
                System.out.println(o.kitchenInstruction());
            }
        }
    }
}
