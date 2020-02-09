// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.activity;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RestaurantHomeActivity_ViewBinding implements Unbinder {
  private RestaurantHomeActivity target;

  private View view7f08007f;

  private View view7f080085;

  private View view7f080081;

  private View view7f080083;

  private View view7f080082;

  private View view7f080080;

  @UiThread
  public RestaurantHomeActivity_ViewBinding(RestaurantHomeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RestaurantHomeActivity_ViewBinding(final RestaurantHomeActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.activity_restaurant_home_img_car, "field 'ImgCar' and method 'onViewClicked'");
    target.ImgCar = Utils.castView(view, R.id.activity_restaurant_home_img_car, "field 'ImgCar'", ImageView.class);
    view7f08007f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.activity_restaurant_homeimg_notification_appbar, "field 'imgNotificationAppbar' and method 'onViewClicked'");
    target.imgNotificationAppbar = Utils.castView(view, R.id.activity_restaurant_homeimg_notification_appbar, "field 'imgNotificationAppbar'", ImageView.class);
    view7f080085 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.activity_restaurant_home_img_menu, "field 'ImgMenu' and method 'onViewClicked'");
    target.ImgMenu = Utils.castView(view, R.id.activity_restaurant_home_img_menu, "field 'ImgMenu'", ImageView.class);
    view7f080081 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.activity_restaurant_home_img_profil, "field 'ImgProfil' and method 'onViewClicked'");
    target.ImgProfil = Utils.castView(view, R.id.activity_restaurant_home_img_profil, "field 'ImgProfil'", ImageView.class);
    view7f080083 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.activity_restaurant_home_img_myorder, "field 'ImgMyorder' and method 'onViewClicked'");
    target.ImgMyorder = Utils.castView(view, R.id.activity_restaurant_home_img_myorder, "field 'ImgMyorder'", ImageView.class);
    view7f080082 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.activity_restaurant_home_img_home, "field 'ImgHome' and method 'onViewClicked'");
    target.ImgHome = Utils.castView(view, R.id.activity_restaurant_home_img_home, "field 'ImgHome'", ImageView.class);
    view7f080080 = view;
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
    RestaurantHomeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ImgCar = null;
    target.imgNotificationAppbar = null;
    target.ImgMenu = null;
    target.ImgProfil = null;
    target.ImgMyorder = null;
    target.ImgHome = null;

    view7f08007f.setOnClickListener(null);
    view7f08007f = null;
    view7f080085.setOnClickListener(null);
    view7f080085 = null;
    view7f080081.setOnClickListener(null);
    view7f080081 = null;
    view7f080083.setOnClickListener(null);
    view7f080083 = null;
    view7f080082.setOnClickListener(null);
    view7f080082 = null;
    view7f080080.setOnClickListener(null);
    view7f080080 = null;
  }
}
