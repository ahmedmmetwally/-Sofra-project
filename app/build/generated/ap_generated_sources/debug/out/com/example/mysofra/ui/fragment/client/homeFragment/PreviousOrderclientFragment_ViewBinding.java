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

public class PreviousOrderclientFragment_ViewBinding implements Unbinder {
  private PreviousOrderclientFragment target;

  @UiThread
  public PreviousOrderclientFragment_ViewBinding(PreviousOrderclientFragment target, View source) {
    this.target = target;

    target.PreviousOrderclientRcRcyclerview = Utils.findRequiredViewAsType(source, R.id.fragment_previous_orderclient_rc_rcyclerview, "field 'PreviousOrderclientRcRcyclerview'", RecyclerView.class);
    target.fragPreviousOrderclientSwprfSwiprefresh = Utils.findRequiredViewAsType(source, R.id.fragment_previous_orderclient_swprf_swiprefresh, "field 'fragPreviousOrderclientSwprfSwiprefresh'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PreviousOrderclientFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.PreviousOrderclientRcRcyclerview = null;
    target.fragPreviousOrderclientSwprfSwiprefresh = null;
  }
}
