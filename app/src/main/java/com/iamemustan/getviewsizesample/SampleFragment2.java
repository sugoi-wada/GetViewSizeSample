package com.iamemustan.getviewsizesample;

import android.app.Fragment;
import android.os.*;
import android.util.Log;
import android.view.*;

public class SampleFragment2 extends Fragment {
    private View mImageView;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sample, container, false);
        mImageView = view.findViewById(R.id.imageView);
        return view;
    }

    @Override public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(SampleFragment2.class.getName(), "w = " + mImageView.getMeasuredWidth() + " h = " + mImageView.getMeasuredHeight());

        mHandler.post(new Runnable() {
            @Override public void run() {
                Log.d(SampleFragment2.class.getName(), "w = " + mImageView.getMeasuredWidth() + " h = " + mImageView.getMeasuredHeight());
            }
        });
    }
}
