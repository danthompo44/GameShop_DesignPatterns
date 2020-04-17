package GameApp.java.controllers;

import GameApp.java.controllers.interfaces.IConsoleCommunication;
import GameApp.java.general.AlertMessage;
import GameApp.java.general.CostFormatter;
import GameApp.java.models.adaptors.ConsoleViewAdapter;
import GameApp.java.routers.RouteNames;
import GameApp.java.routers.Router;
import GameApp.java.services.ConsoleService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLEditConsoleController implements Initializable, IConsoleCommunication {
    private Router router = new Router();
    @FXML
    private TextField id, description, cost, bitDepth, formFactor;
    @FXML
    private CheckBox rented, repair;
    @FXML
    private void handleBackAction(ActionEvent event) throws IOException{//method for changing routes to the show consoles page
        router.changeRoute(RouteNames.SHOW_CONSOLES, event);
    }
    @FXML
    private void handleSubmitAction(ActionEvent event){//method for updating a customer and changing routes to the show consoles page
        String id = this.id.getText();
        String description = this.description.getText();
        String cost = this.cost.getText();
        String bitDepth = this.bitDepth.getText();
        String formFactor = this.formFactor.getText();
        boolean isRented = rented.isSelected();
        boolean beingRepaired = repair.isSelected();
        try{
            ConsoleService.editConsole(id, description, cost, bitDepth, formFactor, isRented, beingRepaired);
            router.changeRoute(RouteNames.SHOW_CONSOLES, event);
        }
        catch(Exception e){
            AlertMessage.showMessage(Alert.AlertType.INFORMATION, e.getMessage());
        }
    }

    @Override
    public void passID(String id) {//method for passing an objects id from the previous page
        try{
            ConsoleViewAdapter.getConsoleDetails(ConsoleService.getConsoleByID(id), this);
        }
        catch(Exception e){//exception should never be seen, here for completeness
            AlertMessage.showMessage(Alert.AlertType.INFORMATION, e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void setRepairedVisibility(){//set the visibility of the repair checkbox so you can't set a product to being repaired when it's on loan
        if(rented.isSelected()){
            repair.setVisible(false);
        }
    }

    @Override
    public void consoleDetailsToEdit(String id, String description, double cost, String bitDepth, String formFactor, boolean isRented, boolean beingRepaired) {
        this.id.setText(id);
        this.description.setText(description);
        this.cost.setText(CostFormatter.format(cost));
        this.bitDepth.setText(bitDepth);
        this.formFactor.setText(formFactor);
        this.rented.setSelected(isRented);
        this.repair.setSelected(beingRepaired);
        setRepairedVisibility();
    }
}
