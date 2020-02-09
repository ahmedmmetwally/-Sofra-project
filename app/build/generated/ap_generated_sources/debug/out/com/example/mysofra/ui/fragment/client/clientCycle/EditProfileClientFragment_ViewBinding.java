// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.client.clientCycle;

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

public class EditProfileClientFragment_ViewBinding implements Unbinder {
  private EditProfileClientFragment target;

  private View view7f080113;

  private View view7f08010f;

  @UiThread
  public EditProfileClientFragment_ViewBinding(final EditProfileClientFragment target,
      View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.fragment_edit_profile_client_img_imgecricle, "field 'imgecricle' and method 'onViewClicked'");
    target.imgecricle = Utils.castView(view, R.id.fragment_edit_profile_client_img_imgecricle, "field 'imgecricle'", CircleImageView.class);
    view7f080113 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.edtName = Utils.findRequiredViewAsType(source, R.id.fragment_edit_profile_client_edt_name, "field 'edtName'", EditText.class);
    target.edtEmail = Utils.findRequiredViewAsType(source, R.id.fragment_edit_profile_client_edt_email, "field 'edtEmail'", TextView.class);
    target.edtPhone = Utils.findRequiredViewAsType(source, R.id.fragment_edit_profile_client_edt_phone, "field 'edtPhone'", EditText.class);
    target.spinerCity = Utils.findRequiredViewAsType(source, R.id.fragment_edit_profile_client_spn_spiner_city, "field 'spinerCity'", Spinner.class);
    target.spinnerRegion = Utils.findRequiredViewAsType(source, R.id.fragment_edit_profile_client_spn_sinner_region, "field 'spinnerRegion'", Spinner.class);
    view = Utils.findRequiredView(source, R.id.fragment_edit_profile_client_btn_continue, "field 'btnContinue' and method 'onViewClicked'");
    target.btnContinue = Utils.castView(view, R.id.fragment_edit_profile_client_btn_continue, "field 'btnContinue'", Button.class);
    view7f08010f = view;
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
    EditProfileClientFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgecricle = null;
    target.edtName = null;
    target.edtEmail = null;
    target.edtPhone = null;
    target.spinerCity = null;
    target.spinnerRegion = null;
    target.btnContinue = null;

    view7f080113.setOnClickListener(null);
    view7f080113 = null;
    view7f08010f.setOnClickListener(null);
    view7f08010f = null;
  }
}
