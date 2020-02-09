package com.example.mysofra.ui.fragment;

import androidx.fragment.app.Fragment;

import com.example.mysofra.ui.activity.BaseActivity;

public class BaseFragment extends Fragment {

    public BaseActivity baseActivity;


    public void setUpActivity() {
        baseActivity = (BaseActivity) getActivity();
        baseActivity.baseFragment = this;
    }



    public void onBack() {
        baseActivity.superBackPressed();
    }

}




























//    <?xml version="1.0" encoding="utf-8"?>
//<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
//        android:layout_width="match_parent"
//        android:layout_height="match_parent"
//        android:orientation="vertical"
//        android:padding="@dimen/dim_32">
//
//<TextView
//        android:id="@+id/___txt_request_deta"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_centerHorizontal="true"
//                android:layout_marginBottom="@dimen/dim_16"
//                android:gravity="center_vertical"
//                android:text="@string/request_details"
//                android:textAppearance="@style/TextAppearance.AppCompat.Large"
//                android:textSize="30sp" />
//
//<RelativeLayout
//        android:id="@+id/___rl_container"
//
//                android:layout_width="match_parent"
//                android:layout_height="150dp"
//                android:layout_below="@+id/___txt_request_deta"
//                android:background="@drawable/rectangle_shap2_grey"
//                android:padding="@dimen/dim_16">
//
//<TextView
//            android:id="@+id/___txt_notif"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:layout_alignParentEnd="true"
//                    android:text="@string/add_notification"
//
//                    android:textSize="30sp" />
//
//<EditText
//            android:id="@+id/___txt_add_notification"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:layout_below="@id/___txt_notif"
//                    android:layout_alignParentEnd="true"
//                    android:text="ddddddd"
//                    android:textSize="23sp" />
//</RelativeLayout>
//
//<TextView
//        android:id="@+id/___txt_adres_"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_below="@id/___rl_container"
//                android:layout_alignParentEnd="true"
//                android:text="@string/delivery_adress"
//                android:textSize="30sp" />
//
//<TextView
//        android:id="@+id/___txt_delivery_adress"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_below="@id/___txt_adres_"
//                android:layout_alignParentEnd="true"
//                android:layout_marginVertical="@dimen/dim_8"
//                android:text="yyyyyyyy"
//                android:textColor="@color/redre"
//                android:textSize="30sp" />
//
//<TextView
//        android:id="@+id/___txt_paying_"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_below="@id/___txt_delivery_adress"
//                android:layout_alignParentEnd="true"
//                android:text="@string/paying_off"
//                android:textSize="30sp" />
//
//<TextView
//        android:id="@+id/___txt_payin_on_delivery_"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_alignParentEnd="true"
//                android:layout_marginVertical="@dimen/dim_8"
//                android:text="@string/cash_on_delivery"
//                android:textColor="@color/redre"
//                android:textSize="30sp"
//                android:layout_below="@+id/___txt_paying_"
//                />
//
//
//
//<TextView
//        android:id="@+id/___txt_payin_online_"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_below="@id/___txt_paying_"
//                android:layout_alignParentStart="true"
//                android:layout_marginVertical="@dimen/dim_8"
//                android:layout_alignBaseline="@id/___txt_payin_on_delivery_"
//                android:text="@string/online_payment"
//                android:textColor="@color/redre"
//                android:textSize="30sp" />
//<RadioGroup
//        android:id="@+id/___rg_radio_group"
//                android:layout_width="match_parent"
//                android:layout_height="wrap_content"
//                android:layout_below="@id/___txt_payin_on_delivery_"
//                android:orientation="horizontal"
//                >
//<de.hdodenhof.circleimageview.CircleImageView
//        android:id="@+id/___img_cash_on_delivery"
//        android:layout_width="50dp"
//        android:layout_height="50dp"
//        android:layout_below="@id/___txt_payin_on_delivery_"
//        android:layout_alignParentEnd="true"
//        android:layout_marginRight="25dp"
//        android:background="@drawable/circle_with_strok"/>
//<de.hdodenhof.circleimageview.CircleImageView
//        android:id="@+id/___img_online_payment"
//        android:layout_width="50dp"
//        android:layout_height="50dp"
//        android:layout_below="@id/___txt_payin_online_"
//        android:layout_marginStart="50dp"
//        android:background="@drawable/circle_with_strok"/>
//</RadioGroup>
//
//
//<RelativeLayout
//        android:id="@+id/___rl_con_"
//                android:layout_width="match_parent"
//                android:layout_height="110dp"
//                android:layout_below="@+id/___rg_radio_group"
//                android:background="@drawable/rectangel_shape_white"
//                android:padding="@dimen/dim_5"
//                >
//
//<TextView
//            android:id="@+id/___txt_total_"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:layout_alignParentEnd="true"
//                    android:text="@string/total"
//                    android:textAppearance="@style/TextAppearance.AppCompat.Large"
//                    android:textSize="23sp" />
//
//<TextView
//            android:id="@+id/___txt_total"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//
//                    android:layout_marginRight="@dimen/dim_8"
//                    android:layout_toLeftOf="@+id/___txt_total_"
//                    android:text="dddddddd"
//                    android:textAppearance="@style/TextAppearance.AppCompat.Large"
//                    android:textSize="23sp"
//                    />
//<TextView
//            android:id="@+id/___txt_charg_deli_"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:text="@string/delivery_charge"
//                    android:textAppearance="@style/TextAppearance.AppCompat.Large"
//                    android:textSize="23sp"
//                    android:layout_alignParentEnd="true"
//                    android:layout_below="@id/___txt_total"/>
//
//<TextView
//            android:id="@+id/___txt_charg_delivery"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:layout_toLeftOf="@+id/___txt_charg_deli_"
//                    android:text="dddddddd"
//                    android:textAppearance="@style/TextAppearance.AppCompat.Large"
//                    android:textSize="23sp"
//                    android:layout_below="@id/___txt_total"/>
//<TextView
//            android:id="@+id/___txt_totalamou_"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:text="@string/delivery_charge"
//                    android:textAppearance="@style/TextAppearance.AppCompat.Large"
//                    android:textSize="23sp"
//                    android:layout_alignParentEnd="true"
//                    android:layout_below="@id/___txt_charg_delivery"/>
//
//<TextView
//            android:id="@+id/___txt_total_amount"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:layout_toLeftOf="@+id/___txt_totalamou_"
//                    android:text="dddddddd"
//                    android:textAppearance="@style/TextAppearance.AppCompat.Large"
//                    android:textSize="23sp"
//                    android:layout_below="@id/___txt_charg_delivery"/>
//
//</RelativeLayout>
//
//
//<RelativeLayout
//        android:id="@+id/__rl_contain_button"
//                android:layout_width="200dp"
//                android:layout_height="wrap_content"
//                android:background="@drawable/rectangle56"
//                android:layout_below="@+id/___rl_con_"
//                android:layout_centerHorizontal="true"
//                android:gravity="center_horizontal"
//                android:layout_marginTop="@dimen/dim_16">
//<TextView
//            android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:text="@string/confirm_delivery"
//                    android:textSize="25sp"
//
//                    android:textAppearance="@style/TextAppearance.AppCompat.Large"
//                    />
//</RelativeLayout>
//
//
//
//
//
//</RelativeLayout>
//













//
//    <?xml version="1.0" encoding="utf-8"?>
//<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
//        android:layout_width="match_parent"
//        android:layout_height="match_parent"
//        android:orientation="vertical"
//        android:padding="@dimen/dim_32">
//
//<TextView
//        android:id="@+id/___txt_request_deta"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_centerHorizontal="true"
//                android:layout_marginBottom="@dimen/dim_16"
//                android:gravity="center_vertical"
//                android:text="@string/request_details"
//                android:textAppearance="@style/TextAppearance.AppCompat.Large"
//                android:textSize="30sp" />
//
//<RelativeLayout
//        android:id="@+id/___rl_container"
//
//                android:layout_width="match_parent"
//                android:layout_height="150dp"
//                android:layout_below="@+id/___txt_request_deta"
//                android:background="@drawable/rectangle_shap2_grey"
//                android:padding="@dimen/dim_16">
//
//<TextView
//            android:id="@+id/___txt_notif"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:layout_alignParentEnd="true"
//                    android:text="@string/add_notification"
//                    android:textSize="30sp" />
//
//<EditText
//            android:id="@+id/___txt_add_notification"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:layout_below="@id/___txt_notif"
//                    android:layout_alignParentEnd="true"
//                    android:text="ddddddd"
//                    android:textSize="23sp" />
//</RelativeLayout>
//
//<TextView
//        android:id="@+id/___txt_adres_"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_below="@id/___rl_container"
//                android:layout_alignParentEnd="true"
//                android:text="@string/delivery_adress"
//                android:textSize="30sp" />
//
//<TextView
//        android:id="@+id/___txt_delivery_adress"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_below="@id/___txt_adres_"
//                android:layout_alignParentEnd="true"
//                android:layout_marginVertical="@dimen/dim_8"
//                android:text="yyyyyyyy"
//                android:textColor="@color/redre"
//                android:textSize="30sp" />
//
//<TextView
//        android:id="@+id/___txt_paying_"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_below="@id/___txt_delivery_adress"
//                android:layout_alignParentEnd="true"
//                android:text="@string/paying_off"
//                android:textSize="30sp" />
//<RadioGroup
//        android:layout_width="match_parent"
//                android:layout_height="wrap_content"
//                android:layout_below="@+id/__rl_contain_button">
//<TextView
//        android:id="@+id/___txt_payin_on_delivery_"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_below="@id/___txt_paying_"
//                android:layout_alignParentEnd="true"
//                android:layout_marginVertical="@dimen/dim_8"
//                android:text="@string/cash_on_delivery"
//                android:textColor="@color/redre"
//                android:textSize="30sp" />
//
//<de.hdodenhof.circleimageview.CircleImageView
//        android:id="@+id/___img_cash_on_delivery"
//        android:layout_width="50dp"
//        android:layout_height="50dp"
//        android:layout_below="@id/___txt_payin_on_delivery_"
//        android:layout_alignParentEnd="true"
//        android:layout_marginRight="25dp"
//        android:background="@drawable/circle_with_strok"/>
//
//<TextView
//        android:id="@+id/___txt_payin_online_"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_below="@id/___txt_paying_"
//                android:layout_alignParentStart="true"
//                android:layout_marginVertical="@dimen/dim_8"
//                android:layout_alignBaseline="@id/___txt_payin_on_delivery_"
//                android:text="@string/online_payment"
//                android:textColor="@color/redre"
//                android:textSize="30sp" />
//
//<de.hdodenhof.circleimageview.CircleImageView
//        android:id="@+id/___img_online_payment"
//        android:layout_width="50dp"
//        android:layout_height="50dp"
//        android:layout_below="@id/___txt_payin_online_"
//        android:layout_marginStart="50dp"
//        android:background="@drawable/circle_with_strok"/>
//
//<RelativeLayout
//        android:id="@+id/___rl_con_"
//                android:layout_width="match_parent"
//                android:layout_height="110dp"
//                android:layout_below="@+id/___img_cash_on_delivery"
//                android:background="@drawable/rectangel_shape_white"
//                android:padding="@dimen/dim_5"
//                >
//
//<TextView
//            android:id="@+id/___txt_total_"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:layout_alignParentEnd="true"
//                    android:text="@string/total"
//                    android:textAppearance="@style/TextAppearance.AppCompat.Large"
//                    android:textSize="23sp" />
//
//<TextView
//            android:id="@+id/___txt_total"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//
//                    android:layout_marginRight="@dimen/dim_8"
//                    android:layout_toLeftOf="@+id/___txt_total_"
//                    android:text="dddddddd"
//                    android:textAppearance="@style/TextAppearance.AppCompat.Large"
//                    android:textSize="23sp"
//                    />
//<TextView
//            android:id="@+id/___txt_charg_deli_"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:text="@string/delivery_charge"
//                    android:textAppearance="@style/TextAppearance.AppCompat.Large"
//                    android:textSize="23sp"
//                    android:layout_alignParentEnd="true"
//                    android:layout_below="@id/___txt_total"/>
//
//<TextView
//            android:id="@+id/___txt_charg_delivery"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:layout_toLeftOf="@+id/___txt_charg_deli_"
//                    android:text="dddddddd"
//                    android:textAppearance="@style/TextAppearance.AppCompat.Large"
//                    android:textSize="23sp"
//                    android:layout_below="@id/___txt_total"/>
//<TextView
//            android:id="@+id/___txt_totalamou_"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:text="@string/delivery_charge"
//                    android:textAppearance="@style/TextAppearance.AppCompat.Large"
//                    android:textSize="23sp"
//                    android:layout_alignParentEnd="true"
//                    android:layout_below="@id/___txt_charg_delivery"/>
//
//<TextView
//            android:id="@+id/___txt_total_amount"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:layout_toLeftOf="@+id/___txt_totalamou_"
//                    android:text="dddddddd"
//                    android:textAppearance="@style/TextAppearance.AppCompat.Large"
//                    android:textSize="23sp"
//                    android:layout_below="@id/___txt_charg_delivery"/>
//
//</RelativeLayout>
//
//
//<RelativeLayout
//        android:id="@+id/__rl_contain_button"
//                android:layout_width="200dp"
//                android:layout_height="wrap_content"
//                android:background="@drawable/rectangle56"
//                android:layout_below="@+id/___rl_con_"
//                android:layout_centerHorizontal="true"
//                android:gravity="center_horizontal"
//                android:layout_marginTop="@dimen/dim_16">
//<TextView
//            android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:text="@string/confirm_delivery"
//                    android:textSize="25sp"
//
//                    android:textAppearance="@style/TextAppearance.AppCompat.Large"
//                    />
//</RelativeLayout>
//
//
//
//
//
//</RelativeLayout>