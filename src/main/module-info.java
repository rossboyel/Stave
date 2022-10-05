module com.example.stave {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
    requires java.desktop;
    requires javafx.swing;





    opens content.com.stave to javafx.fxml;
    exports content.com.stave;

    exports content.com.stave.controllers;
    opens content.com.stave.controllers to javafx.fxml;
    exports content.com.stave.controllers.lessons;
    opens content.com.stave.controllers.lessons to javafx.fxml;
    exports content.com.stave.controllers.quizzes;
    opens content.com.stave.controllers.quizzes to javafx.fxml;
}