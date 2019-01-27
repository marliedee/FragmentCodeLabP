package org.pursuit.fragmentpractice;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import static android.widget.RatingBar.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragment extends Fragment {
    private static final int YES = 0;
    private static final int NO = 1;

    public static SimpleFragment newInstance() {
        return new SimpleFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView =
                inflater.inflate(R.layout.fragment_simple2, container, false);
        final RadioGroup radioGroup = rootView.findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radioGroup.findViewById(checkedId);
                int index = radioGroup.indexOfChild(radioButton);
                TextView textView = rootView.findViewById(R.id.fragment_header);

                switch (index) {
                    case YES: // User chose "Yes."
                        textView.setText(getString(R.string.radio1));
                        break;
                    case NO: // User chose "No."
                        textView.setText(getString(R.string.radio2));
                        break;
                    default: // No choice made.
                        // Do nothing.
                        break;
                }
            }
        });
//        final RatingBar ratingBar = rootView.findViewById(R.id.rating);
//        ratingBar.setOnRatingBarChangeListener(OnRatingBarChangeListener);

        return rootView;

    }

}
