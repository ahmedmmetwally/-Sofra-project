// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.restaurant;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CurrentOrderRestaurantFragment_ViewBinding implements Unbinder {
  private CurrentOrderRestaurantFragment target;

  @UiThread
  public CurrentOrderRestaurantFragment_ViewBinding(CurrentOrderRestaurantFragment target,
      View source) {
    this.target = target;

    target.rcyRecycler = Utils.findRequiredViewAsType(source, R.id.fragment_previous_order_restaurant_rcy_recycler, "field 'rcyRecycler'", RecyclerView.class);
    target.swipFresh = Utils.findRequiredViewAsType(source, R.id.fragment_previous_order_restaurant_sypf_swipfresh, "field 'swipFresh'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CurrentOrderRestaurantFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rcyRecycler = null;
    target.swipFresh = null;
  }
}
