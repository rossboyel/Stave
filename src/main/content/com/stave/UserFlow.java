package content.com.stave;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A class with a single method that handles how to move a user to the home screen after completing content on the
 * application.
 */
public class UserFlow {

    /**
     * A method to load the home fxml file and set it as the new scene.
     * @param referencePane A Pane object to get the current scene
     * @throws IOException
     */
    public void sendHome(Pane referencePane) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/stave/home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 650);
        Stage stage = (Stage) referencePane.getScene().getWindow();
        stage.setScene(scene);
    }
}
