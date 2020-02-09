// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StartUpActivity_ViewBinding implements Unbinder {
  private StartUpActivity target;

  private View view7f08026e;

  private View view7f08026f;

  @UiThread
  public StartUpActivity_ViewBinding(StartUpActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public StartUpActivity_ViewBinding(final StartUpActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.start_activity_btn_foodrequest, "field 'BtnFoodrequest' and method 'onViewClicked'");
    target.BtnFoodrequest = Utils.castView(view, R.id.start_activity_btn_foodrequest, "field 'BtnFoodrequest'", Button.class);
    view7f08026e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.start_activity_btn_restourant_register, "field 'BtnRestourantRegister' and method 'onViewClicked'");
    target.BtnRestourantRegister = Utils.castView(view, R.id.start_activity_btn_restourant_register, "field 'BtnRestourantRegister'", Button.class);
    view7f08026f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.activitSplashView = Utils.findRequiredViewAsType(source, R.id.activit_splash_view, "field 'activitSplashView'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    StartUpActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.BtnFoodrequest = null;
    target.BtnRestourantRegister = null;
    target.activitSplashView = null;

    view7f08026e.setOnClickListener(null);
    view7f08026e = null;
    view7f08026f.setOnClickListener(null);
    view7f08026f = null;
  }
}
