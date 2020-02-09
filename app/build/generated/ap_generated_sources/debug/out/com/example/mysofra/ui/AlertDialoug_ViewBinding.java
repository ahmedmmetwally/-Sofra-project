// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AlertDialoug_ViewBinding implements Unbinder {
  private AlertDialoug target;

  private View view7f08021e;

  private View view7f08021f;

  @UiThread
  public AlertDialoug_ViewBinding(AlertDialoug target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AlertDialoug_ViewBinding(final AlertDialoug target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.shape_sign_out_alterdialog_close, "field 'shapeSignOutAlterdialogClose' and method 'onViewClicked'");
    target.shapeSignOutAlterdialogClose = Utils.castView(view, R.id.shape_sign_out_alterdialog_close, "field 'shapeSignOutAlterdialogClose'", CircleImageView.class);
    view7f08021e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.shape_sign_out_alterdialog_sure, "field 'shapeSignOutAlterdialogSure' and method 'onViewClicked'");
    target.shapeSignOutAlterdialogSure = Utils.castView(view, R.id.shape_sign_out_alterdialog_sure, "field 'shapeSignOutAlterdialogSure'", CircleImageView.class);
    view7f08021f = view;
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
    AlertDialoug target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.shapeSignOutAlterdialogClose = null;
    target.shapeSignOutAlterdialogSure = null;

    view7f08021e.setOnClickListener(null);
    view7f08021e = null;
    view7f08021f.setOnClickListener(null);
    view7f08021f = null;
  }
}
