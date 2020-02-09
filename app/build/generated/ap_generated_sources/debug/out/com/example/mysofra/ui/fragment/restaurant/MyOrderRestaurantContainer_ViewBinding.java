// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.restaurant;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import com.google.android.material.tabs.TabLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyOrderRestaurantContainer_ViewBinding implements Unbinder {
  private MyOrderRestaurantContainer target;

  @UiThread
  public MyOrderRestaurantContainer_ViewBinding(MyOrderRestaurantContainer target, View source) {
    this.target = target;

    target.tabTablayotu = Utils.findRequiredViewAsType(source, R.id.fragment_my_order_restaurant_container_tab_tablayotu, "field 'tabTablayotu'", TabLayout.class);
    target.vpViewpager = Utils.findRequiredViewAsType(source, R.id.fragment_my_order_restaurant_container_vp_viewpager, "field 'vpViewpager'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyOrderRestaurantContainer target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tabTablayotu = null;
    target.vpViewpager = null;
  }
}
