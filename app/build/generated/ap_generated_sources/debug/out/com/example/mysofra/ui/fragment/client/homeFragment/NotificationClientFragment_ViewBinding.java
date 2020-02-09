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

public class NotificationClientFragment_ViewBinding implements Unbinder {
  private NotificationClientFragment target;

  @UiThread
  public NotificationClientFragment_ViewBinding(NotificationClientFragment target, View source) {
    this.target = target;

    target.recyRecycler = Utils.findRequiredViewAsType(source, R.id.fragment_notification_client_recy_recycler, "field 'recyRecycler'", RecyclerView.class);
    target.sypSwipeRefresh = Utils.findRequiredViewAsType(source, R.id.fragment_notification_client_syp_swipe_refresh, "field 'sypSwipeRefresh'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NotificationClientFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyRecycler = null;
    target.sypSwipeRefresh = null;
  }
}
