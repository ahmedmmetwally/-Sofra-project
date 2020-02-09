package com.example.mysofra.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mysofra.R;
import com.example.mysofra.data.local.SharedPreferencesManger;
import com.example.mysofra.data.model.restaurntLogin.RestaurntLoginUser;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.ui.fragment.restaurant.CommissionsFragment;
import com.example.mysofra.ui.fragment.restaurant.EditProfileRestaurant;
import com.example.mysofra.ui.fragment.restaurant.MyOrderRestaurantContainer;
import com.example.mysofra.ui.fragment.restaurant.NotificationRestaurant;
import com.example.mysofra.ui.fragment.restaurant.RestaurantMyCategoriesFragmet;
import com.example.mysofra.ui.fragment.restaurant.restaurantCycle.MoreRestaurantFragment;
import com.example.mysofra.ui.fragment.restaurant.restaurantCycle.RestaurantLoginFragment;

import static com.example.mysofra.helper.constant.RESTAURANT_API_TOKEN;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RestaurantHomeActivity extends BaseActivity {

    @BindView(R.id.activity_restaurant_home_img_car)
    ImageView ImgCar;
    @BindView(R.id.activity_restaurant_homeimg_notification_appbar)
    ImageView imgNotificationAppbar;
    @BindView(R.id.activity_restaurant_home_img_menu)
    ImageView ImgMenu;
    @BindView(R.id.activity_restaurant_home_img_profil)
    ImageView ImgProfil;
    @BindView(R.id.activity_restaurant_home_img_myorder)
    ImageView ImgMyorder;
    @BindView(R.id.activity_restaurant_home_img_home)
    ImageView ImgHome;
    RestaurntLoginUser restaurntData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_home);
        ButterKnife.bind(this);
        HelperMethod.ReplaceFragment(getSupportFragmentManager(), new RestaurantMyCategoriesFragmet(),
                R.id.activity_restaurant_home_frame_fragment, null, null);

        restaurntData = SharedPreferencesManger
                .loadRestaurantData(RestaurantHomeActivity.this);
        if(restaurntData!=null)
        RESTAURANT_API_TOKEN = restaurntData.getApiToken();
    }


    @OnClick({R.id.activity_restaurant_home_img_car, R.id.activity_restaurant_homeimg_notification_appbar
            , R.id.activity_restaurant_home_img_menu, R.id.activity_restaurant_home_img_profil
            , R.id.activity_restaurant_home_img_myorder, R.id.activity_restaurant_home_img_home})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_restaurant_home_img_car:
               HelperMethod.ReplaceFragment(getSupportFragmentManager(), new CommissionsFragment(),
                        R.id.activity_restaurant_home_frame_fragment, null, null);
                break;
            case R.id.activity_restaurant_homeimg_notification_appbar:

                HelperMethod.ReplaceFragment(getSupportFragmentManager(), new NotificationRestaurant(),
                        R.id.activity_restaurant_home_frame_fragment, null, null);

                break;
            case R.id.activity_restaurant_home_img_menu:
                HelperMethod.ReplaceFragment(getSupportFragmentManager(), new MoreRestaurantFragment(),
                        R.id.activity_restaurant_home_frame_fragment, null, null);
                break;

            case R.id.activity_restaurant_home_img_profil:

                if (restaurntData != null) {
                    HelperMethod.ReplaceFragment(getSupportFragmentManager(), new EditProfileRestaurant(),
                            R.id.activity_restaurant_home_frame_fragment, null, null);
                } else {
                    Toast.makeText(this, getString(R.string.shoud_register), Toast.LENGTH_LONG).show();
                    RestaurantLoginFragment restaurantLoginFragment = new RestaurantLoginFragment();
                    restaurantLoginFragment.from_editProfile = true;
                    HelperMethod.ReplaceFragment(getSupportFragmentManager(), new RestaurantLoginFragment(),
                            R.id.activity_restaurant_home_frame_fragment, null, null);
                }

                break;

            case R.id.activity_restaurant_home_img_myorder:
                HelperMethod.ReplaceFragment(getSupportFragmentManager(), new MyOrderRestaurantContainer(),
                        R.id.activity_restaurant_home_frame_fragment, null, null);
                break;

            case R.id.activity_restaurant_home_img_home:
                HelperMethod.ReplaceFragment(getSupportFragmentManager(), new RestaurantMyCategoriesFragmet()
                        , R.id.activity_restaurant_home_frame_fragment, null, null);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        baseFragment.onBack();
    }

}
