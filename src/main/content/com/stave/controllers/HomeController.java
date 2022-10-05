package content.com.stave.controllers;

import content.com.stave.DatabaseQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import content.com.stave.User;
import java.io.IOException;
import java.sql.SQLException;

/**
 * A class that implements the home page of the application. Shows various information to the user and has buttons to
 * move the user around the application.
 */
public class HomeController {

    @FXML
    private BorderPane bpHome;

    @FXML
    private AnchorPane ap;

    @FXML
    private Label userLabel;

    @FXML
    private Label userLessonLabel;

    @FXML
    private Label userQuizLabel;

    @FXML
    private Label userHighScoreLabel;

    @FXML
    private Button homeButton;

    @FXML
    private Label userSkillLevelLabel;

    public void initialize() throws SQLException {
        userLabel.setText(User.getLoggedUser().getUsername());
        updateUserProgress();

    }

    /**
     * When clicked the user is taken to the home page. Also checks for any updated user information.
     * @param event User clicking on the button
     * @throws SQLException
     */
    @FXML
    public void home(MouseEvent event) throws SQLException {
        bpHome.setCenter(ap);
        updateUserProgress();
    }

    /**
     * When clicked the user is taken to the lesson page. Also checks for any updated user information.
     * @param event User clicking on the button
     * @throws SQLException
     */
    @FXML
    public void lesson(MouseEvent event) throws SQLException {
        loadScreen("/com/stave/lesson");
        updateUserProgress();
    }

    /**
     * When clicked the user is taken to the quiz page. Also checks for any updated user information.
     * @param event User clicking on the button
     * @throws SQLException
     */
    @FXML
    public void quiz(MouseEvent event) throws SQLException {
        loadScreen("/com/stave/quiz");
        updateUserProgress();

    }

    /**
     * When clicked the user is taken to the random note generator. Also checks for any updated user information.
     * @param event User clicking on the button
     * @throws SQLException
     */
    @FXML
    public void generator(MouseEvent event) throws SQLException {
        loadScreen("/com/stave/randomNoteGenerator");
        updateUserProgress();
    }

    /**
     * Takes an FXML string file and displays this as the new root FXML.
     * @param screen the fxml file as a string
     */
    private void loadScreen(String screen) {
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource(screen + ".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bpHome.setCenter(root);
    }


    /**
     * Closes the application.
     * @param event User clicking on the button
     */
    @FXML
    private void quitBoxAction(ActionEvent event) {
        Stage stage = (Stage) homeButton.getScene().getWindow();
        stage.close();
    }

    /**
     * A set of methods that will handle updating the user's progress on the home screen.
     *
     * @throws SQLException
     */
    private void updateUserProgress() throws SQLException {
        DatabaseQuery databaseQuery = new DatabaseQuery();
        databaseQuery.getUserLessons();
        databaseQuery.getUsersQuizzes();
        databaseQuery.updateUserSkill(User.getLoggedUser().getUserID());
        updateCompletedQuizzesCount();
        updateCompletedLessonsCount();
        getHighScore();
        getSkillLevel();
    }

    /**
     * Gets how many lessons the user has completed and displays this on the home screen.
     * @throws SQLException
     */
    private void updateCompletedQuizzesCount() throws SQLException {
        DatabaseQuery databaseQuery = new DatabaseQuery();
        int count = databaseQuery.getTotalQuizzesCompleted();
        userQuizLabel.setText(String.valueOf(count));
    }

    /**
     * Gets how many lessons the user has completed and displays this to the user on the home screen.
     * @throws SQLException
     */
    private void updateCompletedLessonsCount() throws SQLException {
        DatabaseQuery databaseQuery = new DatabaseQuery();
        int count = databaseQuery.getTotalLessonsCompleted();

        userLessonLabel.setText(String.valueOf(count));
    }

    /**
     * Gets the user's high score from the database and uses the return skill group to determine what information
     * to show the user on the home screen.
     * @throws SQLException
     */
    private void getHighScore() throws SQLException {
        DatabaseQuery databaseQuery = new DatabaseQuery();
        int highScore = databaseQuery.getHighScore();
        userHighScoreLabel.setText(String.valueOf(highScore));
    }

    /**
     * Gets the user's skill from the database and uses the return skill group to determine what information to show
     * the user on the home screen.
     * @throws SQLException
     */
    private void getSkillLevel() throws SQLException {
        DatabaseQuery databaseQuery = new DatabaseQuery();
        String skillGroup = databaseQuery.getSkillLevel();

        if (skillGroup.equals("beginner")) {
            userSkillLevelLabel.setText("Beginner");
        }

        if (skillGroup.equals("inter")) {
            userSkillLevelLabel.setText("Intermediate");
        }

        if (skillGroup.equals("expert")) {
            userSkillLevelLabel.setText("Expert");
        }
    }
}
