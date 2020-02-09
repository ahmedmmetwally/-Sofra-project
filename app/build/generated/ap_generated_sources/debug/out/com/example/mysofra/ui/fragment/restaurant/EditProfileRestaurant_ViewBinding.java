// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.restaurant;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EditProfileRestaurant_ViewBinding implements Unbinder {
  private EditProfileRestaurant target;

  private View view7f08011a;

  private View view7f080116;

  @UiThread
  public EditProfileRestaurant_ViewBinding(final EditProfileRestaurant target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.fragment_edit_profile_restaurant_img_imgecricle, "field 'imgecricle' and method 'onViewClicked'");
    target.imgecricle = Utils.castView(view, R.id.fragment_edit_profile_restaurant_img_imgecricle, "field 'imgecricle'", CircleImageView.class);
    view7f08011a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.edtName = Utils.findRequiredViewAsType(source, R.id.fragment_edit_profile_restaurant_edt_name, "field 'edtName'", EditText.class);
    target.edtEmail = Utils.findRequiredViewAsType(source, R.id.fragment_edit_profile_restaurant_edt_email, "field 'edtEmail'", TextView.class);
    target.spinerCity = Utils.findRequiredViewAsType(source, R.id.fragment_edit_profile_restaurant_spn_spiner_city, "field 'spinerCity'", Spinner.class);
    target.spinnerRegion = Utils.findRequiredViewAsType(source, R.id.fragment_edit_profile_restaurant_spn_sinner_region, "field 'spinnerRegion'", Spinner.class);
    target.edtdeliverycost = Utils.findRequiredViewAsType(source, R.id.fragment_edit_profile_restaurant_edt_delivery_cost, "field 'edtdeliverycost'", EditText.class);
    view = Utils.findRequiredView(source, R.id.fragment_edit_profile_restaurant_btn_continue, "field 'btnContinue' and method 'onViewClicked'");
    target.btnContinue = Utils.castView(view, R.id.fragment_edit_profile_restaurant_btn_continue, "field 'btnContinue'", Button.class);
    view7f080116 = view;
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
    EditProfileRestaurant target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgecricle = null;
    target.edtName = null;
    target.edtEmail = null;
    target.spinerCity = null;
    target.spinnerRegion = null;
    target.edtdeliverycost = null;
    target.btnContinue = null;

    view7f08011a.setOnClickListener(null);
    view7f08011a = null;
    view7f080116.setOnClickListener(null);
    view7f080116 = null;
  }
}
