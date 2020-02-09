// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.client.homeFragment;

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

public class NewOffersClientFragment_ViewBinding implements Unbinder {
  private NewOffersClientFragment target;

  @UiThread
  public NewOffersClientFragment_ViewBinding(NewOffersClientFragment target, View source) {
    this.target = target;

    target.recyRecyclerView = Utils.findRequiredViewAsType(source, R.id.fragment_new_offer_restaurant_recy_recycler_view, "field 'recyRecyclerView'", RecyclerView.class);
    target.sypSwipeFresh = Utils.findRequiredViewAsType(source, R.id.fragment_new_offer_restaurant_syp_swipe_fresh, "field 'sypSwipeFresh'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NewOffersClientFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyRecyclerView = null;
    target.sypSwipeFresh = null;
  }
}
