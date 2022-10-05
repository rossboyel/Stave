package content.com.stave;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Junit testing for the UserLessonProgress class
 */
class UserLessonProgressTest {

    @BeforeEach
    void init() {
        UserLessonProgress.setLoggedUserLessonProgress(new UserLessonProgress());

    }

    /**
     * Test that ensures all method is returning true when there are all true boolean types in list.
     */
    @Test
    void areAllTrue() {

        UserLessonProgress.getLoggedUserLessonProgress();

        UserLessonProgress userLessonProgress = new UserLessonProgress();
        UserLessonProgress.getLoggedUserLessonProgress().setBasicNotesTaken(true);
        UserLessonProgress.getLoggedUserLessonProgress().setBasicClefsTaken(true);
        UserLessonProgress.getLoggedUserLessonProgress().setBasicScalesTaken(true);
        UserLessonProgress.getLoggedUserLessonProgress().setBasicTimeSignaturesTaken(true);
        UserLessonProgress.getLoggedUserLessonProgress().setBasicRestsTaken(true);
        UserLessonProgress.getLoggedUserLessonProgress().setBasicSymbolTaken(true);
        UserLessonProgress.getLoggedUserLessonProgress().addBasicBoolean
                (UserLessonProgress.getLoggedUserLessonProgress().isBasicClefsTaken());
        UserLessonProgress.getLoggedUserLessonProgress().addBasicBoolean
                (UserLessonProgress.getLoggedUserLessonProgress().isBasicNotesTaken());
        UserLessonProgress.getLoggedUserLessonProgress().addBasicBoolean
                (UserLessonProgress.getLoggedUserLessonProgress().isBasicScalesTaken());
        UserLessonProgress.getLoggedUserLessonProgress().addBasicBoolean
                (UserLessonProgress.getLoggedUserLessonProgress().isBasicRestsTaken());
        UserLessonProgress.getLoggedUserLessonProgress().addBasicBoolean
                (UserLessonProgress.getLoggedUserLessonProgress().isBasicSymbolTaken());
        UserLessonProgress.getLoggedUserLessonProgress().addBasicBoolean
                (UserLessonProgress.getLoggedUserLessonProgress().isBasicTimeSignaturesTaken());

        System.out.println(UserLessonProgress.getLoggedUserLessonProgress().getBasicQuizzes());

        assertEquals(true, userLessonProgress.areAllTrue
                (UserLessonProgress.getLoggedUserLessonProgress().getBasicQuizzes()));
    }


    /**
     * Test that ensures all method is returning false when there are not all true boolean types in list.
     */
    @Test
    void failAreAllTrue() {

        UserLessonProgress.getLoggedUserLessonProgress();

        UserLessonProgress userLessonProgress = new UserLessonProgress();
        UserLessonProgress.getLoggedUserLessonProgress().setBasicNotesTaken(true);
        UserLessonProgress.getLoggedUserLessonProgress().setBasicClefsTaken(false);
        UserLessonProgress.getLoggedUserLessonProgress().setBasicScalesTaken(true);
        UserLessonProgress.getLoggedUserLessonProgress().setBasicTimeSignaturesTaken(true);
        UserLessonProgress.getLoggedUserLessonProgress().setBasicRestsTaken(true);
        UserLessonProgress.getLoggedUserLessonProgress().setBasicSymbolTaken(true);
        UserLessonProgress.getLoggedUserLessonProgress().addBasicBoolean
                (UserLessonProgress.getLoggedUserLessonProgress().isBasicClefsTaken());
        UserLessonProgress.getLoggedUserLessonProgress().addBasicBoolean
                (UserLessonProgress.getLoggedUserLessonProgress().isBasicNotesTaken());
        UserLessonProgress.getLoggedUserLessonProgress().addBasicBoolean
                (UserLessonProgress.getLoggedUserLessonProgress().isBasicScalesTaken());
        UserLessonProgress.getLoggedUserLessonProgress().addBasicBoolean
                (UserLessonProgress.getLoggedUserLessonProgress().isBasicRestsTaken());
        UserLessonProgress.getLoggedUserLessonProgress().addBasicBoolean
                (UserLessonProgress.getLoggedUserLessonProgress().isBasicSymbolTaken());
        UserLessonProgress.getLoggedUserLessonProgress().addBasicBoolean
                (UserLessonProgress.getLoggedUserLessonProgress().isBasicTimeSignaturesTaken());

        System.out.println(UserLessonProgress.getLoggedUserLessonProgress().getBasicQuizzes());

        assertEquals(true, userLessonProgress.areAllTrue
                (UserLessonProgress.getLoggedUserLessonProgress().getBasicQuizzes()));
    }


    @Test
    void setBasicSymbolTaken() {
        UserLessonProgress.getLoggedUserLessonProgress().setBasicSymbolTaken(true);
        assertEquals(true, UserLessonProgress.getLoggedUserLessonProgress().isBasicSymbolTaken());

    }


    @Test
    void setBasicTimeSignaturesTaken() {
        UserLessonProgress.getLoggedUserLessonProgress().setBasicTimeSignaturesTaken(true);
        assertEquals(true, UserLessonProgress.getLoggedUserLessonProgress().isBasicTimeSignaturesTaken());
    }

    @Test
    void setBasicNotesTaken() {
        UserLessonProgress.getLoggedUserLessonProgress().setBasicNotesTaken(true);
        assertEquals(true, UserLessonProgress.getLoggedUserLessonProgress().isBasicNotesTaken());
    }

    @Test
    void setBasicRestsTaken() {
        UserLessonProgress.getLoggedUserLessonProgress().setBasicRestsTaken(true);
        assertEquals(true, UserLessonProgress.getLoggedUserLessonProgress().isBasicRestsTaken());
    }

    @Test
    void setBasicScalesTaken() {
        UserLessonProgress.getLoggedUserLessonProgress().setBasicScalesTaken(true);
        assertEquals(true, UserLessonProgress.getLoggedUserLessonProgress().isBasicScalesTaken());
    }

    @Test
    void setInterSymbolTaken() {
        UserLessonProgress.getLoggedUserLessonProgress().setInterSymbolTaken(true);
        assertEquals(true, UserLessonProgress.getLoggedUserLessonProgress().isInterSymbolTaken());

    }

    @Test
    void setInterClefsTaken() {
        UserLessonProgress.getLoggedUserLessonProgress().setInterClefsTaken(true);
        assertEquals(true, UserLessonProgress.getLoggedUserLessonProgress().isInterClefsTaken());
    }

    @Test
    void setInterTimeSignaturesTaken() {
        UserLessonProgress.getLoggedUserLessonProgress().setInterTimeSignaturesTaken(true);
        assertEquals(true, UserLessonProgress.getLoggedUserLessonProgress().isInterTimeSignaturesTaken());
    }

    @Test
    void setInterNotesTaken() {
        UserLessonProgress.getLoggedUserLessonProgress().setInterNotesTaken(true);
        assertEquals(true, UserLessonProgress.getLoggedUserLessonProgress().isInterNotesTaken());
    }

    @Test
    void setInterRestsTaken() {
        UserLessonProgress.getLoggedUserLessonProgress().setInterRestsTaken(true);
        assertEquals(true, UserLessonProgress.getLoggedUserLessonProgress().isInterRestsTaken());
    }

    @Test
    void setInterScalesTaken() {
        UserLessonProgress.getLoggedUserLessonProgress().setInterScalesTaken(true);
        assertEquals(true, UserLessonProgress.getLoggedUserLessonProgress().isInterScalesTaken());
    }

    @Test
    void setExpertSymbolTaken() {
        UserLessonProgress.getLoggedUserLessonProgress().setInterSymbolTaken(true);
        assertEquals(true, UserLessonProgress.getLoggedUserLessonProgress().isInterSymbolTaken());
    }

    @Test
    void setExpertClefsTaken() {
        UserLessonProgress.getLoggedUserLessonProgress().setExpertClefsTaken(true);
        assertEquals(true, UserLessonProgress.getLoggedUserLessonProgress().isExpertClefsTaken());
    }

    @Test
    void setExpertTimeSignaturesTaken() {
        UserLessonProgress.getLoggedUserLessonProgress().setExpertTimeSignaturesTaken(true);
        assertEquals(true, UserLessonProgress.getLoggedUserLessonProgress().isExpertTimeSignaturesTaken());
    }

    @Test
    void setExpertNotesTaken() {
        UserLessonProgress.getLoggedUserLessonProgress().setExpertNotesTaken(true);
        assertEquals(true, UserLessonProgress.getLoggedUserLessonProgress().isExpertNotesTaken());
    }

    @Test
    void setExpertRestsTaken() {
        UserLessonProgress.getLoggedUserLessonProgress().setExpertRestsTaken(true);
        assertEquals(true, UserLessonProgress.getLoggedUserLessonProgress().isExpertRestsTaken());
    }

    @Test
    void setExpertScalesTaken() {
        UserLessonProgress.getLoggedUserLessonProgress().setExpertScalesTaken(true);
        assertEquals(true, UserLessonProgress.getLoggedUserLessonProgress().isExpertScalesTaken());
    }

    @Test
    void setBasicClefsTaken() {
        UserLessonProgress.getLoggedUserLessonProgress().setBasicClefsTaken(true);
        assertEquals(true, UserLessonProgress.getLoggedUserLessonProgress().isBasicClefsTaken());
    }

    @Test
    void setBasicClefsTakenFail() {
        UserLessonProgress.getLoggedUserLessonProgress().setBasicClefsTaken(false);
        assertEquals(false, UserLessonProgress.getLoggedUserLessonProgress().isBasicClefsTaken());
        System.out.println(UserLessonProgress.getLoggedUserLessonProgress().isBasicClefsTaken());
    }

}
