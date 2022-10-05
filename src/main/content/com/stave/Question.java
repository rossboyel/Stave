package content.com.stave;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

/**
 * A class that handles the login for changing the question within quizzes and how to implement the end of a quiz.
 */
public class Question {

    public Question() {
    }

    /**
     * Takes the user's answer from the ToggleGroup object and updates the corresponding label tracking correct
     * answers. Sets the next pane visible which contains the next question and the previous question's pane invisible.
     * @param answer
     * @param first
     * @param second
     */
    public void showNextQuestion(ToggleGroup tg, String answer, Pane first, Pane second, Label correctCountLabel) {
        if (tg.selectedToggleProperty().toString().contains(answer)) {
            Integer correctAnswerCount = Integer.parseInt(correctCountLabel.getText());

            correctAnswerCount = correctAnswerCount + 1;
            correctCountLabel.setText(correctAnswerCount.toString());
        } else {
        }
        first.setVisible(false);
        second.setVisible(true);

    }

    /**
     * This method handles the last question of a quiz, it checks if the answer is correct and then shows the finish
     * button that will take the user back to the main screen.
     * @param tg the toggle group that the answers belong to
     * @param answer the correct answer within the togglegroup
     * @param lastEnterButton last enter button in for the quiz
     * @param finishButton takes the user back to main screen
     * @param correctCountLabel label that is tracking correct answers
     */
    public void lastQuestion(ToggleGroup tg, String answer,Button lastEnterButton,
                             Button finishButton, Label correctCountLabel) {

        lastEnterButton.setVisible(false);

        if (tg.selectedToggleProperty().toString().contains(answer)) {
            Integer correctAnswerCount = Integer.parseInt(correctCountLabel.getText());

            correctAnswerCount = correctAnswerCount + 1;
            correctCountLabel.setText(correctAnswerCount.toString());
        } else {
            System.out.println("Incorrect Answer");
        }

        finishButton.setVisible(true);

        }

    }
