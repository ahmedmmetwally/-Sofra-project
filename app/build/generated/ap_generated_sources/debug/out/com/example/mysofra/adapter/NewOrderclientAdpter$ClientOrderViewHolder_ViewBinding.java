// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NewOrderclientAdpter$ClientOrderViewHolder_ViewBinding implements Unbinder {
  private NewOrderclientAdpter.ClientOrderViewHolder target;

  @UiThread
  public NewOrderclientAdpter$ClientOrderViewHolder_ViewBinding(
      NewOrderclientAdpter.ClientOrderViewHolder target, View source) {
    this.target = target;

    target.ImgCustomer = Utils.findRequiredViewAsType(source, R.id.show_new_orderclient_recycler_shape_img_customer, "field 'ImgCustomer'", ImageView.class);
    target.OrderNumber = Utils.findRequiredViewAsType(source, R.id.show_new_orderclient_recycler_shape_order_number, "field 'OrderNumber'", TextView.class);
    target.Total = Utils.findRequiredViewAsType(source, R.id.show_new_orderclient_recycler_shape_order_total, "field 'Total'", TextView.class);
    target.OrderAdress = Utils.findRequiredViewAsType(source, R.id.show_new_orderclient_recycler_shape_order_adress, "field 'OrderAdress'", TextView.class);
    target.lndecline = Utils.findRequiredViewAsType(source, R.id.show_new_orderclient_recycler_shape_rl_all, "field 'lndecline'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NewOrderclientAdpter.ClientOrderViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ImgCustomer = null;
    target.OrderNumber = null;
    target.Total = null;
    target.OrderAdress = null;
    target.lndecline = null;
  }
}
