// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.client.homeFragment;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FinalAcceptCancelCallOrderFragment_ViewBinding implements Unbinder {
  private FinalAcceptCancelCallOrderFragment target;

  private View view7f080120;

  private View view7f08011d;

  private View view7f080121;

  @UiThread
  public FinalAcceptCancelCallOrderFragment_ViewBinding(
      final FinalAcceptCancelCallOrderFragment target, View source) {
    this.target = target;

    View view;
    target.imgRestaurantImage = Utils.findRequiredViewAsType(source, R.id.fragment_final_accept_cancel_call_order_cimg_restaurant_image, "field 'imgRestaurantImage'", CircleImageView.class);
    target.txtRestaurantName = Utils.findRequiredViewAsType(source, R.id.fragment_final_accept_cancel_call_order_txt_restaurant_name, "field 'txtRestaurantName'", EditText.class);
    target.txtActualAdress = Utils.findRequiredViewAsType(source, R.id.fragment_final_accept_cancel_call_order_txt_actual_adress, "field 'txtActualAdress'", TextView.class);
    target.txtPrice = Utils.findRequiredViewAsType(source, R.id.fragment_final_accept_cancel_call_order_txt_price, "field 'txtPrice'", TextView.class);
    target.txtChargDelivery = Utils.findRequiredViewAsType(source, R.id.fragment_final_accept_cancel_call_order_txt_charg_delivery, "field 'txtChargDelivery'", TextView.class);
    target.txtTotalAmount = Utils.findRequiredViewAsType(source, R.id.fragment_final_accept_cancel_call_order_txt_total_amount, "field 'txtTotalAmount'", TextView.class);
    target.txtTotalPaying = Utils.findRequiredViewAsType(source, R.id.fragment_final_accept_cancel_call_order_txt_total_paying, "field 'txtTotalPaying'", TextView.class);
    view = Utils.findRequiredView(source, R.id.fragment_final_accept_cancel_call_order_rl_call, "field 'rlCall' and method 'onViewClicked'");
    target.rlCall = Utils.castView(view, R.id.fragment_final_accept_cancel_call_order_rl_call, "field 'rlCall'", RelativeLayout.class);
    view7f080120 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_final_accept_cancel_call_order_accept, "field 'rlccept' and method 'onViewClicked'");
    target.rlccept = Utils.castView(view, R.id.fragment_final_accept_cancel_call_order_accept, "field 'rlccept'", RelativeLayout.class);
    view7f08011d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_final_accept_cancel_call_order_rl_cancel, "field 'rlCancel' and method 'onViewClicked'");
    target.rlCancel = Utils.castView(view, R.id.fragment_final_accept_cancel_call_order_rl_cancel, "field 'rlCancel'", RelativeLayout.class);
    view7f080121 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.recRecyclerView = Utils.findRequiredViewAsType(source, R.id.fragment_final_accept_cancel_call_order_rec_recycler_view, "field 'recRecyclerView'", RecyclerView.class);
    target.txtDate = Utils.findRequiredViewAsType(source, R.id.fragment_final_accept_cancel_call_order_txt_date, "field 'txtDate'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FinalAcceptCancelCallOrderFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgRestaurantImage = null;
    target.txtRestaurantName = null;
    target.txtActualAdress = null;
    target.txtPrice = null;
    target.txtChargDelivery = null;
    target.txtTotalAmount = null;
    target.txtTotalPaying = null;
    target.rlCall = null;
    target.rlccept = null;
    target.rlCancel = null;
    target.recRecyclerView = null;
    target.txtDate = null;

    view7f080120.setOnClickListener(null);
    view7f080120 = null;
    view7f08011d.setOnClickListener(null);
    view7f08011d = null;
    view7f080121.setOnClickListener(null);
    view7f080121 = null;
  }
}
