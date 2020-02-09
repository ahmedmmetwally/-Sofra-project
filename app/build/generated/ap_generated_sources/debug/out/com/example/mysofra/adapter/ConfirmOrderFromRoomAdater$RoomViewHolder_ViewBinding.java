// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ConfirmOrderFromRoomAdater$RoomViewHolder_ViewBinding implements Unbinder {
  private ConfirmOrderFromRoomAdater.RoomViewHolder target;

  @UiThread
  public ConfirmOrderFromRoomAdater$RoomViewHolder_ViewBinding(
      ConfirmOrderFromRoomAdater.RoomViewHolder target, View source) {
    this.target = target;

    target.imgPhotoItem = Utils.findRequiredViewAsType(source, R.id.show_recycler_confirem_order_from_room_img_photo_item, "field 'imgPhotoItem'", ImageView.class);
    target.txtItemName = Utils.findRequiredViewAsType(source, R.id.show_recycler_confirem_order_from_room_txt_item_name, "field 'txtItemName'", TextView.class);
    target.txtItemPrice = Utils.findRequiredViewAsType(source, R.id.show_recycler_confirem_order_from_room_txt_item_Price, "field 'txtItemPrice'", TextView.class);
    target.btnPlus = Utils.findRequiredViewAsType(source, R.id.show_recycler_confirem_order_from_room_btn_plus, "field 'btnPlus'", Button.class);
    target.txtQuantity = Utils.findRequiredViewAsType(source, R.id.show_recycler_confirem_order_from_room_txt_quantity, "field 'txtQuantity'", TextView.class);
    target.btnMinus = Utils.findRequiredViewAsType(source, R.id.show_recycler_confirem_order_from_room_btn_minus, "field 'btnMinus'", Button.class);
    target.btnDelete = Utils.findRequiredViewAsType(source, R.id.show_restaurant_my_item_shape_recycler_btn_delete, "field 'btnDelete'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ConfirmOrderFromRoomAdater.RoomViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgPhotoItem = null;
    target.txtItemName = null;
    target.txtItemPrice = null;
    target.btnPlus = null;
    target.txtQuantity = null;
    target.btnMinus = null;
    target.btnDelete = null;
  }
}
