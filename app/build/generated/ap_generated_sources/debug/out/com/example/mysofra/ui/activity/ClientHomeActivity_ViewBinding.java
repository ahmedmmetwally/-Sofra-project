// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ClientHomeActivity_ViewBinding implements Unbinder {
  private ClientHomeActivity target;

  private View view7f080077;

  private View view7f08007b;

  private View view7f080079;

  private View view7f08007c;

  private View view7f08007a;

  private View view7f080078;

  @UiThread
  public ClientHomeActivity_ViewBinding(ClientHomeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ClientHomeActivity_ViewBinding(final ClientHomeActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.activity_home_img_car, "field 'activityHomeImgCar' and method 'onViewClicked'");
    target.activityHomeImgCar = Utils.castView(view, R.id.activity_home_img_car, "field 'activityHomeImgCar'", ImageView.class);
    view7f080077 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.activity_home_img_notification_appbar, "field 'activityHomeImgNotificationAppbar' and method 'onViewClicked'");
    target.activityHomeImgNotificationAppbar = Utils.castView(view, R.id.activity_home_img_notification_appbar, "field 'activityHomeImgNotificationAppbar'", ImageView.class);
    view7f08007b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.appBarLayout = Utils.findRequiredViewAsType(source, R.id.appBar_layout, "field 'appBarLayout'", AppBarLayout.class);
    target.activityHomeFrameFragment = Utils.findRequiredViewAsType(source, R.id.activity_home_client_frame_fragment, "field 'activityHomeFrameFragment'", FrameLayout.class);
    view = Utils.findRequiredView(source, R.id.activity_home_img_menu, "field 'activityHomeImgMenu' and method 'onViewClicked'");
    target.activityHomeImgMenu = Utils.castView(view, R.id.activity_home_img_menu, "field 'activityHomeImgMenu'", ImageView.class);
    view7f080079 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.activity_home_img_profil, "field 'activityHomeImgProfil' and method 'onViewClicked'");
    target.activityHomeImgProfil = Utils.castView(view, R.id.activity_home_img_profil, "field 'activityHomeImgProfil'", ImageView.class);
    view7f08007c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.activity_home_img_myorder, "field 'activityHomeImgmyOrder' and method 'onViewClicked'");
    target.activityHomeImgmyOrder = Utils.castView(view, R.id.activity_home_img_myorder, "field 'activityHomeImgmyOrder'", ImageView.class);
    view7f08007a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.activity_home_img_home, "field 'activityHomeImgHome' and method 'onViewClicked'");
    target.activityHomeImgHome = Utils.castView(view, R.id.activity_home_img_home, "field 'activityHomeImgHome'", ImageView.class);
    view7f080078 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.activityHomeLnlyMenu = Utils.findRequiredViewAsType(source, R.id.activity_home_lnly_menu, "field 'activityHomeLnlyMenu'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ClientHomeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.activityHomeImgCar = null;
    target.activityHomeImgNotificationAppbar = null;
    target.appBarLayout = null;
    target.activityHomeFrameFragment = null;
    target.activityHomeImgMenu = null;
    target.activityHomeImgProfil = null;
    target.activityHomeImgmyOrder = null;
    target.activityHomeImgHome = null;
    target.activityHomeLnlyMenu = null;

    view7f080077.setOnClickListener(null);
    view7f080077 = null;
    view7f08007b.setOnClickListener(null);
    view7f08007b = null;
    view7f080079.setOnClickListener(null);
    view7f080079 = null;
    view7f08007c.setOnClickListener(null);
    view7f08007c = null;
    view7f08007a.setOnClickListener(null);
    view7f08007a = null;
    view7f080078.setOnClickListener(null);
    view7f080078 = null;
  }
}
