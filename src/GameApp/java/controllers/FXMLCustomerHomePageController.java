package GameApp.java.controllers;

import GameApp.java.general.AlertMessage;
import GameApp.java.models.adaptors.ConsoleViewAdapter;
import GameApp.java.routers.RouteNames;
import GameApp.java.routers.Router;
import GameApp.java.services.ConsoleService;
import GameApp.java.services.GameService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLCustomerHomePageController implements Initializable{
    private Router router = new Router();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gamesByConsoleCheckbox.setSelected(true);
        populateAvailableConsoles();
        consolesOutput.getSelectionModel().selectFirst();
        showAvailableGames();
    }
    @FXML
    ListView consolesOutput;
    @FXML
    ListView gamesOutput;
    @FXML
    CheckBox gamesByConsoleCheckbox;
    @FXML
    private void handleSelectConsoleMouseClickAction(MouseEvent event){//method for available console depending on what console is selected
        showAvailableGames();
    }
    @FXML
    private void handleColleagueSignInAction(ActionEvent event) throws IOException{//method for changing routes to the colleague sign in page
        router.changeRoute(RouteNames.COLLEAGUE_SIGN_IN, event);
    }
    @FXML
    private void handleGamesByConsoleCheckboxAction(ActionEvent event){
        showAvailableGames();
    }

    private void populateAvailableConsoles() {//method for displaying available consoles in the console listview
        ObservableList consoles;
        consoles = FXCollections.observableArrayList(ConsoleService.availableConsoles());
        consolesOutput.setItems(consoles);
    }

    private void showAvailableGames(){
        if(gamesByConsoleCheckbox.isSelected()){
            ObservableList availableGamesByPlatform;
            try{
                availableGamesByPlatform = FXCollections.observableArrayList(GameService.getAvailableGamesByConsole(ConsoleService.getConsoleByID(ConsoleViewAdapter.getID(consolesOutput))));
                gamesOutput.setItems(availableGamesByPlatform);
            }
            catch(Exception e){//exception should never be seen, here for completeness
                AlertMessage.showMessage(Alert.AlertType.INFORMATION, e.getMessage());
            }
        }
        else{
            ObservableList games;
            games = FXCollections.observableArrayList(GameService.availableGames());
            gamesOutput.setItems(games);
        }

    }
}
