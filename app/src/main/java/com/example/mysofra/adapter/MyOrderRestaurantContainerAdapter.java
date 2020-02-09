package com.example.mysofra.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyOrderRestaurantContainerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments=new ArrayList<>();
    private List<String > titls=new ArrayList<>();

    public MyOrderRestaurantContainerAdapter(@NonNull FragmentManager fm, List<Fragment> fragments, List<String> titls) {
        super(fm);
        this.fragments = fragments;
        this.titls = titls;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titls.get(position);
    }
}
