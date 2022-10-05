package content.com.stave;

import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A class that handles all the database querying within the application. Has every method that is requried for
 * creating, updating and selecting user data.
 */
public class DatabaseQuery {

    /**
     * Takes a lesson parameter and updates the user's records to indicate it has been completed.
     * @param lessonName The name of the completed lesson
     * @throws SQLException
     */
    public void lessonUpdate(String lessonName) throws SQLException {
        DatabaseConnection connection = new DatabaseConnection(); // create connection
        Connection connectDB = connection.getConnection();

        int userID = User.getLoggedUser().getUserID();

        Statement statement = connectDB.createStatement();
        String updateUserLessonList = ("INSERT INTO lesson_list(USER_ID, " + lessonName + ") " +
                "VALUES('" + userID + "','" + "1" + "') ON DUPLICATE KEY " +
                "UPDATE " + lessonName + " = 1 and USER_ID = '" + userID + "'");

        statement.executeUpdate(updateUserLessonList);
    }

    /**
     * Takes a quiz parameter and updates the user's records to indicate it has been completed.
     * @param quizName The name of the completed quiz
     * @throws SQLException
     */
    public void quizUpdate(String quizName) throws SQLException {
        DatabaseConnection connection = new DatabaseConnection(); // create connection
        Connection connectDB = connection.getConnection();

        int userID = User.getLoggedUser().getUserID();

        Statement statement = connectDB.createStatement();
        String updateUserLessonList = ("INSERT INTO quiz_list(USER_ID, " + quizName + ") " +
                "VALUES('" + userID + "','" + "1" + "') ON DUPLICATE KEY " +
                "UPDATE " + quizName + " = 1 and USER_ID = '" + userID + "'");

        statement.executeUpdate(updateUserLessonList);

    }

    /**
     * Access the database, determine what resources the user has taken and fill the UserProgress object's data fields.
     * @param resultSet The queried data from the database
     * @param loggedUserProgress The UserProgress object
     * @throws SQLException
     */
    public void getResourcesTaken(ResultSet resultSet, UserProgress loggedUserProgress) throws SQLException {
        while (resultSet.next()) {

            // Check user has completed beginner level resources and add result to progress.

            loggedUserProgress.basicQuizzes.removeAll(loggedUserProgress.basicQuizzes); //stop list from stacking

            loggedUserProgress.setBasicSymbolTaken(resultSet.getBoolean("BASIC_SYMBOLS"));
            loggedUserProgress.addBasicBoolean(loggedUserProgress.isBasicSymbolTaken());

            loggedUserProgress.setBasicClefsTaken(resultSet.getBoolean("BASIC_CLEFS"));
            loggedUserProgress.addBasicBoolean(loggedUserProgress.isBasicClefsTaken());

            loggedUserProgress.setBasicTimeSignaturesTaken(resultSet.getBoolean("BASIC_TIME_SIGNATURES"));
            loggedUserProgress.addBasicBoolean(loggedUserProgress.isBasicTimeSignaturesTaken());

            loggedUserProgress.setBasicNotesTaken(resultSet.getBoolean("BASIC_NOTES"));
            loggedUserProgress.addBasicBoolean(loggedUserProgress.isBasicNotesTaken());

            loggedUserProgress.setBasicRestsTaken(resultSet.getBoolean("BASIC_RESTS"));
            loggedUserProgress.addBasicBoolean(loggedUserProgress.isBasicRestsTaken());

            loggedUserProgress.setBasicScalesTaken(resultSet.getBoolean("BASIC_SCALES"));
            loggedUserProgress.addBasicBoolean(loggedUserProgress.isBasicScalesTaken());

            // Check user has completed intermediate level resources.

            loggedUserProgress.interQuizzes.removeAll(loggedUserProgress.interQuizzes); //stop list from stacking

            loggedUserProgress.setInterSymbolTaken(resultSet.getBoolean("INTER_SYMBOLS"));
            loggedUserProgress.addInterBoolean(loggedUserProgress.isInterSymbolTaken());

            loggedUserProgress.setInterClefsTaken(resultSet.getBoolean("INTER_CLEFS"));
            loggedUserProgress.addInterBoolean(loggedUserProgress.isInterClefsTaken());

            loggedUserProgress.setInterTimeSignaturesTaken(resultSet.getBoolean("INTER_TIME_SIGNATURES"));
            loggedUserProgress.addInterBoolean(loggedUserProgress.isInterTimeSignaturesTaken());

            loggedUserProgress.setInterNotesTaken(resultSet.getBoolean("INTER_NOTES"));
            loggedUserProgress.addInterBoolean(loggedUserProgress.isInterNotesTaken());

            loggedUserProgress.setInterRestsTaken(resultSet.getBoolean("INTER_RESTS"));
            loggedUserProgress.addInterBoolean(loggedUserProgress.isInterRestsTaken());

            loggedUserProgress.setInterScalesTaken(resultSet.getBoolean("INTER_SCALES"));
            loggedUserProgress.addInterBoolean(loggedUserProgress.isInterScalesTaken());

            // Check user has completed expert level resources

            loggedUserProgress.expertQuizzes.removeAll(loggedUserProgress.expertQuizzes); //stop list from stacking

            loggedUserProgress.setExpertSymbolTaken(resultSet.getBoolean("EXPERT_SYMBOLS"));
            loggedUserProgress.addExpertBoolean(loggedUserProgress.isExpertSymbolTaken());

            loggedUserProgress.setExpertClefsTaken(resultSet.getBoolean("EXPERT_CLEFS"));
            loggedUserProgress.addExpertBoolean(loggedUserProgress.isExpertClefsTaken());

            loggedUserProgress.setExpertTimeSignaturesTaken(resultSet.getBoolean("EXPERT_TIME_SIGNATURES"));
            loggedUserProgress.addExpertBoolean(loggedUserProgress.isExpertTimeSignaturesTaken());

            loggedUserProgress.setExpertNotesTaken(resultSet.getBoolean("EXPERT_NOTES"));
            loggedUserProgress.addExpertBoolean(loggedUserProgress.isExpertNotesTaken());

            loggedUserProgress.setExpertRestsTaken(resultSet.getBoolean("EXPERT_RESTS"));
            loggedUserProgress.addExpertBoolean(loggedUserProgress.isExpertRestsTaken());

            loggedUserProgress.setExpertScalesTaken(resultSet.getBoolean("EXPERT_SCALES"));
            loggedUserProgress.addExpertBoolean(loggedUserProgress.isExpertScalesTaken());
        }
    }

    /**
     * Queries the database for the logged user's lesson progress.
     * @throws SQLException
     */
    public void getUserLessons() throws SQLException {
        DatabaseConnection connection = new DatabaseConnection(); // create connection
        Connection connectDB = connection.getConnection();
        int userID = User.getLoggedUser().getUserID();
        Statement statement = connectDB.createStatement();
        String getUserLessons = "Select * FROM lesson_list where user_ID='" + userID + "'";
        ResultSet resultSet = statement.executeQuery(getUserLessons);

        getResourcesTaken(resultSet, UserLessonProgress.getLoggedUserLessonProgress());
    }

    /**
     * Finds what quizzes the user has taken and creates a UserProgress object. Fills its data fields
     * with the resulting data.
     * @throws SQLException
     */
    public void getUsersQuizzes() throws SQLException {
        DatabaseConnection connection = new DatabaseConnection(); // create connection
        Connection connectDB = connection.getConnection();
        int userID = User.getLoggedUser().getUserID();

        Statement statement = connectDB.createStatement();
        String getUserQuizzes = "Select * FROM quiz_list where user_id='" + userID + "'";
        ResultSet resultSet = statement.executeQuery(getUserQuizzes);

        getResourcesTaken(resultSet, UserProgress.getLoggedUserProgress());

    }

    /**
     * Use the details entered by a user and check them against the database. If unsuccessful,informs user via Label.
     * @param username The user's username
     * @param password The user's password
     * @param loginLabel Label which will inform user
     * @throws SQLException
     */
    public void login(String username, String password, Label loginLabel) throws SQLException {
        DatabaseConnection connection = new DatabaseConnection(); // create connection
        Connection connectDB = connection.getConnection();

        Statement statement = connectDB.createStatement();
        String validateUser = "Select * FROM user where username='" + username + "' " +
                "and password ='" + password + "'";
        ResultSet resultSet = statement.executeQuery(validateUser);

        if (resultSet.next()) {

            Double sessionTime = resultSet.getDouble("SESSION_TIME");
            String skillLevel = resultSet.getString("SKILL_LEVEL");
            int highScore = resultSet.getInt("HIGH_SCORE");
            int userID = resultSet.getInt("USER_ID");

            User.getLoggedUser().setUsername(username);
            User.getLoggedUser().setTimePerSession(sessionTime);
            User.getLoggedUser().setSkillLevel(skillLevel);
            User.getLoggedUser().setHighScore(highScore);
            User.getLoggedUser().setUserID(userID);

            System.out.println("Logged in as " + User.getLoggedUser().getUsername());

        } else {
            loginLabel.setText("An account with those details does not exist.");
        }
    }

    /**
     * Returns how many lessons a user has completed as an int.
     * @return The total lessons completed
     * @throws SQLException
     */
    public int getTotalLessonsCompleted() throws SQLException {
        DatabaseConnection connection = new DatabaseConnection(); // create connection
        Connection connectDB = connection.getConnection();
        int userID = User.getLoggedUser().getUserID();
        int total = 0;
        Statement statement = connectDB.createStatement();
        String getTotalLessonsCompleted = "Select SUM(BASIC_SYMBOLS + BASIC_CLEFS + BASIC_NOTES + BASIC_RESTS + " +
                "BASIC_SCALES +BASIC_TIME_SIGNATURES +INTER_SYMBOLS + INTER_CLEFS + INTER_NOTES + INTER_RESTS " +
                "+ INTER_SCALES +INTER_TIME_SIGNATURES + EXPERT_SYMBOLS + EXPERT_CLEFS + EXPERT_NOTES + " +
                "EXPERT_RESTS +EXPERT_SCALES +EXPERT_TIME_SIGNATURES) " +
                "as total FROM lesson_list where user_ID='" + userID + "'";
        ResultSet resultSet = statement.executeQuery(getTotalLessonsCompleted);

        if (resultSet.next()) {
            total = resultSet.getInt("total");
        }
        return total;
    }

    /**
     * Returns how many quizzes a user has completed.
     * @return Total quizzes completed
     * @throws SQLException
     */
    public int getTotalQuizzesCompleted() throws SQLException {
        DatabaseConnection connection = new DatabaseConnection(); // create connection
        Connection connectDB = connection.getConnection();
        int userID = User.getLoggedUser().getUserID();
        int total = 0;
        Statement statement = connectDB.createStatement();
        String getTotalQuizzesCompleted = "Select SUM(BASIC_SYMBOLS + BASIC_CLEFS + BASIC_NOTES + BASIC_RESTS + " +
                "BASIC_SCALES +BASIC_TIME_SIGNATURES +INTER_SYMBOLS + INTER_CLEFS + INTER_NOTES + INTER_RESTS " +
                "+ INTER_SCALES +INTER_TIME_SIGNATURES + EXPERT_SYMBOLS + EXPERT_CLEFS + EXPERT_NOTES + " +
                "EXPERT_RESTS +EXPERT_SCALES +EXPERT_TIME_SIGNATURES) " +
                "as total FROM quiz_list where user_ID='" + userID + "'";
        ResultSet resultSet = statement.executeQuery(getTotalQuizzesCompleted);

        if (resultSet.next()) {
            total = resultSet.getInt("total");
        }
        return total;
    }

    /**
     * Updates the user's high score in the random note generator.
     * @param intCount The total number of correct answers in a row
     * @throws SQLException
     */
    public void updateHighScore(int intCount) throws SQLException {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();
        Statement statement = connectDB.createStatement();
        int userID = User.getLoggedUser().getUserID();

        String updateHighScore = ("UPDATE user set HIGH_SCORE = '" +
                intCount + "' where USER_ID = '" + userID + "'");
        statement.executeUpdate(updateHighScore);
    }

    /**
     * Return the user' random note generator high score from the database.
     * @return The user's high score
     * @throws SQLException
     */
    public int getHighScore() throws SQLException {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();
        Statement statement = connectDB.createStatement();
        int userID = User.getLoggedUser().getUserID();
        int highScore = 0;

        String getHighSCore = ("SELECT HIGH_SCORE FROM USER WHERE USER_ID = '" +userID+"'");
        ResultSet resultSet = statement.executeQuery(getHighSCore);

        if(resultSet.next()) {
            highScore = resultSet.getInt("HIGH_SCORE");
        }
        return highScore;
    }

    /**
     * Returns the user's skill level from the database.
     * @return The user's skill level
     * @throws SQLException
     */
    public String getSkillLevel() throws SQLException {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();
        Statement statement = connectDB.createStatement();
        int userID = User.getLoggedUser().getUserID();

        String skillLevel = "";
        String getSkillLevel = ("SELECT SKILL_LEVEL FROM USER WHERE USER_ID = '" +userID+"'");
        ResultSet resultSet = statement.executeQuery(getSkillLevel);
        if(resultSet.next()) {
            skillLevel = resultSet.getString("SKILL_LEVEL");
        }
        return skillLevel;
    }

    /**
     * Registers a user on the application by using the data given to create a user, quiz list and lesson list entry.
     * @param username The user's username
     * @param password The user's password
     * @param timePerSession The user's learning goal time
     * @param email The user's E-Mail
     * @param skill The user's chosen skill level
     * @throws SQLException
     */
    public void registerUser(String username, String password, Double timePerSession, String email,
                             String skill) throws SQLException {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();
        Statement statement = connectDB.createStatement();

        String registerUser = ("INSERT INTO user(USERNAME, PASSWORD, SESSION_TIME, email, SKILL_LEVEL) " +
                "VALUES('" + username + "','" + password + "','" + timePerSession + "','" + email + "','" + skill + "')");
        statement.executeUpdate(registerUser);
    }

    /**
     * Creates a lesson list entry on the database for the user.
     * @param username The user's username
     * @throws SQLException
     */
    public void createLessonList(String username) throws SQLException {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();
        Statement statement = connectDB.createStatement();
        String createLessonList = ("INSERT INTO lesson_list(user_id) SELECT(USER_ID) FROM user WHERE USERNAME = '"+username+"'");

        statement.executeUpdate(createLessonList);
    }

    /**
     * Creates a quiz list entry on the database for the user.
     * @param username The user's username
     * @throws SQLException
     */
    public void createQuizList(String username) throws SQLException {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();
        Statement statement = connectDB.createStatement();

        String createQuizList = ("INSERT INTO quiz_list(user_id)" + "SELECT(USER_ID) FROM user WHERE USERNAME = '"+username+"'");

        statement.executeUpdate(createQuizList);
    }

    /**
     * Checks whether the user has completed the last quiz in a block needed to progress to next skill level. IF they
     * have, upgrades user's skill level on the database.
     * @param userID The user's user id
     * @throws SQLException
     */
    public void updateUserSkill(int  userID) throws SQLException {

            DatabaseConnection connection = new DatabaseConnection(); // create connection
            Connection connectDB = connection.getConnection();

            System.out.println(UserProgress.getLoggedUserProgress().getBasicQuizzes());
            if (UserProgress.getLoggedUserProgress().
                    areAllTrue(UserProgress.getLoggedUserProgress().getBasicQuizzes())) {
                System.out.println("user is inter skill level");
                User.getLoggedUser().setSkillLevel("intermediate");
                Statement statement = connectDB.createStatement();
                String updateUserSkill = "UPDATE user set SKILL_LEVEL = 'inter' where user_ID='" + userID + "'";
                statement.executeUpdate(updateUserSkill);
            }

            if(UserProgress.getLoggedUserProgress().
                    areAllTrue(UserProgress.getLoggedUserProgress().getInterQuizzes())) {
                System.out.println("User is now expert skill level");
                User.getLoggedUser().setSkillLevel("expert");
                Statement statement = connectDB.createStatement();
                String updateUserSkill = "UPDATE user set SKILL_LEVEL = 'expert' where USER_ID='" + userID + "'";
                statement.executeUpdate(updateUserSkill);
            }
        }
}

