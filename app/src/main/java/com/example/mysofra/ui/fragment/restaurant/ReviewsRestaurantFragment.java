package com.example.mysofra.ui.fragment.restaurant;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mysofra.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewsRestaurantFragment extends Fragment {


    public ReviewsRestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification_restaurant, container, false);
    }

}
