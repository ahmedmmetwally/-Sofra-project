// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.client.homeFragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ConfirmOrderFromRoomFragment_ViewBinding implements Unbinder {
  private ConfirmOrderFromRoomFragment target;

  private View view7f0800ed;

  private View view7f0800ec;

  @UiThread
  public ConfirmOrderFromRoomFragment_ViewBinding(final ConfirmOrderFromRoomFragment target,
      View source) {
    this.target = target;

    View view;
    target.recyRecyclerView = Utils.findRequiredViewAsType(source, R.id.fragment_confirm_order_from_room_recy_recycler_view, "field 'recyRecyclerView'", RecyclerView.class);
    target.swipFresh = Utils.findRequiredViewAsType(source, R.id.fragment_confirm_order_from_room_swip_fresh, "field 'swipFresh'", SwipeRefreshLayout.class);
    target.txtTotal = Utils.findRequiredViewAsType(source, R.id.fragment_confirm_order_from_room_txt_total, "field 'txtTotal'", TextView.class);
    view = Utils.findRequiredView(source, R.id.fragment_confirm_order_from_room_btn_add_more, "field 'btnAddMore' and method 'onViewClicked'");
    target.btnAddMore = Utils.castView(view, R.id.fragment_confirm_order_from_room_btn_add_more, "field 'btnAddMore'", Button.class);
    view7f0800ed = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_confirm_order_from_room_btn_add_confirm, "field 'btnAddConfirm' and method 'onViewClicked'");
    target.btnAddConfirm = Utils.castView(view, R.id.fragment_confirm_order_from_room_btn_add_confirm, "field 'btnAddConfirm'", Button.class);
    view7f0800ec = view;
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
    ConfirmOrderFromRoomFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyRecyclerView = null;
    target.swipFresh = null;
    target.txtTotal = null;
    target.btnAddMore = null;
    target.btnAddConfirm = null;

    view7f0800ed.setOnClickListener(null);
    view7f0800ed = null;
    view7f0800ec.setOnClickListener(null);
    view7f0800ec = null;
  }
}
