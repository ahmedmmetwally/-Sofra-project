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

public class AddNewOfferFragment_ViewBinding implements Unbinder {
  private AddNewOfferFragment target;

  private View view7f0800dc;

  private View view7f0800de;

  private View view7f0800dd;

  private View view7f0800d5;

  @UiThread
  public AddNewOfferFragment_ViewBinding(final AddNewOfferFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.fragment_add_new_offer_img_offerimage, "field 'imgOfferimage' and method 'onViewClicked'");
    target.imgOfferimage = Utils.castView(view, R.id.fragment_add_new_offer_img_offerimage, "field 'imgOfferimage'", ImageView.class);
    view7f0800dc = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.edtOfferName = Utils.findRequiredViewAsType(source, R.id.fragment_add_new_offer_edt_offer_name, "field 'edtOfferName'", EditText.class);
    target.edtDescriptin = Utils.findRequiredViewAsType(source, R.id.fragment_add_new_offer_edt_descriptin, "field 'edtDescriptin'", EditText.class);
    target.txtDateTo = Utils.findRequiredViewAsType(source, R.id.fragment_add_new_offer_txt_date_to, "field 'txtDateTo'", TextView.class);
    view = Utils.findRequiredView(source, R.id.fragment_add_new_offer_rl_date_to, "field 'llDateTo' and method 'onViewClicked'");
    target.llDateTo = Utils.castView(view, R.id.fragment_add_new_offer_rl_date_to, "field 'llDateTo'", RelativeLayout.class);
    view7f0800de = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.txtDateFrom = Utils.findRequiredViewAsType(source, R.id.fragment_add_new_offer_txt_date_from, "field 'txtDateFrom'", TextView.class);
    view = Utils.findRequiredView(source, R.id.fragment_add_new_offer_rl_date_from, "field 'llDateFrom' and method 'onViewClicked'");
    target.llDateFrom = Utils.castView(view, R.id.fragment_add_new_offer_rl_date_from, "field 'llDateFrom'", RelativeLayout.class);
    view7f0800dd = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_add_new_offer_btn_update, "field 'btnUpdate' and method 'onViewClicked'");
    target.btnUpdate = Utils.castView(view, R.id.fragment_add_new_offer_btn_update, "field 'btnUpdate'", Button.class);
    view7f0800d5 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.edtPrice = Utils.findRequiredViewAsType(source, R.id.fragment_add_new_offer_edt_price, "field 'edtPrice'", EditText.class);
    target.edtPriceInOffer = Utils.findRequiredViewAsType(source, R.id.fragment_add_new_offer_edt_price_in_offer, "field 'edtPriceInOffer'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AddNewOfferFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgOfferimage = null;
    target.edtOfferName = null;
    target.edtDescriptin = null;
    target.txtDateTo = null;
    target.llDateTo = null;
    target.txtDateFrom = null;
    target.llDateFrom = null;
    target.btnUpdate = null;
    target.edtPrice = null;
    target.edtPriceInOffer = null;

    view7f0800dc.setOnClickListener(null);
    view7f0800dc = null;
    view7f0800de.setOnClickListener(null);
    view7f0800de = null;
    view7f0800dd.setOnClickListener(null);
    view7f0800dd = null;
    view7f0800d5.setOnClickListener(null);
    view7f0800d5 = null;
  }
}
