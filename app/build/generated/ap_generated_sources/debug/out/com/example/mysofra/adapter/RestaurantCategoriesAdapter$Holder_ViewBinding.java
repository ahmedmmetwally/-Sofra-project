// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RestaurantCategoriesAdapter$Holder_ViewBinding implements Unbinder {
  private RestaurantCategoriesAdapter.Holder target;

  @UiThread
  public RestaurantCategoriesAdapter$Holder_ViewBinding(RestaurantCategoriesAdapter.Holder target,
      View source) {
    this.target = target;

    target.CategoryShapeImageCateogyr = Utils.findRequiredViewAsType(source, R.id.show_restaurant_category_shape_image_cateogyr, "field 'CategoryShapeImageCateogyr'", CircleImageView.class);
    target.CategoryShapeTxtCategoryName = Utils.findRequiredViewAsType(source, R.id.show_restaurant_category_shape_txt_category_name, "field 'CategoryShapeTxtCategoryName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RestaurantCategoriesAdapter.Holder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.CategoryShapeImageCateogyr = null;
    target.CategoryShapeTxtCategoryName = null;
  }
}
