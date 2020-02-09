// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.client.homeFragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MakeOrder4Fragment_ViewBinding implements Unbinder {
  private MakeOrder4Fragment target;

  private View view7f080151;

  private View view7f080150;

  private View view7f080152;

  @UiThread
  public MakeOrder4Fragment_ViewBinding(final MakeOrder4Fragment target, View source) {
    this.target = target;

    View view;
    target.imgItemImage = Utils.findRequiredViewAsType(source, R.id.fragment_make_order4_img_item_image, "field 'imgItemImage'", ImageView.class);
    target.txtItemName = Utils.findRequiredViewAsType(source, R.id.fragment_make_order4_txt_item_name, "field 'txtItemName'", TextView.class);
    target.txtItemDescription = Utils.findRequiredViewAsType(source, R.id.fragment_make_order4_txt_item_description, "field 'txtItemDescription'", TextView.class);
    target.txtItemPrice = Utils.findRequiredViewAsType(source, R.id.fragment_make_order4_txt_item_price, "field 'txtItemPrice'", TextView.class);
    target.edtEnterOrder = Utils.findRequiredViewAsType(source, R.id.fragment_make_order4_edt_enter_order, "field 'edtEnterOrder'", EditText.class);
    view = Utils.findRequiredView(source, R.id.fragment_make_order4_btn_plus, "field 'btnPlus' and method 'onViewClicked'");
    target.btnPlus = Utils.castView(view, R.id.fragment_make_order4_btn_plus, "field 'btnPlus'", Button.class);
    view7f080151 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.txtQuantity = Utils.findRequiredViewAsType(source, R.id.fragment_make_order4_txt_quantity, "field 'txtQuantity'", TextView.class);
    view = Utils.findRequiredView(source, R.id.fragment_make_order4_btn_minus, "field 'btnMinus' and method 'onViewClicked'");
    target.btnMinus = Utils.castView(view, R.id.fragment_make_order4_btn_minus, "field 'btnMinus'", Button.class);
    view7f080150 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_make_order4_btn_save, "field 'btnSave' and method 'onViewClicked'");
    target.btnSave = Utils.castView(view, R.id.fragment_make_order4_btn_save, "field 'btnSave'", Button.class);
    view7f080152 = view;
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
    MakeOrder4Fragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgItemImage = null;
    target.txtItemName = null;
    target.txtItemDescription = null;
    target.txtItemPrice = null;
    target.edtEnterOrder = null;
    target.btnPlus = null;
    target.txtQuantity = null;
    target.btnMinus = null;
    target.btnSave = null;

    view7f080151.setOnClickListener(null);
    view7f080151 = null;
    view7f080150.setOnClickListener(null);
    view7f080150 = null;
    view7f080152.setOnClickListener(null);
    view7f080152 = null;
  }
}
