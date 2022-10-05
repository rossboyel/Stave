package content.com.stave.controllers.quizzes;

import content.com.stave.DatabaseQuery;
import content.com.stave.UserProgress;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import content.com.stave.User;
import content.com.stave.controllers.lessons.LessonController;
import java.io.IOException;
import java.sql.SQLException;

/**
 * A class that implements the main quiz page and shows users which content that have unlocked and what content
 * they have completed. Handles changing scenes when a user clicks on the appropriate quiz button.
 */
public class QuizController {

    @FXML
    private Circle basicSymbolCircle;

    @FXML
    private Circle basicClefCircle;

    @FXML
    private Circle basicTimeSignaturesCircle;

    @FXML
    private Circle basicNotesCircle;

    @FXML
    private Circle basicRestsCircle;

    @FXML
    private Circle basicScalesCircle;

    @FXML
    private Circle interSymbolCircle;

    @FXML
    private Circle interClefCircle;

    @FXML
    private Circle interTimeSignaturesCircle;

    @FXML
    private Circle interNotesCircle;

    @FXML
    private Circle interRestsCircle;

    @FXML
    private Circle interScalesCircle;

    @FXML
    private Circle expertSymbolCircle;

    @FXML
    private Circle expertClefCircle;

    @FXML
    private Circle expertTimeSignaturesCircle;

    @FXML
    private Circle expertNotesCircle;

    @FXML
    private Circle expertRestsCircle;

    @FXML
    private Circle expertScalesCircle;

    @FXML
    private BorderPane bpQuiz;

    @FXML
    private VBox beginVBox;

    @FXML
    private VBox interVBox;

    @FXML
    private VBox expertVBox;


    public void initialize() throws SQLException {
        checkUserSkill();
        checkUserQuizTaken();
        DatabaseQuery databaseQuery = new DatabaseQuery();
        databaseQuery.updateUserSkill(User.getLoggedUser().getUserID());
    }

    /**
     * Takes the user to the relevant quiz by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void quizBasicSymbol(MouseEvent event) {
        loadScreen("/com/stave/quizBasicSymbol");
    }

    /**
     * Takes the user to the relevant quiz by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void quizBasicClef(MouseEvent event) {
        loadScreen("/com/stave/quizBasicClef");
    }

    /**
     * Takes the user to the relevant quiz by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private  void quizBasicNotes(MouseEvent event) {
        loadScreen("/com/stave/quizBasicNotes");
    }

    /**
     * Takes the user to the relevant quiz by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void quizBasicTimeSignatures(MouseEvent event) {
        loadScreen("/com/stave/quizBasicTimeSignatures");
    }

    /**
     * Takes the user to the relevant quiz by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void quizBasicScales(MouseEvent event) {
        loadScreen("/com/stave/quizBasicScales");
    }

    /**
     * Takes the user to the relevant quiz by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void quizBasicRests(MouseEvent event) {
        loadScreen("/com/stave/quizBasicRests");
    }

    /**
     * Takes the user to the relevant quiz by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void quizInterSymbol(MouseEvent event) {
        loadScreen("/com/stave/quizInterSymbols");
    }

    /**
     * Takes the user to the relevant quiz by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void quizInterClef(MouseEvent event) {
        loadScreen("/com/stave/quizInterClefs");
    }

    /**
     * Takes the user to the relevant quiz by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private  void quizInterNotes(MouseEvent event) {
        loadScreen("/com/stave/quizInterNotes");
    }

    /**
     * Takes the user to the relevant quiz by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void quizInterTimeSignatures(MouseEvent event) {
        loadScreen("/com/stave/quizInterTimeSignatures");
    }

    /**
     * Takes the user to the relevant quiz by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void quizInterScales(MouseEvent event) {
        loadScreen("/com/stave/quizInterScales");
    }

    /**
     * Takes the user to the relevant quiz by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void quizInterRests(MouseEvent event) {
        loadScreen("/com/stave/quizInterRests");
    }

    /**
     * Takes the user to the relevant quiz by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void quizExpertSymbol(MouseEvent event) {
        loadScreen("/com/stave/quizExpertSymbols");
    }

    /**
     * Takes the user to the relevant quiz by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void quizExpertClef(MouseEvent event) {
        loadScreen("/com/stave/quizExpertClefs");
    }

    /**
     * Takes the user to the relevant quiz by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private  void quizExpertNotes(MouseEvent event) {
        loadScreen("/com/stave/quizExpertNotes");
    }

    /**
     * Takes the user to the relevant quiz by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void quizExpertTimeSignatures(MouseEvent event) {
        loadScreen("/com/stave/quizExpertTimeSignatures");
    }

    /**
     * Takes the user to the relevant quiz by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void quizExpertScales(MouseEvent event) {
        loadScreen("/com/stave/quizExpertScales");
    }

    /**
     * Takes the user to the relevant quiz by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void quizExpertRests(MouseEvent event) {
        loadScreen("/com/stave/quizExpertRests");
    }

    /**
     * Takes a string parameter which represents an FXML file and sets it as the current root.
     * @param screen The String value of the FXML value
     */
    public void loadScreen(String screen) {
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource(screen + ".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bpQuiz.setCenter(root);
    }

    /**
     * Checks user's skill level and displays appropriate content relevant to the level.
     */
    private void checkUserSkill() {
        LessonController.showVBoxes(beginVBox, interVBox, expertVBox);
    }

    /**
     * This method checks to see what quizzes the user has taken and will update the visual marker
     * if it reads any quizzes have been completed.
     */
    private void checkUserQuizTaken() {

        // Fill appropriate Circle objects if user is found to of completed the quiz

        circleFiller(basicSymbolCircle, UserProgress.getLoggedUserProgress().isBasicSymbolTaken());
        circleFiller(basicClefCircle, UserProgress.getLoggedUserProgress().isBasicClefsTaken());
        circleFiller(basicTimeSignaturesCircle, UserProgress.getLoggedUserProgress().isBasicTimeSignaturesTaken());
        circleFiller(basicNotesCircle, UserProgress.getLoggedUserProgress().isBasicNotesTaken());
        circleFiller(basicRestsCircle, UserProgress.getLoggedUserProgress().isBasicRestsTaken());
        circleFiller(basicScalesCircle, UserProgress.getLoggedUserProgress().isBasicScalesTaken());

        circleFiller(interSymbolCircle, UserProgress.getLoggedUserProgress().isInterSymbolTaken());
        circleFiller(interClefCircle, UserProgress.getLoggedUserProgress().isInterClefsTaken());
        circleFiller(interTimeSignaturesCircle, UserProgress.getLoggedUserProgress().isInterTimeSignaturesTaken());
        circleFiller(interNotesCircle, UserProgress.getLoggedUserProgress().isInterNotesTaken());
        circleFiller(interRestsCircle, UserProgress.getLoggedUserProgress().isInterRestsTaken());
        circleFiller(interScalesCircle, UserProgress.getLoggedUserProgress().isInterScalesTaken());

        circleFiller(expertSymbolCircle, UserProgress.getLoggedUserProgress().isExpertSymbolTaken());
        circleFiller(expertClefCircle, UserProgress.getLoggedUserProgress().isExpertClefsTaken());
        circleFiller(expertTimeSignaturesCircle, UserProgress.getLoggedUserProgress().isExpertTimeSignaturesTaken());
        circleFiller(expertNotesCircle, UserProgress.getLoggedUserProgress().isExpertNotesTaken());
        circleFiller(expertRestsCircle, UserProgress.getLoggedUserProgress().isExpertRestsTaken());
        circleFiller(expertScalesCircle, UserProgress.getLoggedUserProgress().isExpertScalesTaken());

    }

    /**
     * A method to check if the user has completed the quiz and update the appropiate circle within the GUI.
     * @param circle the circle to fill if quiz is completed
     * @param quizCheck boolean value representing whether quiz has been completed
     */
    private void circleFiller(Circle circle, boolean quizCheck) {
        if(quizCheck == true) {
            circle.setFill(Color.rgb(51,51,136));
        }
    }

}
