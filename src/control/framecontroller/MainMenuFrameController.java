package control.framecontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuFrameController implements Initializable{

    @FXML
    MenuItem addPersonMnuItm,editPersonMnuItm,removePersonMnuItm,findPersonMnuItm;
    @FXML
    MenuItem addBookMnuItm,editBookMnuItm,removeBookMnuItm,findBookMnuItm;
    @FXML
    MenuItem addBorrowMnuItm,inavalidateBorrowMnuItm,reportBorrowMnuItm;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;
    @FXML
    private Parent root;
    @FXML
    GridPane mainMenu;

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

    }
}
