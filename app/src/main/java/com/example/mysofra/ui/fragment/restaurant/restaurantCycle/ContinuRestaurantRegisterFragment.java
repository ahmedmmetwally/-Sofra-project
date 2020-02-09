package com.example.mysofra.ui.fragment.restaurant.restaurantCycle;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;

import com.example.mysofra.data.model.restaurntRegister.RestaurntRegister;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.helper.InternetState;
import com.example.mysofra.ui.activity.RestaurntLoginActivity;

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
import static com.example.mysofra.helper.HelperMethod.showProgressDialog;
import static com.example.mysofra.helper.Validation.isValidPhone;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContinuRestaurantRegisterFragment extends Fragment {
    public String name;
    public String email;
    public String password;
    public String confirm_password;
    public String minimumOrder;
    public String deliveryCharge;
    public String district_Id;
    public String duration_time;
    @BindView(R.id.fragment_continue_restaurant_register_edt_phonenum)
    EditText EdtPhonenum;
    @BindView(R.id.fragment_continue_restaurant_register_edt_watts)
    EditText EdtWatts;
    @BindView(R.id.fragment_continue_restaurant_register_btn_register)
    Button BtnRegister;
    @BindView(R.id.fragment_login_rlt_register)
    RelativeLayout fragmentLoginRltRegister;
    @BindView(R.id.fragment_continue_restaurant_register_image_profile)
    ImageView ImageProfile;
    private String watts;
    public String phone;
    private Uri uriimage;
    private String urlImage;
    Unbinder unbinder;

    public ContinuRestaurantRegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_continue_restaurant_register, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @OnClick({R.id.fragment_continue_restaurant_register_image_profile, R.id.fragment_continue_restaurant_register_btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_continue_restaurant_register_image_profile:
                openFileChooser();
                break;
            case R.id.fragment_continue_restaurant_register_btn_register:
                initData();
                break;
        }
    }


    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*")
                .setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 2);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            uriimage = data.getData();
            urlImage = uriimage.toString();
            //Picasso.with(getActivity()).load(uriimage).into(ImageProfile);
            ImageProfile.setImageURI(uriimage);
        }
    }

    private void initData() {
        phone = EdtPhonenum.getText().toString().trim();
        watts = EdtWatts.getText().toString().trim();
        if (!isValidPhone(phone)) {
            EdtPhonenum.setFocusable(true);
            customToast(getActivity(), getResources().getString(R.string.re_enter_phone), false);
            return;
        }
        if (!isValidPhone(watts)) {
            EdtPhonenum.setFocusable(true);
            customToast(getActivity(), getResources().getString(R.string.please_enter_watts_num), false);
            return;
        }
        if (urlImage.isEmpty()) {
            customToast(getActivity(), getResources().getString(R.string.choose_picture), false);
            return;
        }
        restaurantRegister(name, email, district_Id, password, confirm_password, phone
                , watts, minimumOrder, deliveryCharge, urlImage, duration_time);
    }

    private void restaurantRegister(String name, String email, String duration_time, String district_Id, String password, String confirm_password
            , String phone, String watts, String minimumOrder, String deliveryCharge, String urlImage) {
        if (InternetState.isConnected(getContext())) {
            showProgressDialog(getActivity(), getString(R.string.registerr));
            RetrofitSofra.getInstance().registerRestaurant(convertToRequestBody(name),convertToRequestBody(email)
                    ,convertToRequestBody(district_Id) ,convertToRequestBody(password) ,convertToRequestBody(confirm_password)
                    ,convertToRequestBody(phone) ,convertToRequestBody(watts) ,convertToRequestBody(minimumOrder) ,convertToRequestBody(deliveryCharge)
                    ,convertFileToMultipart(urlImage,"resProfileImage") ,convertToRequestBody(duration_time) ).enqueue(new Callback<RestaurntRegister>() {
                @Override
                public void onResponse(Call<RestaurntRegister> call, Response<RestaurntRegister> response) {
                    try {
                        dismissProgressDialog();
                        if (response.body().getStatus() == 1) {
                            customToast(getActivity(), response.body().getMsg(), true);
                            HelperMethod.ReplaceFragment(getFragmentManager(),new RestaurantLoginFragment(),
                                    R.id.activity_restaurnt_login_framlayout,null,null);
                        }
                    } catch (Exception e) {
                        dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), true);
                    }


                }

                @Override
                public void onFailure(Call<RestaurntRegister> call, Throwable t) {
                    dismissProgressDialog();
                    customToast(getActivity(), t.getMessage(), true);

                }
            });

        } else customToast(getActivity(), getResources().getString(R.string.offline), false);
    }

}
