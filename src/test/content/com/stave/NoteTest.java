package content.com.stave;


import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ArrayList;

/**
 * Implements Junit tests for the Note class.
 */
public class NoteTest {

    ArrayList<Note> notes = new ArrayList<>();

    @Test
    public void testNoteGeneratorAddNote() {
        notes.add(new Note());
        Assert.assertEquals(1, notes.size());
    }

    @Test
    public void testNoteGeneratorSetterName() {
        Note aFourNote = new Note();
        aFourNote.setName("A");
        Assert.assertEquals("A", aFourNote.getName());
    }

    @Test
    public void testNoteGeneratorSetterValue() {
        Note aFourNote = new Note();
        aFourNote.setValue(4.0);
        Assert.assertEquals(4.0, aFourNote.getValue());
    }

}
