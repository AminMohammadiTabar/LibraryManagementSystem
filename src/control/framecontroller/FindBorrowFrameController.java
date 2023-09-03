package control.framecontroller;

import control.modelcontroller.BorrowController;
import control.modelcontroller.PersonController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.entity.Borrow;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class FindBorrowFrameController implements Initializable {
    @FXML
    Scene scene;
    @FXML
    private Stage stage;
    @FXML
    private Parent root;
    @FXML
    GridPane mainMenu;
    @FXML
    Button findBtn,clearBtn;
    @FXML
    TextField nameTxt,lastNameTxt,bookNameTxt,idTxt;
    @FXML
    TableView borrowTbl;
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
        borrowTbl.setOnMouseClicked(event -> {
            Borrow borrow = (Borrow) borrowTbl.getSelectionModel().getSelectedItem();
            nameTxt.setText(borrow.getName());
            lastNameTxt.setText(borrow.getLastName());
            bookNameTxt.setText(borrow.getBookName());
            idTxt.setText(String.valueOf(borrow.getId()));
        });
        findBtn.setOnAction(event -> {
            showData(nameTxt.getText(),lastNameTxt.getText(),bookNameTxt.getText());
        });
        clearBtn.setOnAction(event -> {
            clearText();
        });
    }
    private void clearText(){
        idTxt.clear();
        nameTxt.clear();
        lastNameTxt.clear();
        bookNameTxt.clear();
    }
    private void showData(String name,String lastName,String bookName){

        TableColumn<Borrow, Integer> idCol = new TableColumn<>("کد قرض");
        idCol.setCellValueFactory(new PropertyValueFactory<Borrow, Integer>("id"));

        TableColumn<Borrow, String> nameCol = new TableColumn<>("نام");
        nameCol.setCellValueFactory(new PropertyValueFactory<Borrow, String>("name"));

        TableColumn<Borrow, String> familyCol = new TableColumn<>("نام خانوادگی");
        familyCol.setCellValueFactory(new PropertyValueFactory<Borrow, String>("lastName"));

        TableColumn<Borrow, String> bookCol = new TableColumn<>("نام کتاب");
        bookCol.setCellValueFactory(new PropertyValueFactory<Borrow, String>("bookName"));

        TableColumn<Borrow, LocalDate> dateCol = new TableColumn<>("تاریخ قرض");
        dateCol.setCellValueFactory(new PropertyValueFactory<Borrow, LocalDate>("borrowDate"));

        TableColumn<Borrow, Boolean> validCol = new TableColumn<>("وضعیت اعتبار");
        validCol.setCellValueFactory(new PropertyValueFactory<Borrow, Boolean>("valid"));

        borrowTbl.getColumns().clear();
        ObservableList observableList;
        if(!name.isEmpty()){
            observableList= FXCollections.observableList(BorrowController.reportByName(name));
        }
        else if(!lastName.isEmpty()){
            observableList=FXCollections.observableList(BorrowController.reportByLastName(lastName));
        }
        else if(!bookName.isEmpty()){
            observableList=FXCollections.observableList(BorrowController.reportByBookName(bookName));
        }
        else{
            observableList=FXCollections.observableList(BorrowController.reportAll());
        }
        borrowTbl.getColumns().addAll(idCol,nameCol,familyCol,bookCol,dateCol,validCol);
        borrowTbl.setItems(observableList);
    }

}
