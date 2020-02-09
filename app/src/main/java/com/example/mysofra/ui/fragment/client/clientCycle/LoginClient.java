package com.example.mysofra.ui.fragment.client.clientCycle;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import static com.example.mysofra.helper.HelperMethod.ReplaceFragment;
import static com.example.mysofra.helper.constant.CLIENT_API_TOKEN;

import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.local.SharedPreferencesManger;
import com.example.mysofra.data.model.clientlogin.Clientlogin;
import com.example.mysofra.data.model.clientlogin.ClientloginUser;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.helper.InternetState;
import com.example.mysofra.ui.fragment.BaseFragment;
import com.example.mysofra.ui.fragment.client.homeFragment.HomeFragmentt;

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
import static com.example.mysofra.helper.Validation.setEmailValidation;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginClient extends BaseFragment {


    @BindView(R.id.fragment_login_edt_email)
    EditText EdtEmail;
    @BindView(R.id.fragment_login_edt_password)
    EditText EdtPassword;
    @BindView(R.id.fragment_login_txtv_forgetpassword)
    TextView TxtvForgetpassword;
    @BindView(R.id.fragment_login_rlt_register)
    RelativeLayout RltRegister;
    Unbinder unbinder;

    public ClientloginUser clientloginUser;
    @BindView(R.id.fragment_login_txtv_creataccount)
    TextView TxtvCreataccount;

    public LoginClient() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View veiw = inflater.inflate(R.layout.fragment_login_client, container, false);
        unbinder = ButterKnife.bind(this, veiw);
        setUpActivity();
        return veiw;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.fragment_login_txtv_forgetpassword, R.id.fragment_login_rlt_register,
            R.id.fragment_login_txtv_creataccount})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_login_txtv_forgetpassword:
                HelperMethod.ReplaceFragment(getFragmentManager(), new ForgetPasswordClientFragment(), R.id.activity_home_client_frame_fragment, null, null);

                break;
            case R.id.fragment_login_rlt_register: {
                login();
                break;
            }
            case R.id.fragment_login_txtv_creataccount: {

                HelperMethod.ReplaceFragment(getFragmentManager(), new RegisterClientFragment(), R.id.activity_home_client_frame_fragment, null, null);
                break;
            }
        }
    }

    private void login() {
        String email = EdtEmail.getText().toString().trim();
        String password = EdtPassword.getText().toString().trim();

        if (email.isEmpty()) {
            EdtEmail.setFocusable(true);
            customToast(getActivity(), getResources().getString(R.string.email), false);
            return;
        }
        if (!setEmailValidation(getActivity(), email)) {
            customToast(getActivity(), getResources().getString(R.string.invalid_Email), false);
            return;
        }
        if (password.isEmpty()) {
            customToast(getActivity(), getResources().getString(R.string.enter_password), false);
            return;
        }

        if (InternetState.isConnected(getContext())) {
            Log.e("login", "login function");
            showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().getUserLogin(email, password).enqueue(new Callback<Clientlogin>() {
                @Override
                public void onResponse(Call<Clientlogin> call, Response<Clientlogin> response) {
                    dismissProgressDialog();
                    if (response.body().getStatus() == 1) {
                        Log.e("login", response.body().getMsg());
                        clientloginUser = response.body().getData().getUser();
                        String apiToken = response.body().getData().getApiToken();
                        clientloginUser.setApiToken(apiToken);
                        CLIENT_API_TOKEN = apiToken;
                        SharedPreferencesManger.saveUserData(getActivity(), clientloginUser);
                        ReplaceFragment(getFragmentManager(),new HomeFragmentt(),
                                R.id.activity_home_client_frame_fragment,null,null);
                    }
                }

                @Override
                public void onFailure(Call<Clientlogin> call, Throwable t) {
                    Log.e("login", "in failure Login" + t.toString());
                }
            });
        } else customToast(getActivity(), getResources().getString(R.string.offline), false);

    }
}
