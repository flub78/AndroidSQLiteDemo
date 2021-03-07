package flub78.org.sqlitedemo;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

import java.util.List;

import flub78.org.sqlitedemo.bean.Note;

/**
 * Created by flub78 on 06/03/2021.
 *
 * Unit test for MyDatabaseHelper
 *
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Config.OLDEST_SDK})
public class MyDatabaseHelperTest extends TestCase {

    private final String TAG = "MyDatabaseHelperTest";

    MyDatabaseHelper dbh;

    @Before
    public void setUp() throws Exception {
        // uncomment to see the logs on stdout
        ShadowLog.stream = System.out;

        super.setUp();

        Log.i(TAG, "setup (((");
        Application myapp = RuntimeEnvironment.application;
        dbh = new MyDatabaseHelper(myapp);

        assertNotNull(this.dbh);

        dbh.createDefaultNotesIfNeed();
    }

    @After
    public void tearDown() throws Exception {
        Log.i(TAG, "))) teardown");
        dbh.close();
    }

    @Test
    public void testAddNote() {
        Log.i(TAG, "testAddNote");

        int count = this.dbh.getNotesCount();

        final String TITLE3 = "Today";
        final String TEXT3 = "Go tothe market";
        final String TITLE4 = "Tomorrow";
        final String TEXT4 = "is another day";

        Note note3 = new Note(TITLE3, TEXT3);
        Note note4 = new Note(TITLE4, TEXT4);
        dbh.addNote(note3);
        dbh.addNote(note4);

        assertEquals(count + 2, dbh.getNotesCount());

        Note nb1 = dbh.getNote(3); // Note read back from DB
        assertEquals(TITLE3, nb1.getNoteTitle());
    }


    @Test
    public void testGetAllNotes() {
        Log.i(TAG, "testGetAllNotes");
        assertNotNull(this.dbh);

        List<Note> l = dbh.getAllNotes();

        assertEquals(2, l.size());

        Note n = l.get(1);

        Log.i(TAG, "content = " + n.getNoteContent());

        assertEquals("See Android SQLite Example in o7planning.org", n.getNoteContent());
        assertEquals("See Android ListView Example in o7planning.org", l.get(0).getNoteContent());
    }

    @Test
    public void testGetNotesCount() {

        Log.i(TAG, "testGetNotesCount");

        int count = this.dbh.getNotesCount();

        Log.i(TAG, "count = " + count);
        assertEquals(2, count);
    }

    @Test
    public void testUpdateNote() {
        Log.i(TAG, "testUpdateNote");

        Note n = new Note("Replaced title", "Replaced text");
        int count = dbh.getNotesCount();
        assertEquals(2, count);
        n.setNoteId(1);
        dbh.updateNote(n);
        assertEquals(2, dbh.getNotesCount());

        Note r = dbh.getNote(1);
        assertEquals("Replaced title", r.getNoteTitle());
        assertEquals("Replaced text", r.getNoteContent());

    }

    @Test
    public void testDeleteNote() {
        Log.i(TAG, "testDeleteNote");

        assertEquals(2, dbh.getNotesCount());
        Note n = dbh.getNote(1);
        dbh.deleteNote(n);

        assertEquals(1, dbh.getNotesCount());
        n = dbh.getNote(2);
        dbh.deleteNote(n);

        assertEquals(0, dbh.getNotesCount());

    }
}