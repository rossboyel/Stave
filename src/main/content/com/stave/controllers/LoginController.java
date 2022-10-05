package content.com.stave.controllers;

import content.com.stave.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;

/**
 * A class that implements the login screen and is the first screen shown to a user.
 */
public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label loginLabel;

    public void initialize() {

        UserProgress.setLoggedUserProgress(new UserProgress());
        User.setLoggedUser(new User());
        UserLessonProgress.setLoggedUserLessonProgress(new UserLessonProgress());

    }


    /**
     * Checks the credentials entered by the user against the database. If they match, the user is logged into
     * the application and a User object is initialized and given the user's information.
     *
     * @param event
     * @throws SQLException
     */
    public void validation(ActionEvent event) throws SQLException {

        String username = usernameField.getText(); // assign entered login details to string
        String password = passwordField.getText();
        DatabaseQuery databaseQuery = new DatabaseQuery();
        databaseQuery.login(username, password, loginLabel);

        if(User.getLoggedUser().getUsername() != "") {
            loadHomeScreen();
            Timer timer = new Timer();
            timer.startLearningTimer();
        }

    }

    /**
     * Loads FXML file and displays the home screen to the user.
     */
    public void loadHomeScreen () {
        try {
            Stage stage;
            stage = (Stage) loginLabel.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("/com/stave/home.fxml"));
            Stage homeStage = new Stage();
            homeStage.initStyle(StageStyle.UNIFIED);
            homeStage.setTitle("Stave");
            homeStage.setScene(new Scene(root, 1000, 650));
            homeStage.setResizable(false);
            homeStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes user to the application's registration form.
     * @param event User clicking on the button
     * @throws IOException
     */
    public void loadRegisterScreen (ActionEvent event) throws IOException {

        Stage stage;
        stage = (Stage) loginLabel.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("/com/stave/register.fxml"));
        Stage homeStage = new Stage();
        homeStage.initStyle(StageStyle.UNIFIED);
        homeStage.setTitle("Stave");
        homeStage.setScene(new Scene(root, 1000, 650));
        homeStage.setResizable(false);
        homeStage.show();

    }

}
