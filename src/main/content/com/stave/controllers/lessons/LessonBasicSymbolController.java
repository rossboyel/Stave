package content.com.stave.controllers.lessons;

import content.com.stave.DatabaseQuery;
import content.com.stave.UserFlow;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.SQLException;

/**
 * A Class that implements a lesson in the system.
 */
public class LessonBasicSymbolController {

    @FXML
    private Pane lessonPaneFace;

    @FXML
    private Pane lessonPaneSymbol;

    @FXML
    private Pane lessonPaneLine;

    @FXML
    private Pane lessonPaneFinal;

    /**
     * A method that sets GUI components visible/invisible and transitions content.
     * @param event User clicks on button
     */
    @FXML
    private void setFaceVisible(MouseEvent event) {
        lessonPaneFace.setVisible(true);
        FadeTransition transition = new FadeTransition(Duration.seconds(3), lessonPaneFace);
        transition.setFromValue(0.0);
        transition.setToValue(2.0);
        transition.play();
    }

    /**
     * A method that sets GUI components visible/invisible and transitions content.
     * @param event User clicks on button
     */
    @FXML
    private void setSymbolVisible(MouseEvent event) {
        lessonPaneSymbol.setVisible(true);
        FadeTransition transition = new FadeTransition(Duration.seconds(3), lessonPaneSymbol);
        transition.setFromValue(0.0);
        transition.setToValue(2.0);
        transition.play();
    }

    /**
     * A method that sets GUI components visible/invisible and transitions content.
     * @param event User clicks on button
     */
    @FXML
    private void setLinesVisible(MouseEvent event) {
        lessonPaneLine.setVisible(true);
        FadeTransition transition = new FadeTransition(Duration.seconds(3), lessonPaneLine);
        transition.setFromValue(0.0);
        transition.setToValue(2.0);
        transition.play();
    }

    /**
     * A method that sets GUI components visible/invisible and transitions content.
     * @param event User clicks on button
     */
    @FXML
    private void setLessonFinalVisible(MouseEvent event) throws SQLException, IOException {
        lessonPaneFinal.setVisible(true);

        DatabaseQuery databaseQuery = new DatabaseQuery();
        databaseQuery.lessonUpdate("BASIC_SYMBOLS");
    }

    /**
     * Takes the user to the home page.
     * @param event Use clicks on button
     * @throws IOException
     */
    @FXML
    public void finish (MouseEvent event)  throws IOException {
        UserFlow userFlow = new UserFlow();
        userFlow.sendHome(lessonPaneFinal);
    }

}
