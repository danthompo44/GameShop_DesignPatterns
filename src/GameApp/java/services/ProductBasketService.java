package GameApp.java.services;

import GameApp.java.models.Product;
import GameApp.java.repositories.ProductBasketRepository;

import java.util.ArrayList;

//Keeps track of what products the user has been added to their basket
public class ProductBasketService {
    private ProductBasketRepository pbr = new ProductBasketRepository();
    public ArrayList<Product> allBasketItems() {
        return pbr.getProductBasket();
    }

    public void addProduct(Product product) throws Exception{
        pbr.addProduct(product);
    }

    public void clearBasket(){
        pbr.clearBasket();
    }

    public void removeProduct(Product product){
        pbr.removeProduct(product);
    }

    public static boolean consoleLimitReached(){
        return ProductBasketRepository.consoleLimitReached();
    }

}
