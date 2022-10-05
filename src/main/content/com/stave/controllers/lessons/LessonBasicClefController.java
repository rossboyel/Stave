package content.com.stave.controllers.lessons;

import content.com.stave.DatabaseQuery;
import content.com.stave.UserFlow;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.SQLException;

/**
 * A Class that implements a lesson in the system.
 */
public class LessonBasicClefController {

    @FXML
    private Button bassClefButton;

    @FXML
    private Button combinedClefButton;

    @FXML
    private Pane lessonBassClefPane;

    @FXML
    private Pane lessonCombinedClefPane;

    @FXML
    private Pane lessonPaneFinal;

    /**
     * A method that sets GUI components visible/invisible and transitions content.
     * @param event User clicks on button
     */
    @FXML
    private void setBassClefPaneVisible(MouseEvent event) {
        lessonBassClefPane.setVisible(true);
        bassClefButton.setVisible(false);
    }

    /**
     * A method that sets GUI components visible/invisible and transitions content.
     * @param event User clicks on button
     */
    @FXML
    private void setCombinedClefPaneVisible(MouseEvent event) throws SQLException {
        combinedClefButton.setVisible(false);
        lessonCombinedClefPane.setVisible(true);
        lessonPaneFinal.setVisible(true);
        FadeTransition transition = new FadeTransition(Duration.seconds(3), lessonPaneFinal);
        transition.setFromValue(0.0);
        transition.setToValue(4.0);
        transition.play();

        DatabaseQuery databaseQuery = new DatabaseQuery();
        databaseQuery.lessonUpdate("BASIC_CLEFS");

        }

    /**
     * Takes the user to the home page.
     * @param event Use clicks on button
     * @throws IOException
     */
    @FXML
    public void finish(MouseEvent event)  throws IOException {
        UserFlow userFlow = new UserFlow();
        userFlow.sendHome(lessonPaneFinal);
    }

}
