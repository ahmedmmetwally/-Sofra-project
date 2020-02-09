package com.example.mysofra.ui.fragment.client.homeFragment;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.local.SharedPreferencesManger;
import com.example.mysofra.data.model.clientlogin.ClientloginUser;
import com.example.mysofra.data.model.contactWithUs.ContactWithUs;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.helper.InternetState;
import com.example.mysofra.ui.fragment.BaseFragment;
import com.example.mysofra.ui.fragment.restaurant.restaurantCycle.MoreRestaurantFragment;

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
import static com.example.mysofra.helper.Validation.setEmailValidation;
import static com.example.mysofra.helper.constant.USER_TYPE;


public class ContactUsFragment extends BaseFragment {

    @BindView(R.id.fragment_contact_us_edt_fullname)
    EditText edtFullname;
    @BindView(R.id.fragment_contact_us_edt_email)
    EditText edtEmail;
    @BindView(R.id.fragment_contact_us_edt_phone)
    EditText edtPhone;
    @BindView(R.id.fragment_contact_us_edt_message)
    EditText edtMessage;
    @BindView(R.id.fragment_contact_us_radio_query)
    RadioButton radioQuery;
    @BindView(R.id.fragment_contact_us_radio_suggest)
    RadioButton radioSuggest;
    @BindView(R.id.fragment_contact_us_radio_complaint)
    RadioButton radioComplaint;
    @BindView(R.id.fragment_contact_us_btn_send)
    Button btnSend;
    @BindView(R.id.fragment_contact_us_rdg_radiogroup)
    RadioGroup rdgRadiogroup;
    private Unbinder nubind;
    private String contact_type;
    private String name;
    private String email;
    private String phone;
    private String message;

    public ContactUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);
        nubind = ButterKnife.bind(this, view);
        setUpActivity();
        setData();
        return view;
    }

    private void setData() {
        ClientloginUser userData = SharedPreferencesManger.loadUserData((Activity) getContext());
        name = userData.getName();
        edtFullname.setText(name);

        email = userData.getEmail();
        edtEmail.setText(email);

        phone = userData.getPhone();
        edtPhone.setText(phone);
    }

    @OnClick(R.id.fragment_contact_us_btn_send)
    public void onViewClicked() {
        getInfo();

        if (USER_TYPE == ("client"))
            HelperMethod.ReplaceFragment(getFragmentManager(), new MoreFragment()
                    , R.id.activity_home_client_frame_fragment, null, null);
        else HelperMethod.ReplaceFragment(getFragmentManager(), new MoreRestaurantFragment()
                , R.id.activity_restaurant_home_frame_fragment, null, null);
    }

    private void getInfo() {
        name = edtFullname.getText().toString().trim();
        if (name.length() < 3) {
            customToast(getActivity(), getResources().getString(R.string.enter_name), false);
            return;
        }
        phone = edtPhone.getText().toString().trim();
        if (!isValidPhone(phone)) {
            edtPhone.setFocusable(true);
            customToast(getActivity(), getResources().getString(R.string.re_enter_phone), false);
            return;
        }
        email = edtEmail.getText().toString().trim();
        if (email.isEmpty()) {
            edtEmail.setFocusable(true);
            customToast(getActivity(), getResources().getString(R.string.email), false);
            return;
        }


        if (!setEmailValidation(getActivity(), email)) {
            customToast(getActivity(), getResources().getString(R.string.invalid_Email), true);
            return;
        }


        message = edtMessage.getText().toString().trim();
        if (message.isEmpty()) {
            edtMessage.setFocusable(true);
            HelperMethod.customToast(getActivity(), getActivity().getResources().getString(R.string.enter_name), false);
            return;
        }
//        if (contact_type==null) {
//            HelperMethod.customToast(getActivity(), getActivity().getResources().getString(R.string.please_select_type), false);
//            return;
//        }
        rdgRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.fragment_contact_us_radio_query:
                        contact_type = "inquiry";
                        break;
                    case R.id.fragment_contact_us_radio_suggest:
                        contact_type = "suggestion";
                        break;
                    case R.id.fragment_contact_us_radio_complaint:
                        contact_type = "complaint";
                        break;

                }


            }
        });
        contact();

    }

    private void contact() {
        if (InternetState.isConnected(getContext())) {
            Log.e("gggggg", "in internet State");
            RetrofitSofra.getInstance().contactUs(name, email, phone, contact_type, message).enqueue(new Callback<ContactWithUs>() {
                @Override
                public void onResponse(Call<ContactWithUs> call, Response<ContactWithUs> response) {
                    try {
                        if (response.body().getStatus() == 1) {
                            Log.e("gggggg", "in try");
                            HelperMethod.customToast(getActivity(), response.body().getMsg()
                                    + (R.string.our_request_sent_to_the_officials), true);

                        }
                    } catch (Exception e) {
                        Log.e("gggggg", "in catch");
                        dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), false);
                    }
                }

                @Override
                public void onFailure(Call<ContactWithUs> call, Throwable t) {
                    Log.e("gggggg", "in failure");
                    customToast(getActivity(), getActivity().getResources().getString(R.string.error), false);
                }
            });
        } else {
            Log.e("gggggg", "in internet failure");
            customToast(getActivity(), getActivity().getResources().getString(R.string.offline), false);
        }

    }

//    @Override
//    public void onBack() {
//        if (USER_TYPE==("client"))
//            HelperMethod.ReplaceFragment(getFragmentManager(), new MoreFragment()
//                    , R.id.activity_home_client_frame_fragment, null, null);
//        else HelperMethod.ReplaceFragment(getFragmentManager(), new MoreRestaurantFragment()
//                ,R.id.activity_restaurant_home_frame_fragment, null, null);
//    }
}
