package GameApp.java.models;

import java.util.ArrayList;

public class Basket {
    private static final Basket basket = new Basket();
    private ArrayList<Product> products = new ArrayList<>();

    private Basket(){
    }

    public static Basket getBasket(){
        return basket;
    }

    public void addProduct(Product product){
        products.add(product);
    }
    public void removeProduct(Product product){
        products.remove(product);
    }
    public void clearBasket(){
        products.clear();
    }
    public ArrayList<Product> getProducts(){
        return products;
    }
}
