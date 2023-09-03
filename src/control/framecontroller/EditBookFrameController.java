package control.framecontroller;

import control.modelcontroller.BookController;
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

public class EditBookFrameController implements Initializable {
    @FXML
    Scene scene;
    @FXML
    private Stage stage;
    @FXML
    private Parent root;
    @FXML
    GridPane mainMenu;
    @FXML
    Button editBtn,clearBtn;
    @FXML
    TextField nameTxt,authortxt,idTxt;
    public void jumpToAddPerson(ActionEvent actionEvent)throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("addPerson.fxml"));
        root=loader.load();
        scene=new Scene(root);
        stage =(Stage) mainMenu.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Sign New Members");
    }
    public void jumpToEditPerson(ActionEvent actionEvent)throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("editPerson.fxml"));
        root=loader.load();
        scene=new Scene(root);
        stage =(Stage) mainMenu.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Edit Members");
    }
    public void jumpToFindPerson(ActionEvent actionEvent)throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("findPerson.fxml"));
        root=loader.load();
        scene=new Scene(root);
        stage =(Stage) mainMenu.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Reports");
        stage.show();
    }
    public void jumpToRemovePerson(ActionEvent actionEvent)throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("removePerson.fxml"));
        root=loader.load();
        scene=new Scene(root);
        stage =(Stage) mainMenu.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Remove Member");
        stage.show();
    }
    public void jumpToAddBook(ActionEvent actionEvent)throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("addBook.fxml"));
        root=loader.load();
        scene=new Scene(root);
        stage =(Stage) mainMenu.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Add New Books");
        stage.show();
    }
    public void jumpToEditBook(ActionEvent actionEvent)throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("editBook.fxml"));
        root=loader.load();
        scene=new Scene(root);
        stage =(Stage) mainMenu.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Edit Books");
        stage.show();
    }
    public void jumpToFindBook(ActionEvent actionEvent)throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("findBook.fxml"));
        root=loader.load();
        scene=new Scene(root);
        stage =(Stage) mainMenu.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Reports");
        stage.show();
    }
    public void jumpToRemoveBook(ActionEvent actionEvent)throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("removeBook.fxml"));
        root=loader.load();
        scene=new Scene(root);
        stage =(Stage) mainMenu.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Remove Books");
        stage.show();
    }
    public void jumpToAddBorrow(ActionEvent actionEvent)throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("addBorrow.fxml"));
        root=loader.load();
        scene=new Scene(root);
        stage =(Stage) mainMenu.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Lend Books");
        stage.show();
    }
    public void jumpToEditBorrow(ActionEvent actionEvent)throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("editBorrow.fxml"));
        root=loader.load();
        scene=new Scene(root);
        stage =(Stage) mainMenu.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Edit Lending");
        stage.show();
    }
    public void jumpToFindBorrow(ActionEvent actionEvent)throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("findBorrow.fxml"));
        root=loader.load();
        scene=new Scene(root);
        stage =(Stage) mainMenu.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Reports");
        stage.show();
    }
    public void jumpToInvalidateBorrow(ActionEvent actionEvent)throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("invalidateBorrow.fxml"));
        root=loader.load();
        scene=new Scene(root);
        stage =(Stage) mainMenu.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Recieve Books");
        stage.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        editBtn.setOnAction(event -> {
            if(!nameTxt.getText().isEmpty()&&!authortxt.getText().isEmpty()&&!idTxt.getText().isEmpty()){
                if(!BookController.findById(Integer.parseInt(idTxt.getText())).toString().isEmpty()){
                    Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Do really want to change "
                    +BookController.findById(Integer.parseInt(idTxt.getText())).toString()+" to \n"
                    +"name: "+nameTxt.getText()
                            +"author: "+authortxt.getText()+" ?");
                    alert.show();
                    BookController.edit(Integer.parseInt(idTxt.getText()),nameTxt.getText(),authortxt.getText());
                    clearText();
                }
                else{
                    Alert alert=new Alert(Alert.AlertType.ERROR,"Wrong Entries!");
                    alert.show();
                }
            }
            else {
                Alert alert=new Alert(Alert.AlertType.ERROR,"Fill all the fields.");
                alert.show();
            }
        });
        clearBtn.setOnAction(event -> {
            clearText();
        });
    }
    private void clearText(){
        nameTxt.clear();
        authortxt.clear();
        idTxt.clear();
    }
}
