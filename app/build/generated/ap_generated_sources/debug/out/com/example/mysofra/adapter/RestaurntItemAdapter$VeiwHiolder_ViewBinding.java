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

public class RestaurntItemAdapter$VeiwHiolder_ViewBinding implements Unbinder {
  private RestaurntItemAdapter.VeiwHiolder target;

  @UiThread
  public RestaurntItemAdapter$VeiwHiolder_ViewBinding(RestaurntItemAdapter.VeiwHiolder target,
      View source) {
    this.target = target;

    target.ImgItemImage = Utils.findRequiredViewAsType(source, R.id.show_restaurant_items_shape_recycler_img_item_image, "field 'ImgItemImage'", ImageView.class);
    target.TxtItemName = Utils.findRequiredViewAsType(source, R.id.show_restaurant_items_shape_recycler_txt_item_name, "field 'TxtItemName'", TextView.class);
    target.TxtItemDescription = Utils.findRequiredViewAsType(source, R.id.show_restaurant_items_shape_recycler_txt_item_description, "field 'TxtItemDescription'", TextView.class);
    target.TxtItemPrice = Utils.findRequiredViewAsType(source, R.id.show_restaurant_items_shape_recycler_txt_item_price, "field 'TxtItemPrice'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RestaurntItemAdapter.VeiwHiolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ImgItemImage = null;
    target.TxtItemName = null;
    target.TxtItemDescription = null;
    target.TxtItemPrice = null;
  }
}
