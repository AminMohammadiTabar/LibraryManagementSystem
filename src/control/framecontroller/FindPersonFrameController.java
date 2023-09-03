package control.framecontroller;

import control.modelcontroller.PersonController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.entity.Person;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class FindPersonFrameController implements Initializable {
    @FXML
    Scene scene;
    @FXML
    private Stage stage;
    @FXML
    private Parent root;
    @FXML
    GridPane mainMenu;
    @FXML
    TextField nameTxt,lastNameTxt,idTxt,membershipStartTxt;
    @FXML
    Button findBtn,clearBtn;
    @FXML
    TableView personTbl;
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
        personTbl.setOnMouseClicked(event -> {
            Person person = (Person) personTbl.getSelectionModel().getSelectedItem();
            idTxt.setText(String.valueOf(person.getId()));
            nameTxt.setText(person.getName());
            lastNameTxt.setText(person.getLastName());
            membershipStartTxt.setText(person.getMembershipStart().toString());
        });
        findBtn.setOnAction(event -> {
            showData(nameTxt.getText(),lastNameTxt.getText());
        });
        clearBtn.setOnAction(event -> {
            clearText();
        });
    }
    private void showData(String name,String lastName) {

        TableColumn<Person, Integer> idCol = new TableColumn<>("کد عضویت");
        idCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));

        TableColumn<Person, String> nameCol = new TableColumn<>("نام");
        nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));

        TableColumn<Person, String> familyCol = new TableColumn<>("نام خانوادگی");
        familyCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));

        TableColumn<Person, LocalDate> dateCol = new TableColumn<>("تاریخ عضویت");
        dateCol.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("membershipStart"));

        personTbl.getColumns().clear();
        ObservableList observableList;
        if(!name.isEmpty()){
            observableList=FXCollections.observableList(PersonController.findByName(name));
        }
        else if(!lastName.isEmpty()){
            observableList=FXCollections.observableList(PersonController.findByLastname(lastName));
        }
        else{
            observableList=FXCollections.observableList(PersonController.findAll());
        }
        personTbl.getColumns().addAll(idCol, nameCol, familyCol,dateCol);
        personTbl.setItems(observableList);
    }
    private void clearText(){
        nameTxt.clear();
        lastNameTxt.clear();
        idTxt.clear();
        membershipStartTxt.clear();
    }
}
