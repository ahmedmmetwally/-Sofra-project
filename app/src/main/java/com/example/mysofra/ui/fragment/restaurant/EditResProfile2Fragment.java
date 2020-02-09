package com.example.mysofra.ui.fragment.restaurant;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.fragment.app.Fragment;

import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.local.SharedPreferencesManger;
import com.example.mysofra.data.model.restaurantEditProfile.RestaurantEditProfile;
import com.example.mysofra.data.model.restaurntLogin.RestaurntLoginUser;
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
import static com.example.mysofra.helper.Validation.isValidPhone;
import static com.example.mysofra.helper.constant.RESTAURANT_API_TOKEN;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditResProfile2Fragment extends BaseFragment {
    public String name;
    public String email;
    public String delivery_cost;
    public String regionId;
    public String imgUrl;
    @BindView(R.id._fragment_edit_restaurant_profile_continu_edt_minimum_charg)
    EditText edtminimum_charg;
    @BindView(R.id._fragment_edit_restaurant_profile_continu_edt_time)
    EditText edtTime;
    @BindView(R.id._fragment_edit_restaurant_profile_continusw_switch)
    Switch swSwitch;
    @BindView(R.id._fragment_edit_restaurant_profile_continu_edt_phone)
    EditText edtPhone;
    @BindView(R.id._fragment_edit_restaurant_profile_continu_edit_watts)
    EditText editWatts;
    @BindView(R.id._fragment_edit_restaurant_profile_continubtn_continue)
    Button btnContinue;
    private String api_token =RESTAURANT_API_TOKEN;
    private RestaurntLoginUser restaurantData;
    private Unbinder unbind;
    private String avilabilty;
    private String phone;
    private String timee;
    private String minimumCharg;
    private String watts;


    public EditResProfile2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_restaurant_profile_continu, container, false);
        unbind = ButterKnife.bind(this, view);
        setUpActivity();
        restaurantData = SharedPreferencesManger.loadRestaurantData(getActivity());
        setData();

        return view;
    }

    private void setData() {
        edtminimum_charg.setText(restaurantData.getMinimumCharger());
        edtTime.setText(restaurantData.getDeliveryTime());
        if (restaurantData.getAvailability() == "open") {
            swSwitch.setChecked(true);
        } else swSwitch.setChecked(false);
        edtPhone.setText(restaurantData.getPhone());
        editWatts.setText(restaurantData.getWhatsapp());

    }

    @OnClick({R.id._fragment_edit_restaurant_profile_continusw_switch, R.id._fragment_edit_restaurant_profile_continubtn_continue})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id._fragment_edit_restaurant_profile_continusw_switch:
                if (swSwitch.isChecked() == true) {
                    avilabilty = "open";
                } else avilabilty = "close";
                break;
            case R.id._fragment_edit_restaurant_profile_continubtn_continue:
                minimumCharg = edtminimum_charg.getText().toString().trim();
                if (minimumCharg == null) {
                    edtminimum_charg.setFocusable(true);
                    HelperMethod.customToast(getActivity(), getActivity().getResources().getString(R.string.enter_minimum_charg), false);
                    return;
                }
                timee = edtTime.getText().toString().trim();
                if (timee == null) {
                    edtTime.setFocusable(true);
                    HelperMethod.customToast(getActivity(), getActivity().getResources().getString(R.string.enter_minimum_charg), false);
                    return;
                }
                phone = edtPhone.getText().toString().trim();
                if (!isValidPhone(phone)) {
                    edtPhone.setFocusable(true);
                    customToast(getActivity(), getResources().getString(R.string.re_enter_phone), false);
                    return;
                }
                watts = editWatts.getText().toString().trim();
                if (!isValidPhone(phone)) {
                    editWatts.setFocusable(true);
                    customToast(getActivity(), getResources().getString(R.string.please_enter_watts_num), false);
                    return;
                }
                editRestaurantData();
                HelperMethod.ReplaceFragment(getFragmentManager(), new RestaurantMyCategoriesFragmet()
                        , R.id.activity_home_client_frame_fragment, null, null);
                break;
        }
    }

    private void editRestaurantData() {
        if (InternetState.isConnected(getContext())) {
            RetrofitSofra.getInstance().eidtProfileRestaurant(email, name, phone, regionId,
                    delivery_cost, minimumCharg, avilabilty, imgUrl, api_token, timee, watts).enqueue(new Callback<RestaurantEditProfile>() {
                @Override
                public void onResponse(Call<RestaurantEditProfile> call, Response<RestaurantEditProfile> response) {
                    try {
                        if (response.body().getStatus() == 1) {
                            HelperMethod.customToast(getActivity(), response.body().getMsg(), false);

                        }
                    } catch (Exception e) {
                        dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), false);
                    }
                }

                @Override
                public void onFailure(Call<RestaurantEditProfile> call, Throwable t) {
                    customToast(getActivity(), getActivity().getResources().getString(R.string.error), true);
                }
            });
        } else {
            customToast(getActivity(), getActivity().getResources().getString(R.string.offline), false);
        }
    }


}
