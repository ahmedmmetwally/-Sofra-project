package com.example.mysofra.ui.fragment.client.homeFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mysofra.R;
import com.example.mysofra.adapter.MyOrderClientContainerAdapter;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.ui.fragment.BaseFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MyOrderClientContainerFragment extends BaseFragment {


    @BindView(R.id.fragment_my_order_client_container_vp_viewpager)
    ViewPager ClientContainerVpViewpager;
    @BindView(R.id.fragment_my_order_client_container_tab_taplayout)
    TabLayout ClientContainerTabTaplayout;
    Unbinder unbinder;

    public MyOrderClientContainerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_order_client_container, container, false);
        unbinder = ButterKnife.bind(this, view);
        setUpActivity();
        List<Fragment> fragments = new ArrayList<>();
        List<String> titls = new ArrayList<>();
        fragments.add(new NewOrderclientFragment());
        fragments.add(new CurrentOrderclientFragment());
        fragments.add(new PreviousOrderclientFragment());
        titls.add(getString(R.string.new_orders));
        titls.add(getString(R.string.current_orders));
        titls.add(getString(R.string.recent_orders));

        MyOrderClientContainerAdapter myOrderClientContainerAdapter =
                new MyOrderClientContainerAdapter(getChildFragmentManager()
                        , fragments, titls);
        ClientContainerVpViewpager.setAdapter(myOrderClientContainerAdapter);
        ClientContainerTabTaplayout.setupWithViewPager(ClientContainerVpViewpager);

        return view;
    }
//    @Override
//    public void onBack() {
//        HelperMethod.ReplaceFragment(getFragmentManager(),new HomeFragmentt()
//                ,R.id.activity_home_client_frame_fragment,null,null);
//    }

}
