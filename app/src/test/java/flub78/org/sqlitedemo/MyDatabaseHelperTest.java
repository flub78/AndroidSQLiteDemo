package flub78.org.sqlitedemo;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

/**
 * Created by flub78 on 06/03/2021.
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Config.OLDEST_SDK})
public class MyDatabaseHelperTest extends TestCase {

    private final String TAG = "MyDatabaseHelperTest";

    MyDatabaseHelper dbh;

    @Before
    public void setUp() throws Exception {
        super.setUp();

        ShadowLog.stream = System.out;

        Log.i(TAG, "setup (((");
        Application myapp = RuntimeEnvironment.application;
        dbh = new MyDatabaseHelper(myapp);

        assertNotNull(this.dbh);
    }

    @After
    public void tearDown() throws Exception {
        Log.i(TAG, "))) teardown");
        dbh = null;
    }

    @Test
    public void testCreateDefaultNotesIfNeed() {
        Log.i(TAG, "testCreateDefaultNotesIfNeed");
        assertEquals(1, 1);
    }

    public void testAddNote() {
    }

    public void testGetNote() {
    }

    @Test
    public void testGetAllNotes() {
        Log.i(TAG, "testGetAllNotes");
        assertNotNull(this.dbh);
    }

    @Test
    public void testGetNotesCount() {

        Log.i(TAG, "testGetNotesCount");

        int count = this.dbh.getNotesCount();

        Log.i(TAG, "count = " + count);
        assertEquals(0, count);
    }

    public void testUpdateNote() {
    }

    public void testDeleteNote() {
    }
}