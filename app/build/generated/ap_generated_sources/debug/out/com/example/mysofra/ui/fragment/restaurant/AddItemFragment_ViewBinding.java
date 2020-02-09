// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.restaurant;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddItemFragment_ViewBinding implements Unbinder {
  private AddItemFragment target;

  private View view7f0800d4;

  private View view7f0800cf;

  @UiThread
  public AddItemFragment_ViewBinding(final AddItemFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.fragment_add_item_img_offerimage, "field 'imgOfferimage' and method 'onViewClicked'");
    target.imgOfferimage = Utils.castView(view, R.id.fragment_add_item_img_offerimage, "field 'imgOfferimage'", ImageView.class);
    view7f0800d4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.edtOfferName = Utils.findRequiredViewAsType(source, R.id.fragment_add_item_edt_offer_name, "field 'edtOfferName'", EditText.class);
    target.edtDescriptin = Utils.findRequiredViewAsType(source, R.id.fragment_add_item_edt_descriptin, "field 'edtDescriptin'", EditText.class);
    target.edtPrice = Utils.findRequiredViewAsType(source, R.id.fragment_add_item_edt_price, "field 'edtPrice'", EditText.class);
    target.edtPriceInOffer = Utils.findRequiredViewAsType(source, R.id.fragment_add_item_edt_price_in_offer, "field 'edtPriceInOffer'", EditText.class);
    view = Utils.findRequiredView(source, R.id.fragment_add_item_btn_add, "field 'fragmentAddItemBtnAdd' and method 'onViewClicked'");
    target.fragmentAddItemBtnAdd = Utils.castView(view, R.id.fragment_add_item_btn_add, "field 'fragmentAddItemBtnAdd'", Button.class);
    view7f0800cf = view;
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
    AddItemFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgOfferimage = null;
    target.edtOfferName = null;
    target.edtDescriptin = null;
    target.edtPrice = null;
    target.edtPriceInOffer = null;
    target.fragmentAddItemBtnAdd = null;

    view7f0800d4.setOnClickListener(null);
    view7f0800d4 = null;
    view7f0800cf.setOnClickListener(null);
    view7f0800cf = null;
  }
}
