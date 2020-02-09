// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.restaurant;

import android.view.View;
import android.widget.Button;
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

public class MyOfferRestaurantFragment_ViewBinding implements Unbinder {
  private MyOfferRestaurantFragment target;

  private View view7f080161;

  @UiThread
  public MyOfferRestaurantFragment_ViewBinding(final MyOfferRestaurantFragment target,
      View source) {
    this.target = target;

    View view;
    target.rcRecyclerView = Utils.findRequiredViewAsType(source, R.id.fragment_new_offer_restaurant_rc_recycler_view, "field 'rcRecyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.fragment_new_offer_restaurant_btn_add_new_offer, "field 'btnAddNewOffer' and method 'onViewClicked'");
    target.btnAddNewOffer = Utils.castView(view, R.id.fragment_new_offer_restaurant_btn_add_new_offer, "field 'btnAddNewOffer'", Button.class);
    view7f080161 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.sfSwipeRefresh = Utils.findRequiredViewAsType(source, R.id.fragment_new_offer_restaurant_sf_swipe_refresh, "field 'sfSwipeRefresh'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyOfferRestaurantFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rcRecyclerView = null;
    target.btnAddNewOffer = null;
    target.sfSwipeRefresh = null;

    view7f080161.setOnClickListener(null);
    view7f080161 = null;
  }
}
