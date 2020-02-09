package com.example.mysofra.ui.fragment.client.homeFragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;

import com.example.mysofra.data.model.restaurntDetails.RestaurntDetails;
import com.example.mysofra.helper.InternetState;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mysofra.helper.HelperMethod.customToast;
import static com.example.mysofra.helper.HelperMethod.dismissProgressDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public class GetRestaurantsDetailsFragment extends Fragment {


    @BindView(R.id.fragment_get_restaurants_details_txt_status)
    TextView DetailsTxtStatus;
    @BindView(R.id.fragment_get_restaurants_details_txt_city)
    TextView DetailsTxtCity;
    @BindView(R.id.fragment_get_restaurants_details_txt_district)
    TextView DetailsTxtDistrict;
    @BindView(R.id.fragment_get_restaurants_details_txt_minimum)
    TextView DetailsTxtMinimum;
    @BindView(R.id.fragment_get_restaurants_details_txt_cost)
    TextView DetailsTxtCost;
    // private String name;
    private String status;
    private String city;
    private String district;
    private String minimum;
    private String deliveryCost;
    //  private String imageUrl;
    public int restaurant_idd;
    Unbinder unbinder;


    public GetRestaurantsDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_get_restaurants_details, container, false);
        unbinder = ButterKnife.bind(this, view);
        getDetails(restaurant_idd);
        return view;
    }

    private void getDetails(int restaurantId) {

        if (InternetState.isConnected(getContext())) {

            // showProgressDialog(getActivity(), getString(R.string.registerr));
            RetrofitSofra.getInstance().getRestaurntDetails(restaurantId).enqueue(new Callback<RestaurntDetails>() {
                @Override
                public void onResponse(Call<RestaurntDetails> call, Response<RestaurntDetails> response) {
                    try {
                        if (response.body().getStatus() == 1) {
                            //   dismissProgressDialog();
                            status = response.body().getData().getAvailability();
                            city = response.body().getData().getRegion().getCity().getName();
                            district = response.body().getData().getRegion().getName();
                            minimum = response.body().getData().getMinimumCharger();
                            deliveryCost = response.body().getData().getDeliveryCost();
                            setDetails();
                            //Log.i("ttttttttttttt",status);

                        }
                    } catch (Exception e) {
                        // dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), true);
                    }

                }

                @Override
                public void onFailure(Call<RestaurntDetails> call, Throwable t) {
                    // dismissProgressDialog();
                    Log.e("in restaurants failure", "in restaurants details failure" + t.toString());
                    customToast(getActivity(), getResources().getString(R.string.error), true);
                }
            });


        } else customToast(getActivity(), getResources().getString(R.string.offline), false);
    }

    private void setDetails() {
        DetailsTxtStatus.setText(status);
        DetailsTxtCity.setText(city);
        DetailsTxtDistrict.setText(district);
        DetailsTxtMinimum.setText(minimum);
        DetailsTxtCost.setText(deliveryCost);

    }
}
