package GameApp.java.models;

import GameApp.java.general.DateHelp;

import java.util.ArrayList;

public class Rental {
    private String id;
    private static int idSeed = 1000;
    private ArrayList<Product> rentalItems = new ArrayList<>();
    private Customer customer;
    private boolean rentalReturned;
    private String returnDate;
    private double totalCost;

    public Rental(Customer customer, ArrayList<Product> products){
        id = "RE" + idSeed;
        idSeed++;
        rentalReturned = false;
        this.customer = customer;
        rentalItems.addAll(products);
        returnDate = DateHelp.getOneMonthLater();
        setTotalCost(products);
        for(Product p: products){
            p.setRented(true);
        }
    }

    public String getId(){
        return id;
    }

    public Customer getCustomer(){//method for returning a rentals customer object (if they exist).
            return customer;
    }

    public ArrayList<Product> getProducts(){
        return rentalItems;
    }

    public void returnRental(){
        rentalReturned = true;
        for(Product p: rentalItems){
            p.setRented(false);
        }
    }

    public String getReturnDate(){
        return returnDate;
    }

    private void setTotalCost(ArrayList<Product> products){
        totalCost = 0.0;
        for(Product p: products){
            totalCost+=p.getCost();
        }
    }

    public double getTotalCost(){
        return totalCost;
    }
}