package com.example.mysofra.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mysofra.ui.fragment.client.homeFragment.GetRestaurantsDetailsFragment;
import com.example.mysofra.ui.fragment.client.homeFragment.GetRestaurantsItemAndCategoryFoodFragment;
import com.example.mysofra.ui.fragment.client.homeFragment.GetRestaurantsReviewsFragment;
import com.example.mysofra.ui.fragment.client.homeFragment.ShowRestaurantsContainerFragment;

public class ShowRestaurantsContainerAdapter extends FragmentPagerAdapter {
    int id;
    ShowRestaurantsContainerFragment sh=new ShowRestaurantsContainerFragment();

    public ShowRestaurantsContainerAdapter(@NonNull FragmentManager fm,int id) {
        super(fm);
        this.id=id;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                GetRestaurantsItemAndCategoryFoodFragment itemtFoood = new GetRestaurantsItemAndCategoryFoodFragment();
                itemtFoood.restaurantId=id;
                return itemtFoood;

            case 1:
                GetRestaurantsReviewsFragment reviews = new GetRestaurantsReviewsFragment();
                reviews.restaurant_iddd=id;
                return reviews;
            case 2:
                GetRestaurantsDetailsFragment details = new GetRestaurantsDetailsFragment();
                details.restaurant_idd=id;
                return details;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
               return "قائمة الطعام";
            // return (R.string.food_menu) + "";
            //return getString(R.string.food_menu);

            case 1:
               return "التعليقات والتقيمات";
            // return R.string.restaurants_comments_and_ratings + "";
               // return getResurces.getString(R.string.restaurants_comments_and_ratings);

            case 2:
                return "معلومات المتجر";
            //   return (R.string.restaurnt_information) + "";

            default:
                return null;
        }


    }
}
