// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.client.homeFragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OfferDetailsFragment_ViewBinding implements Unbinder {
  private OfferDetailsFragment target;

  private View view7f08017f;

  @UiThread
  public OfferDetailsFragment_ViewBinding(final OfferDetailsFragment target, View source) {
    this.target = target;

    View view;
    target.txtName = Utils.findRequiredViewAsType(source, R.id.fragment_offer_details_txt_name, "field 'txtName'", TextView.class);
    target.txtDescrpition = Utils.findRequiredViewAsType(source, R.id.fragment_offer_details_txt_descrpition, "field 'txtDescrpition'", TextView.class);
    target.txtFrom = Utils.findRequiredViewAsType(source, R.id.fragment_offer_details_txt_from, "field 'txtFrom'", TextView.class);
    target.txtTo = Utils.findRequiredViewAsType(source, R.id.fragment_offer_details_txt_to, "field 'txtTo'", TextView.class);
    view = Utils.findRequiredView(source, R.id.fragment_offer_details_btn_details, "field 'btnDetails' and method 'onViewClicked'");
    target.btnDetails = Utils.castView(view, R.id.fragment_offer_details_btn_details, "field 'btnDetails'", Button.class);
    view7f08017f = view;
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
    OfferDetailsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtName = null;
    target.txtDescrpition = null;
    target.txtFrom = null;
    target.txtTo = null;
    target.btnDetails = null;

    view7f08017f.setOnClickListener(null);
    view7f08017f = null;
  }
}
