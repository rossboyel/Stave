package content.com.stave;

import java.util.ArrayList;

/**
 * A class that implements how to handle a user's lesson progress within the application. Has a boolean value for each
 * lesson in the program which can be updated when the user completes this. Extends UserProgress as it shares many of
 * the same data fields and methods.
 */
public class UserLessonProgress extends UserProgress {

    private ArrayList<Boolean> basicLessons;
    private ArrayList<Boolean> interLessons;
    private ArrayList<Boolean> expertLessons;

    private static UserLessonProgress loggedUserLessonProgress;

    public UserLessonProgress() {

        basicLessons = new ArrayList<>();
        interLessons = new ArrayList<>();
        expertLessons = new ArrayList<>();

    }

    public void addBasicBoolean(Boolean hasCompleted) {
        basicLessons.add(hasCompleted);
    }

    public void addInterBoolean(Boolean hasCompleted) {
        interLessons.add(hasCompleted);
    }

    public void addExpertBoolean(Boolean hasCompleted) {
        expertLessons.add(hasCompleted);
    }

    public static UserLessonProgress getLoggedUserLessonProgress() {
        return loggedUserLessonProgress;
    }

    public static void setLoggedUserLessonProgress(UserLessonProgress loggedUserLessonProgress) {
        UserLessonProgress.loggedUserLessonProgress = loggedUserLessonProgress;
    }

}
