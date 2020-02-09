package com.example.mysofra.ui.fragment.client.homeFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mysofra.R;
import com.example.mysofra.adapter.ShowRestaurantsContainerAdapter;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.ui.fragment.BaseFragment;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowRestaurantsContainerFragment extends BaseFragment {


    @BindView(R.id.fragment_show_restaurants_container_tablayout)
    TabLayout tablayout;
    @BindView(R.id.fragment_show_restaurants_containerL_vp_page_containar)
    ViewPager VpPageContainar;
    Unbinder unbinder;

    ShowRestaurantsContainerAdapter resAdater;
    public int id;


    public ShowRestaurantsContainerFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_restaurants_container, container, false);
        unbinder = ButterKnife.bind(this, view);
        setUpActivity();
        resAdater = new ShowRestaurantsContainerAdapter(getChildFragmentManager(), id);
        VpPageContainar.setAdapter(resAdater);
        tablayout.setupWithViewPager(VpPageContainar);


        return view;
    }

}
