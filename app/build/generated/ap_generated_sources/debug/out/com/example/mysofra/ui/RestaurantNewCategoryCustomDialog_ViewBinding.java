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

public class RestaurantNewCategoryCustomDialog_ViewBinding implements Unbinder {
  private RestaurantNewCategoryCustomDialog target;

  private View view7f080221;

  private View view7f080220;

  @UiThread
  public RestaurantNewCategoryCustomDialog_ViewBinding(RestaurantNewCategoryCustomDialog target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RestaurantNewCategoryCustomDialog_ViewBinding(
      final RestaurantNewCategoryCustomDialog target, View source) {
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
    target.edtname = Utils.findRequiredViewAsType(source, R.id.shape_update_category_alertdialoug_edt_categoryname, "field 'edtname'", EditText.class);
    view = Utils.findRequiredView(source, R.id.shape_update_category_alertdialoug_btn_addbutton, "field 'addbutton' and method 'onViewClicked'");
    target.addbutton = Utils.castView(view, R.id.shape_update_category_alertdialoug_btn_addbutton, "field 'addbutton'", Button.class);
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
    RestaurantNewCategoryCustomDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img = null;
    target.edtname = null;
    target.addbutton = null;

    view7f080221.setOnClickListener(null);
    view7f080221 = null;
    view7f080220.setOnClickListener(null);
    view7f080220 = null;
  }
}
