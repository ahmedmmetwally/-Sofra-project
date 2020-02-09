// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.restaurant.restaurantCycle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RestaurantRegisterFragment_ViewBinding implements Unbinder {
  private RestaurantRegisterFragment target;

  private View view7f08019f;

  @UiThread
  public RestaurantRegisterFragment_ViewBinding(final RestaurantRegisterFragment target,
      View source) {
    this.target = target;

    View view;
    target.EdtRestourantname = Utils.findRequiredViewAsType(source, R.id.fragment_restaurant_register_edt_restourantname, "field 'EdtRestourantname'", EditText.class);
    target.EdtEmail = Utils.findRequiredViewAsType(source, R.id.fragment_restaurant_register_edt_email, "field 'EdtEmail'", EditText.class);
    target.SpCity = Utils.findRequiredViewAsType(source, R.id.fragment_restaurant_register_sp_city, "field 'SpCity'", Spinner.class);
    target.SpDistrict = Utils.findRequiredViewAsType(source, R.id.fragment_restaurant_register_sp_district, "field 'SpDistrict'", Spinner.class);
    target.EdtPassewrd = Utils.findRequiredViewAsType(source, R.id.fragment_restaurant_register_edt_passewrd, "field 'EdtPassewrd'", EditText.class);
    target.EdtPassewrdConfirm = Utils.findRequiredViewAsType(source, R.id.fragment_restaurant_register_edt_passewrd_confirm, "field 'EdtPassewrdConfirm'", EditText.class);
    target.EdtMinimumOrder = Utils.findRequiredViewAsType(source, R.id.fragment_restaurant_register_edt_minimum_order, "field 'EdtMinimumOrder'", EditText.class);
    target.EdtDeliveryCharge = Utils.findRequiredViewAsType(source, R.id.fragment_restaurant_register_delivery_charge, "field 'EdtDeliveryCharge'", EditText.class);
    view = Utils.findRequiredView(source, R.id.fragment_restaurant_register_btn_contnue, "field 'BtnContnue' and method 'onViewClicked'");
    target.BtnContnue = Utils.castView(view, R.id.fragment_restaurant_register_btn_contnue, "field 'BtnContnue'", Button.class);
    view7f08019f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.EdtDurationArrival = Utils.findRequiredViewAsType(source, R.id.fragment_restaurant_registert_edt_Duration_arrival, "field 'EdtDurationArrival'", EditText.class);
    target.LinearDistrict = Utils.findRequiredViewAsType(source, R.id.fragment_restaurant_register_linear_district, "field 'LinearDistrict'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RestaurantRegisterFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.EdtRestourantname = null;
    target.EdtEmail = null;
    target.SpCity = null;
    target.SpDistrict = null;
    target.EdtPassewrd = null;
    target.EdtPassewrdConfirm = null;
    target.EdtMinimumOrder = null;
    target.EdtDeliveryCharge = null;
    target.BtnContnue = null;
    target.EdtDurationArrival = null;
    target.LinearDistrict = null;

    view7f08019f.setOnClickListener(null);
    view7f08019f = null;
  }
}
