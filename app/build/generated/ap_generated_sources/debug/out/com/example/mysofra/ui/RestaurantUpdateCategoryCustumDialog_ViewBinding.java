// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RestaurantUpdateCategoryCustumDialog_ViewBinding implements Unbinder {
  private RestaurantUpdateCategoryCustumDialog target;

  private View view7f080221;

  private View view7f080220;

  @UiThread
  public RestaurantUpdateCategoryCustumDialog_ViewBinding(
      RestaurantUpdateCategoryCustumDialog target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RestaurantUpdateCategoryCustumDialog_ViewBinding(
      final RestaurantUpdateCategoryCustumDialog target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.shape_update_category_alertdialoug_cimg_category_img, "field 'img' and method 'onViewClicked'");
    target.img = Utils.castView(view, R.id.shape_update_category_alertdialoug_cimg_category_img, "field 'img'", CircleImageView.class);
    view7f080221 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.txtName = Utils.findRequiredViewAsType(source, R.id.shape_update_category_alertdialoug_edt_categoryname, "field 'txtName'", EditText.class);
    view = Utils.findRequiredView(source, R.id.shape_update_category_alertdialoug_btn_addbutton, "field 'button' and method 'onViewClicked'");
    target.button = Utils.castView(view, R.id.shape_update_category_alertdialoug_btn_addbutton, "field 'button'", Button.class);
    view7f080220 = view;
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
    RestaurantUpdateCategoryCustumDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img = null;
    target.txtName = null;
    target.button = null;

    view7f080221.setOnClickListener(null);
    view7f080221 = null;
    view7f080220.setOnClickListener(null);
    view7f080220 = null;
  }
}
