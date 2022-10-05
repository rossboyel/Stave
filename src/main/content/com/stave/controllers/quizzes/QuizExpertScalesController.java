package content.com.stave.controllers.quizzes;

import content.com.stave.DatabaseQuery;
import content.com.stave.UserFlow;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.sql.SQLException;

/**
 * A Class that implements a quiz in the system.
 */
public class QuizExpertScalesController {

    @FXML
    private Pane referencePane;

    /**
     * Takes the user back to the home screen and updates progress.
     * @param event User clicks on the button
     * @throws SQLException
     * @throws IOException
     */
    @FXML
    public void finish(MouseEvent event) throws SQLException, IOException {
        DatabaseQuery databaseQuery = new DatabaseQuery();
        databaseQuery.quizUpdate("EXPERT_SCALES");
        UserFlow userFlow = new UserFlow();
        userFlow.sendHome(referencePane);

    }
}
