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

public class MyItemFragment_ViewBinding implements Unbinder {
  private MyItemFragment target;

  private View view7f080159;

  @UiThread
  public MyItemFragment_ViewBinding(final MyItemFragment target, View source) {
    this.target = target;

    View view;
    target.rcyRecycler = Utils.findRequiredViewAsType(source, R.id.fragment_my_item_rcy_recycler, "field 'rcyRecycler'", RecyclerView.class);
    target.sypfSwipefresh = Utils.findRequiredViewAsType(source, R.id.fragment_my_item_sypf_swipefresh, "field 'sypfSwipefresh'", SwipeRefreshLayout.class);
    view = Utils.findRequiredView(source, R.id.fragment_my_item_fbtn_Button_add_new_item, "field 'fbtnButtonAddNewItem' and method 'onViewClicked'");
    target.fbtnButtonAddNewItem = Utils.castView(view, R.id.fragment_my_item_fbtn_Button_add_new_item, "field 'fbtnButtonAddNewItem'", FloatingActionButton.class);
    view7f080159 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MyItemFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rcyRecycler = null;
    target.sypfSwipefresh = null;
    target.fbtnButtonAddNewItem = null;

    view7f080159.setOnClickListener(null);
    view7f080159 = null;
  }
}
