package com.example.mysofra.ui.fragment.client.homeFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.mysofra.R;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.ui.AlertDialoug;
import com.example.mysofra.ui.fragment.BaseFragment;
import com.example.mysofra.ui.fragment.client.clientCycle.ChangPasswordFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends BaseFragment {


    @BindView(R.id.fragment_register_linl_offers)
    LinearLayout linlOffers;
    @BindView(R.id.fragment_register_linl_contact_us)
    LinearLayout linlContactUs;
    @BindView(R.id.fragment_register_linl_about_application)
    LinearLayout linlAboutApplication;
    @BindView(R.id.fragment_register_linl_chang_passewrd)
    LinearLayout linlChangPassewrd;
    @BindView(R.id.fragment_register_linl_register_out)
    LinearLayout linlRegisterOut;
    Unbinder unbinder;


    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        unbinder = ButterKnife.bind(this, view);
        setUpActivity();
        return view;
    }


    @OnClick({R.id.fragment_register_linl_offers, R.id.fragment_register_linl_contact_us,
            R.id.fragment_register_linl_about_application, R.id.fragment_register_linl_chang_passewrd,
            R.id.fragment_register_linl_register_out})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_register_linl_offers:

                HelperMethod.ReplaceFragment(getFragmentManager(), new NewOffersClientFragment(),
                        R.id.activity_home_client_frame_fragment, null, null);

                break;
            case R.id.fragment_register_linl_contact_us:
                HelperMethod.ReplaceFragment(getFragmentManager(), new ContactUsFragment(),
                        R.id.activity_home_client_frame_fragment, null, null);

                break;
            case R.id.fragment_register_linl_about_application:
                HelperMethod.ReplaceFragment(getFragmentManager(), new WhoAreWeFragment(),
                        R.id.activity_home_client_frame_fragment, null, null);

                break;
            case R.id.fragment_register_linl_chang_passewrd:
                HelperMethod.ReplaceFragment(getFragmentManager(), new ChangPasswordFragment(),
                        R.id.activity_home_client_frame_fragment, null, null);
                break;
            case R.id.fragment_register_linl_register_out:
                AlertDialoug cd = new AlertDialoug(getContext());
                cd.setCanceledOnTouchOutside(true);
                // cd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cd.show();
                break;

        }


    }


}


