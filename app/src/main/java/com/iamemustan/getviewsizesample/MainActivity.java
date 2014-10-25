package com.iamemustan.getviewsizesample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewTreeObserver(View v) {
        getFragmentManager().beginTransaction()
                .add(R.id.frame, new SampleFragment())
                .addToBackStack(null)
                .commit();
    }

    public void uiThread(View v) {
        getFragmentManager().beginTransaction()
                .add(R.id.frame, new SampleFragment2())
                .addToBackStack(null)
                .commit();
    }
}
