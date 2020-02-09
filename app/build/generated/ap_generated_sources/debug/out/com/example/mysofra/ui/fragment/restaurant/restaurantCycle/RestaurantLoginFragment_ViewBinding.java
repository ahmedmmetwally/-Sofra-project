// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.restaurant.restaurantCycle;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RestaurantLoginFragment_ViewBinding implements Unbinder {
  private RestaurantLoginFragment target;

  private View view7f08019e;

  private View view7f08019c;

  private View view7f08019d;

  @UiThread
  public RestaurantLoginFragment_ViewBinding(final RestaurantLoginFragment target, View source) {
    this.target = target;

    View view;
    target.RestaurantLoginEdtEmail = Utils.findRequiredViewAsType(source, R.id.fragment_restaurant_login_edt_email, "field 'RestaurantLoginEdtEmail'", EditText.class);
    target.RestaurantLoginEdtPassword = Utils.findRequiredViewAsType(source, R.id.fragment_restaurant_login_edt_password, "field 'RestaurantLoginEdtPassword'", EditText.class);
    view = Utils.findRequiredView(source, R.id.fragment_restaurant_login_txtv_forgetpassword, "field 'RestaurantLoginTxtvForgetpassword' and method 'onViewClicked'");
    target.RestaurantLoginTxtvForgetpassword = Utils.castView(view, R.id.fragment_restaurant_login_txtv_forgetpassword, "field 'RestaurantLoginTxtvForgetpassword'", TextView.class);
    view7f08019e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_restaurant_login_rlt_register, "field 'RestaurantLoginRltRegister' and method 'onViewClicked'");
    target.RestaurantLoginRltRegister = Utils.castView(view, R.id.fragment_restaurant_login_rlt_register, "field 'RestaurantLoginRltRegister'", RelativeLayout.class);
    view7f08019c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_restaurant_login_txtv_creataccount, "field 'RestaurantLoginTxtvCreataccount' and method 'onViewClicked'");
    target.RestaurantLoginTxtvCreataccount = Utils.castView(view, R.id.fragment_restaurant_login_txtv_creataccount, "field 'RestaurantLoginTxtvCreataccount'", TextView.class);
    view7f08019d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    RestaurantLoginFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.RestaurantLoginEdtEmail = null;
    target.RestaurantLoginEdtPassword = null;
    target.RestaurantLoginTxtvForgetpassword = null;
    target.RestaurantLoginRltRegister = null;
    target.RestaurantLoginTxtvCreataccount = null;

    view7f08019e.setOnClickListener(null);
    view7f08019e = null;
    view7f08019c.setOnClickListener(null);
    view7f08019c = null;
    view7f08019d.setOnClickListener(null);
    view7f08019d = null;
  }
}
