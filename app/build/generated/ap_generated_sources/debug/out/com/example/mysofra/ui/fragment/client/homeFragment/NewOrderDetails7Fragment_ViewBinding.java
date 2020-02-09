// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.client.homeFragment;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class NewOrderDetails7Fragment_ViewBinding implements Unbinder {
  private NewOrderDetails7Fragment target;

  private View view7f080169;

  private View view7f080168;

  private View view7f080178;

  @UiThread
  public NewOrderDetails7Fragment_ViewBinding(final NewOrderDetails7Fragment target, View source) {
    this.target = target;

    View view;
    target.edtAddNotification = Utils.findRequiredViewAsType(source, R.id.fragment_new_order_details7_edt_add_notification, "field 'edtAddNotification'", EditText.class);
    target.edtDeliveryAdress = Utils.findRequiredViewAsType(source, R.id.fragment_new_order_details7_edt_delivery_adress, "field 'edtDeliveryAdress'", TextView.class);
    view = Utils.findRequiredView(source, R.id.fragment_new_order_details7_rb_payin_on_delivery, "field 'rbPayinOnDelivery' and method 'onViewClicked'");
    target.rbPayinOnDelivery = Utils.castView(view, R.id.fragment_new_order_details7_rb_payin_on_delivery, "field 'rbPayinOnDelivery'", RadioButton.class);
    view7f080169 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_new_order_details7_rb_online_pay, "field 'rbOnlinePay' and method 'onViewClicked'");
    target.rbOnlinePay = Utils.castView(view, R.id.fragment_new_order_details7_rb_online_pay, "field 'rbOnlinePay'", RadioButton.class);
    view7f080168 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.txtTotal = Utils.findRequiredViewAsType(source, R.id.fragment_new_order_details7_txt_total, "field 'txtTotal'", TextView.class);
    target.txtChargDelivery = Utils.findRequiredViewAsType(source, R.id.fragment_new_order_details7_txt_charg_delivery, "field 'txtChargDelivery'", TextView.class);
    target.txtTotalAmount = Utils.findRequiredViewAsType(source, R.id.fragment_new_order_details7_txt_total_amount, "field 'txtTotalAmount'", TextView.class);
    view = Utils.findRequiredView(source, R.id.fragment_new_order_details7rl_contain_button, "field 'rlContainButton' and method 'onViewClicked'");
    target.rlContainButton = Utils.castView(view, R.id.fragment_new_order_details7rl_contain_button, "field 'rlContainButton'", RelativeLayout.class);
    view7f080178 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rgRadioGroup = Utils.findRequiredViewAsType(source, R.id.fragment_new_order_details7_rg_radio_group, "field 'rgRadioGroup'", RadioGroup.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NewOrderDetails7Fragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edtAddNotification = null;
    target.edtDeliveryAdress = null;
    target.rbPayinOnDelivery = null;
    target.rbOnlinePay = null;
    target.txtTotal = null;
    target.txtChargDelivery = null;
    target.txtTotalAmount = null;
    target.rlContainButton = null;
    target.rgRadioGroup = null;

    view7f080169.setOnClickListener(null);
    view7f080169 = null;
    view7f080168.setOnClickListener(null);
    view7f080168 = null;
    view7f080178.setOnClickListener(null);
    view7f080178 = null;
  }
}
