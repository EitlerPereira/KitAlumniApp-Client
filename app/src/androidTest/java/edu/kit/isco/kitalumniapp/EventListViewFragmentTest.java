package edu.kit.isco.kitalumniapp;

import android.app.Fragment;

import android.app.FragmentTransaction;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;

import edu.kit.isco.kitalumniapp.fragments.EventListViewFragment;

/**
 * Created by Kristina on 21.3.2015 г..
 */
public class EventListViewFragmentTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity mainActivity;
    EventListViewFragment eventListViewFragment;

    public EventListViewFragmentTest(){
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mainActivity = getActivity();
        startFragment();
    }

    private void startFragment() {
        FragmentTransaction transaction = mainActivity.getFragmentManager().beginTransaction();
        eventListViewFragment = new EventListViewFragment();
        transaction.add(R.id.container, eventListViewFragment).commitAllowingStateLoss();
    }

    public void testPreConditions() {
        assertNotNull(mainActivity);
        assertNotNull(eventListViewFragment);
    }
}

