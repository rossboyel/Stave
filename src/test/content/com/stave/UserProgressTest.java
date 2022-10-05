package content.com.stave;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserProgressTest {

    @BeforeEach
    void init() {
        UserProgress.setLoggedUserProgress(new UserProgress());

    }

    /**
     * Test that ensures all method is returning true when there are all true boolean types in list.
     */
    @Test
    void areAllTrue() {

        UserProgress.getLoggedUserProgress();
        UserProgress userProgress = new UserProgress();

        UserProgress.getLoggedUserProgress().setBasicNotesTaken(true);
        UserProgress.getLoggedUserProgress().setBasicClefsTaken(true);
        UserProgress.getLoggedUserProgress().setBasicScalesTaken(true);
        UserProgress.getLoggedUserProgress().setBasicTimeSignaturesTaken(true);
        UserProgress.getLoggedUserProgress().setBasicRestsTaken(true);
        UserProgress.getLoggedUserProgress().setBasicSymbolTaken(true);
        UserProgress.getLoggedUserProgress().addBasicBoolean(UserProgress.getLoggedUserProgress().isBasicClefsTaken());
        UserProgress.getLoggedUserProgress().addBasicBoolean(UserProgress.getLoggedUserProgress().isBasicNotesTaken());
        UserProgress.getLoggedUserProgress().addBasicBoolean(UserProgress.getLoggedUserProgress().isBasicScalesTaken());
        UserProgress.getLoggedUserProgress().addBasicBoolean(UserProgress.getLoggedUserProgress().isBasicRestsTaken());
        UserProgress.getLoggedUserProgress().addBasicBoolean(UserProgress.getLoggedUserProgress().isBasicSymbolTaken());
        UserProgress.getLoggedUserProgress().addBasicBoolean(UserProgress.getLoggedUserProgress()
                .isBasicTimeSignaturesTaken());

        System.out.println(UserProgress.getLoggedUserProgress().getBasicQuizzes());

        assertEquals(true, userProgress.areAllTrue(UserProgress.getLoggedUserProgress().getBasicQuizzes()));
    }


    /**
     * Test that ensures all method is returning false when there are not all true boolean types in list.
     */
    @Test
    void failAreAllTrue() {

        UserProgress userProgress = new UserProgress();
        UserProgress.setLoggedUserProgress(new UserProgress());

        UserProgress.getLoggedUserProgress().setBasicNotesTaken(true);
        UserProgress.getLoggedUserProgress().setBasicClefsTaken(false);
        UserProgress.getLoggedUserProgress().setBasicScalesTaken(true);
        UserProgress.getLoggedUserProgress().setBasicTimeSignaturesTaken(true);
        UserProgress.getLoggedUserProgress().setBasicRestsTaken(true);
        UserProgress.getLoggedUserProgress().setBasicSymbolTaken(true);

        UserProgress.getLoggedUserProgress().addBasicBoolean(UserProgress.getLoggedUserProgress().isBasicClefsTaken());
        UserProgress.getLoggedUserProgress().addBasicBoolean(UserProgress.getLoggedUserProgress().isBasicNotesTaken());
        UserProgress.getLoggedUserProgress().addBasicBoolean(UserProgress.getLoggedUserProgress().isBasicScalesTaken());
        UserProgress.getLoggedUserProgress().addBasicBoolean(UserProgress.getLoggedUserProgress().isBasicRestsTaken());
        UserProgress.getLoggedUserProgress().addBasicBoolean(UserProgress.getLoggedUserProgress().isBasicSymbolTaken());
        UserProgress.getLoggedUserProgress().addBasicBoolean(UserProgress.getLoggedUserProgress().
                isBasicTimeSignaturesTaken());

        System.out.println(UserProgress.getLoggedUserProgress().getBasicQuizzes());

        assertEquals(false, userProgress.areAllTrue(UserProgress.getLoggedUserProgress().getBasicQuizzes()));
    }


    @Test
    void setBasicSymbolTaken() {
        UserProgress.getLoggedUserProgress().setBasicSymbolTaken(true);
        assertEquals(true, UserProgress.getLoggedUserProgress().isBasicSymbolTaken());

    }


    @Test
    void setBasicTimeSignaturesTaken() {
        UserProgress.getLoggedUserProgress().setBasicTimeSignaturesTaken(true);
        assertEquals(true, UserProgress.getLoggedUserProgress().isBasicTimeSignaturesTaken());
    }

    @Test
    void setBasicNotesTaken() {
        UserProgress.getLoggedUserProgress().setBasicNotesTaken(true);
        assertEquals(true, UserProgress.getLoggedUserProgress().isBasicNotesTaken());
    }

    @Test
    void setBasicRestsTaken() {
        UserProgress.getLoggedUserProgress().setBasicRestsTaken(true);
        assertEquals(true, UserProgress.getLoggedUserProgress().isBasicRestsTaken());
    }

    @Test
    void setBasicScalesTaken() {
        UserProgress.getLoggedUserProgress().setBasicScalesTaken(true);
        assertEquals(true, UserProgress.getLoggedUserProgress().isBasicScalesTaken());
    }

    @Test
    void setInterSymbolTaken() {
        UserProgress.getLoggedUserProgress().setInterSymbolTaken(true);
        assertEquals(true, UserProgress.getLoggedUserProgress().isInterSymbolTaken());

    }

    @Test
    void setInterClefsTaken() {
        UserProgress.getLoggedUserProgress().setInterClefsTaken(true);
        assertEquals(true, UserProgress.getLoggedUserProgress().isInterClefsTaken());
    }

    @Test
    void setInterTimeSignaturesTaken() {
        UserProgress.getLoggedUserProgress().setInterTimeSignaturesTaken(true);
        assertEquals(true, UserProgress.getLoggedUserProgress().isInterTimeSignaturesTaken());
    }

    @Test
    void setInterNotesTaken() {
        UserProgress.getLoggedUserProgress().setInterNotesTaken(true);
        assertEquals(true, UserProgress.getLoggedUserProgress().isInterNotesTaken());
    }

    @Test
    void setInterRestsTaken() {
        UserProgress.getLoggedUserProgress().setInterRestsTaken(true);
        assertEquals(true, UserProgress.getLoggedUserProgress().isInterRestsTaken());
    }

    @Test
    void setInterScalesTaken() {
        UserProgress.getLoggedUserProgress().setInterScalesTaken(true);
        assertEquals(true, UserProgress.getLoggedUserProgress().isInterScalesTaken());
    }

    @Test
    void setExpertSymbolTaken() {
        UserProgress.getLoggedUserProgress().setInterSymbolTaken(true);
        assertEquals(true, UserProgress.getLoggedUserProgress().isInterSymbolTaken());
    }

    @Test
    void setExpertClefsTaken() {
        UserProgress.getLoggedUserProgress().setExpertClefsTaken(true);
        assertEquals(true, UserProgress.getLoggedUserProgress().isExpertClefsTaken());
    }

    @Test
    void setExpertTimeSignaturesTaken() {
        UserProgress.getLoggedUserProgress().setExpertTimeSignaturesTaken(true);
        assertEquals(true, UserProgress.getLoggedUserProgress().isExpertTimeSignaturesTaken());
    }

    @Test
    void setExpertNotesTaken() {
        UserProgress.getLoggedUserProgress().setExpertNotesTaken(true);
        assertEquals(true, UserProgress.getLoggedUserProgress().isExpertNotesTaken());
    }

    @Test
    void setExpertRestsTaken() {
        UserProgress.getLoggedUserProgress().setExpertRestsTaken(true);
        assertEquals(true, UserProgress.getLoggedUserProgress().isExpertRestsTaken());
    }

    @Test
    void setExpertScalesTaken() {
        UserProgress.getLoggedUserProgress().setExpertScalesTaken(true);
        assertEquals(true, UserProgress.getLoggedUserProgress().isExpertScalesTaken());
    }

    @Test
    void setBasicClefsTaken() {
        UserProgress.getLoggedUserProgress().setBasicClefsTaken(true);
        assertEquals(true, UserProgress.getLoggedUserProgress().isBasicClefsTaken());
    }

    @Test
    void setBasicClefsTakenFail() {
        UserProgress.getLoggedUserProgress().setBasicClefsTaken(false);
        assertEquals(false, UserProgress.getLoggedUserProgress().isBasicClefsTaken());
        System.out.println(UserProgress.getLoggedUserProgress().isBasicClefsTaken());
    }

}