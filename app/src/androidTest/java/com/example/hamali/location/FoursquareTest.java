package com.example.hamali.location;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNull;

/**
 * Created by hamali on 15/08/2017.
 */

public class FoursquareTest implements Interface.venue_foursquare {

    public Interface.venue_presentor presentor;

    public void searchvenue(String userinput, String cloc) {

        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile" };

        List<String> items = new ArrayList<>();
        for (int i = 0; i < values.length; ++i) {
            items.add(values[i]);
        }

        presentor.result(items);
    }

}
