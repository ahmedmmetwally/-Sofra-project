// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.adapter;

import android.view.View;
import android.widget.EditText;
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

public class NewOrderRestaurantAdapter$NeewViewHolder_ViewBinding implements Unbinder {
  private NewOrderRestaurantAdapter.NeewViewHolder target;

  @UiThread
  public NewOrderRestaurantAdapter$NeewViewHolder_ViewBinding(
      NewOrderRestaurantAdapter.NeewViewHolder target, View source) {
    this.target = target;

    target.imgCustomer = Utils.findRequiredViewAsType(source, R.id.show_restaurant_new_order_shape_recycler_img_customer, "field 'imgCustomer'", ImageView.class);
    target.txtCustomerName = Utils.findRequiredViewAsType(source, R.id.show_restaurant_new_order_shape_recycler_txt_customer_name, "field 'txtCustomerName'", TextView.class);
    target.txtOrderNumber = Utils.findRequiredViewAsType(source, R.id.show_restaurant_new_order_shape_recycler_txt_order_number, "field 'txtOrderNumber'", TextView.class);
    target.txtOrderTotal = Utils.findRequiredViewAsType(source, R.id.show_restaurant_new_order_shape_recycler_order_total, "field 'txtOrderTotal'", TextView.class);
    target.txtOrderAdress = Utils.findRequiredViewAsType(source, R.id.show_restaurant_new_order_shape_recycler_order_adress, "field 'txtOrderAdress'", TextView.class);
    target.edtcancelResion = Utils.findRequiredViewAsType(source, R.id.show_restaurant_new_order_shape_recycler_edt_refuse_resion, "field 'edtcancelResion'", EditText.class);
    target.rlCall = Utils.findRequiredViewAsType(source, R.id.show_restaurant_new_order_shape_recycler_rl_call, "field 'rlCall'", RelativeLayout.class);
    target.rlAccept = Utils.findRequiredViewAsType(source, R.id.show_restaurant_new_order_shape_recycler_accept, "field 'rlAccept'", RelativeLayout.class);
    target.rlCancel = Utils.findRequiredViewAsType(source, R.id.show_restaurant_new_order_shape_recycler_rl_cancel, "field 'rlCancel'", RelativeLayout.class);
    target.txtCall = Utils.findRequiredViewAsType(source, R.id.show_restaurant_new_order_shape_recycler_txt_call, "field 'txtCall'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NewOrderRestaurantAdapter.NeewViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgCustomer = null;
    target.txtCustomerName = null;
    target.txtOrderNumber = null;
    target.txtOrderTotal = null;
    target.txtOrderAdress = null;
    target.edtcancelResion = null;
    target.rlCall = null;
    target.rlAccept = null;
    target.rlCancel = null;
    target.txtCall = null;
  }
}
