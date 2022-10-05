package content.com.stave;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    User user = new User();

    @Test
    void setHighScore() {
        user.setHighScore(1);
        Assertions.assertEquals(1, user.getHighScore());
    }

    @Test
    void setUsername() {
        user.setUsername("John");
        Assertions.assertEquals("John", user.getUsername());
    }

    @Test
    void setSkillLevel() {
        user.setSkillLevel("Expert");
        Assertions.assertEquals("Expert", user.getSkillLevel());
    }

    @Test
    void setUserID() {
        user.setUserID(112);
        Assertions.assertEquals(112, user.getUserID());
    }

    @Test
    void setTimePerSession() {
        user.setTimePerSession(5.0);
        Assertions.assertEquals(5.0, user.getTimePerSession());
    }
}
