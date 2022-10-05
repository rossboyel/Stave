package content.com.stave;

import javafx.application.Platform;
import javafx.scene.control.Alert;

import java.awt.event.ActionListener;

/**
 * A class that implements a timer function to show an alert to a user.
 */
public class Timer {

    /**
     * Creates a timer that will inform the user when they have achieved their learning goal in terms of time
     * spent learning on the application. Gets the user's desired time from the LoginController and converts into an
     * integer before using as a parameter for the timer.
     */
    public void startLearningTimer() {

        double loggedTime = User.getLoggedUser().getTimePerSession();//get time in minutes
        loggedTime = Math.round(loggedTime); //round to the closest int
        int intLoggedTime = (int) loggedTime; //cast to int
        int conversionNumber = 60000; //60000 = conversion for minutes into milliseconds
        int convertedNumber = intLoggedTime * conversionNumber; // convert users time per session into milliseconds

        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.out.println("timer reached");     //Action to be performed on timer

                Platform.runLater(() -> {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("You have met your session goal time! Well done.");
                    alert.setTitle("Session com.example.test.Timer");
                    alert.setHeaderText(null);
                    alert.show();
                });
            }
        };

        javax.swing.Timer timer = new javax.swing.Timer(convertedNumber, taskPerformer);
        timer.setRepeats(false);
        timer.start();

    }

}
