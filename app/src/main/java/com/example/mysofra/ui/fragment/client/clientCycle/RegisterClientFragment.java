package com.example.mysofra.ui.fragment.client.clientCycle;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.mysofra.R;
import com.example.mysofra.adapter.SpinnerAdpter;
import com.example.mysofra.data.api.RetrofitSofra;

import com.example.mysofra.data.model.city.City;
import com.example.mysofra.data.model.city.CityDatum;
import com.example.mysofra.data.model.clientRegister.ClientRegister;
import com.example.mysofra.data.model.clientRegister.ClientRegisterUser;
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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;
import static com.example.mysofra.helper.HelperMethod.convertFileToMultipart;
import static com.example.mysofra.helper.HelperMethod.convertToRequestBody;
import static com.example.mysofra.helper.HelperMethod.customToast;
import static com.example.mysofra.helper.HelperMethod.dismissProgressDialog;
import static com.example.mysofra.helper.HelperMethod.getDataSpinners;
import static com.example.mysofra.helper.HelperMethod.showProgressDialog;
import static com.example.mysofra.helper.Validation.isValidPhone;
import static com.example.mysofra.helper.Validation.setConfirmPassword;
import static com.example.mysofra.helper.Validation.setEmailValidation;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterClientFragment extends BaseFragment {


    @BindView(R.id.fragment_register_edt_name)
    EditText EdtName;
    @BindView(R.id.fragment_register_edt_email)
    EditText EdtEmail;
    @BindView(R.id.fragment_register_edt_phonenum)
    EditText EdtPhonenum;
    @BindView(R.id.fragment_register_sp_city)
    Spinner SpCity;
    @BindView(R.id.fragment_register_sp_district)
    Spinner SpDistrict;
    @BindView(R.id.fragment_register_edt_passewrd)
    EditText EdtPassewrd;
    @BindView(R.id.fragment_register_edt_passewrd_confirm)
    EditText EdtPassewrdConfirm;
    @BindView(R.id.fragment_register_btn_register)
    Button BtnContnue;
    Unbinder unbinder;
    @BindView(R.id.fragment_register_img_profileImage)
    ImageView ImgProfileImage;
    @BindView(R.id.fragment_register_linear_district)
    LinearLayout LinearDistrict;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String confirm_password;
    private List<CityDatum> cityData;
    private List<RegionByCityIdDatum> districtData;
    private ArrayList<String> cityName;
    private ArrayList<Integer> cityId;
    private ArrayList<String> districtId;
    private ArrayList<String> districtIdName;
    private int city_id;
    private String district_Id;
    private Uri uriimage;
    private static final int pick_image_Request = 1;
    private String urlImage;
    public ClientRegisterUser userrData;

    public RegisterClientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        unbinder = ButterKnife.bind(this, view);
        setUpActivity();
        cityData = new ArrayList<>();
        districtData = new ArrayList<>();
        cityName = new ArrayList<>();
        cityId = new ArrayList<>();
        districtId = new ArrayList<>();
        districtIdName = new ArrayList<>();
        fillCity();
//        filldistrict();
//

        return view;
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
                    ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, cityName);
                    SpCity.setAdapter(arrayAdapter);
                    SpCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            city_id = cityId.get(position);
                            LinearDistrict.setVisibility(View.VISIBLE);

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

//        SpinnerAdpter spinnerAdpter = new SpinnerAdpter(getActivity());
//        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                city_id = cityId.get(position);
//                SpinnerAdpter Adpter = new SpinnerAdpter(getActivity());
//                getDataSpinners(RetrofitSofra.getInstance().getRegoin(city_id), Adpter, getString(R.string.districtName), SpDistrict);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        };
//        getDataSpinners(RetrofitSofra.getInstance().getCity1(), spinnerAdpter, getString(R.string.cityName), SpCity, listener);


    }

    private void filldistrict() {
        if (InternetState.isConnected(getContext())) {
            RetrofitSofra.getInstance().getRegionByCityId(city_id).enqueue(new Callback<RegionByCityId>() {
                @Override
                public void onResponse(Call<RegionByCityId> call, Response<RegionByCityId> response) {
                    try {
                        if (response.body().getStatus() == 1) {
                            districtData = response.body().getData().getData();
                            districtIdName=new ArrayList<>();
                            districtId=new ArrayList<>();
                            districtId.add("0");
                            districtIdName.add(getResources().getString(R.string.districtName));

                            for (int i = 1; i < districtData.size(); i++) {
                                districtIdName.add(districtData.get(i).getName());
                                districtId.add(districtData.get(i).getId().toString());
                            }
                            ArrayAdapter arrayAdapterr = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, districtIdName);
                            SpDistrict.setAdapter(arrayAdapterr);
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


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.fragment_register_btn_register, R.id.fragment_register_img_profileImage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_register_btn_register: {
                name = EdtName.getText().toString().trim();
                email = EdtEmail.getText().toString().trim();
                phone = EdtPhonenum.getText().toString().trim();
                password = EdtPassewrd.getText().toString().trim();
                confirm_password = EdtPassewrdConfirm.getText().toString().trim();
                if (name.length() < 3) {
                    customToast(getActivity(), getResources().getString(R.string.enter_name), false);
                    return;
                }
                if (!isValidPhone(phone)) {
                    EdtPhonenum.setFocusable(true);
                    customToast(getActivity(), getResources().getString(R.string.re_enter_phone), false);
                    return;
                }
            }

            if (email.isEmpty()) {
                EdtEmail.setFocusable(true);
                customToast(getActivity(), getResources().getString(R.string.email), false);
                return;
            }


            if (!setEmailValidation(getActivity(), email)) {
                // customToast(getActivity(), getResources().getString(R.string.invalid_Email), true);
                return;
            }

            district_Id = String.valueOf(SpDistrict.getSelectedItemPosition());
            if (district_Id.equals("0")) {
                customToast(getActivity(), getResources().getString(R.string.districtName), false);
                return;
            }

            if (setConfirmPassword(getActivity(), password, confirm_password)) {

            } else {
                return;
            }

            doRegister();

            HelperMethod.ReplaceFragment(getFragmentManager(), new LoginClient()
                    , R.id.activity_home_client_frame_fragment, null, null);
            case R.id.fragment_register_img_profileImage:
                openFileChooser();

        }

    }


    private void openFileChooser() {
//        Intent intent = new Intent();
//        intent.setType("image/*")
//                .setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent, pick_image_Request);
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == pick_image_Request && resultCode == RESULT_OK && data != null && data.getData() != null) {
//            uriimage = data.getData();
//            urlImage = uriimage.toString();
//            Picasso.with(getActivity()).load(uriimage).into(ImgProfileImage);
//        }

        HelperMethod.selectImage(getContext(), 3, new Action<ArrayList<AlbumFile>>() {
            @Override
            public void onAction(@NonNull ArrayList<AlbumFile> result) {
                urlImage = result.get(0).getPath();
                Glide.with(ImgProfileImage.getContext())
                        .load(urlImage)
                        .error(R.drawable.rror_black_24dp)
                        .placeholder(R.drawable.upload_24dp)
                        .crossFade()
                        .into(ImgProfileImage);
            }
        });
    }

    private void doRegister() {

        if (InternetState.isConnected(getContext())) {
            showProgressDialog(getActivity(), getString(R.string.registerr));
            RetrofitSofra.getInstance().registerUser(convertToRequestBody(name), convertToRequestBody(email),
                    convertToRequestBody(password), convertToRequestBody(confirm_password)
                    , convertToRequestBody(phone), convertToRequestBody(district_Id),
                    convertFileToMultipart(urlImage, "profileImage")).enqueue(new Callback<ClientRegister>() {
                @Override
                public void onResponse(Call<ClientRegister> call, Response<ClientRegister> response) {
                    try {
                        if (response.body().getStatus() == 1) {
                            dismissProgressDialog();
                            userrData = response.body().getData().getUser();
                            String apiToken = response.body().getData().getApiToken();
                            userrData.setApiToken(apiToken);
                            customToast(getActivity(), response.body().getMsg(), true);
                        } else {
                            dismissProgressDialog();
                            customToast(getActivity(), response.body().getMsg(), true);
                        }

                    } catch (Exception e) {
                        customToast(getActivity(), e.getMessage(), false);
                    }


                }

                @Override
                public void onFailure(Call<ClientRegister> call, Throwable t) {
                    dismissProgressDialog();
                    customToast(getActivity(), t.getMessage(), true);
                }
            });
        } else customToast(getActivity(), getResources().getString(R.string.offline), false);

    }

}
