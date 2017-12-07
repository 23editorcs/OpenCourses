package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HairSalon {

    private BookingManager manager;
    private SpecialistSuggesion specialist = new SpecialistSuggesion();

    // EFFECTS: creates a hair salon with available booking times from 0-17hrs.
    public HairSalon(){
        manager = new BookingManager();
    }

    // MODIFIES: this and Customer
    // EFFECTS: books the customer into the requested timeslot if it is a valid timeslot,
    //          and lets the Customer know the booking time.
    public boolean makeNewBooking(Customer c, int bookingTime, Treatment treatment){
        return manager.makeNewBooking(c, bookingTime, treatment);
    }
    public boolean cancelBooking(Customer c, int bookingTime, Treatment treatment){
        return manager.cancelBooking(c, bookingTime, treatment);
    }
    // EFFECTS: prints out all the bookings.  If the time has not been booked, prints "available"
    public void printBookingsList(){
        manager.printBookingsList();
    }
    // EFFECTS: returns true if the customer is found at the booking time.
    public boolean verifyBooking(Customer c, int bookingTime){
        return manager.verifyBooking(c, bookingTime);
    }
    // EFFECTS: returns true if the customer is booked at the booking time
    public boolean confirmBookedName(String cName, int bookingTime){
        return manager.confirmBookedName(cName, bookingTime);
    }

    // MODIFIES: this and Customer
    // EFFECTS:  changes the customer booked in the bookings, and let's the Customer know the new booking time.
    public void changeBooking(Customer customer, int newTime){
        manager.changeBooking(customer, newTime);
    }

    public ArrayList<String> suggestConsultant(Treatment treatment) {
       return specialist.suggestConsultant(treatment);
    }


}