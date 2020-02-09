package com.example.mysofra.ui.fragment.restaurant;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.restaurantCommissions.RestaurantCommissions;
import com.example.mysofra.data.model.restaurantCommissions.RestaurantCommissionsData;
import com.example.mysofra.data.model.restaurantsWithFiltre.RestaurantsWithFiltre;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.helper.InternetState;
import com.example.mysofra.ui.fragment.BaseFragment;
import com.example.mysofra.ui.fragment.restaurant.RestaurantMyCategoriesFragmet;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mysofra.helper.HelperMethod.customToast;
import static com.example.mysofra.helper.HelperMethod.dismissProgressDialog;
import static com.example.mysofra.helper.HelperMethod.showProgressDialog;
import static com.example.mysofra.helper.constant.RESTAURANT_API_TOKEN;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommissionsFragment extends BaseFragment {


    @BindView(R.id.fragment_commission_tv_description)
    TextView tvDescription;
    @BindView(R.id.fragment_commission_tv_restaurant_sale)
    TextView tvRestaurantSale;
    @BindView(R.id.fragment_commission_tv_application_commissions)
    TextView tvApplicationCommissions;
    @BindView(R.id.fragment_commission_tv_what_is_paid)
    TextView tvWhatIsPaid;
    @BindView(R.id.fragment_commission_tv_residual)
    TextView tvResidual;
    @BindView(R.id.fragment_commission_tv_account1)
    TextView tvAccount1;
    @BindView(R.id.fragment_commission_tv_account2)
    TextView tvAccount2;
    private Unbinder unbind;
    private String api_token =RESTAURANT_API_TOKEN;
    private RestaurantCommissionsData commissionsData = new RestaurantCommissionsData();

    public CommissionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_commissions, container, false);
        unbind = ButterKnife.bind(this, view);
        setUpActivity();
        getCommission(api_token);

        return view;
    }

    private void getCommission(String api_token) {
        if (InternetState.isConnected(getContext())) {

            showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().getCommissions(api_token).enqueue(new Callback<RestaurantCommissions>() {
                @Override
                public void onResponse(Call<RestaurantCommissions> call, Response<RestaurantCommissions> response) {
                    try {
                        dismissProgressDialog();
                        if (response.body().getStatus() == 1) {
                            commissionsData = (response.body().getData());
//                            "count": 76,
//                                    "total": "218208.00",
//                                    "commissions": "21500.80",
//                                    "payments": "25877.00",
//                                    "net_commissions": -4376.20000000000072759576141834259033203125,
//                                    "commission": "0.10"
//                            tvDescription.setText(response.body().getMsg());
//                            tvAccount2
//                           tvAccount1
//                            tvApplicationCommissions.setText(commissionsData.getCommissions());
//                            tvRestaurantSale
//                            tvResidual
//                            tvWhatIsPaid
//                            tvResidual.setText(commissionsData.get);


                        }
                    } catch (Exception e) {
                        dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), false);
                    }


                }

                @Override
                public void onFailure(Call<RestaurantCommissions> call, Throwable t) {
                    dismissProgressDialog();
                    customToast(getActivity(), getResources().getString(R.string.error), true);

                }
            });
        } else customToast(getActivity(), getResources().getString(R.string.offline), false);

    }


}
