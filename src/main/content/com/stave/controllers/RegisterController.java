package content.com.stave.controllers;

import content.com.stave.DatabaseQuery;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;

/**
 * A class that implements how to register o new user on the system.
 */
public class RegisterController {

    @FXML
    private TextField createUsernameField;

    @FXML
    private TextField createPasswordField;

    @FXML
    private TextField createEmailTextField;

    @FXML
    private Slider createSessionTimeSlider;

    @FXML
    private ToggleGroup skillToggleGroup;

    @FXML
    private Label errorLabel;


    /**
     * Takes the information entered by user on the registration form, inserts information into database if
     * all fields have information entered and takes user back to login page.
     * @param event User clicking on register button
     * @throws SQLException
     */
    @FXML
    public void register(MouseEvent event) throws SQLException {

        String username = createUsernameField.getText(); // assign entered login details to string
        String password = createPasswordField.getText();
        Double timePerSession = createSessionTimeSlider.getValue();
        String email = createEmailTextField.getText();
        String skill = "beginner";

        if(skillToggleGroup.selectedToggleProperty().toString().equals("beginner")) {
            skill = "beginner";
        }
        if(skillToggleGroup.selectedToggleProperty().toString().equals("intermediate")) {
            skill = "intermediate";
        }
        if(skillToggleGroup.selectedToggleProperty().toString().equals("expert")) {
            skill = "expert";

        }

        if (createUsernameField.getText().equals("") || createPasswordField.getText().equals("")) {
            System.out.println("Missing a field");
            errorLabel.setText("Missing a field");
        } else {
            DatabaseQuery databaseQuery = new DatabaseQuery();
            errorLabel.setText("An account with that information already exists."); //only shows when unsuccessful
            databaseQuery.registerUser(username, password, timePerSession, email, skill);

            databaseQuery.createLessonList(username);
            databaseQuery.createQuizList(username);

            try {
                backButton(event);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Handles displaying the home page.
     * @param event User clicking on back button
     * @throws IOException
     */
    @FXML
    public void backButton(MouseEvent event) throws IOException {
            Stage stage;
            stage = (Stage) createSessionTimeSlider.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("/com/stave/login.fxml"));
            Stage homeStage = new Stage();
            homeStage.initStyle(StageStyle.UNIFIED);
            homeStage.setTitle("Stave");
            homeStage.setScene(new Scene(root, 1000, 650));
            homeStage.setResizable(false);
            homeStage.show();
        }

    }
