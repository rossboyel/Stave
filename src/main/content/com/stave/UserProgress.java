package content.com.stave;

import java.util.ArrayList;

/**
 * A class that implements how to handle a user's quiz progress within the application. Has a boolean value for each
 * quiz in the program which can be updated when the user completes this.
 */
public class UserProgress {

    private boolean basicSymbolTaken;
    private boolean basicClefsTaken;
    private boolean basicTimeSignaturesTaken;
    private boolean basicNotesTaken;
    private boolean basicRestsTaken;
    private boolean basicScalesTaken;

    private boolean interSymbolTaken;
    private boolean interClefsTaken;
    private boolean interTimeSignaturesTaken;
    private boolean interNotesTaken;
    private boolean interRestsTaken;
    private boolean interScalesTaken;

    private boolean expertSymbolTaken;
    private boolean expertClefsTaken;
    private boolean expertTimeSignaturesTaken;
    private boolean expertNotesTaken;
    private boolean expertRestsTaken;
    private boolean expertScalesTaken;

    ArrayList<Boolean> basicQuizzes;
    ArrayList<Boolean> interQuizzes;
    ArrayList<Boolean> expertQuizzes;

    private static UserProgress loggedUserProgress;

    public UserProgress() {
        basicSymbolTaken = false;
        basicClefsTaken = false;
        basicTimeSignaturesTaken = false;
        basicNotesTaken = false;
        basicRestsTaken = false;
        basicScalesTaken = false;

        interSymbolTaken = false;
        interClefsTaken = false;
        interTimeSignaturesTaken = false;
        interNotesTaken = false;
        interRestsTaken = false;
        interScalesTaken = false;

        expertSymbolTaken = false;
        expertClefsTaken = false;
        expertTimeSignaturesTaken = false;
        expertNotesTaken = false;
        expertRestsTaken = false;
        expertScalesTaken = false;

        basicQuizzes = new ArrayList<>();
        interQuizzes = new ArrayList<>();
        expertQuizzes = new ArrayList<>();

    }

    public boolean isBasicSymbolTaken() {
        return basicSymbolTaken;
    }

    public void setBasicSymbolTaken(boolean basicSymbolTaken) {
        this.basicSymbolTaken = basicSymbolTaken;
    }

    public boolean isBasicClefsTaken() {
        return basicClefsTaken;
    }

    public void setBasicClefsTaken(boolean basicClefsTaken) {
        this.basicClefsTaken = basicClefsTaken;
    }

    public boolean isBasicTimeSignaturesTaken() {
        return basicTimeSignaturesTaken;
    }

    public void setBasicTimeSignaturesTaken(boolean basicTimeSignaturesTaken) {
        this.basicTimeSignaturesTaken = basicTimeSignaturesTaken;
    }

    public boolean isBasicNotesTaken() {
        return basicNotesTaken;
    }

    public void setBasicNotesTaken(boolean basicNotesTaken) {
        this.basicNotesTaken = basicNotesTaken;
    }

    public boolean isBasicRestsTaken() {
        return basicRestsTaken;
    }

    public void setBasicRestsTaken(boolean basicRestsTaken) {
        this.basicRestsTaken = basicRestsTaken;
    }

    public boolean isBasicScalesTaken() {
        return basicScalesTaken;
    }

    public void setBasicScalesTaken(boolean basicScalesTaken) {
        this.basicScalesTaken = basicScalesTaken;
    }

    public boolean isInterSymbolTaken() {
        return interSymbolTaken;
    }

    public void setInterSymbolTaken(boolean interSymbolTaken) {
        this.interSymbolTaken = interSymbolTaken;
    }

    public boolean isInterClefsTaken() {
        return interClefsTaken;
    }

    public void setInterClefsTaken(boolean interClefsTaken) {
        this.interClefsTaken = interClefsTaken;
    }

    public boolean isInterTimeSignaturesTaken() {
        return interTimeSignaturesTaken;
    }

    public void setInterTimeSignaturesTaken(boolean interTimeSignaturesTaken) {
        this.interTimeSignaturesTaken = interTimeSignaturesTaken;
    }

    public boolean isInterNotesTaken() {
        return interNotesTaken;
    }

    public void setInterNotesTaken(boolean interNotesTaken) {
        this.interNotesTaken = interNotesTaken;
    }

    public boolean isInterRestsTaken() {
        return interRestsTaken;
    }

    public void setInterRestsTaken(boolean interRestsTaken) {
        this.interRestsTaken = interRestsTaken;
    }

    public boolean isInterScalesTaken() {
        return interScalesTaken;
    }

    public void setInterScalesTaken(boolean interScalesTaken) {
        this.interScalesTaken = interScalesTaken;
    }

    public boolean isExpertSymbolTaken() {
        return expertSymbolTaken;
    }

    public void setExpertSymbolTaken(boolean expertSymbolTaken) {
        this.expertSymbolTaken = expertSymbolTaken;
    }

    public boolean isExpertClefsTaken() {
        return expertClefsTaken;
    }

    public void setExpertClefsTaken(boolean expertClefsTaken) {
        this.expertClefsTaken = expertClefsTaken;
    }

    public boolean isExpertTimeSignaturesTaken() {
        return expertTimeSignaturesTaken;
    }

    public void setExpertTimeSignaturesTaken(boolean expertTimeSignaturesTaken) {
        this.expertTimeSignaturesTaken = expertTimeSignaturesTaken;
    }

    public boolean isExpertNotesTaken() {
        return expertNotesTaken;
    }

    public void setExpertNotesTaken(boolean expertNotesTaken) {
        this.expertNotesTaken = expertNotesTaken;
    }

    public boolean isExpertRestsTaken() {
        return expertRestsTaken;
    }

    public void setExpertRestsTaken(boolean expertRestsTaken) {
        this.expertRestsTaken = expertRestsTaken;
    }

    public boolean isExpertScalesTaken() {
        return expertScalesTaken;
    }

    public void setExpertScalesTaken(boolean expertScalesTaken) {
        this.expertScalesTaken = expertScalesTaken;
    }

    public ArrayList<Boolean> getBasicQuizzes() {
        return basicQuizzes;
    }

    public ArrayList<Boolean> getInterQuizzes() {
        return interQuizzes;
    }

    public ArrayList<Boolean> getExpertQuizzes() {
        return expertQuizzes;
    }

    public void addBasicBoolean(Boolean hasCompleted) {
        basicQuizzes.add(hasCompleted);
    }

    public void addInterBoolean(Boolean hasCompleted) {
        interQuizzes.add(hasCompleted);
    }

    public void addExpertBoolean(Boolean hasCompleted) {
        expertQuizzes.add(hasCompleted);
    }

    public static UserProgress getLoggedUserProgress() {
        return loggedUserProgress;
    }

    public static void setLoggedUserProgress(UserProgress loggedUserProgress) {
        UserProgress.loggedUserProgress = loggedUserProgress;
    }

    /**
     * Checks the ArrayList and returns true if all Boolean values are true, if any are false returns false.
     * @param array The ArrayList to be checked
     * @return
     */
    public boolean areAllTrue(ArrayList<Boolean> array) {
        for(boolean b : array)
            if (!b) return false;
        return true;

    }

}
