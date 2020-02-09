package com.example.mysofra.data.local;

import android.app.Activity;
import android.content.SharedPreferences;

import com.example.mysofra.data.model.clientlogin.ClientloginUser;
import com.example.mysofra.data.model.restaurntLogin.RestaurntLoginUser;
import com.google.gson.Gson;

public class SharedPreferencesManger {
    private static SharedPreferences sharedPreferences = null;
    private static String USER_DATA = "USER_DATA";
    private static String RESTAURANT_DATA = "RESTAURANT_DATA";
    private static String USER_ID = "USER_ID";
    private static String USER_EMAIL = "USER_EMAIL";
    private static String USER_NAME = "USER_NAME";
    private static String USER_BID = "USER_BID";
    private static String USER_PHONE = "USER_PHONE";
    private static String USER_DLD = "USER_DLD";
    private static String USER_PIN_CODE = "USER_PIN_CODE";
    public static String USER_API_TOKEN = "USER_API_TOKEN";
    private static String USER_CITY_ID = "USER_CITY_ID";
    private static String USER_CITY_NAME = "USER_CITY_NAME";
    private static String USER_GOVERMENT_NAME = "USER_GOVERMENT_NAME";
    private static String USER_GOVERMENT_ID = "USER_GOVERMENT_ID";
    private static String USER_BLOOD_TYPE_ID = "USER_BLOOD_TYPE_ID";
    private static String USER_BLOOD_TYPE_NAME = "USER_BLOOD_TYPE_NAME";
    public static String USER_PASSWORD = "USER_PASSWORD";
    public static String REMEMBER = "REMEMBER";
    public static String TOTAL_PRICEE = "TOTAL_PRICE";


    public static void setSharedPreferences(Activity activity) {
        if (sharedPreferences == null) {
            sharedPreferences = activity.getSharedPreferences(
                    "sofra", activity.MODE_PRIVATE);
        }
    }

    public static void SaveData(Activity activity, String data_Key, String data_Value) {
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(data_Key, data_Value);
            editor.commit();
        } else {
            setSharedPreferences(activity);
        }
    }

    public static void SaveData(Activity activity, String data_Key, boolean data_Value) {
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(data_Key, data_Value);
            editor.commit();
        } else {
            setSharedPreferences(activity);
        }
    }


    public static String LoadData(Activity activity, String data_Key) {
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
        } else {
            setSharedPreferences(activity);
        }

        return sharedPreferences.getString(data_Key, null);
    }



    public static boolean LoadBoolean(Activity activity, String data_Key) {
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
        } else {
            setSharedPreferences(activity);
        }

        return sharedPreferences.getBoolean(data_Key, false);
    }

    public static void SaveData(Activity activity, String data_Key, Object data_Value) {
        setSharedPreferences(activity);
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String StringData = gson.toJson(data_Value);
            editor.putString(data_Key, StringData);
            editor.commit();
        }
    }
    public static void saveTotalPrice(Activity activity,Float TotalPricee) {
      //  String TotalPrice=TotalPricee.toString();
        saveTotal(activity, TOTAL_PRICEE, TotalPricee);
    }
    public static void saveTotal(Activity activity, String data_Key, Float data_Value) {
        setSharedPreferences(activity);
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putFloat(data_Key, data_Value);
            editor.apply();
            editor.commit();
        }
    }
    public static Float loadTotal(Activity activity) {
        return (LoadFloatData(activity, TOTAL_PRICEE));
    }
    public static Float LoadFloatData(Activity activity, String data_Key) {
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
        } else {
            setSharedPreferences(activity);
        }

        return sharedPreferences.getFloat(data_Key, 0);
    }






    public static void saveUserData(Activity activity, ClientloginUser userData) {
        SaveData(activity, USER_DATA, userData);
    }
    public static void saveRestaurantData(Activity activity, RestaurntLoginUser restaurantData) {
        SaveData(activity, RESTAURANT_DATA, restaurantData);
    }

    public static ClientloginUser loadUserData(Activity activity) {
        ClientloginUser userData = null;

        Gson gson = new Gson();
        userData = gson.fromJson(LoadData(activity, USER_DATA), ClientloginUser.class);

        return userData;
    }
    public static RestaurntLoginUser loadRestaurantData(Activity activity) {
        RestaurntLoginUser restaurantData = null;

        Gson gson = new Gson();
        restaurantData = gson.fromJson(LoadData(activity, RESTAURANT_DATA), RestaurntLoginUser.class);

        return restaurantData;
    }

    public static void clean(Activity activity) {
        setSharedPreferences(activity);
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.commit();
        }
    }

    public static void deleteDate(String key){
//        sharedPreferences = activity.getSharedPreferences(
//                "sofra", activity.MODE_PRIVATE);
        sharedPreferences.edit().remove(key).commit();

    }

}