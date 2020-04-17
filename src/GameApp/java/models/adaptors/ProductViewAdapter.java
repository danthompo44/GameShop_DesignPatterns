package GameApp.java.models.adaptors;

import GameApp.java.models.Product;
import javafx.scene.control.ListView;

public class ProductViewAdapter {
    public static String getProductDescription(ListView<Product> lv){
        return lv.getSelectionModel().getSelectedItem().getDescription();
    }

    public static Product getProductObject(ListView<Product> lv){
        return lv.getSelectionModel().getSelectedItem();
    }
}
