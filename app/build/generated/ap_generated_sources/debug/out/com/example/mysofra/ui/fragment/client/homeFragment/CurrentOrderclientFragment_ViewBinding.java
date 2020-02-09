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

public class CurrentOrderclientFragment_ViewBinding implements Unbinder {
  private CurrentOrderclientFragment target;

  @UiThread
  public CurrentOrderclientFragment_ViewBinding(CurrentOrderclientFragment target, View source) {
    this.target = target;

    target.CurrentOrderclientRcRcyclerview = Utils.findRequiredViewAsType(source, R.id.fragment_current_orderclient_rc_rcyclerview, "field 'CurrentOrderclientRcRcyclerview'", RecyclerView.class);
    target.CurrentOrderclientSwprfSwiprefresh = Utils.findRequiredViewAsType(source, R.id.fragment_current_orderclient_swprf_swiprefresh, "field 'CurrentOrderclientSwprfSwiprefresh'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CurrentOrderclientFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.CurrentOrderclientRcRcyclerview = null;
    target.CurrentOrderclientSwprfSwiprefresh = null;
  }
}
