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
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;

/**
 * A Class that implements a lesson in the system.
 */
public class LessonBasicNoteController {

    @FXML
    private Text lessonTextMinim;

    @FXML
    private Text lessonTextQuaver;

    @FXML
    private Text lessonTextCrotchet;

    @FXML
    private Text lessonTextSemi;

    @FXML
    private Button lessonButtonMinim;

    @FXML
    private Button lessonButtonQuaver;

    @FXML
    private Button lessonButtonCrotchet;

    @FXML
    private Button lessonButtonSemi;

    @FXML
    private Pane lessonNotesPaneFinal;

    /**
     * A method that sets GUI components visible/invisible and transitions content.
     * @param event User clicks on button
     */
    @FXML
    private void setQuaverVisible(MouseEvent event) {
        lessonTextQuaver.setVisible(true);
        lessonButtonQuaver.setVisible(false);
        lessonButtonCrotchet.setVisible(true);
        FadeTransition transition = new FadeTransition(Duration.seconds(1), lessonTextQuaver);
        FadeTransition transitionTwo = new FadeTransition(Duration.seconds(2), lessonButtonCrotchet);
        transition.setFromValue(0.0);
        transition.setToValue(2.0);
        transitionTwo.setFromValue(0.0);
        transitionTwo.setToValue(2.0);
        transition.play();
        transitionTwo.play();
    }

    /**
     * A method that sets GUI components visible/invisible and transitions content.
     * @param event User clicks on button
     */
    @FXML
    private void setCrotchetVisible(MouseEvent event) {
        lessonButtonCrotchet.setVisible(false);
        lessonTextCrotchet.setVisible(true);
        lessonButtonMinim.setVisible(true);
        FadeTransition transition = new FadeTransition(Duration.seconds(1), lessonTextCrotchet);
        transition.setFromValue(0.0);
        transition.setToValue(2.0);
        transition.play();
    }

    /**
     * A method that sets GUI components visible/invisible and transitions content.
     * @param event User clicks on button
     */
    @FXML
    private void setMinimVisible(MouseEvent event) {
        lessonTextMinim.setVisible(true);
        lessonButtonMinim.setVisible(false);
        lessonButtonSemi.setVisible(true);
        FadeTransition transition = new FadeTransition(Duration.seconds(1), lessonTextMinim);
        transition.setFromValue(0.0);
        transition.setToValue(2.0);
        transition.play();
    }

    /**
     * A method that sets GUI components visible/invisible and transitions content.
     * @param event User clicks on button
     */
    @FXML
    private void setSemiVisible(MouseEvent event) throws SQLException {
        lessonTextSemi.setVisible(true);
        lessonButtonSemi.setVisible(false);
        lessonNotesPaneFinal.setVisible(true);
        FadeTransition transition = new FadeTransition(Duration.seconds(1), lessonTextSemi);
        transition.setFromValue(0.0);
        transition.setToValue(2.0);
        transition.play();

        DatabaseQuery databaseQuery = new DatabaseQuery();
        databaseQuery.lessonUpdate("BASIC_NOTES");
    }

    /**
     * Takes the user to the home page.
     * @param event Use clicks on button
     * @throws IOException
     */
    @FXML
    private void finish (MouseEvent event)  throws IOException {
        UserFlow userFlow = new UserFlow();
        userFlow.sendHome(lessonNotesPaneFinal);
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

    public void playHalfSound(MouseEvent event) {
        play("src/main/resources//Sounds/lessonNoteStab.wav");
    }


    public void playSemi() {
        play("src/main/resources//Sounds/semi-Note.wav");
    }

    public void playMinim() {
        play("src/main/resources//Sounds/minim-Note.wav");
    }

    public void playCrotchet() {
        play("src/main/resources//Sounds/crotchet-Note.wav");
    }
}
