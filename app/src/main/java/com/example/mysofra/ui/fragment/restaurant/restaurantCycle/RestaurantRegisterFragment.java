package com.example.mysofra.ui.fragment.restaurant.restaurantCycle;


import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.city.City;
import com.example.mysofra.data.model.city.CityDatum;
import com.example.mysofra.data.model.regionByCityId.RegionByCityId;
import com.example.mysofra.data.model.regionByCityId.RegionByCityIdDatum;
import com.example.mysofra.helper.InternetState;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mysofra.helper.HelperMethod.customToast;
import static com.example.mysofra.helper.HelperMethod.dismissProgressDialog;
import static com.example.mysofra.helper.HelperMethod.showProgressDialog;
import static com.example.mysofra.helper.Validation.isValidEmail;
import static com.example.mysofra.helper.Validation.setConfirmPassword;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantRegisterFragment extends Fragment {


    @BindView(R.id.fragment_restaurant_register_edt_restourantname)
    EditText EdtRestourantname;
    @BindView(R.id.fragment_restaurant_register_edt_email)
    EditText EdtEmail;
    @BindView(R.id.fragment_restaurant_register_sp_city)
    Spinner SpCity;
    @BindView(R.id.fragment_restaurant_register_sp_district)
    Spinner SpDistrict;
    @BindView(R.id.fragment_restaurant_register_edt_passewrd)
    EditText EdtPassewrd;
    @BindView(R.id.fragment_restaurant_register_edt_passewrd_confirm)
    EditText EdtPassewrdConfirm;
    @BindView(R.id.fragment_restaurant_register_edt_minimum_order)
    EditText EdtMinimumOrder;
    @BindView(R.id.fragment_restaurant_register_delivery_charge)
    EditText EdtDeliveryCharge;
    @BindView(R.id.fragment_restaurant_register_btn_contnue)
    Button BtnContnue;
    @BindView(R.id.fragment_restaurant_registert_edt_Duration_arrival)
    EditText EdtDurationArrival;
    @BindView(R.id.fragment_restaurant_register_linear_district)
    LinearLayout LinearDistrict;
    private String name;
    private String email;
    private String duration_time;
    private String password;
    private String confirm_password;
    private String minimumOrder;
    private String deliveryCharge;
    private List<CityDatum> cityData;
    private List<RegionByCityIdDatum> districtData;
    private ArrayList<String> cityName;
    private ArrayList<String> cityId;
    private ArrayList<String> districtId;
    private ArrayList<String> districtIdName;
    private String city_id;
    private String district_Id;
    private ContinuRestaurantRegisterFragment continuRestaurantRegisterFragment;
    Unbinder unbinder;

    public RestaurantRegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_restaurant_register, container, false);
        unbinder = ButterKnife.bind(this, view);
        continuRestaurantRegisterFragment = new ContinuRestaurantRegisterFragment();
        LinearDistrict.setVisibility(View.GONE);
        cityData = new ArrayList<>();
        districtData = new ArrayList<>();
        districtData = new ArrayList<>();
        cityName = new ArrayList<>();
        cityId = new ArrayList<>();
        districtId = new ArrayList<>();
        districtIdName = new ArrayList<>();
        fillCity();


        return view;
    }

    private void fillCity() {
        cityData = new ArrayList<>();
        if (InternetState.isConnected(getContext())) {
         //   showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().getCity().enqueue(new Callback<City>() {
                @Override
                public void onResponse(Call<City> call, Response<City> response) {
                    try {
                        dismissProgressDialog();
                        if (response.body().getStatus() == 1) {
                            cityData = response.body().getData().getData();
                            cityId.add("0");
                            cityName.add(getResources().getString(R.string.cityName));

                            for (int i = 0; i < cityData.size(); i++) {
                                cityName.add(cityData.get(i).getName());
                                cityId.add(cityData.get(i).getId().toString());
                            }
                            ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, cityName);
                            SpCity.setAdapter(arrayAdapter);
                            SpCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    city_id = cityId.get(position);
                                    LinearDistrict.setVisibility(View.VISIBLE);
                                    districtData = new ArrayList<>();
                                    districtIdName = new ArrayList<>();
                                    districtId = new ArrayList<>();
                                    filldistrict(city_id);
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });


                        }
                    } catch (Exception e) {
                        dismissProgressDialog();
                        Log.d("mmmmmm", e.toString() + response.body().getMsg());
                    }
                }

                @Override
                public void onFailure(Call<City> call, Throwable t) {
                    dismissProgressDialog();
                    customToast(getActivity(), t.getMessage(), false);
                }
            });
        } else customToast(getActivity(), getResources().getString(R.string.offline), false);
    }

    private void filldistrict(String id) {
        districtData = new ArrayList<>();
        if (InternetState.isConnected(getContext())) {
            RetrofitSofra.getInstance().getRegionByCityId(Integer.parseInt(city_id)).enqueue(new Callback<RegionByCityId>() {
                @Override
                public void onResponse(Call<RegionByCityId> call, Response<RegionByCityId> response) {
                    try {
                        if (response.body().getStatus() == 1) {
                            districtData = response.body().getData().getData();
                            districtId.add("0");
                            districtIdName.add(getResources().getString(R.string.districtName));

                            for (int i = 0; i < districtData.size(); i++) {
                                districtIdName.add(districtData.get(i).getName());
                                districtId.add(districtData.get(i).getId().toString());
                            }
                            ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, districtIdName);
                            SpDistrict.setAdapter(arrayAdapter);
                            SpDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    district_Id = districtId.get(position);

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                        } else {
                            customToast(getActivity(), response.body().getMsg(), true);
                        }
                    } catch (Exception e) {
                        customToast(getActivity(), e.getMessage(), true);
                    }
                }

                @Override
                public void onFailure(Call<RegionByCityId> call, Throwable t) {
                    customToast(getActivity(), getResources().getString(R.string.error), true);
                }
            });
        } else customToast(getActivity(), getResources().getString(R.string.offline), false);
    }


    @OnClick(R.id.fragment_restaurant_register_btn_contnue)
    public void onViewClicked() {
        name = EdtRestourantname.getText().toString().trim();
        email = EdtEmail.getText().toString().trim();
        duration_time = EdtDurationArrival.getText().toString().trim();
        password = EdtPassewrd.getText().toString().trim();
        confirm_password = EdtPassewrdConfirm.getText().toString().trim();
        minimumOrder = EdtMinimumOrder.getText().toString().trim();
        deliveryCharge = EdtDeliveryCharge.getText().toString().trim();
        if (name.isEmpty()) {
            EdtRestourantname.setFocusable(true);
            customToast(getActivity(), getResources().getString(R.string.enter_name), false);
            return;
        }
        if (email.isEmpty()) {
            customToast(getActivity(), getResources().getString(R.string.email), false);
            return;
        }
        if (!isValidEmail(email)) {
            EdtEmail.setFocusable(true);
            return;
        }
        if (!TextUtils.isDigitsOnly(duration_time)) {
            EdtDurationArrival.setFocusable(true);
            return;
        }


        if (!setConfirmPassword(getActivity(), password, confirm_password)) {
            EdtPassewrdConfirm.setFocusable(true);
            return;

        }
        if (!TextUtils.isDigitsOnly(minimumOrder)) {
            EdtMinimumOrder.setFocusable(true);
            return;
        }
        if (!TextUtils.isDigitsOnly(deliveryCharge)) {
            EdtDeliveryCharge.setFocusable(true);
            return;
        }
        continueRegister(name, email, duration_time, district_Id, password, confirm_password, minimumOrder, deliveryCharge);
    }

    private void continueRegister(String name, String email, String duration_time, String district_Id, String password, String confirm_password
            , String minimumOrder, String deliveryCharge) {

        continuRestaurantRegisterFragment.name = name;
        continuRestaurantRegisterFragment.email = email;
        continuRestaurantRegisterFragment.district_Id = district_Id;
        continuRestaurantRegisterFragment.password = password;
        continuRestaurantRegisterFragment.confirm_password = confirm_password;
        continuRestaurantRegisterFragment.minimumOrder = minimumOrder;
        continuRestaurantRegisterFragment.deliveryCharge = deliveryCharge;
        continuRestaurantRegisterFragment.duration_time = duration_time;

    }

}
