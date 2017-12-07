package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * model.Customer interface for making requests of various Ganges.com, Inc. services.
 */
public class GangesServiceManager {

    private int customerIdCounter;

    public static final int FIRST_CUSTOMER_NUMBER = 100;

    private BookingManager bk;
    private CustomerStorage cs;

    public GangesServiceManager() {
        this.customerIdCounter = FIRST_CUSTOMER_NUMBER;

        bk = new BookingManager();
        cs = new CustomerStorage();
    }

    // EFFECTS: Create a new customer with the given address and name
    public Customer signUpNewCustomer(String address, String name) {
        return new Customer(name, address, customerIdCounter++);
    }

    // EFFECTS: Print all books for sale to the console, along with the index number + 1.
    public void listAvailableBooks() {
       bk.listAvailableBooks();
    }

    // REQUIRES: bookNumber is >= 1
    // MODIFIES: this
    // EFFECTS: If the book number corresponds to a book in stock (i.e., is a valid index+1 of the list books),
    //          then create a new model.BookOrder and return the order number; otherwise, do not create an order and return -1.
    public BookOrder orderBook(Customer c, int bookNumber) {
       return bk.orderBook(c, bookNumber);
    }

    // MODIFIES: this
    // EFFECTS: if this order number matches a current order, then the order is cancelled (removed from the orders list)
    public boolean cancelBookOrder(int orderNumber) {
       return bk.cancelBookOrder(orderNumber);
    }

    // MODIFIES: this
    // EFFECTS: Stores the given data in the cloud under this customer's account
    public void putData(Customer c, String data) {
        cs.putData(c, data);
    }

    // Returns the given customer's data from the cloud
    public String getData(Customer c) {
            return cs.getData(c);
    }

    // MODIFIES: this
    // EFFECTS: Deletes this customer's data from the cloud
    public String deleteData(Customer c) {
        return cs.deleteData(c);
    }
}
