// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.restaurant;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RestaurantMyCategoriesFragmet_ViewBinding implements Unbinder {
  private RestaurantMyCategoriesFragmet target;

  private View view7f080143;

  private View view7f080142;

  @UiThread
  public RestaurantMyCategoriesFragmet_ViewBinding(final RestaurantMyCategoriesFragmet target,
      View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.fragment_home_restaurt_fragmetn_rcy_recycler, "field 'recyRecycler' and method 'onViewClicked'");
    target.recyRecycler = Utils.castView(view, R.id.fragment_home_restaurt_fragmetn_rcy_recycler, "field 'recyRecycler'", RecyclerView.class);
    view7f080143 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.SypfSwipFresh = Utils.findRequiredViewAsType(source, R.id.fragment_home_restaurt_fragmetn_sypf_swipFresh, "field 'SypfSwipFresh'", SwipeRefreshLayout.class);
    view = Utils.findRequiredView(source, R.id.fragment_home_restaurt_fragmetn_fbtn_btnnnew, "field 'fragmentHomeRestaurtFragmetnFbtnBtnnnew' and method 'onViewClicked'");
    target.fragmentHomeRestaurtFragmetnFbtnBtnnnew = Utils.castView(view, R.id.fragment_home_restaurt_fragmetn_fbtn_btnnnew, "field 'fragmentHomeRestaurtFragmetnFbtnBtnnnew'", FloatingActionButton.class);
    view7f080142 = view;
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
    RestaurantMyCategoriesFragmet target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyRecycler = null;
    target.SypfSwipFresh = null;
    target.fragmentHomeRestaurtFragmetnFbtnBtnnnew = null;

    view7f080143.setOnClickListener(null);
    view7f080143 = null;
    view7f080142.setOnClickListener(null);
    view7f080142 = null;
  }
}
