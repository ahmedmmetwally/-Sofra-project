// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FinalAcceptCancelCallOrderAdapter$FinalRooomViewHolder_ViewBinding implements Unbinder {
  private FinalAcceptCancelCallOrderAdapter.FinalRooomViewHolder target;

  @UiThread
  public FinalAcceptCancelCallOrderAdapter$FinalRooomViewHolder_ViewBinding(
      FinalAcceptCancelCallOrderAdapter.FinalRooomViewHolder target, View source) {
    this.target = target;

    target.txtPrice = Utils.findRequiredViewAsType(source, R.id.show_client_room_oreder_shap_recyclerview_txt_price, "field 'txtPrice'", TextView.class);
    target.txtItemName = Utils.findRequiredViewAsType(source, R.id.show_client_room_oreder_shap_recyclerview_txt_item_name, "field 'txtItemName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FinalAcceptCancelCallOrderAdapter.FinalRooomViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtPrice = null;
    target.txtItemName = null;
  }
}
