package com.example.mysofra.ui.fragment.client.clientCycle;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.mysofra.R;
import com.example.mysofra.data.model.resetPassword.ResetPassword;
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

import static com.example.mysofra.data.api.RetrofitSofra.getInstance;
import static com.example.mysofra.helper.HelperMethod.customToast;
import static com.example.mysofra.helper.HelperMethod.dismissProgressDialog;
import static com.example.mysofra.helper.HelperMethod.showProgressDialog;
import static com.example.mysofra.helper.Validation.setEmailValidation;
import static com.example.mysofra.helper.constant.USER_TYPE;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForgetPasswordClientFragment extends BaseFragment {


    @BindView(R.id.fragment_creat_new_password_edt_email)
    EditText EdtEmail;
    @BindView(R.id.fragment_creat_new_password_btn_send)
    Button BtnSend;
    Unbinder unbinder;
    private String email;

    public ForgetPasswordClientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forget_password_client, container, false);
        unbinder = ButterKnife.bind(this, view);
        setUpActivity();

        return view;
    }

    @OnClick(R.id.fragment_creat_new_password_btn_send)
    public void onViewClicked() {
        checkValidate();
    }

    private void checkValidate() {
        email = EdtEmail.getText().toString().trim();
        if (setEmailValidation(getActivity(), email)) {
            if (USER_TYPE.equals("client"))
                goToCreatNewPassClient(email);
            else
                goToCreatNewPassRestaurant(email);
        } else
            EdtEmail.setFocusable(true);
        return;


    }


    private void goToCreatNewPassClient(String email) {
        if (InternetState.isConnected(getContext())) {
            showProgressDialog(getActivity(), getResources().getString(R.string.code_was_sent));
            getInstance().resetPassword(email).enqueue(new Callback<ResetPassword>() {
                @Override
                public void onResponse(Call<ResetPassword> call, Response<ResetPassword> response) {
                    try {
                        if (response.body().getStatus() == 1) ;
                        dismissProgressDialog();
                        HelperMethod.ReplaceFragment(getFragmentManager(), new CreatNewPasswordClientAndRestaurantFragment()
                                , R.id.activit_splash, null, null);
                    } catch (Exception e) {
                        dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), false);
                    }
                }

                @Override
                public void onFailure(Call<ResetPassword> call, Throwable t) {
                    dismissProgressDialog();
                }
            });

        } else customToast(getActivity(), getResources().getString(R.string.offline), false);
    }

    private void goToCreatNewPassRestaurant(String email) {
        if (InternetState.isConnected(getContext())) {
            showProgressDialog(getActivity(), getResources().getString(R.string.code_was_sent));
            getInstance().restaurantresetPassword(email).enqueue(new Callback<ResetPassword>() {
                @Override
                public void onResponse(Call<ResetPassword> call, Response<ResetPassword> response) {
                    try {
                        if (response.body().getStatus() == 1) ;
                        dismissProgressDialog();
                        HelperMethod.ReplaceFragment(getFragmentManager(), new CreatNewPasswordClientAndRestaurantFragment()
                                , R.id.activit_splash, null, null);
                    } catch (Exception e) {
                        dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), false);
                    }
                }

                @Override
                public void onFailure(Call<ResetPassword> call, Throwable t) {
                    dismissProgressDialog();
                }
            });

        } else customToast(getActivity(), getResources().getString(R.string.offline), false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
