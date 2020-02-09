package com.example.mysofra.ui.activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mysofra.R;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.ui.fragment.restaurant.restaurantCycle.RestaurantLoginFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurntLoginActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurnt_login);
        ButterKnife.bind(this);
        HelperMethod.ReplaceFragment(getSupportFragmentManager(),new RestaurantLoginFragment(),
                R.id.activity_restaurnt_login,null,null);

    }
}
