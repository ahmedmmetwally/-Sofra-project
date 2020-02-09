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

public class GetRestaurantsItemAndCategoryFoodFragment_ViewBinding implements Unbinder {
  private GetRestaurantsItemAndCategoryFoodFragment target;

  @UiThread
  public GetRestaurantsItemAndCategoryFoodFragment_ViewBinding(
      GetRestaurantsItemAndCategoryFoodFragment target, View source) {
    this.target = target;

    target.RcyCategory = Utils.findRequiredViewAsType(source, R.id.fragment_get_restaurants_itemfood_rcy_category, "field 'RcyCategory'", RecyclerView.class);
    target.RcyItem = Utils.findRequiredViewAsType(source, R.id.fragment_get_restaurants_itemfood_rcy_item, "field 'RcyItem'", RecyclerView.class);
    target.SwipFreshItem = Utils.findRequiredViewAsType(source, R.id.fragment_get_restaurants_itemfood_swip_fresh_item, "field 'SwipFreshItem'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GetRestaurantsItemAndCategoryFoodFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.RcyCategory = null;
    target.RcyItem = null;
    target.SwipFreshItem = null;
  }
}
