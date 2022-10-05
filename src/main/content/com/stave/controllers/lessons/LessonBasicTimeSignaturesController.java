package content.com.stave.controllers.lessons;

import content.com.stave.DatabaseQuery;
import content.com.stave.UserFlow;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;

/**
 * A Class that implements a lesson in the system.
 */
public class LessonBasicTimeSignaturesController {

    @FXML
    private Button threeFourButton;

    @FXML
    private Button twoFourButton;

    @FXML
    private Pane lessonPaneThreeFour;

    @FXML
    private Pane lessonPaneTwoFour;

    @FXML
    private Button finalButton;

    @FXML
    private Pane lessonPaneFinal;

    /**
     * A method that sets GUI components visible/invisible and transitions content.
     * @param event User clicks on button
     */
    @FXML
    private void setThreeFourVisible(MouseEvent event) {
        lessonPaneThreeFour.setVisible(true);
        threeFourButton.setVisible(false);
        FadeTransition transition = new FadeTransition(Duration.seconds(3), lessonPaneThreeFour);
        transition.setFromValue(0.0);
        transition.setToValue(2.0);
        transition.play();
        }

    /**
     * A method that sets GUI components visible/invisible and transitions content.
     * @param event User clicks on button
     */
    @FXML
    private void setTwoFourVisible(MouseEvent event) {
    lessonPaneTwoFour.setVisible(true);
    twoFourButton.setVisible(false);
    FadeTransition transition = new FadeTransition(Duration.seconds(3), lessonPaneTwoFour);
    transition.setFromValue(0.0);
    transition.setToValue(2.0);
    transition.play();
    }

    /**
     * A method that sets GUI components visible/invisible and transitions content.
     * @param event User clicks on button
     */
    @FXML
    private void setFinalPaneVisible(MouseEvent event) throws SQLException, IOException {
        lessonPaneFinal.setVisible(true);
        finalButton.setVisible(false);
        DatabaseQuery databaseQuery = new DatabaseQuery();
        databaseQuery.lessonUpdate("BASIC_TIME_SIGNATURES");
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

    /**
     * Creates a MediaPlayer object that will play whatever audio file is given to it
     * via the String parameter.
     * @param path The location of the audio file.
     */
    @FXML
    public void play(String path) {
        Media m = new Media(Paths.get(path).toUri().toString());
        MediaPlayer player = new MediaPlayer(m);
        player.play();
    }

    @FXML
    private void playFourFourSound(MouseEvent event) {
        play("src/main/resources/Sounds/four-Four.wav");
    }

    @FXML
    private void playThreeFourSound(MouseEvent event) {
        play("src/main/resources//Sounds/three-Four.wav");
    }

    @FXML
    private void playTwoFourSound(MouseEvent event) {
        play("src/main/resources//Sounds/two-Four.wav");
    }
}
