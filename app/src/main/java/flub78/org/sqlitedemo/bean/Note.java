package flub78.org.sqlitedemo.bean;

import java.io.Serializable;

/**
 * The object handled both internally by the application and by the persistent layer
 */
public class Note implements Serializable {

    private int noteId;
    private String noteTitle;
    private String noteContent;

    /**
     * Constructor
     */
    public Note()  {

    }

    /**
     * Constructor with parameters
     * @param noteTitle
     * @param noteContent
     */
    public Note(String noteTitle, String noteContent) {
        this.noteTitle= noteTitle;
        this.noteContent= noteContent;
    }

    /**
     * Constructor with noteId to retrieve the object from database
     * @param noteId
     * @param noteTitle
     * @param noteContent
     */
    public Note(int noteId, String noteTitle, String noteContent) {
        this.noteId= noteId;
        this.noteTitle= noteTitle;
        this.noteContent= noteContent;
    }

    /**
     * Getters and settters
     */

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }


    @Override
    public String toString()  {
        return this.noteTitle;
    }
}
