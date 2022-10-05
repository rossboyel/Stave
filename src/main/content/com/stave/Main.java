package content.com.stave;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Main method for launching the application.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/stave/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 650);
        stage.setTitle("Stave");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNIFIED);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}

