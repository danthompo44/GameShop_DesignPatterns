package GameApp.java.repositories;

import GameApp.java.models.Basket;
import GameApp.java.models.Product;
import GameApp.java.models.validators.BasketValidator;
import GameApp.java.services.SessionService;

import java.util.ArrayList;

//responsible for keep track of items in the basket and adding them to an array list
public class ProductBasketRepository {
    private Basket basket = Basket.getBasket();
    public ArrayList<Product> getProductBasket() {
        return basket.getProducts();
    }

    public void addProduct(Product product) throws Exception{
        if(!getProductBasket().contains(product)){
            BasketValidator.addProduct(product);
            basket.addProduct(product);
        }
        else{
            throw new Exception(product.getDescription() + " is already in your basket!");
        }
    }//method for adding a Product to the Product Basket, runs checks to make sure not too many games/consoles
    // are already rented and if the product already exists in the basket

    public void removeProduct(Product product){
        if(getProductBasket().contains(product)){
            BasketValidator.removeProduct(product);
            basket.removeProduct(product);
        }
    }//checks if product exists and checks what type of product it is,
    //removes the product and lowers the console/game count accordingly.

    //returns true if console limit is reached

    public void clearBasket(){
        BasketValidator.reset();
        basket.clearBasket();
    }

    public static boolean consoleLimitReached(){
        return BasketValidator.consoleLimitReached();
    }
    public static boolean gameLimitReached(){//added for testing purposes
        return BasketValidator.gameLimitReached();
    }
    public static int getTotalConsolesAdded(){//added for testing purposes
        return BasketValidator.getConsoleCount();
    }
    public static int getTotalGamesAdded(){//added for testing purposes
        return BasketValidator.getGameCount();
    }
}



//
//