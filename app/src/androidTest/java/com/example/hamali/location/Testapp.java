package com.example.hamali.location;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by hamali on 15/08/2017.
 */

@RunWith(AndroidJUnit4.class)
public class Testapp {
    private Viewinterfacetest viewtest;
    private FoursquareTest fourtest;
    private Interface.venue_presentor presentor;
    @Test
    public void Testappfunction() {
        viewtest = new Viewinterfacetest();
        presentor = new Presenter(viewtest);
        viewtest.presentor = presentor;
        fourtest = new FoursquareTest();
        fourtest.presentor = presentor;
        presentor.process("coffee");
    }

}


