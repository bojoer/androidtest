
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;


import com.example.androidtest.MainActivity;
import com.example.androidtest.R;
import com.example.androidtest.ResultActivity;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;
import org.robolectric.tester.android.view.TestMenuItem;

import static junit.framework.Assert.assertEquals;


@RunWith(RobolectricTestRunner.class)
public class DummyTest {

    private MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity = Robolectric.buildActivity(MainActivity.class).create().get();
    }

    private void performTest(String numberOne, String numberTwo, String expected) {
        mainActivity.getNumberOne().setText(numberOne);
        mainActivity.getNumberTwo().setText(numberTwo);

        MenuItem item = new TestMenuItem(R.id.add);

        mainActivity.onOptionsItemSelected(item);

        ShadowActivity shadowActivity = Robolectric.shadowOf(mainActivity);
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent = Robolectric.shadowOf(startedIntent);

        assertEquals(shadowIntent.getComponent().getClassName(), ResultActivity.class.getName());

        Bundle extras = shadowIntent.getExtras();
        assertEquals(extras.get("Total").toString(), expected);
    }

    @Test
    public void addBothNumbers() throws Exception {
        performTest("1", "2", "3");
    }

    @Test
    public void addMissingFirst() throws Exception {
        performTest("", "2", "2");
    }

    @Test
    public void addMissingSecond() throws Exception {
        performTest("1", "", "1");
    }

    @Test
    public void addMissingBoth() throws Exception {
        performTest("0", "", "0");
    }

}

