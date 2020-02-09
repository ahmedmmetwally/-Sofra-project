// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PreviousOrderclientAdapter$ViewwHolderr_ViewBinding implements Unbinder {
  private PreviousOrderclientAdapter.ViewwHolderr target;

  @UiThread
  public PreviousOrderclientAdapter$ViewwHolderr_ViewBinding(
      PreviousOrderclientAdapter.ViewwHolderr target, View source) {
    this.target = target;

    target.RecyclerShapeImgCustomer = Utils.findRequiredViewAsType(source, R.id.show_new_orderclient_recycler_shape_img_customer, "field 'RecyclerShapeImgCustomer'", CircleImageView.class);
    target.RecyclerShapeOrderNumber = Utils.findRequiredViewAsType(source, R.id.show_new_orderclient_recycler_shape_order_number, "field 'RecyclerShapeOrderNumber'", TextView.class);
    target.RecyclerShapeOrderTotal = Utils.findRequiredViewAsType(source, R.id.show_new_orderclient_recycler_shape_order_total, "field 'RecyclerShapeOrderTotal'", TextView.class);
    target.RecyclerShapeOrderAdress = Utils.findRequiredViewAsType(source, R.id.show_new_orderclient_recycler_shape_order_adress, "field 'RecyclerShapeOrderAdress'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PreviousOrderclientAdapter.ViewwHolderr target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.RecyclerShapeImgCustomer = null;
    target.RecyclerShapeOrderNumber = null;
    target.RecyclerShapeOrderTotal = null;
    target.RecyclerShapeOrderAdress = null;
  }
}
