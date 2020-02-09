package com.example.mysofra.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.mysofra.R;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.ui.fragment.client.clientCycle.LoginClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.mysofra.helper.constant.USER_TYPE;

public class StartUpActivity extends BaseActivity {

    @BindView(R.id.start_activity_btn_foodrequest)
    Button BtnFoodrequest;
    @BindView(R.id.start_activity_btn_restourant_register)
    Button BtnRestourantRegister;
    @BindView(R.id.activit_splash_view)
    FrameLayout activitSplashView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.start_activity_btn_foodrequest, R.id.start_activity_btn_restourant_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.start_activity_btn_foodrequest:

                USER_TYPE="client";
                Intent intent = new Intent(this, ClientHomeActivity.class);
                startActivity(intent);
            //  HelperMethod.ReplaceFragment(getSupportFragmentManager(),new LoginClient(),R.id.activit_splash_view,null,null);

                break;
            case R.id.start_activity_btn_restourant_register:
//                activitSplashView.setVisibility(View.INVISIBLE);
//                HelperMethod.ReplaceFragment(getSupportFragmentManager(), new RestaurantLoginFragment()
//                        , R.id.activit_splash, null, null);
//                //   finishActivity(3);


//                Intent intent1=new Intent(this,RestaurntLoginActivity.class);
//                startActivity(intent1);
                USER_TYPE="restaurant";
                Intent intent1=new Intent(this,RestaurntLoginActivity.class);
                startActivity(intent1);

                break;
        }
    }
}
