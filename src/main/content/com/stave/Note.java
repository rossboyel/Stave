package content.com.stave;

import javafx.scene.image.Image;

import java.util.ArrayList;

/**
 * This class represents a note that will be used for the random note generator. The ArrayList
 * holds all the notes that will be used to generate a random note.
 */
public class Note {
    private String name;
    private Double value;
    private Image image;
    private ArrayList<Note> notes;

    public Note() {
        this.name = "";
        this.value = 0.0;
        this.image = null;
        this.notes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    /**
     * Generates the note objects and fills their data fields. Adds the note objects to an ArrayList.
     */
    public void noteGenerator() {
        Note aFourNote = new Note();
        aFourNote.setName("A");
        aFourNote.setValue(4.0);
        aFourNote.setImage(new Image(getClass().getResource("/NoteImages/aFourBeats.png").toString()));

        Note bThreeNote = new Note();
        bThreeNote.setName("B");
        bThreeNote.setValue(3.0);
        bThreeNote.setImage(new Image(getClass().getResource("/NoteImages/bThreeBeats.png").toString()));

        Note eFourNote = new Note();
        eFourNote.setName("E");
        eFourNote.setValue(4.0);
        eFourNote.setImage(new Image(getClass().getResource("/NoteImages/eFourBeats.png").toString()));

        Note gFourNote = new Note();
        gFourNote.setName("G");
        gFourNote.setValue(4.0);
        gFourNote.setImage(new Image(getClass().getResource("/NoteImages/gFourBeats.png").toString()));

        Note gOneNote = new Note();
        gOneNote.setName("G");
        gOneNote.setValue(1.0);
        gOneNote.setImage(new Image(getClass().getResource("/NoteImages/gOneBeat.png").toString()));

        notes = new ArrayList<>();
        notes.add(bThreeNote);
        notes.add(aFourNote);
        notes.add(eFourNote);
        notes.add(gFourNote);
        notes.add(gOneNote);
    }
}
