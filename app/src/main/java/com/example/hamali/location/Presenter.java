package com.example.hamali.location;

import android.util.Log;

import java.util.List;

/**
 * Created by hamali on 14/08/2017.
 */

public class Presenter implements Interface.venue_presentor {
    String input,str;
    private Interface.venue_view view;
    private Interface.venue_foursquare four;
    public Presenter(Interface.venue_view view) {
        this.view = view;
        four = new Foursqaure(this);
    }
    @Override
    public void result(List result) {

        view.showresult(result);
    }

    @Override
    public void process(String keyword) {
        input = new String(keyword);
        view.location();
    }
    public void locresult(String userloc){
        str = new String(userloc);
        four.searchvenue(input,str);
    }
}
