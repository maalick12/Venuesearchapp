package com.example.hamali.location;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by hamali on 15/08/2017.
 */

public class Viewinterfacetest implements Interface.venue_view {
    public Interface.venue_presentor presentor;
    @Override
    public void showresult(List result_venue) {assertNotNull(result_venue);}
    @Override
    public void location() {
               presentor.locresult("123");
    }
}
