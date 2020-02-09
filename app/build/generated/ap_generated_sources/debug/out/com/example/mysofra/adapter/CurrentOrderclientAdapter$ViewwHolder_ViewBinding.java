// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.adapter;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CurrentOrderclientAdapter$ViewwHolder_ViewBinding implements Unbinder {
  private CurrentOrderclientAdapter.ViewwHolder target;

  @UiThread
  public CurrentOrderclientAdapter$ViewwHolder_ViewBinding(
      CurrentOrderclientAdapter.ViewwHolder target, View source) {
    this.target = target;

    target.ShapeImgCustomer = Utils.findRequiredViewAsType(source, R.id.show_new_orderclient_recycler_shape_img_customer, "field 'ShapeImgCustomer'", CircleImageView.class);
    target.ShapeOrderNumber = Utils.findRequiredViewAsType(source, R.id.show_new_orderclient_recycler_shape_order_number, "field 'ShapeOrderNumber'", TextView.class);
    target.ShapeOrderTotal = Utils.findRequiredViewAsType(source, R.id.show_new_orderclient_recycler_shape_order_total, "field 'ShapeOrderTotal'", TextView.class);
    target.ShapeOrderAdress = Utils.findRequiredViewAsType(source, R.id.show_new_orderclient_recycler_shape_order_adress, "field 'ShapeOrderAdress'", TextView.class);
    target.lnconfiremDelivery = Utils.findRequiredViewAsType(source, R.id.show_new_orderclient_recycler_shape_rl_all, "field 'lnconfiremDelivery'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CurrentOrderclientAdapter.ViewwHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ShapeImgCustomer = null;
    target.ShapeOrderNumber = null;
    target.ShapeOrderTotal = null;
    target.ShapeOrderAdress = null;
    target.lnconfiremDelivery = null;
  }
}
