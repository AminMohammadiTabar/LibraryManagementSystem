package control.framecontroller;

import control.modelcontroller.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserLoginFrameController implements Initializable {
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;
    @FXML
    private Parent root;
    @FXML
    GridPane mainMenu;
    @FXML
    Button loginBtn,clearBtn;
    @FXML
    TextField usernameTxt,passwordTxt;

    public void jumpToMainMenu(ActionEvent actionEvent)throws IOException {
        if (UserController.isUserActive(usernameTxt.getText(),passwordTxt.getText())){
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("mainMenu.fxml"));
            root=loader.load();
            scene=new Scene(root);
            stage =(Stage) mainMenu.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Welcome to Main Menu!");
            stage.show();
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Successful!");
            alert.show();
        }
        else{
            Alert alert=new Alert(Alert.AlertType.ERROR,"Wrong Username Or Password");
            alert.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clearBtn.setOnAction(event -> {
            clearText();
        });
    }
    public void clearText(){
        usernameTxt.clear();
        passwordTxt.clear();
    }
}
