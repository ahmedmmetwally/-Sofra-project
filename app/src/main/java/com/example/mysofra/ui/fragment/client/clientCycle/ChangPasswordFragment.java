package com.example.mysofra.ui.fragment.client.clientCycle;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.local.SharedPreferencesManger;
import com.example.mysofra.data.model.changPasswordClient.ChangPasswordClient;
import com.example.mysofra.data.model.changPasswordRestaurant.ChangPasswordRestaurant;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.helper.InternetState;
import com.example.mysofra.ui.fragment.BaseFragment;
import com.example.mysofra.ui.fragment.client.homeFragment.MoreFragment;
import com.example.mysofra.ui.fragment.restaurant.restaurantCycle.MoreRestaurantFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mysofra.helper.HelperMethod.ReplaceFragment;
import static com.example.mysofra.helper.HelperMethod.customToast;
import static com.example.mysofra.helper.HelperMethod.dismissProgressDialog;
import static com.example.mysofra.helper.HelperMethod.showProgressDialog;
import static com.example.mysofra.helper.constant.CLIENT_API_TOKEN;
import static com.example.mysofra.helper.constant.RESTAURANT_API_TOKEN;
import static com.example.mysofra.helper.constant.USER_TYPE;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChangPasswordFragment extends BaseFragment {


    @BindView(R.id.fragment_chang_password_edt_old_passward)
    EditText edtOldPassward;
    @BindView(R.id.fragment_chang_password_edt_new_password)
    EditText edtNewPassword;
    @BindView(R.id.fragment_chang_password_edt_confirm_password)
    EditText edtConfirmPassword;
    @BindView(R.id.fragment_chang_passwordbtn_continue)
    Button btnContinue;
    private Unbinder unbind;
    private String api_token;

    public ChangPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chang_password, container, false);
        setUpActivity();
//        if(USER_TYPE.equals("client"){api_token=(SharedPreferencesManger.loadUserData(getActivity()).getApiToken());
//
//        }
//        else api_token=(SharedPreferencesManger.loadRestaurantData(getActivity()).getApiToken());

        unbind = ButterKnife.bind(this, view);
        api_token = CLIENT_API_TOKEN;//123456
        return view;
    }

    @OnClick(R.id.fragment_chang_passwordbtn_continue)
    public void onViewClicked() {
        changePassward();
    }

    private void changePassward() {
        String pin_code = edtOldPassward.getText().toString().trim();
        String password = edtNewPassword.getText().toString().trim();
        String password_confirmation = edtConfirmPassword.getText().toString().trim();
        if (pin_code.isEmpty()) {
            edtOldPassward.requestFocus();
            customToast(getActivity(), getResources().getString(R.string.enter_old_password), true);
            return;
        }

        if (password.isEmpty()) {
            edtNewPassword.requestFocus();
            customToast(getActivity(), getResources().getString(R.string.enter_password), true);
            return;
        }

        if (password.length() < 2) {
            edtNewPassword.requestFocus();
            customToast(getActivity(), getResources().getString(R.string.passwordWeak), true);
            return;
        }

        if (password_confirmation.isEmpty()) {
            edtConfirmPassword.requestFocus();
            customToast(getActivity(), getResources().getString(R.string.enter_confirm_new_password), true);
            return;
        }
        if (!password_confirmation.equals(password)) {
            edtConfirmPassword.requestFocus();
            customToast(getActivity(), getResources().getString(R.string.ensure_same_password), true);
            return;
        }
        if (USER_TYPE.equals("client")) {
            if (InternetState.isConnected(getActivity())) {
                showProgressDialog(getActivity(), getString(R.string.waiit));
                RetrofitSofra.getInstance().changPasswordClient(api_token, pin_code, password, password_confirmation)
                        .enqueue(new Callback<ChangPasswordClient>() {
                            @Override
                            public void onResponse(Call<ChangPasswordClient> call, Response<ChangPasswordClient> response) {
                                try {

                                    if (response.body().getStatus() == 1) {
                                        dismissProgressDialog();
                                        SharedPreferencesManger.deleteDate("USER_DATA");
                                        ReplaceFragment(getFragmentManager(), new ChangPasswordFragment(), R.id.activity_home_client_frame_fragment,
                                                null, null);
                                    } else {
                                        customToast(getActivity(), response.body().getMsg(), true);
                                    }

                                    dismissProgressDialog();
                                } catch (Exception e) {
                                    dismissProgressDialog();

                                }
                            }

                            @Override
                            public void onFailure(Call<ChangPasswordClient> call, Throwable t) {
                                dismissProgressDialog();
                                customToast(getActivity(), t.getMessage(), true);

                            }
                        });
            } else {
                dismissProgressDialog();

                customToast(getActivity(), getResources().getString(R.string.offline), true);
            }
            HelperMethod.ReplaceFragment(getFragmentManager(), new MoreFragment()
                    , R.id.activity_home_client_frame_fragment, null, null);
        } else {
            if (InternetState.isConnected(getActivity())) {
                showProgressDialog(getActivity(), getString(R.string.waiit));
                RetrofitSofra.getInstance().changPasswordCRestaurant(api_token, pin_code, password, password_confirmation).enqueue(new Callback<ChangPasswordRestaurant>() {
                    @Override
                    public void onResponse(Call<ChangPasswordRestaurant> call, Response<ChangPasswordRestaurant> response) {
                        try {

                            if (response.body().getStatus() == 1) {
                                dismissProgressDialog();
                                SharedPreferencesManger.deleteDate("RESTAURANT_DATA");

                                ReplaceFragment(getFragmentManager(), new ChangPasswordFragment(), R.id.activity_restaurnt_login_framlayout,
                                        null, null);
                            } else {
                                dismissProgressDialog();
                                customToast(getActivity(), response.body().getMsg(), true);
                            }

                            dismissProgressDialog();
                        } catch (Exception e) {
                            dismissProgressDialog();

                        }
                    }

                    @Override
                    public void onFailure(Call<ChangPasswordRestaurant> call, Throwable t) {
                        dismissProgressDialog();
                        customToast(getActivity(), getResources().getString(R.string.offline), true);
                    }
                });
            } else {
                dismissProgressDialog();

                customToast(getActivity(), getResources().getString(R.string.offline), true);
            }
            HelperMethod.ReplaceFragment(getFragmentManager(), new MoreRestaurantFragment(),
                    R.id.activity_restaurant_home_frame_fragment, null, null);
        }

    }

//    @Override
//    public void onBack() {
//        if (USER_TYPE.equals("client")) {
//            HelperMethod.ReplaceFragment(getFragmentManager(), new MoreFragment()
//                    , R.id.activity_home_client_frame_fragment, null, null);
//        } else HelperMethod.ReplaceFragment(getFragmentManager(), new MoreRestaurantFragment(),
//                R.id.activity_restaurant_home_frame_fragment, null, null);
//
//    }
}
