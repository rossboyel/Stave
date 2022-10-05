package content.com.stave.controllers;

import content.com.stave.DatabaseQuery;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import content.com.stave.Note;
import content.com.stave.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 * A class that implements a mini-game by taking user input and comparing the input to generated Note objects.
 */
public class RandomNoteGeneratorController {

    private int intCount;

    private Note setRandomNote;

    @FXML
    private ImageView notesImage;

    @FXML
    private TextField noteNameTextField;

    @FXML
    private Slider noteValueSlider;

    @FXML
    private Label answerLabel;

    @FXML
    private Label streakCount;

    @FXML
    private Button enterAnswerButton;

    @FXML
    private Button generateButton;

    /**
     * Take the user's answer to the random note and check against the note object to see if it is correct. If the
     * user's streak is above their high score, update the user's recorded high score.
     * @param event Mouse click on button
     * @throws SQLException
     */
    @FXML
    private void checkAnswer(MouseEvent event)  throws SQLException {
        generateButton.setVisible(true);
        answerLabel.setTextFill(Color.rgb(17, 119, 51));

        if (noteNameTextField.getText().toUpperCase().equals(setRandomNote.getName())
                && noteValueSlider.getValue() == setRandomNote.getValue()) { // if values entered are correct
            answerLabel.setText("Correct!");
            System.out.println("Correct");

            intCount = intCount + 1; //increase streak by 1


            String streak =  String.valueOf(intCount);
            System.out.println(streak);
            streakCount.setText(streak);  // show user their streak score

            System.out.println(User.getLoggedUser().getHighScore());

            if(User.getLoggedUser().getHighScore() < intCount) {  // if user's streak is higher than their high score
                DatabaseQuery databaseQuery = new DatabaseQuery();
                databaseQuery.updateHighScore(intCount); //update high score
                User.getLoggedUser().setHighScore(intCount);
            }
            enterAnswerButton.setVisible(false);

        } else if (!noteNameTextField.getText().toUpperCase().equals(setRandomNote.getName())
                || noteValueSlider.getValue() != setRandomNote.getValue()){  // if values entered are incorrect
            answerLabel.setText("Incorrect, try again.");
            System.out.println("Incorrect");
            answerLabel.setTextFill(Color.rgb(51, 51, 136));
            streakCount.setText("0");  // reset streak counter
            intCount = 0;
            }
        }



    /**
     * Chooses a random note from the ArrayList containing note objects and assign its data to the randomNote object.
     * @throws IOException
     */
    @FXML
    private void chooseImage() {
        Note note = new Note();
        note.noteGenerator(); //initialise note objects into list
        ArrayList<Note> notes = note.getNotes();
        Random ran = new Random();

        int index = ran.nextInt(notes.size());//get random index from list
        Note randomNote = notes.get(index);//use index to chose random note object

        Image randomNotePath = randomNote.getImage();
        notesImage.setImage(randomNotePath);

        setRandomNote = randomNote;  //assign randomly chosen note
        setRandomNote.setName(randomNote.getName()); //assign name & value to note
        setRandomNote.setValue(randomNote.getValue());

        enterAnswerButton.setVisible(true);
        generateButton.setVisible(false);
    }
}
