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
import com.example.mysofra.data.model.creatNewPassword.CreatNewPassword;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.helper.InternetState;
import com.example.mysofra.ui.fragment.BaseFragment;
import com.example.mysofra.ui.fragment.restaurant.restaurantCycle.RestaurantLoginFragment;

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
import static com.example.mysofra.helper.Validation.setConfirmPassword;
import static com.example.mysofra.helper.Validation.setPasswordValidation;
import static com.example.mysofra.helper.constant.USER_TYPE;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreatNewPasswordClientAndRestaurantFragment extends BaseFragment {


    @BindView(R.id.fragment_creat_new_password_edt_code)
    EditText EdtCode;
    @BindView(R.id.fragment_creat_new_password_edt_password)
    EditText EdtPassword;
    @BindView(R.id.fragment_creat_new_password_edt_confirm_password)
    EditText EdtConfirmPassword;
    @BindView(R.id.fragment_creat_new_password_btn_send)
    Button BtnSend;
    private Unbinder unbinder;
    private String code;
    private String password;
    private String confirmPassword;

    public CreatNewPasswordClientAndRestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_creat_new_password_client, container, false);
        unbinder = ButterKnife.bind(this, view);
        setUpActivity();
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }

    @OnClick(R.id.fragment_creat_new_password_btn_send)
    public void onViewClicked() {
        validation();
    }

    private void validation() {
        code = EdtCode.getText().toString().trim();
        password = EdtPassword.getText().toString().trim();
        confirmPassword = EdtConfirmPassword.getText().toString().trim();
        if (code.isEmpty()) {
            EdtCode.setFocusable(true);
            customToast(getActivity(), getResources().getString(R.string.enter_code), false);
            return;
        }
        if (setPasswordValidation(getActivity(), password)) {

        } else {
            EdtPassword.setFocusable(true);
            return;
        }

        if (setConfirmPassword(getActivity(), password, confirmPassword)) {

        } else {
            EdtConfirmPassword.setFocusable(true);
            return;
        }
        if (USER_TYPE.equals("client"))
            createNewPsswordClient(code, password, confirmPassword);
        else
            createNewPsswordRestaurant(code, password, confirmPassword);


    }


    private void createNewPsswordClient(String codee, String passwordd, String confirmPasswordd) {
        if (InternetState.isConnected(getContext())) {
            showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().getNewPassword(codee, passwordd, confirmPasswordd).enqueue(new Callback<CreatNewPassword>() {
                @Override
                public void onResponse(Call<CreatNewPassword> call, Response<CreatNewPassword> response) {
                    try {
                        if (response.body().getStatus() == 1) {
                            dismissProgressDialog();
                            customToast(getActivity(), getResources().getString(R.string.new_pssword_ismade), false);
                            HelperMethod.ReplaceFragment(getFragmentManager(), new LoginClient()
                                    , R.id.activity_home_client_frame_fragment, null, null);
                        } else {
                            dismissProgressDialog();
                            customToast(getActivity(), response.body().getMsg(), false);
                        }
                    } catch (Exception e) {
                    }

                }

                @Override
                public void onFailure(Call<CreatNewPassword> call, Throwable t) {
                    dismissProgressDialog();
                    customToast(getActivity(), t.getMessage(), false);

                }
            });
        }
        customToast(getActivity(), getResources().getString(R.string.offline), false);
    }

    private void createNewPsswordRestaurant(String code, String password, String confirmPassword) {
        if (InternetState.isConnected(getContext())) {
            showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().getNewPasswordRestaurant(code, password, confirmPassword).enqueue(new Callback<CreatNewPassword>() {
                @Override
                public void onResponse(Call<CreatNewPassword> call, Response<CreatNewPassword> response) {
                    try {
                        if (response.body().getStatus() == 1) {
                            dismissProgressDialog();
                            customToast(getActivity(), getResources().getString(R.string.new_pssword_ismade), false);
                            HelperMethod.ReplaceFragment(getFragmentManager(), new RestaurantLoginFragment()
                                    , R.id.activity_restaurant_home_frame_fragment, null, null);
                        } else {
                            dismissProgressDialog();
                            customToast(getActivity(), response.body().getMsg(), false);
                        }
                    } catch (Exception e) {
                    }

                }

                @Override
                public void onFailure(Call<CreatNewPassword> call, Throwable t) {
                    dismissProgressDialog();
                    customToast(getActivity(), t.getMessage(), false);

                }
            });
        }
        customToast(getActivity(), getResources().getString(R.string.offline), false);
    }

}
