// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RestaurantMyCategoriesnAdapter$MyCategorisHolder_ViewBinding implements Unbinder {
  private RestaurantMyCategoriesnAdapter.MyCategorisHolder target;

  @UiThread
  public RestaurantMyCategoriesnAdapter$MyCategorisHolder_ViewBinding(
      RestaurantMyCategoriesnAdapter.MyCategorisHolder target, View source) {
    this.target = target;

    target.imgDelete = Utils.findRequiredViewAsType(source, R.id.my_category_recycler_shap_img_delete, "field 'imgDelete'", ImageView.class);
    target.imgEdit = Utils.findRequiredViewAsType(source, R.id.my_category_recycler_shap_img_edit, "field 'imgEdit'", ImageView.class);
    target.imgContaner = Utils.findRequiredViewAsType(source, R.id.my_category_recycler_shap_img_contaner, "field 'imgContaner'", ImageView.class);
    target.txtCategoryname = Utils.findRequiredViewAsType(source, R.id.my_category_recycler_shap_txt_categoryname, "field 'txtCategoryname'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RestaurantMyCategoriesnAdapter.MyCategorisHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgDelete = null;
    target.imgEdit = null;
    target.imgContaner = null;
    target.txtCategoryname = null;
  }
}
