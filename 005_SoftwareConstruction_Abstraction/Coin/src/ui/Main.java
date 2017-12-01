package ui;

import model.Coin;

public class Main {
    public static void main(String[] args) {
        Coin c = new Coin();
        c.flip();
        System.out.println(c.checkStatus());
    }
}
