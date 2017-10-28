package iamdilipkumar.com.andrioddk.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import iamdilipkumar.com.andrioddk.R;

/**
 * A simple {@link Fragment} subclass.
 *
 * @author dilipkumar4813
 * @version 1.0
 * @since 28/10/2017
 */
public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

}
