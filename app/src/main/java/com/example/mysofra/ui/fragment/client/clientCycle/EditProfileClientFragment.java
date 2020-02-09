package com.example.mysofra.ui.fragment.client.clientCycle;


import android.os.Bundle;
import android.util.Log;
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
import com.example.mysofra.adapter.SpinnerAdpter;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.local.SharedPreferencesManger;
import com.example.mysofra.data.model.city.City;
import com.example.mysofra.data.model.city.CityDatum;
import com.example.mysofra.data.model.clientlogin.ClientloginUser;
import com.example.mysofra.data.model.editProfileClient.EditProfileClient;
import com.example.mysofra.data.model.regionByCityId.RegionByCityId;
import com.example.mysofra.data.model.regionByCityId.RegionByCityIdDatum;
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

import static com.example.mysofra.helper.HelperMethod.ReplaceFragment;
import static com.example.mysofra.helper.HelperMethod.customToast;
import static com.example.mysofra.helper.HelperMethod.dismissProgressDialog;
import static com.example.mysofra.helper.HelperMethod.getDataSpinners;
import static com.example.mysofra.helper.HelperMethod.selectImage;
import static com.example.mysofra.helper.Validation.isValidPhone;
import static com.example.mysofra.helper.Validation.setEmailValidation;
import static com.example.mysofra.helper.constant.CLIENT_API_TOKEN;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditProfileClientFragment extends BaseFragment {
    @BindView(R.id.fragment_edit_profile_client_img_imgecricle)
    CircleImageView imgecricle;
    @BindView(R.id.fragment_edit_profile_client_edt_name)
    EditText edtName;
    @BindView(R.id.fragment_edit_profile_client_edt_email)
    TextView edtEmail;
    @BindView(R.id.fragment_edit_profile_client_edt_phone)
    EditText edtPhone;
    @BindView(R.id.fragment_edit_profile_client_spn_spiner_city)
    Spinner spinerCity;
    @BindView(R.id.fragment_edit_profile_client_spn_sinner_region)
    Spinner spinnerRegion;
    @BindView(R.id.fragment_edit_profile_client_btn_continue)
    Button btnContinue;
    private String api_token = CLIENT_API_TOKEN;
    private List<CityDatum> cityData;
    private List<RegionByCityIdDatum> districtData;
    private ArrayList<String> cityName;
    private ArrayList<Integer> cityId;
    private ArrayList<String> districtId;
    private ArrayList<String> districtIdName;
    private int city_id;
    private String district_Id;
    private Unbinder nubind;
    private String imgUrl;
    private ClientloginUser userData;

    public EditProfileClientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_profile_client, container, false);
        nubind = ButterKnife.bind(this, view);
        setUpActivity();
        userData = SharedPreferencesManger.loadUserData(getActivity());
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
        edtName.setText(userData.getName());
        edtEmail.setText(userData.getEmail());
        edtPhone.setText(userData.getPhone());
        Picasso.with(getContext()).load(userData.getPhotoUrl()).into(imgecricle);

    }

    private void fillCity() {
        //      cityData = new ArrayList<>();
//        RetrofitSofra.getInstance().getCity().enqueue(new Callback<City>() {
//            @Override
//            public void onResponse(Call<City> call, Response<City> response) {
//                if (response.body().getStatus() == 1) {
//                    cityData = response.body().getData().getData();
//                    cityId.add(0);
//                    cityName.add(getResources().getString(R.string.cityName));
//
//                    for (int i = 0; i < cityData.size(); i++) {
//                        cityName.add(cityData.get(i).getName());
//                        cityId.add(cityData.get(i).getId());
//                    }
//                    ArrayAdapter arrayAdapter = new ArrayAdapter(getContext()
//                            , android.R.layout.simple_list_item_1, cityName);
//                    spinerCity.setAdapter(arrayAdapter);
//                    //  spinerCity.setSelection(userData.getRegion().getCity().getId());
//                    spinerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                        @Override
//                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                            city_id = cityId.get(position);
//                            Log.e("id", city_id + "");
//                            districtData=new ArrayList<>();
//                            districtId=new ArrayList<>();
//                            districtIdName=new ArrayList<>();
//                            filldistrict();
//                        }
//
//                        @Override
//                        public void onNothingSelected(AdapterView<?> parent) {
//
//                        }
//                    });
//
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<City> call, Throwable t) {
//                customToast(getActivity(), t.getMessage(), false);
//            }
//        });
        SpinnerAdpter spinnerAdpter = new SpinnerAdpter(getActivity());
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                SpinnerAdpter Adpter = new SpinnerAdpter(getActivity());
                getDataSpinners(RetrofitSofra.getInstance().getRegoin(position), Adpter, getString(R.string.districtName), spinnerRegion);
                district_Id = String.valueOf(Adpter.itemselected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        getDataSpinners(RetrofitSofra.getInstance().getCity1(), spinnerAdpter, getString(R.string.cityName), spinerCity, listener);


    }

//    private void filldistrict() {
//        if (InternetState.isConnected(getContext())) {
//            RetrofitSofra.getInstance().getRegionByCityId(city_id).enqueue(new Callback<RegionByCityId>() {
//                @Override
//                public void onResponse(Call<RegionByCityId> call, Response<RegionByCityId> response) {
//                    try {
//                        if (response.body().getStatus() == 1) {
//                            districtData = response.body().getData().getData();
//                            districtId.add("0");
//                            districtIdName.add(getResources().getString(R.string.districtName));
//
//                            for (int i = 0; i < districtData.size(); i++) {
//                                districtIdName.add(districtData.get(i).getName());
//                                districtId.add(districtData.get(i).getId().toString());
//                            }
//                            ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, districtIdName);
//                            spinnerRegion.setAdapter(arrayAdapter);
//                            // spinnerRegion.setSelection(userData.getRegion().getId());
//                            spinnerRegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                                @Override
//                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                                    district_Id = districtId.get(position);
//                                }
//
//                                @Override
//                                public void onNothingSelected(AdapterView<?> parent) {
//
//                                }
//                            });
//                        } else {
//                            customToast(getActivity(), response.body().getMsg(), true);
//                        }
//                    } catch (Exception e) {
//                        customToast(getActivity(), e.getMessage(), true);
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<RegionByCityId> call, Throwable t) {
//                    customToast(getActivity(), getResources().getString(R.string.error), true);
//                }
//            });
//        } else customToast(getActivity(), getResources().getString(R.string.offline), false);
//    }


    @OnClick({R.id.fragment_edit_profile_client_img_imgecricle, R.id.fragment_edit_profile_client_btn_continue})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_edit_profile_client_img_imgecricle:
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
            case R.id.fragment_edit_profile_client_btn_continue:
                String email = edtEmail.getText().toString().trim();
                if (email.isEmpty()) {
                    edtEmail.setFocusable(true);
                    customToast(getActivity(), getResources().getString(R.string.email), false);
                    return;
                }
                if (!setEmailValidation(getActivity(), email)) {
                    customToast(getActivity(), getResources().getString(R.string.invalid_Email), true);
                    return;
                }
                String name = edtName.getText().toString().trim();
                if (name.isEmpty()) {
                    edtName.setFocusable(true);
                    HelperMethod.customToast(getActivity(), getActivity().getResources().getString(R.string.enter_name), false);
                    return;
                }
                String phone = edtPhone.getText().toString().trim();
                if (!isValidPhone(phone)) {
                    edtPhone.setFocusable(true);
                    customToast(getActivity(), getResources().getString(R.string.re_enter_phone), false);
                    return;
                }

                if (InternetState.isConnected(getContext())) {
                    RetrofitSofra.getInstance().eidtProfileClient(api_token, email, name, phone, district_Id, imgUrl)
                            .enqueue(new Callback<EditProfileClient>() {
                                @Override
                                public void onResponse(Call<EditProfileClient> call, Response<EditProfileClient> response) {
                                    try {
                                        if (response.body().getStatus() == 1) {
                                            HelperMethod.customToast(getActivity(), response.body().getMsg(), false);
                                            SharedPreferencesManger.deleteDate("USER_DATA");
                                            ReplaceFragment(getFragmentManager(), new ChangPasswordFragment(), R.id.activity_home_client_frame_fragment,
                                                    null, null);

                                        }
                                    } catch (Exception e) {
                                        dismissProgressDialog();
                                        customToast(getActivity(), response.body().getMsg(), false);
                                    }
                                }

                                @Override
                                public void onFailure(Call<EditProfileClient> call, Throwable t) {
                                    customToast(getActivity(), getActivity().getResources().getString(R.string.error), true);
                                }
                            });
                } else {
                    customToast(getActivity(), getActivity().getResources().getString(R.string.offline), false);
                }

                break;
        }
    }
}
