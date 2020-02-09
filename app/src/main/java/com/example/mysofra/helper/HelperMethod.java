package com.example.mysofra.helper;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.format.DateFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.example.mysofra.R;
import com.example.mysofra.adapter.SpinnerAdpter;
import com.example.mysofra.data.model.DateTxt;
import com.example.mysofra.data.model.cityAndRegion.CitiesAndRegion;
import com.google.android.material.snackbar.Snackbar;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumConfig;
import com.yanzhenjie.album.AlbumFile;

import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.core.content.ContextCompat.startActivity;


public class HelperMethod {

    private static ProgressDialog checkDialog;
    public static AlertDialog alertDialog;
    public static Snackbar snackbar;

    public static MultipartBody.Part convertFileToMultipart(String pathImageFile, String Key) {
        if (pathImageFile != null) {
            File file = new File(pathImageFile);

            RequestBody reqFileselect = RequestBody.create(MediaType.parse("image/*"), file);

            MultipartBody.Part Imagebody = MultipartBody.Part.createFormData(Key, file.getName(), reqFileselect);

            return Imagebody;
        } else {
            return null;
        }
    }


    public static RequestBody convertToRequestBody(String part) {
        try {
            if (!part.equals("")) {
                RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), part);
                return requestBody;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static void onLoadImageFromUrl(ImageView imageView, String URl, Context context, int drId) {
        Glide.with(context)
                .load(URl)
                .into(imageView);
    }

    public static void createSnackBar(View view, String message, Context context) {
        final Snackbar snackbar = Snackbar.make(view, message, 50000);
        snackbar.setAction(R.string.dismiss, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss();
            }
        })
                .setActionTextColor(context.getResources().getColor(android.R.color.holo_red_light))

                .show();
    }

    public static void createSnackBar(View view, String message, Context context, View.OnClickListener action, String Title) {
        snackbar = Snackbar.make(view, message, 50000);
        snackbar.setAction(Title, action)
                .setActionTextColor(context.getResources().getColor(android.R.color.holo_red_light))
                .show();
    }

    public static void customToast(Activity activity, String ToastTitle, boolean failed) {

        LayoutInflater inflater = activity.getLayoutInflater();

        int layout_id;

        if (failed) {
            layout_id = R.layout.success_toast;
        } else {
              layout_id = R.layout.toast;
        }

        View layout = inflater.inflate(layout_id,
                (ViewGroup) activity.findViewById(R.id.toast_layout_root));

        TextView text = layout.findViewById(R.id.text);
        text.setText(ToastTitle);

        Toast toast = new Toast(activity);
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM, 0, 100);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    //Calender
//    public static void showCalender(Context context, String title, final TextView text_view_data, final DateModel data1) {
//
//        DatePickerDialog mDatePicker = new DatePickerDialog(context, AlertDialog.THEME_HOLO_DARK, new DatePickerDialog.OnDateSetListener() {
//            public void onDateSet(DatePicker datepicker, int selectedYear, int selectedMonth, int selectedDay) {
//
//                DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
//                DecimalFormat mFormat = new DecimalFormat("00", symbols);
//                String data = selectedYear + "-" + String.format(new Locale("en"), mFormat.format(Double.valueOf((selectedMonth + 1)))) + "-"
//                        + mFormat.format(Double.valueOf(selectedDay));
//                data1.setDate_txt(data);
//                data1.setDay(mFormat.format(Double.valueOf(selectedDay)));
//                data1.setMonth(mFormat.format(Double.valueOf(selectedMonth + 1)));
//                data1.setYear(String.valueOf(selectedYear));
//                if (text_view_data != null) {
//                    text_view_data.setText(data);
//                }
//            }
//        }, Integer.parseInt(data1.getYear()), Integer.parseInt(data1.getMonth()) - 1, Integer.parseInt(data1.getDay()));
//        mDatePicker.setTitle(title);
//        mDatePicker.show();
//    }

    public static void showProgressDialog(Activity activity, String title) {
        try {
            checkDialog = new ProgressDialog(activity);
            checkDialog.setMessage(title);
            checkDialog.setIndeterminate(false);
            checkDialog.setCancelable(false);
            checkDialog.show();

        } catch (Exception e) {

        }
    }

    public static void dismissProgressDialog() {
        try {
            if (checkDialog != null && checkDialog.isShowing()) {
                checkDialog.dismiss();
            }
        } catch (Exception e) {

        }
    }

    public static void ReplaceFragment(FragmentManager supportFragmentManager, Fragment fragment, int container_id
            , TextView toolbarTitle, String title) {

        FragmentTransaction transaction = supportFragmentManager.beginTransaction();

        transaction.replace(container_id, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        if (toolbarTitle != null) {
            toolbarTitle.setText(title);
        }

    }

    public static void showCalender(Context context, String title, final TextView text_view_data, final DateTxt data1) {
        DatePickerDialog mDatePicker = new DatePickerDialog(context, AlertDialog.THEME_HOLO_DARK, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datepicker, int selectedYear, int selectedMonth, int selectedDay) {
                DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
                DecimalFormat mFormat = new DecimalFormat("00", symbols);
                String data = selectedYear + "-" + mFormat.format(Double.valueOf((selectedMonth + 1))) + "-" + mFormat.format(Double.valueOf(selectedDay));
                data1.setDate_txt(data);
                data1.setDay(mFormat.format(Double.valueOf(selectedDay)));
                data1.setMonth(mFormat.format(Double.valueOf(selectedMonth + 1)));
                data1.setYear(String.valueOf(selectedYear));
                text_view_data.setText(data);
            }
        }, Integer.parseInt(data1.getYear()), Integer.parseInt(data1.getMonth()) - 1, Integer.parseInt(data1.getDay()));
        mDatePicker.setTitle(title);
        mDatePicker.show();
    }

    public static Date convertDateString(String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date parse = format.parse(date);

            return parse;

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static DateTxt convertStringToDateTxtModel(String date) {
        try {
            Date date1 = convertDateString(date);
            String day = (String) DateFormat.format("dd", date1); // 20
            String monthNumber = (String) DateFormat.format("MM", date1); // 06
            String year = (String) DateFormat.format("yyyy", date1); // 2013

            return new DateTxt(day, monthNumber, year, date);

        } catch (Exception e) {
            return null;
        }
    }

    public static void disappearKeypad(Activity activity, View v) {
        try {
            if (v != null) {
                InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        } catch (Exception e) {

        }
    }

    public static void onPermission(Activity activity) {
        String[] perms = {
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.CALL_PHONE};

        ActivityCompat.requestPermissions(activity,
                perms,
                100);

    }

    public static boolean checkWriteExternalPermission(Context context) {
        boolean check = false;
        String permission1 = android.Manifest.permission.ACCESS_FINE_LOCATION;
        int res1 = context.checkCallingOrSelfPermission(permission1);
        if (res1 != PackageManager.PERMISSION_GRANTED) {
            check = true;
        }
//
//        String permission2 = android.Manifest.permission.READ_CONTACTS;
//        int res2 = context.checkCallingOrSelfPermission(permission2);
//        if (res2 != PackageManager.PERMISSION_GRANTED) {
//            check = true;
//        }

        String permission3 = android.Manifest.permission.READ_EXTERNAL_STORAGE;
        int res3 = context.checkCallingOrSelfPermission(permission3);
        if (res3 != PackageManager.PERMISSION_GRANTED) {
            check = true;
        }

        String permission4 = android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
        int res4 = context.checkCallingOrSelfPermission(permission4);
        if (res4 != PackageManager.PERMISSION_GRANTED) {
            check = true;
        }

//        String permission5 = android.Manifest.permission.READ_PHONE_STATE;
//        int res5 = context.checkCallingOrSelfPermission(permission5);
//        if (res5 != PackageManager.PERMISSION_GRANTED) {
//            check = true;
//        }

        String permission6 = android.Manifest.permission.CALL_PHONE;
        int res6 = context.checkCallingOrSelfPermission(permission6);
        if (res6 != PackageManager.PERMISSION_GRANTED) {
            check = true;
        }

        return check;
    }

    public static void selectImage(Context context, int count, Action<ArrayList<AlbumFile>> action) {
        Album.initialize(AlbumConfig.newBuilder(context)
                .setAlbumLoader(new MediaLoader()).build());

        Album.image(context) // Image selection.
                .multipleChoice()
                .camera(true)
                .columnCount(count)
                .onResult(action)
                .onCancel(new Action<String>() {
                    @Override
                    public void onAction(@NonNull String result) {
                    }
                })
                .start();
    }

    public static void selectImage(Context context, ArrayList<AlbumFile> mAlbumFiles, int count, int selectCount
            , Action<ArrayList<AlbumFile>> action) {
        Album.initialize(AlbumConfig.newBuilder(context)
                .setAlbumLoader(new MediaLoader()).build());

        Album.image(context) // Image selection.
                .multipleChoice()
                .camera(true)
                .columnCount(count)// The number of columns in the page list.
                .selectCount(selectCount) // Choose up to a few images.
                .checkedList(mAlbumFiles) // To reverse the list.
                .onResult(action)
                .onCancel(new Action<String>() {
                    @Override
                    public void onAction(@NonNull String result) {
                    }
                })
                .start();
    }
    public static void getDataSpinners(Call<CitiesAndRegion> call, final SpinnerAdpter adpter, final String hint, final Spinner spinner) {
        call.enqueue(new Callback<CitiesAndRegion>() {
            @Override
            public void onResponse(Call<CitiesAndRegion> call, Response<CitiesAndRegion> response) {
                try {
                    if (response.body().getStatus() == 1) {
                        adpter.setData(response.body().getData(), hint);
                        spinner.setAdapter(adpter);
                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<CitiesAndRegion> call, Throwable t) {

            }
        });

    }

    public static void getDataSpinners(Call<CitiesAndRegion> call, final SpinnerAdpter adpter
            , final String hint, final Spinner spinner, final AdapterView.OnItemSelectedListener listener) {
        call.enqueue(new Callback<CitiesAndRegion>() {
            @Override
            public void onResponse(Call<CitiesAndRegion> call, Response<CitiesAndRegion> response) {
                try {
                    if (response.body().getStatus() == 1) {
                        adpter.setData(response.body().getData(), hint);
                        spinner.setAdapter(adpter);
                        spinner.setOnItemSelectedListener(listener);
                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<CitiesAndRegion> call, Throwable t) {

            }
        });

    }
    public void makeCall(String num){
//       if (checkWriteExternalPermission(getActivity())) {
//            onPermission(getActivity());
//            return;
//        }
//
//        String number = "tel:" + donationData.getPhone();
//        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(number));
//        startActivity(callIntent);
//    }
    }
}
