package content.com.stave;

/**
 * A class that represents a user of the system and contains the user's credentials and information.
 */
public class User {

    private String username;
    private double timePerSession;
    private int highScore;
    private String skillLevel;
    private int userID;

    private static User loggedUser;

    public User() {
        username = "";
        timePerSession = 0;
        highScore = 0;
        skillLevel = "";
        userID = 0;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getTimePerSession() {
        return timePerSession;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public static User getLoggedUser() {
        return loggedUser;
    }

    public static void setLoggedUser(User loggedUser) {
        User.loggedUser = loggedUser;
    }

    public void setTimePerSession(Double timePerSession) {
        this.timePerSession = timePerSession;
    }
}
