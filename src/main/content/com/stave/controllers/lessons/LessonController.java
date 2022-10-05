package content.com.stave.controllers.lessons;

import content.com.stave.User;
import content.com.stave.UserLessonProgress;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;

/**
 * A class that implements the main lesson page and shows users  which content that have unlocked and what content
 * they have completed. Handles changing scenes when a user clicks on the appropriate lesson button.
 */
public class LessonController {

    @FXML
    private BorderPane bpLesson;

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
    private VBox beginVBox;

    @FXML
    private VBox interVBox;

    @FXML
    private VBox expertVBox;

    public void initialize()  {
        checkUserLessonTaken();
        checkUserSkill();
    }


    /**
     * Takes the user to the relevant lesson by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void lessonBasicSymbol(MouseEvent event) {
        loadScreen("/com/stave/lessonBasicSymbol");
    }

    /**
     * Takes the user to the relevant lesson by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void lessonBasicNotes(MouseEvent event) {
        loadScreen("/com/stave/lessonBasicNotes");
    }

    /**
     * Takes the user to the relevant lesson by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void lessonBasicClef(MouseEvent event) {
        loadScreen("/com/stave/lessonBasicClef");
    }


    /**
     * Takes the user to the relevant lesson by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void lessonBasicRests(MouseEvent event) {
        loadScreen("/com/stave/lessonBasicRests");
    }

    /**
     * Takes the user to the relevant lesson by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void lessonBasicScales(MouseEvent event) {
        loadScreen("/com/stave/lessonBasicScales");
    }

    /**
     * Takes the user to the relevant lesson by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void lessonBasicTimeSignatures(MouseEvent event) {
        loadScreen("/com/stave/lessonBasicTimeSignatures");
    }

    /**
     * Takes the user to the relevant lessonby calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void lessonInterSymbol(MouseEvent event) {
        loadScreen("/com/stave/lessonInterSymbols");
    }

    /**
     * Takes the user to the relevant lesson by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void lessonInterClef(MouseEvent event) {
        loadScreen("/com/stave/lessonInterClefs");
    }

    /**
     * Takes the user to the relevant lesson by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private  void lessonInterNotes(MouseEvent event) {
        loadScreen("/com/stave/lessonInterNotes");
    }

    /**
     * Takes the user to the relevant lesson by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void lessonInterTimeSignatures(MouseEvent event) {
        loadScreen("/com/stave/lessonInterTimeSignatures");
    }

    /**
     * Takes the user to the relevant lesson by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void lessonInterScales(MouseEvent event) {
        loadScreen("/com/stave/lessonInterScales");
    }

    /**
     * Takes the user to the relevant lesson by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void lessonInterRests(MouseEvent event) {
        loadScreen("/com/stave/lessonInterRests");
    }

    /**
     * Takes the user to the relevant lesson by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void lessonExpertSymbol(MouseEvent event) {
        loadScreen("/com/stave/lessonExpertSymbols");
    }

    /**
     * Takes the user to the relevant lesson by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void lessonExpertClef(MouseEvent event) {
        loadScreen("/com/stave/lessonExpertClefs");
    }

    /**
     * Takes the user to the relevant lesson by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private  void lessonExpertNotes(MouseEvent event) {
        loadScreen("/com/stave/lessonExpertNotes");
    }

    /**
     * Takes the user to the relevant lesson by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void lessonExpertTimeSignatures(MouseEvent event) {
        loadScreen("/com/stave/lessonExpertTimeSignatures");
    }

    /**
     * Takes the user to the relevant lesson by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void lessonExpertScales(MouseEvent event) {
        loadScreen("/com/stave/lessonExpertScales");
    }

    /**
     * Takes the user to the relevant lesson by calling loadScreen, using the string as a parameter.
     * @param event User clicks on the button.
     */
    @FXML
    private void lessonExpertRests(MouseEvent event) {
        loadScreen("/com/stave/lessonExpertRests");
    }

    /**
     * A method that implements changing scene by taking a string parameter which represents an FXML file.
     * @param screen The string value of an FXML file
     */
    public void loadScreen(String screen) {
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource(screen + ".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bpLesson.setCenter(root);
    }

    /**
     * Shows the correct lesson content for the logged-in user.
     */
    public void checkUserSkill() {
        showVBoxes(beginVBox, interVBox, expertVBox);
    }

    /**
     * Turns the content VBoxes the appropriate colour and set them disabled if the user has not unlocked them yet.
     * @param beginVBox The beginner content VBox
     * @param interVBox The intermediate content VBox
     * @param expertVBox The expert content VBox
     */
    public static void showVBoxes(VBox beginVBox, VBox interVBox, VBox expertVBox) {

        String userSkillLevel = User.getLoggedUser().getSkillLevel();

        if (userSkillLevel.contains("beginner")) {
            beginVBox.setStyle("-fx-background-color: #117733");
            beginVBox.setDisable(false);
            interVBox.setStyle("-fx-background-color: #DDCC77");
            interVBox.setDisable(true);
            expertVBox.setStyle("-fx-background-color: #DDCC77");
            expertVBox.setDisable(true);
        }

        if (userSkillLevel.contains("inter")) {
            beginVBox.setStyle("-fx-background-color: #117733");
            beginVBox.setDisable(false);
            interVBox.setStyle("-fx-background-color: #117733");
            interVBox.setDisable(false);
            expertVBox.setStyle("-fx-background-color: #DDCC77");
            expertVBox.setDisable(true);
        }

        if (userSkillLevel.contains("expert")) {
            beginVBox.setStyle("-fx-background-color: #117733");
            beginVBox.setDisable(false);
            interVBox.setStyle("-fx-background-color: #117733");
            interVBox.setDisable(false);
            expertVBox.setStyle("-fx-background-color: #117733");
            expertVBox.setDisable(false);
        }
    }

    /**
     * Uses the circleFiller method to check which lessons a user has completed.
     */
    public void checkUserLessonTaken() {

        // Fill appropriate Circle objects if user is found to of completed the lesson

        circleFiller(basicSymbolCircle, UserLessonProgress.getLoggedUserLessonProgress().isBasicSymbolTaken());
        circleFiller(basicClefCircle, UserLessonProgress.getLoggedUserLessonProgress().isBasicClefsTaken());
        circleFiller(basicTimeSignaturesCircle,
                UserLessonProgress.getLoggedUserLessonProgress().isBasicTimeSignaturesTaken());
        circleFiller(basicNotesCircle, UserLessonProgress.getLoggedUserLessonProgress().isBasicNotesTaken());
        circleFiller(basicRestsCircle, UserLessonProgress.getLoggedUserLessonProgress().isBasicRestsTaken());
        circleFiller(basicScalesCircle, UserLessonProgress.getLoggedUserLessonProgress().isBasicScalesTaken());

        circleFiller(interSymbolCircle, UserLessonProgress.getLoggedUserLessonProgress().isInterSymbolTaken());
        circleFiller(interClefCircle, UserLessonProgress.getLoggedUserLessonProgress().isInterClefsTaken());
        circleFiller(interTimeSignaturesCircle,
                UserLessonProgress.getLoggedUserLessonProgress().isInterTimeSignaturesTaken());
        circleFiller(interNotesCircle, UserLessonProgress.getLoggedUserLessonProgress().isInterNotesTaken());
        circleFiller(interRestsCircle, UserLessonProgress.getLoggedUserLessonProgress().isInterRestsTaken());
        circleFiller(interScalesCircle, UserLessonProgress.getLoggedUserLessonProgress().isInterScalesTaken());

        circleFiller(expertSymbolCircle, UserLessonProgress.getLoggedUserLessonProgress().isExpertSymbolTaken());
        circleFiller(expertClefCircle, UserLessonProgress.getLoggedUserLessonProgress().isExpertClefsTaken());
        circleFiller(expertTimeSignaturesCircle,
                UserLessonProgress.getLoggedUserLessonProgress().isExpertTimeSignaturesTaken());
        circleFiller(expertNotesCircle, UserLessonProgress.getLoggedUserLessonProgress().isExpertNotesTaken());
        circleFiller(expertRestsCircle, UserLessonProgress.getLoggedUserLessonProgress().isExpertRestsTaken());
        circleFiller(expertScalesCircle, UserLessonProgress.getLoggedUserLessonProgress().isExpertScalesTaken());

    }

    /**
     * Checks whether a boolean is true/false and fills a circle if true.
     * @param circle the circle to be turned blue
     * @param lessonCheck the lesson being checked
     */
    public void circleFiller(Circle circle, boolean lessonCheck) {
        if(lessonCheck == true) {
            circle.setFill(Color.rgb(51,51,136));
        }
    }

}
