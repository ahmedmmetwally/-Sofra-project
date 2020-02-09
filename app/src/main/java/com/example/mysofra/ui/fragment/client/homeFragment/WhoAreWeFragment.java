package com.example.mysofra.ui.fragment.client.homeFragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mysofra.R;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.ui.fragment.BaseFragment;
import com.example.mysofra.ui.fragment.restaurant.restaurantCycle.MoreRestaurantFragment;

import static com.example.mysofra.helper.constant.USER_TYPE;

/**
 * A simple {@link Fragment} subclass.
 */
public class WhoAreWeFragment extends BaseFragment {


    public WhoAreWeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_who_are_we, container, false);
        setUpActivity();
        return view;
    }

}
