package com.example.mysofra.ui.fragment.restaurant;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.local.SharedPreferencesManger;
import com.example.mysofra.data.model.city.City;
import com.example.mysofra.data.model.city.CityDatum;
import com.example.mysofra.data.model.regionByCityId.RegionByCityId;
import com.example.mysofra.data.model.regionByCityId.RegionByCityIdDatum;
import com.example.mysofra.data.model.restaurntLogin.RestaurntLoginUser;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.helper.InternetState;
import com.example.mysofra.ui.fragment.BaseFragment;
import com.squareup.picasso.Picasso;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.AlbumFile;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mysofra.helper.HelperMethod.customToast;
import static com.example.mysofra.helper.HelperMethod.selectImage;
import static com.example.mysofra.helper.Validation.setEmailValidation;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditProfileRestaurant extends BaseFragment {


    @BindView(R.id.fragment_edit_profile_restaurant_img_imgecricle)
    CircleImageView imgecricle;
    @BindView(R.id.fragment_edit_profile_restaurant_edt_name)
    EditText edtName;
    @BindView(R.id.fragment_edit_profile_restaurant_edt_email)
    TextView edtEmail;
    @BindView(R.id.fragment_edit_profile_restaurant_spn_spiner_city)
    Spinner spinerCity;
    @BindView(R.id.fragment_edit_profile_restaurant_spn_sinner_region)
    Spinner spinnerRegion;
    @BindView(R.id.fragment_edit_profile_restaurant_edt_delivery_cost)
    EditText edtdeliverycost;
    @BindView(R.id.fragment_edit_profile_restaurant_btn_continue)
    Button btnContinue;
    private List<CityDatum> cityData;
    private List<RegionByCityIdDatum> districtData;
    private ArrayList<String> cityName;
    private ArrayList<Integer> cityId;
    private ArrayList<Integer> districtId;
    private ArrayList<String> districtIdName;
    private int city_id;
    private String district_Id;

    private RestaurntLoginUser restaurantData;
    private Unbinder nubind;
    private String imgUrl;

    public EditProfileRestaurant() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_profile_restaurant, container, false);
        nubind = ButterKnife.bind(this, view);
        setUpActivity();
        restaurantData = SharedPreferencesManger.loadRestaurantData(getActivity());
        cityData = new ArrayList<>();
        districtData = new ArrayList<>();
        cityName = new ArrayList<>();
        cityId = new ArrayList<>();
        districtId = new ArrayList<>();
        districtIdName = new ArrayList<>();
        fillData();
        fillCity();

        return view;
    }

    private void fillData() {
        edtName.setText(restaurantData.getName());
        edtEmail.setText(restaurantData.getEmail());
        edtdeliverycost.setText(restaurantData.getDeliveryCost());
        Picasso.with(getContext()).load(restaurantData.getPhotoUrl()).into(imgecricle);

    }

    private void fillCity() {
        cityData = new ArrayList<>();
        RetrofitSofra.getInstance().getCity().enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                if (response.body().getStatus() == 1) {
                    cityData = response.body().getData().getData();
                    cityId.add(0);
                    cityName.add(getResources().getString(R.string.cityName));

                    for (int i = 1; i < cityData.size(); i++) {
                        cityName.add(cityData.get(i).getName());
                        cityId.add(cityData.get(i).getId());
                    }
                    ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, districtIdName);
                    spinerCity.setAdapter(arrayAdapter);
                    spinerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            city_id = cityId.get(position);
                            districtId=new ArrayList<>();
                            districtIdName=new ArrayList<>();
                            districtData=new ArrayList<>();

                            filldistrict();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });


                }
            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {
                customToast(getActivity(), t.getMessage(), false);
            }
        });

    }

    private void filldistrict() {
        if (InternetState.isConnected(getContext())) {
            RetrofitSofra.getInstance().getRegionByCityId(city_id).enqueue(new Callback<RegionByCityId>() {
                @Override
                public void onResponse(Call<RegionByCityId> call, Response<RegionByCityId> response) {
                    try {
                        if (response.body().getStatus() == 1) {
                            districtData = response.body().getData().getData();
                            districtId.add(0);
                            districtIdName.add(getResources().getString(R.string.districtName));

                            for (int i = 1; i < districtData.size(); i++) {
                                districtIdName.add(districtData.get(i).getName());
                                districtId.add(districtData.get(i).getId());
                            }
                            ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, cityName);
                            spinnerRegion.setAdapter(arrayAdapter);
                            spinnerRegion.setSelection(restaurantData.getId());
                            spinnerRegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    district_Id = districtId.get(position).toString();
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


    @OnClick({R.id.fragment_edit_profile_restaurant_img_imgecricle, R.id.fragment_edit_profile_restaurant_btn_continue})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_edit_profile_restaurant_img_imgecricle:

                selectImage(getContext(), 3, new Action<ArrayList<AlbumFile>>() {
                    @Override
                    public void onAction(@NonNull ArrayList<AlbumFile> result) {
                        imgUrl = result.get(0).getPath();
                        Picasso.with(getContext()).load(imgUrl).error(R.drawable.rror_black_24dp)
                                .placeholder(R.drawable.upload_24dp).fit().into(imgecricle);
                    }
                });

                break;
            case R.id.fragment_edit_profile_restaurant_btn_continue:
                String email = edtEmail.getText().toString().trim();
                if (email.isEmpty()) {
                    edtEmail.setFocusable(true);
                    customToast(getActivity(), getResources().getString(R.string.email), false);
                    return;
                }
                if (!setEmailValidation(getActivity(), email)){
                    customToast(getActivity(), getResources().getString(R.string.invalid_Email), true);
                    return;
                }
                String name = edtName.getText().toString().trim();
                if (name.isEmpty()) {
                    edtName.setFocusable(true);
                    HelperMethod.customToast(getActivity(), getActivity().getResources().getString(R.string.enter_name), false);
                    return;
                }
                String deliveryCoast=edtdeliverycost.getText().toString().trim();
                if (edtdeliverycost==null) {
                    edtName.setFocusable(true);
                    HelperMethod.customToast(getActivity(), getActivity().getResources().getString(R.string.enter_ccoast), false);
                    return;
                }
                EditResProfile2Fragment editResProfile2Fragment=new EditResProfile2Fragment();
                editResProfile2Fragment.name=name;
                editResProfile2Fragment.delivery_cost=deliveryCoast;
                editResProfile2Fragment.email=email;
                editResProfile2Fragment.regionId=district_Id;
               editResProfile2Fragment.imgUrl= imgUrl;
                break;

        }
    }

}
