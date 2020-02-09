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
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyOfferRestaurantAdapter$MyOfferHolder_ViewBinding implements Unbinder {
  private MyOfferRestaurantAdapter.MyOfferHolder target;

  @UiThread
  public MyOfferRestaurantAdapter$MyOfferHolder_ViewBinding(
      MyOfferRestaurantAdapter.MyOfferHolder target, View source) {
    this.target = target;

    target.ImgDelete = Utils.findRequiredViewAsType(source, R.id.show_restaurant_my_offer_shape_recycler_img_delete, "field 'ImgDelete'", ImageView.class);
    target.ImgEdit = Utils.findRequiredViewAsType(source, R.id.show_restaurant_my_offer_shape_recycler_img_edit, "field 'ImgEdit'", ImageView.class);
    target.cimgCircleImage = Utils.findRequiredViewAsType(source, R.id.show_restaurant_my_offer_shape_recycler_cimg_circle_image, "field 'cimgCircleImage'", CircleImageView.class);
    target.txtTextview = Utils.findRequiredViewAsType(source, R.id.show_restaurant_my_offer_shape_recycler_txt_textview, "field 'txtTextview'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyOfferRestaurantAdapter.MyOfferHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ImgDelete = null;
    target.ImgEdit = null;
    target.cimgCircleImage = null;
    target.txtTextview = null;
  }
}
