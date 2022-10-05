package content.com.stave.controllers.quizzes;

import content.com.stave.DatabaseQuery;
import content.com.stave.Question;
import content.com.stave.UserFlow;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.sql.SQLException;

/**
 * A Class that implements a quiz in the system.
 */
public class QuizBasicSymbolController {

    @FXML
    private Label correctAnswerCountLabel;

    @FXML
    private ToggleGroup tgStaff;

    @FXML
    private ToggleGroup tgSymbol;

    @FXML
    private ToggleGroup tgClef;

    @FXML
    private ToggleGroup tgRest;

    @FXML
    private ToggleGroup tgNote;

    @FXML
    private ToggleGroup tgRestValue;

    @FXML
    private ToggleGroup tgLineNotes;

    @FXML
    private Pane firstPane;

    @FXML
    private Pane secondPane;

    @FXML
    private Pane thirdPane;

    @FXML
    private Pane fourthPane;

    @FXML
    private Pane fifthPane;

    @FXML
    private Pane sixthPane;

    @FXML
    private Pane seventhPane;

    @FXML
    private Button seventhEnterButton;

    @FXML
    private Button finishButton;

    /**
     * A method that implements a question in the quiz, takes the user's answer and compares it to the correct answer.
     * Transitions to the next question and updates the correct answer count.
     * @param event Usre clicks on a button
     */
    @FXML
    public void firstQuestion(MouseEvent event) {
        Question question = new Question();
        question.showNextQuestion(tgStaff, "firstCorrectAnswer",
                firstPane, secondPane, correctAnswerCountLabel);


    }

    /**
     * A method that implements a question in the quiz, takes the user's answer and compares it to the correct answer.
     * Transitions to the next question and updates the correct answer count.
     * @param event Usre clicks on a button
     */
    @FXML
    public void secondQuestion(MouseEvent event) {

        Question question = new Question();
                question.showNextQuestion(tgSymbol, "secondCorrectAnswer",
                        secondPane, thirdPane, correctAnswerCountLabel);
    }

    /**
     * A method that implements a question in the quiz, takes the user's answer and compares it to the correct answer.
     * Transitions to the next question and updates the correct answer count.
     * @param event Usre clicks on a button
     */
    @FXML
    public void thirdQuestion(MouseEvent event) {

        Question question = new Question();
        question.showNextQuestion(tgRest, "thirdCorrectAnswer",
                thirdPane, fourthPane, correctAnswerCountLabel);
    }

    /**
     * A method that implements a question in the quiz, takes the user's answer and compares it to the correct answer.
     * Transitions to the next question and updates the correct answer count.
     * @param event Usre clicks on a button
     */
    @FXML
    public void fourthQuestion(MouseEvent event) {

        Question question = new Question();
        question.showNextQuestion(tgNote, "fourthCorrectAnswer",
                fourthPane, fifthPane, correctAnswerCountLabel);
    }

    /**
     * A method that implements a question in the quiz, takes the user's answer and compares it to the correct answer.
     * Transitions to the next question and updates the correct answer count.
     * @param event Usre clicks on a button
     */
    @FXML
    public void fifthQuestion(MouseEvent event) {

        Question question = new Question();
        question.showNextQuestion(tgClef,"fifthCorrectAnswer",
                fifthPane, sixthPane, correctAnswerCountLabel);
    }

    /**
     * A method that implements a question in the quiz, takes the user's answer and compares it to the correct answer.
     * Transitions to the next question and updates the correct answer count.
     * @param event Usre clicks on a button
     */
    @FXML
    public void sixthQuestion(MouseEvent event) {

        Question question = new Question();
        question.showNextQuestion(tgRestValue, "sixthCorrectAnswer",
                sixthPane, seventhPane, correctAnswerCountLabel);
    }

    /**
     * Handles the last question of the quiz, if the user has scored 6 or above then the database will update to show
     * they have completed the content.
     * @param event User clicking the button
     * @throws SQLException
     */
    @FXML
    public void lastQuestion(MouseEvent event) throws SQLException {

        Question question = new Question();
        question.lastQuestion(tgLineNotes, "seventhCorrectAnswer",
                seventhEnterButton, finishButton, correctAnswerCountLabel);

        if (correctAnswerCountLabel.getText().equals("7") || correctAnswerCountLabel.getText().equals("6")) {
            DatabaseQuery databaseQuery = new DatabaseQuery();
            databaseQuery.quizUpdate("BASIC_SYMBOLS");
        }
    }

    /**
     * Takes the user back to the home screen so that the appropriate circle object can be filled
     * @param event User clicking the button
     * @throws IOException
     */
    @FXML
    public void finishQuiz(MouseEvent event) throws IOException {

        UserFlow userFlow = new UserFlow();
        userFlow.sendHome(firstPane);
    }

}
