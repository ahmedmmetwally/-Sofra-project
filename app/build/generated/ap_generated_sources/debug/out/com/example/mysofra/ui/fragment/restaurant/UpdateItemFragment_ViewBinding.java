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

public class UpdateItemFragment_ViewBinding implements Unbinder {
  private UpdateItemFragment target;

  private View view7f0801b1;

  private View view7f0801ac;

  @UiThread
  public UpdateItemFragment_ViewBinding(final UpdateItemFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.fragment_update_item_img_item_image, "field 'imgItemimage' and method 'onViewClicked'");
    target.imgItemimage = Utils.castView(view, R.id.fragment_update_item_img_item_image, "field 'imgItemimage'", ImageView.class);
    view7f0801b1 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.edtItemName = Utils.findRequiredViewAsType(source, R.id.fragment_update_item_edt_item_name, "field 'edtItemName'", EditText.class);
    target.edtDescriptin = Utils.findRequiredViewAsType(source, R.id.fragment_update_item_edt_descriptin, "field 'edtDescriptin'", EditText.class);
    target.edtPrice = Utils.findRequiredViewAsType(source, R.id.fragment_update_item_edt_price, "field 'edtPrice'", EditText.class);
    target.edtPriceInOffer = Utils.findRequiredViewAsType(source, R.id.fragment_update_item_edt_price_in_offer, "field 'edtPriceInOffer'", EditText.class);
    view = Utils.findRequiredView(source, R.id.fragment_update_item_btn_update, "field 'btnUpdate' and method 'onViewClicked'");
    target.btnUpdate = Utils.castView(view, R.id.fragment_update_item_btn_update, "field 'btnUpdate'", Button.class);
    view7f0801ac = view;
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
    UpdateItemFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgItemimage = null;
    target.edtItemName = null;
    target.edtDescriptin = null;
    target.edtPrice = null;
    target.edtPriceInOffer = null;
    target.btnUpdate = null;

    view7f0801b1.setOnClickListener(null);
    view7f0801b1 = null;
    view7f0801ac.setOnClickListener(null);
    view7f0801ac = null;
  }
}
