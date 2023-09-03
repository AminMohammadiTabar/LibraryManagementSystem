package control.framecontroller;

import control.modelcontroller.BorrowController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InvalidateBorrowframeController implements Initializable {
    @FXML
    Scene scene;
    @FXML
    private Stage stage;
    @FXML
    private Parent root;
    @FXML
    GridPane mainMenu;
    @FXML
    TextField idTxt;
    @FXML
    DatePicker borrowDatePicker;
    @FXML
    Button invalidateBtn,clearBtn;
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
        invalidateBtn.setOnAction(event -> {
            if (!idTxt.getText().isEmpty()) {
                String name = BorrowController.getPersonName(Integer.parseInt(idTxt.getText()));
                String book= BorrowController.getBookName(Integer.parseInt(idTxt.getText()));
                if (!name.isEmpty()) {
                    String message="Are you sure to recieve "+name+"'s "+book+" back?";
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, message);
                    alert.show();
                    BorrowController.invalidate(Integer.parseInt(idTxt.getText()));
                    claerText();
                }
                else{
                    String message="Inavalid ID! ";
                    Alert alert = new Alert(Alert.AlertType.ERROR, message);
                    alert.show();
                    claerText();
                }
            }
            else {
                String message="Enter an ID first! ";
                Alert alert = new Alert(Alert.AlertType.ERROR, message);
                alert.show();
                claerText();
            }
        });

    }
    private void claerText(){
        idTxt.clear();
    }
}
