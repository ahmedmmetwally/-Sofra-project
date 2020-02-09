// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.restaurant.restaurantCycle;

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

public class MoreRestaurantFragment_ViewBinding implements Unbinder {
  private MoreRestaurantFragment target;

  private View view7f080194;

  private View view7f080193;

  private View view7f080191;

  private View view7f080197;

  private View view7f080192;

  private View view7f080196;

  @UiThread
  public MoreRestaurantFragment_ViewBinding(final MoreRestaurantFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.fragment_register_linl_my_offers, "field 'myOffers' and method 'onViewClicked'");
    target.myOffers = Utils.castView(view, R.id.fragment_register_linl_my_offers, "field 'myOffers'", LinearLayout.class);
    view7f080194 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_register_linl_contact_us, "field 'contactUs' and method 'onViewClicked'");
    target.contactUs = Utils.castView(view, R.id.fragment_register_linl_contact_us, "field 'contactUs'", LinearLayout.class);
    view7f080193 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_register_linl_about_application, "field 'aboutApplication' and method 'onViewClicked'");
    target.aboutApplication = Utils.castView(view, R.id.fragment_register_linl_about_application, "field 'aboutApplication'", LinearLayout.class);
    view7f080191 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_register_lnl_comments_and_ranting, "field 'commentsAndRanting' and method 'onViewClicked'");
    target.commentsAndRanting = Utils.castView(view, R.id.fragment_register_lnl_comments_and_ranting, "field 'commentsAndRanting'", LinearLayout.class);
    view7f080197 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_register_linl_chang_passewrd, "field 'changPassewrd' and method 'onViewClicked'");
    target.changPassewrd = Utils.castView(view, R.id.fragment_register_linl_chang_passewrd, "field 'changPassewrd'", LinearLayout.class);
    view7f080192 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_register_linl_register_out, "field 'registerOut' and method 'onViewClicked'");
    target.registerOut = Utils.castView(view, R.id.fragment_register_linl_register_out, "field 'registerOut'", LinearLayout.class);
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
    MoreRestaurantFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.myOffers = null;
    target.contactUs = null;
    target.aboutApplication = null;
    target.commentsAndRanting = null;
    target.changPassewrd = null;
    target.registerOut = null;

    view7f080194.setOnClickListener(null);
    view7f080194 = null;
    view7f080193.setOnClickListener(null);
    view7f080193 = null;
    view7f080191.setOnClickListener(null);
    view7f080191 = null;
    view7f080197.setOnClickListener(null);
    view7f080197 = null;
    view7f080192.setOnClickListener(null);
    view7f080192 = null;
    view7f080196.setOnClickListener(null);
    view7f080196 = null;
  }
}
