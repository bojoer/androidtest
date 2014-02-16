
import android.widget.Button;


import com.example.androidtest.MainActivity;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;


@RunWith(RobolectricTestRunner.class)
public class DummyTest {

    private MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity = Robolectric.buildActivity(MainActivity.class).create().get();
    }

    @Test
    public void pressingTheButtonShouldStartTheListActivity() throws Exception {
        mainActivity.getNumberOne().setText("1");
        mainActivity.getNumberTwo().setText("2");

        mainActivity.getCalculationButton().performClick();

        assertEquals(mainActivity.getTotal().getText().toString(), "Total = 3");
    }

    @Test
    public void testMissingFirstInput() throws Exception {
        mainActivity.getNumberOne().setText("");
        mainActivity.getNumberTwo().setText("2");

        mainActivity.getCalculationButton().performClick();

        assertEquals(mainActivity.getTotal().getText().toString(), "Total = 2");
        assertEquals(mainActivity.getNumberOne().getText().toString(), "0");
    }

    @Test
    public void testMissingSecondInput() throws Exception {
        mainActivity.getNumberOne().setText("1");
        mainActivity.getNumberTwo().setText("");

        mainActivity.getCalculationButton().performClick();

        assertEquals(mainActivity.getTotal().getText().toString(), "Total = 1");
        assertEquals(mainActivity.getNumberTwo().getText().toString(), "0");
    }

    @Test
    public void testMissingBothInputs() throws Exception {
        mainActivity.getNumberOne().setText("");
        mainActivity.getNumberTwo().setText("");

        mainActivity.getCalculationButton().performClick();

        assertEquals(mainActivity.getTotal().getText().toString(), "Total = 0");
        assertEquals(mainActivity.getNumberOne().getText().toString(), "0");
        assertEquals(mainActivity.getNumberTwo().getText().toString(), "0");
    }
}

