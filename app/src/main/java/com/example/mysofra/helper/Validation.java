package com.example.mysofra.helper;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mysofra.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * Created by sas on 08/04/2018.
 */

public class Validation {
    public static String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    Context context;


    public static boolean setEmailValidation(Activity activity, String email) {

        if (!email.matches(emailPattern)) {
            customToast(activity, activity.getString(R.string.invalid_email));
            return false;
        } else {
            return true;
        }

    }


    // this method validate  password
    public static boolean setPasswordValidation(Activity activity, String password) {

        if (password.length() < 6) {
            customToast(activity, activity.getString(R.string.invalid_password));
            return false;
        } else {
            return true;
        }

    }


    // this method validate confirmation  password you have to put password editText field and confirm password edit text field
    public static boolean setConfirmPassword(Activity activity, String password, String confirmPassword) {

        if (!password.equals(confirmPassword)) {
            customToast(activity, activity.getString(R.string.invalid_confirm_password));
            return false;
        } else {
            return true;
        }


    }

    // this method validate  user name
    public static boolean setTextValidation(Activity activity, String text, int length, String message) {

        if (text.length() <= length) {
            customToast(activity, message);
            return false;
        } else {
            return true;
        }


    }


    //  this method to validate any editText for not null
    public boolean setEmptyValidation(Activity activity, String text) {

        if (TextUtils.isEmpty(text)) {
            customToast(activity, activity.getString(R.string.failed_required));
            return false;
        } else {
            return true;
        }
    }

    public static void customToast(Activity activity, String ToastTitle) {

        LayoutInflater inflater = activity.getLayoutInflater();

        View layout = inflater.inflate(R.layout.toast,
                (ViewGroup) activity.findViewById(R.id.toast_layout_root));

        TextView text = layout.findViewById(R.id.text);
        text.setText(ToastTitle);

        Toast toast = new Toast(activity);
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM, 0, 100);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
    public static final SimpleDateFormat BIRTHDAY_FORMAT_PARSER = new SimpleDateFormat("yyyy-MM-dd");

    public static final String DASH_STRING = "-";

    // This regex must accept Arabic letters,English letters, spaces and numbers
    public static final String USERNAME_PATERN = "^[\\u0621-\\u064Aa-zA-Z\\d\\-_\\s]{3,25}+$";

    public static boolean isValidName(String name) {

        return name.matches(USERNAME_PATERN);
    }

    public static boolean isValidPhone(String phone) {

        return phone.length() == 11 && TextUtils.isDigitsOnly(phone) && !TextUtils.isEmpty(phone);
    }

    public static boolean isValidPassword(String password) {

        return password.length() >= 3 && !TextUtils.isEmpty(password);
    }

    public static boolean isValidContent(String content) {

        return !TextUtils.isEmpty(content);
    }
    public static boolean isIdenticalPassword(String passwordConfirm, String fullConfirmPassword) {

        return passwordConfirm.equals(fullConfirmPassword) && !TextUtils.isEmpty(passwordConfirm)
                && !TextUtils.isEmpty(fullConfirmPassword);
    }

    public static boolean isValidEmail(String email) {

        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && !TextUtils.isEmpty(email);
    }


    public static boolean isEmptyField(String text) {

        return !TextUtils.isEmpty(text);
    }


    public static Calendar parseDateString(String date) {
        Calendar calendar = Calendar.getInstance();
        BIRTHDAY_FORMAT_PARSER.setLenient(false);
        try {
            calendar.setTime(BIRTHDAY_FORMAT_PARSER.parse(date));
        } catch (ParseException e) {
        }
        return calendar;
    }

    public static boolean isValidBirthday(String birthday) {
        Calendar calendar = parseDateString(birthday);
        int year = calendar.get(Calendar.YEAR);
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);

        return year >= 1900 && year < thisYear - 9;
    }

    public static boolean isValiddonationday(String donationday) {
        Calendar calendar = parseDateString(donationday);
        int year = calendar.get(Calendar.YEAR);
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int thismonth = Calendar.getInstance().get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int thisday = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        return year >= 1960 && year <= thisYear && month <= thismonth && day <= thisday;
    }

}
