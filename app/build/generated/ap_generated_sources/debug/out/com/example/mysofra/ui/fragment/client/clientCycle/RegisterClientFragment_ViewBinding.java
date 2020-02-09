// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.client.clientCycle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public class RegisterClientFragment_ViewBinding implements Unbinder {
  private RegisterClientFragment target;

  private View view7f080189;

  private View view7f08018f;

  @UiThread
  public RegisterClientFragment_ViewBinding(final RegisterClientFragment target, View source) {
    this.target = target;

    View view;
    target.EdtName = Utils.findRequiredViewAsType(source, R.id.fragment_register_edt_name, "field 'EdtName'", EditText.class);
    target.EdtEmail = Utils.findRequiredViewAsType(source, R.id.fragment_register_edt_email, "field 'EdtEmail'", EditText.class);
    target.EdtPhonenum = Utils.findRequiredViewAsType(source, R.id.fragment_register_edt_phonenum, "field 'EdtPhonenum'", EditText.class);
    target.SpCity = Utils.findRequiredViewAsType(source, R.id.fragment_register_sp_city, "field 'SpCity'", Spinner.class);
    target.SpDistrict = Utils.findRequiredViewAsType(source, R.id.fragment_register_sp_district, "field 'SpDistrict'", Spinner.class);
    target.EdtPassewrd = Utils.findRequiredViewAsType(source, R.id.fragment_register_edt_passewrd, "field 'EdtPassewrd'", EditText.class);
    target.EdtPassewrdConfirm = Utils.findRequiredViewAsType(source, R.id.fragment_register_edt_passewrd_confirm, "field 'EdtPassewrdConfirm'", EditText.class);
    view = Utils.findRequiredView(source, R.id.fragment_register_btn_register, "field 'BtnContnue' and method 'onViewClicked'");
    target.BtnContnue = Utils.castView(view, R.id.fragment_register_btn_register, "field 'BtnContnue'", Button.class);
    view7f080189 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_register_img_profileImage, "field 'ImgProfileImage' and method 'onViewClicked'");
    target.ImgProfileImage = Utils.castView(view, R.id.fragment_register_img_profileImage, "field 'ImgProfileImage'", ImageView.class);
    view7f08018f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.LinearDistrict = Utils.findRequiredViewAsType(source, R.id.fragment_register_linear_district, "field 'LinearDistrict'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RegisterClientFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.EdtName = null;
    target.EdtEmail = null;
    target.EdtPhonenum = null;
    target.SpCity = null;
    target.SpDistrict = null;
    target.EdtPassewrd = null;
    target.EdtPassewrdConfirm = null;
    target.BtnContnue = null;
    target.ImgProfileImage = null;
    target.LinearDistrict = null;

    view7f080189.setOnClickListener(null);
    view7f080189 = null;
    view7f08018f.setOnClickListener(null);
    view7f08018f = null;
  }
}
