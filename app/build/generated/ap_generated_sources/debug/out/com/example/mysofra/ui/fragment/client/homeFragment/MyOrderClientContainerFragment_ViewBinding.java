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

public class MyOrderClientContainerFragment_ViewBinding implements Unbinder {
  private MyOrderClientContainerFragment target;

  @UiThread
  public MyOrderClientContainerFragment_ViewBinding(MyOrderClientContainerFragment target,
      View source) {
    this.target = target;

    target.ClientContainerVpViewpager = Utils.findRequiredViewAsType(source, R.id.fragment_my_order_client_container_vp_viewpager, "field 'ClientContainerVpViewpager'", ViewPager.class);
    target.ClientContainerTabTaplayout = Utils.findRequiredViewAsType(source, R.id.fragment_my_order_client_container_tab_taplayout, "field 'ClientContainerTabTaplayout'", TabLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyOrderClientContainerFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ClientContainerVpViewpager = null;
    target.ClientContainerTabTaplayout = null;
  }
}
