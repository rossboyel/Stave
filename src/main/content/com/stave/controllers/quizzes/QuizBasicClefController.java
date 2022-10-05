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
public class QuizBasicClefController {

     @FXML
     private Label correctAnswerCountLabel;

     @FXML
     private ToggleGroup tgClefFunction;

     @FXML
     private ToggleGroup tgTrebleLines;

     @FXML
     private ToggleGroup tgClef;

     @FXML
     private ToggleGroup tgBassLines;

     @FXML
     private ToggleGroup tgTrebleSpaces;

     @FXML
     private ToggleGroup tgAltoSpaces;

     @FXML
     private ToggleGroup tgClefRests;

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
        question.showNextQuestion(tgClef, "firstCorrectAnswer",
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
        question.showNextQuestion(tgClefFunction, "secondCorrectAnswer",
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
        question.showNextQuestion(tgTrebleLines, "thirdCorrectAnswer",
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
        question.showNextQuestion(tgBassLines, "fourthCorrectAnswer",
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
        question.showNextQuestion(tgTrebleSpaces,"fifthCorrectAnswer",
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
        question.showNextQuestion(tgAltoSpaces, "sixthCorrectAnswer",
                sixthPane, seventhPane, correctAnswerCountLabel);
     }

    /**
     * A method that implements a question in the quiz, takes the user's answer and compares it to the correct answer.
     * Transitions to the next question and updates the correct answer count.
     * @param event Usre clicks on a button
     */
    @FXML
    public void lastQuestion(MouseEvent event) throws SQLException {
        Question question = new Question();
        question.lastQuestion(tgClefRests, "seventhCorrectAnswer",
                    seventhEnterButton, finishButton, correctAnswerCountLabel);

        DatabaseQuery databaseQuery = new DatabaseQuery();
        databaseQuery.quizUpdate("BASIC_CLEFS");
     }

     /** Takes the user back to the home screen so that the appropriate circle object can be filled
     * @param event User clicking the button
     * @throws IOException
     */
    @FXML
    public void finishQuiz(MouseEvent event) throws IOException {
        UserFlow userFlow = new UserFlow();
        userFlow.sendHome(firstPane);
     }
}
