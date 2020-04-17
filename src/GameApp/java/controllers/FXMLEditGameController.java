package GameApp.java.controllers;

import GameApp.java.controllers.interfaces.IGameCommunication;
import GameApp.java.general.AlertMessage;
import GameApp.java.general.CostFormatter;
import GameApp.java.models.adaptors.GameViewAdapter;
import GameApp.java.routers.RouteNames;
import GameApp.java.routers.Router;
import GameApp.java.services.GameService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLEditGameController implements Initializable, IGameCommunication {
    private Router router = new Router();

    @FXML
    private TextField gameID, gameDescription, cost, platform, consoleID;
    @FXML
    private CheckBox loanedCheckbox, repairedCheckbox;
    @FXML
    private void handleBackAction(ActionEvent event) throws IOException{//method for changing the route to the show games view
        router.changeRoute(RouteNames.SHOW_GAMES, event);
    }
    @FXML
    private void handleSubmitAction(ActionEvent event){//method for editing a game, takes input fields and passes them to the GameService.editGame method
        String id = gameID.getText();
        String description = gameDescription.getText();
        String gameCost = cost.getText();
        String consoleID = this.consoleID.getText();
        boolean loaned = loanedCheckbox.isSelected();
        boolean beingRepaired = repairedCheckbox.isSelected();
        try{
            GameService.editGame(id, description, gameCost, consoleID, loaned, beingRepaired);
            router.changeRoute(RouteNames.SHOW_GAMES, event);
        }
        catch (Exception e){
            AlertMessage.showMessage(Alert.AlertType.INFORMATION, e.getMessage());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }

    @Override
    public void passID(String id) {
        try{
            GameViewAdapter.getGameDetails(GameService.getGameByID(id), this);
        }
        catch(Exception e){//Exception should never be seen, here for completeness
            AlertMessage.showMessage(Alert.AlertType.INFORMATION, e.getMessage());
        }

    }

    @Override
    public void gameDetailsToEdit(String id, String description, double cost, String consoleID, String platform, boolean isLoaned, boolean beingRepaired) {
        gameID.setText(id);
        gameDescription.setText(description);
        this.cost.setText(CostFormatter.format(cost));
        this.consoleID.setText(consoleID);
        this.platform.setText(platform);
        loanedCheckbox.setSelected(isLoaned);
        repairedCheckbox.setSelected(beingRepaired);
        setRepairedCheckboxVisibility();
    }

    private void setRepairedCheckboxVisibility(){
        if(loanedCheckbox.isSelected()){
            repairedCheckbox.setVisible(false);
        }
    }
}
