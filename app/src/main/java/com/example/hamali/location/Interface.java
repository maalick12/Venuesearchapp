package com.example.hamali.location;

import java.util.List;

/**
 * Created by hamali on 14/08/2017.
 */

public interface Interface {
    interface  venue_view{
        void showresult(List result_venue);
        void location();

    }
    interface  venue_presentor{
        void result(List result);
        void process (String keyword);
        void locresult(String userloc);
    }
    interface venue_foursquare{
        void searchvenue(String userinput, String cloc);
    }
}
