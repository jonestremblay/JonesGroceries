package ca.jonestremblay.jonesgroceries.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import ca.jonestremblay.jonesgroceries.R;
import ca.jonestremblay.jonesgroceries.database.DatabaseHelper;
import ca.jonestremblay.jonesgroceries.entities.Category;
import ca.jonestremblay.jonesgroceries.entities.Product;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FlyersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FlyersFragment extends Fragment {

    public static Fragment newInstance() {
        FlyersFragment fragment = new FlyersFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        return inflater.inflate(R.layout.fragment_flyers, container, false);
    }
}