// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.client.homeFragment;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MoreFragment_ViewBinding implements Unbinder {
  private MoreFragment target;

  private View view7f080195;

  private View view7f080193;

  private View view7f080191;

  private View view7f080192;

  private View view7f080196;

  @UiThread
  public MoreFragment_ViewBinding(final MoreFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.fragment_register_linl_offers, "field 'linlOffers' and method 'onViewClicked'");
    target.linlOffers = Utils.castView(view, R.id.fragment_register_linl_offers, "field 'linlOffers'", LinearLayout.class);
    view7f080195 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_register_linl_contact_us, "field 'linlContactUs' and method 'onViewClicked'");
    target.linlContactUs = Utils.castView(view, R.id.fragment_register_linl_contact_us, "field 'linlContactUs'", LinearLayout.class);
    view7f080193 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_register_linl_about_application, "field 'linlAboutApplication' and method 'onViewClicked'");
    target.linlAboutApplication = Utils.castView(view, R.id.fragment_register_linl_about_application, "field 'linlAboutApplication'", LinearLayout.class);
    view7f080191 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_register_linl_chang_passewrd, "field 'linlChangPassewrd' and method 'onViewClicked'");
    target.linlChangPassewrd = Utils.castView(view, R.id.fragment_register_linl_chang_passewrd, "field 'linlChangPassewrd'", LinearLayout.class);
    view7f080192 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_register_linl_register_out, "field 'linlRegisterOut' and method 'onViewClicked'");
    target.linlRegisterOut = Utils.castView(view, R.id.fragment_register_linl_register_out, "field 'linlRegisterOut'", LinearLayout.class);
    view7f080196 = view;
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
    MoreFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.linlOffers = null;
    target.linlContactUs = null;
    target.linlAboutApplication = null;
    target.linlChangPassewrd = null;
    target.linlRegisterOut = null;

    view7f080195.setOnClickListener(null);
    view7f080195 = null;
    view7f080193.setOnClickListener(null);
    view7f080193 = null;
    view7f080191.setOnClickListener(null);
    view7f080191 = null;
    view7f080192.setOnClickListener(null);
    view7f080192 = null;
    view7f080196.setOnClickListener(null);
    view7f080196 = null;
  }
}
