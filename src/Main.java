import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;



public class Main extends Application  {
    public static void main(String[] args) throws Exception{
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("control/framecontroller/userLogin.fxml"));
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Page");
        primaryStage.show();
    }


}
