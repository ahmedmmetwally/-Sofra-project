package com.example.mysofra.ui.fragment.client.homeFragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;

import com.example.mysofra.data.model.clientOfferDetails.ClientOfferDetails;
import com.example.mysofra.data.model.clientOfferDetails.ClientOfferDetailsData;
import com.example.mysofra.data.model.clientOffers.ClientOffersDatum;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.helper.InternetState;
import com.example.mysofra.ui.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mysofra.helper.HelperMethod.customToast;
import static com.example.mysofra.helper.HelperMethod.dismissProgressDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public class OfferDetailsFragment extends BaseFragment {

    @BindView(R.id.fragment_offer_details_txt_name)
    TextView txtName;
    @BindView(R.id.fragment_offer_details_txt_descrpition)
    TextView txtDescrpition;
    @BindView(R.id.fragment_offer_details_txt_from)
    TextView txtFrom;
    @BindView(R.id.fragment_offer_details_txt_to)
    TextView txtTo;
    @BindView(R.id.fragment_offer_details_btn_details)
    Button btnDetails;
    public ClientOffersDatum offersData;
    private ClientOfferDetailsData detailsData;
    private Unbinder unbind;

    public OfferDetailsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_offer_details, container, false);
        unbind = ButterKnife.bind(this, view);
        setUpActivity();
        getData();

        return view;
    }

    private void getData() {
        txtDescrpition.setText(offersData.getDescription().toString().trim());
        txtName.setText(offersData.getName().toString().trim());
        txtFrom.setText(getString(R.string.from) + ":" + offersData.getStartingAt().toString().trim());
        txtTo.setText(getString(R.string.to) + offersData.getEndingAt().toString().trim());
    }


    @OnClick(R.id.fragment_offer_details_btn_details)
    public void onViewClicked() {

    }

//    @Override
//    public void onBack() {
//        HelperMethod.ReplaceFragment(getFragmentManager(), new NewOffersClientFragment()
//                , R.id.activity_home_client_frame_fragment, null, null);
//    }
}
