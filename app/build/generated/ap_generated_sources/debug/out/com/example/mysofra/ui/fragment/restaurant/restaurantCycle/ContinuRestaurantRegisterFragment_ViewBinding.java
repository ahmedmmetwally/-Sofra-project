// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.restaurant.restaurantCycle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ContinuRestaurantRegisterFragment_ViewBinding implements Unbinder {
  private ContinuRestaurantRegisterFragment target;

  private View view7f0800fa;

  private View view7f0800fd;

  @UiThread
  public ContinuRestaurantRegisterFragment_ViewBinding(
      final ContinuRestaurantRegisterFragment target, View source) {
    this.target = target;

    View view;
    target.EdtPhonenum = Utils.findRequiredViewAsType(source, R.id.fragment_continue_restaurant_register_edt_phonenum, "field 'EdtPhonenum'", EditText.class);
    target.EdtWatts = Utils.findRequiredViewAsType(source, R.id.fragment_continue_restaurant_register_edt_watts, "field 'EdtWatts'", EditText.class);
    view = Utils.findRequiredView(source, R.id.fragment_continue_restaurant_register_btn_register, "field 'BtnRegister' and method 'onViewClicked'");
    target.BtnRegister = Utils.castView(view, R.id.fragment_continue_restaurant_register_btn_register, "field 'BtnRegister'", Button.class);
    view7f0800fa = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.fragmentLoginRltRegister = Utils.findRequiredViewAsType(source, R.id.fragment_login_rlt_register, "field 'fragmentLoginRltRegister'", RelativeLayout.class);
    view = Utils.findRequiredView(source, R.id.fragment_continue_restaurant_register_image_profile, "field 'ImageProfile' and method 'onViewClicked'");
    target.ImageProfile = Utils.castView(view, R.id.fragment_continue_restaurant_register_image_profile, "field 'ImageProfile'", ImageView.class);
    view7f0800fd = view;
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
    ContinuRestaurantRegisterFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.EdtPhonenum = null;
    target.EdtWatts = null;
    target.BtnRegister = null;
    target.fragmentLoginRltRegister = null;
    target.ImageProfile = null;

    view7f0800fa.setOnClickListener(null);
    view7f0800fa = null;
    view7f0800fd.setOnClickListener(null);
    view7f0800fd = null;
  }
}
