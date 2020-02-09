package com.example.mysofra.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MyOrderClientContainerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragment;
    List<String>title;

    public MyOrderClientContainerAdapter(@NonNull FragmentManager fm, List<Fragment> fragmetn, List<String> title) {
        super(fm);
        this.fragment = fragmetn;
        this.title = title;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragment.get(position) ;
    }

    @Override
    public int getCount() {
        return fragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position) ;

    }
}
