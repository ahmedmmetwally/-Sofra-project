// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.restaurant;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public class EditOfferFragment_ViewBinding implements Unbinder {
  private EditOfferFragment target;

  private View view7f08010a;

  private View view7f08010c;

  private View view7f08010b;

  private View view7f080105;

  @UiThread
  public EditOfferFragment_ViewBinding(final EditOfferFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.fragment_edit_offer_img_offerimage, "field 'imgOfferimage' and method 'onViewClicked'");
    target.imgOfferimage = Utils.castView(view, R.id.fragment_edit_offer_img_offerimage, "field 'imgOfferimage'", ImageView.class);
    view7f08010a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.edtOfferName = Utils.findRequiredViewAsType(source, R.id.fragment_edit_offer_edt_offer_name, "field 'edtOfferName'", EditText.class);
    target.edtDescriptin = Utils.findRequiredViewAsType(source, R.id.fragment_edit_offer_edt_descriptin, "field 'edtDescriptin'", EditText.class);
    target.txtDateTo = Utils.findRequiredViewAsType(source, R.id.fragment_edit_offer_txt_date_to, "field 'txtDateTo'", TextView.class);
    view = Utils.findRequiredView(source, R.id.fragment_edit_offer_rl_date_to, "field 'rinlDateTo' and method 'onViewClicked'");
    target.rinlDateTo = Utils.castView(view, R.id.fragment_edit_offer_rl_date_to, "field 'rinlDateTo'", RelativeLayout.class);
    view7f08010c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.txtDateFrom = Utils.findRequiredViewAsType(source, R.id.fragment_edit_offer_txt_date_from, "field 'txtDateFrom'", TextView.class);
    view = Utils.findRequiredView(source, R.id.fragment_edit_offer_rl_date_from, "field 'rinlDateFrom' and method 'onViewClicked'");
    target.rinlDateFrom = Utils.castView(view, R.id.fragment_edit_offer_rl_date_from, "field 'rinlDateFrom'", RelativeLayout.class);
    view7f08010b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_edit_offer_btn_update, "field 'btnUpdate' and method 'onViewClicked'");
    target.btnUpdate = Utils.castView(view, R.id.fragment_edit_offer_btn_update, "field 'btnUpdate'", Button.class);
    view7f080105 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.edtPrice = Utils.findRequiredViewAsType(source, R.id.fragment_add_new_offer_edt_price, "field 'edtPrice'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    EditOfferFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgOfferimage = null;
    target.edtOfferName = null;
    target.edtDescriptin = null;
    target.txtDateTo = null;
    target.rinlDateTo = null;
    target.txtDateFrom = null;
    target.rinlDateFrom = null;
    target.btnUpdate = null;
    target.edtPrice = null;

    view7f08010a.setOnClickListener(null);
    view7f08010a = null;
    view7f08010c.setOnClickListener(null);
    view7f08010c = null;
    view7f08010b.setOnClickListener(null);
    view7f08010b = null;
    view7f080105.setOnClickListener(null);
    view7f080105 = null;
  }
}
