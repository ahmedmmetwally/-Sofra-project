package com.example.mysofra.ui.fragment.restaurant;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mysofra.R;
import com.example.mysofra.adapter.MyOrderRestaurantContainerAdapter;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.ui.fragment.BaseFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyOrderRestaurantContainer extends BaseFragment {


    @BindView(R.id.fragment_my_order_restaurant_container_tab_tablayotu)
    TabLayout tabTablayotu;
    @BindView(R.id.fragment_my_order_restaurant_container_vp_viewpager)
    ViewPager vpViewpager;
   private List<Fragment> fragments;
   private List<String > titls;
   Unbinder unbinder;
    public MyOrderRestaurantContainer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_order_restaurant_container, container, false);
        unbinder= ButterKnife.bind(this,view);
        setUpActivity();

        List<Fragment> fragments=new ArrayList<>();
        titls=new ArrayList<>();
        String cancell = getResources().getString(R.string.cancel_order);
        String erroo = getResources().getString(R.string.offline);
        String order_is_confirm = getResources().getString(R.string.order_is_confirm);

        NewOrderRestaurantFragment newOrderRestaurantFragment=new NewOrderRestaurantFragment();
        fragments.add(newOrderRestaurantFragment);

        CurrentOrderRestaurantFragment currentOrderRestaurantFragment=new CurrentOrderRestaurantFragment();
        fragments.add(currentOrderRestaurantFragment);

        fragments.add(new PreviousOrderRestaurantFragment());

        titls.add(getString(R.string.new_orders));
        titls.add(getString(R.string.current_orders));
        titls.add(getString(R.string.recent_orders));
        MyOrderRestaurantContainerAdapter mAdapter=new MyOrderRestaurantContainerAdapter(getChildFragmentManager(),fragments,titls);
        vpViewpager.setAdapter(mAdapter);
        tabTablayotu.setupWithViewPager(vpViewpager);
        return view;
    }

}
