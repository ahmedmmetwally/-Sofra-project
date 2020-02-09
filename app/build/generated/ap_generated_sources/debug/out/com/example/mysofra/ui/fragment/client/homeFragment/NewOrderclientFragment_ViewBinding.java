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

public class NewOrderclientFragment_ViewBinding implements Unbinder {
  private NewOrderclientFragment target;

  @UiThread
  public NewOrderclientFragment_ViewBinding(NewOrderclientFragment target, View source) {
    this.target = target;

    target.RcRcyclerview = Utils.findRequiredViewAsType(source, R.id.fragment_new_orderclient_rc_rcyclerview, "field 'RcRcyclerview'", RecyclerView.class);
    target.SwprfSwiprefresh = Utils.findRequiredViewAsType(source, R.id.fragment_new_orderclient_swprf_swiprefresh, "field 'SwprfSwiprefresh'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NewOrderclientFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.RcRcyclerview = null;
    target.SwprfSwiprefresh = null;
  }
}
