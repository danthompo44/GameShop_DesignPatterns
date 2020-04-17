package GameApp.java.controllers;

import GameApp.java.general.AlertMessage;
import GameApp.java.routers.RouteNames;
import GameApp.java.routers.Router;
import GameApp.java.services.CustomerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLAddCustomerController implements Initializable {
    private Router router = new Router();

    @FXML
    private TextField firstName, surname, address;
    @FXML
    private void handleCustomerConfirmAction(ActionEvent event){
        try{//uses the validator to check that information has been inputted, then creating a customer and adding them to an array list of customers, switches view to the colleague home page
            CustomerService.addCustomer(firstName.getText(), surname.getText(), address.getText());
            router.changeRoute(RouteNames.COLLEAGUE_HOME, event);
        }
        catch(Exception e){//displays an alert message with information about the caught exception
            AlertMessage.showMessage(Alert.AlertType.INFORMATION, e.getMessage());
        }
    }
    @FXML
    private void handleBackAction(ActionEvent event) throws IOException{//switches view back to the colleague home page
        router.changeRoute(RouteNames.COLLEAGUE_HOME, event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
