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

public class MyItemAdapter$MyItemHolder_ViewBinding implements Unbinder {
  private MyItemAdapter.MyItemHolder target;

  @UiThread
  public MyItemAdapter$MyItemHolder_ViewBinding(MyItemAdapter.MyItemHolder target, View source) {
    this.target = target;

    target.imgDelete = Utils.findRequiredViewAsType(source, R.id.show_restaurant_my_items_shape_recycler_recycler_img_delete, "field 'imgDelete'", ImageView.class);
    target.imgEdit = Utils.findRequiredViewAsType(source, R.id.show_restaurant_my_item_shape_recycler_img_edit, "field 'imgEdit'", ImageView.class);
    target.imgPhotoItem = Utils.findRequiredViewAsType(source, R.id.show_restaurant_my_item_shape_recycler_img_photo_item, "field 'imgPhotoItem'", ImageView.class);
    target.txtItemName = Utils.findRequiredViewAsType(source, R.id.show_restaurant_my_item_shape_recycler_txt_item_name, "field 'txtItemName'", TextView.class);
    target.txtItemDescription = Utils.findRequiredViewAsType(source, R.id.show_restaurant_my_item_shape_recycler_txt_item_description, "field 'txtItemDescription'", TextView.class);
    target.txtItemPriceNum = Utils.findRequiredViewAsType(source, R.id.show_restaurant_my_item_shape_recycler_txt_item_price_num, "field 'txtItemPriceNum'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyItemAdapter.MyItemHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgDelete = null;
    target.imgEdit = null;
    target.imgPhotoItem = null;
    target.txtItemName = null;
    target.txtItemDescription = null;
    target.txtItemPriceNum = null;
  }
}
