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

public class PreviousOrderRestaurantAdapter$previousViewHolder_ViewBinding implements Unbinder {
  private PreviousOrderRestaurantAdapter.previousViewHolder target;

  @UiThread
  public PreviousOrderRestaurantAdapter$previousViewHolder_ViewBinding(
      PreviousOrderRestaurantAdapter.previousViewHolder target, View source) {
    this.target = target;

    target.imgCustomer = Utils.findRequiredViewAsType(source, R.id.show_restaurant_new_order_shape_recycler_img_customer, "field 'imgCustomer'", ImageView.class);
    target.txtCustomerName = Utils.findRequiredViewAsType(source, R.id.show_restaurant_new_order_shape_recycler_txt_customer_name, "field 'txtCustomerName'", TextView.class);
    target.txtOrderNumber = Utils.findRequiredViewAsType(source, R.id.show_restaurant_new_order_shape_recycler_txt_order_number, "field 'txtOrderNumber'", TextView.class);
    target.txtOrderTotal = Utils.findRequiredViewAsType(source, R.id.show_restaurant_new_order_shape_recycler_order_total, "field 'txtOrderTotal'", TextView.class);
    target.txtAdr = Utils.findRequiredViewAsType(source, R.id.show_restaurant_new_order_shape_recycler_order_adress, "field 'txtAdr'", TextView.class);
    target.RlCall = Utils.findRequiredViewAsType(source, R.id.show_restaurant_new_order_shape_recycler_rl_call, "field 'RlCall'", RelativeLayout.class);
    target.txtButton = Utils.findRequiredViewAsType(source, R.id.show_restaurant_new_order_shape_recycler_txt_button, "field 'txtButton'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PreviousOrderRestaurantAdapter.previousViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgCustomer = null;
    target.txtCustomerName = null;
    target.txtOrderNumber = null;
    target.txtOrderTotal = null;
    target.txtAdr = null;
    target.RlCall = null;
    target.txtButton = null;
  }
}
