package com.example.mysofra.ui.fragment.restaurant.restaurantCycle;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;

import com.example.mysofra.data.local.SharedPreferencesManger;
import com.example.mysofra.data.model.restaurntLogin.RestaurntLogin;
import com.example.mysofra.data.model.restaurntLogin.RestaurntLoginUser;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.helper.InternetState;
import com.example.mysofra.ui.activity.RestaurantHomeActivity;
import com.example.mysofra.ui.activity.StartUpActivity;
import com.example.mysofra.ui.fragment.BaseFragment;
import com.example.mysofra.ui.fragment.client.clientCycle.EditProfileClientFragment;
import com.example.mysofra.ui.fragment.client.clientCycle.ForgetPasswordClientFragment;
import com.example.mysofra.ui.fragment.restaurant.RestaurantMyCategoriesFragmet;
import static com.example.mysofra.helper.constant.RESTAURANT_API_TOKEN;

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
public class RestaurantLoginFragment extends BaseFragment {


    @BindView(R.id.fragment_restaurant_login_edt_email)
    EditText RestaurantLoginEdtEmail;
    @BindView(R.id.fragment_restaurant_login_edt_password)
    EditText RestaurantLoginEdtPassword;
    @BindView(R.id.fragment_restaurant_login_txtv_forgetpassword)
    TextView RestaurantLoginTxtvForgetpassword;
    @BindView(R.id.fragment_restaurant_login_rlt_register)
    RelativeLayout RestaurantLoginRltRegister;
    @BindView(R.id.fragment_restaurant_login_txtv_creataccount)
    TextView RestaurantLoginTxtvCreataccount;
    private Unbinder unbind;

    public boolean from_editProfile;


    public RestaurantLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_restaurant_login, container, false);
        unbind = ButterKnife.bind(this, view);
        setUpActivity();

        return view;
    }


    @OnClick({R.id.fragment_restaurant_login_txtv_forgetpassword, R.id.fragment_restaurant_login_rlt_register, R.id.fragment_restaurant_login_txtv_creataccount})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_restaurant_login_txtv_forgetpassword:
                HelperMethod.ReplaceFragment(getFragmentManager(), new ForgetPasswordClientFragment(), R.id.activity_restaurant_home_frame_fragment, null, null);
                break;
            case R.id.fragment_restaurant_login_rlt_register:
                getValidationAndOgin();
                if(from_editProfile)
                    HelperMethod.ReplaceFragment(getFragmentManager(), new EditProfileClientFragment()
                            ,R.id.activity_restaurant_home_frame_fragment, null, null);

                break;
            case R.id.fragment_restaurant_login_txtv_creataccount:
                HelperMethod.ReplaceFragment(getFragmentManager(), new RestaurantRegisterFragment(),
                        R.id.activity_restaurnt_login_framlayout, null, null);

                break;
        }
    }

    private void getValidationAndOgin() {
        String email = RestaurantLoginEdtEmail.getText().toString().trim();
        String password = RestaurantLoginEdtPassword.getText().toString().trim();
        if (email.isEmpty()) {
            RestaurantLoginEdtEmail.setFocusable(true);
            customToast(getActivity(), getResources().getString(R.string.email), false);
            return;
        }
        if (!setEmailValidation(getActivity(), email)){
            customToast(getActivity(), getResources().getString(R.string.invalid_Email), true);
            return;
        }
        if (password.isEmpty())
            customToast(getActivity(), getResources().getString(R.string.enter_password), false);
        if (InternetState.isConnected(getContext())) {
            showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().restaurantLogin(email,password).enqueue(new Callback<RestaurntLogin>() {
                @Override
                public void onResponse(Call<RestaurntLogin> call, Response<RestaurntLogin> response) {
                    try {
                        if(response.body().getStatus()==1){
                            RestaurntLoginUser  restaurantList=response.body().getData().getUser();
                            String apii_token=response.body().getData().getApiToken();
                            restaurantList.setApiToken(apii_token);
                            RESTAURANT_API_TOKEN=apii_token;
                            SharedPreferencesManger.saveRestaurantData(getActivity(),restaurantList);
                            Intent intent1=new Intent(getContext(), RestaurantHomeActivity.class);
                            startActivity(intent1);


                        }

                    }catch (Exception e){
                        dismissProgressDialog();
                        Toast.makeText(getActivity(), response.body().getMsg(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<RestaurntLogin> call, Throwable t) {

                }
            });


        } else customToast(getActivity(), getResources().getString(R.string.offline), false);
    }

    @Override
    public void onBack() {
        if(from_editProfile)
        HelperMethod.ReplaceFragment(getFragmentManager(), new RestaurantMyCategoriesFragmet()
                ,R.id.activity_restaurant_home_frame_fragment, null, null);
        else { Intent intent1=new Intent(this.baseActivity, StartUpActivity.class);
            startActivity(intent1);}
    }
}