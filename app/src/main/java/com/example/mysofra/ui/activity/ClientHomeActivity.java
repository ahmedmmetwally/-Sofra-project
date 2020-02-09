package com.example.mysofra.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mysofra.R;
import com.example.mysofra.data.local.SharedPreferencesManger;
import com.example.mysofra.data.model.clientlogin.ClientloginUser;
import com.example.mysofra.helper.HelperMethod;

import com.example.mysofra.ui.fragment.client.homeFragment.ConfirmOrderFromRoomFragment;
import com.example.mysofra.ui.fragment.client.homeFragment.HomeFragmentt;
import com.example.mysofra.ui.fragment.client.homeFragment.MoreFragment;
import com.example.mysofra.ui.fragment.client.homeFragment.MyOrderClientContainerFragment;
import com.example.mysofra.ui.fragment.client.clientCycle.EditProfileClientFragment;
import com.example.mysofra.ui.fragment.client.clientCycle.LoginClient;
import com.example.mysofra.ui.fragment.client.homeFragment.NotificationClientFragment;
import com.example.mysofra.ui.fragment.restaurant.RestaurantMyCategoriesFragmet;
import com.google.android.material.appbar.AppBarLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.mysofra.helper.constant.CLIENT_API_TOKEN;

public class ClientHomeActivity extends BaseActivity {

    @BindView(R.id.activity_home_img_car)
    ImageView activityHomeImgCar;
    @BindView(R.id.activity_home_img_notification_appbar)
    ImageView activityHomeImgNotificationAppbar;
    @BindView(R.id.appBar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.activity_home_client_frame_fragment)
    FrameLayout activityHomeFrameFragment;
    @BindView(R.id.activity_home_img_menu)
    ImageView activityHomeImgMenu;
    @BindView(R.id.activity_home_img_profil)
    ImageView activityHomeImgProfil;
    @BindView(R.id.activity_home_img_myorder)
    ImageView activityHomeImgmyOrder;
    @BindView(R.id.activity_home_img_home)
    ImageView activityHomeImgHome;
    @BindView(R.id.activity_home_lnly_menu)
    LinearLayout activityHomeLnlyMenu;
    @BindView(R.id.activity_home_img_car)
    ImageView img_Car;
    private HomeFragmentt homeFragmentt;
    ClientloginUser userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_home_);
        ButterKnife.bind(this);
        homeFragmentt = new HomeFragmentt();
        HelperMethod.ReplaceFragment(getSupportFragmentManager(),
                homeFragmentt, R.id.activity_home_client_frame_fragment, null, null);

        userData=SharedPreferencesManger.loadUserData(ClientHomeActivity.this);
        if (userData!=null) {
            CLIENT_API_TOKEN=userData.getApiToken();
        }

    }

    @OnClick({R.id.activity_home_img_car, R.id.activity_home_img_notification_appbar,
            R.id.activity_home_img_menu, R.id.activity_home_img_profil, R.id.activity_home_img_myorder, R.id.activity_home_img_home})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_home_img_car:
                HelperMethod.ReplaceFragment(getSupportFragmentManager(), new ConfirmOrderFromRoomFragment(),
                        R.id.activity_home_client_frame_fragment, null, null);
                break;
            case R.id.activity_home_img_notification_appbar:

                HelperMethod.ReplaceFragment(getSupportFragmentManager(), new NotificationClientFragment(),
                        R.id.activity_home_client_frame_fragment, null, null);
                break;
            case R.id.activity_home_img_menu:
                HelperMethod.ReplaceFragment(getSupportFragmentManager(),new MoreFragment(),
                        R.id.activity_home_client_frame_fragment,null,null);
                break;

            case R.id.activity_home_img_profil:
                if (userData != null) {
                    HelperMethod.ReplaceFragment(getSupportFragmentManager(), new EditProfileClientFragment(),
                            R.id.activity_home_client_frame_fragment, null, null);
                } else {
                    Toast.makeText(this, getString(R.string.shoud_register), Toast.LENGTH_LONG).show();
                    HelperMethod.ReplaceFragment(getSupportFragmentManager(), new LoginClient(),
                            R.id.activity_home_client_frame_fragment, null, null);
                }
                break;
            case R.id.activity_home_img_myorder:
                if (userData != null) {
                    HelperMethod.ReplaceFragment(getSupportFragmentManager(), new MyOrderClientContainerFragment(),
                            R.id.activity_home_client_frame_fragment, null, null);
                } else {
                    Toast.makeText(this, getString(R.string.shoud_register), Toast.LENGTH_LONG).show();
                    HelperMethod.ReplaceFragment(getSupportFragmentManager(), new LoginClient(),
                            R.id.activity_home_client_frame_fragment, null, null);
                }

                break;
            case R.id.activity_home_img_home:
                HelperMethod.ReplaceFragment(getSupportFragmentManager(),homeFragmentt
                        ,R.id.activity_home_client_frame_fragment,null,null);
                break;
        }
    }

//    @Override
//    public void onBackPressed() {
//        baseFragment.onBack();
//    }


}
