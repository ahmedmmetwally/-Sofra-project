// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.client.homeFragment;

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

public class ShowRestaurantsContainerFragment_ViewBinding implements Unbinder {
  private ShowRestaurantsContainerFragment target;

  @UiThread
  public ShowRestaurantsContainerFragment_ViewBinding(ShowRestaurantsContainerFragment target,
      View source) {
    this.target = target;

    target.tablayout = Utils.findRequiredViewAsType(source, R.id.fragment_show_restaurants_container_tablayout, "field 'tablayout'", TabLayout.class);
    target.VpPageContainar = Utils.findRequiredViewAsType(source, R.id.fragment_show_restaurants_containerL_vp_page_containar, "field 'VpPageContainar'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ShowRestaurantsContainerFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tablayout = null;
    target.VpPageContainar = null;
  }
}
