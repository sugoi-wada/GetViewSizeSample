package com.iamemustan.getviewsizesample;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.*;

public class SampleFragment extends Fragment {

    private View mImageView;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sample, container, false);
        mImageView = view.findViewById(R.id.imageView);
        return view;
    }

    @Override public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(SampleFragment.class.getName(),"w = " + mImageView.getMeasuredWidth() + " h = " + mImageView.getMeasuredHeight());

        ViewTreeObserver viewTreeObserver = mImageView.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    mImageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    mImageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

                Log.d(SampleFragment.class.getName(),"w = " + mImageView.getMeasuredWidth() + " h = " + mImageView.getMeasuredHeight());
            }
        });
    }
}
