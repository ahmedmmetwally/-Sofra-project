// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.restaurant;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EditResProfile2Fragment_ViewBinding implements Unbinder {
  private EditResProfile2Fragment target;

  private View view7f08003d;

  private View view7f08003c;

  @UiThread
  public EditResProfile2Fragment_ViewBinding(final EditResProfile2Fragment target, View source) {
    this.target = target;

    View view;
    target.edtminimum_charg = Utils.findRequiredViewAsType(source, R.id._fragment_edit_restaurant_profile_continu_edt_minimum_charg, "field 'edtminimum_charg'", EditText.class);
    target.edtTime = Utils.findRequiredViewAsType(source, R.id._fragment_edit_restaurant_profile_continu_edt_time, "field 'edtTime'", EditText.class);
    view = Utils.findRequiredView(source, R.id._fragment_edit_restaurant_profile_continusw_switch, "field 'swSwitch' and method 'onViewClicked'");
    target.swSwitch = Utils.castView(view, R.id._fragment_edit_restaurant_profile_continusw_switch, "field 'swSwitch'", Switch.class);
    view7f08003d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.edtPhone = Utils.findRequiredViewAsType(source, R.id._fragment_edit_restaurant_profile_continu_edt_phone, "field 'edtPhone'", EditText.class);
    target.editWatts = Utils.findRequiredViewAsType(source, R.id._fragment_edit_restaurant_profile_continu_edit_watts, "field 'editWatts'", EditText.class);
    view = Utils.findRequiredView(source, R.id._fragment_edit_restaurant_profile_continubtn_continue, "field 'btnContinue' and method 'onViewClicked'");
    target.btnContinue = Utils.castView(view, R.id._fragment_edit_restaurant_profile_continubtn_continue, "field 'btnContinue'", Button.class);
    view7f08003c = view;
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
    EditResProfile2Fragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edtminimum_charg = null;
    target.edtTime = null;
    target.swSwitch = null;
    target.edtPhone = null;
    target.editWatts = null;
    target.btnContinue = null;

    view7f08003d.setOnClickListener(null);
    view7f08003d = null;
    view7f08003c.setOnClickListener(null);
    view7f08003c = null;
  }
}
