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

public class RestaurantReviewsAdapter$ViewHolderr_ViewBinding implements Unbinder {
  private RestaurantReviewsAdapter.ViewHolderr target;

  @UiThread
  public RestaurantReviewsAdapter$ViewHolderr_ViewBinding(
      RestaurantReviewsAdapter.ViewHolderr target, View source) {
    this.target = target;

    target.TxtName = Utils.findRequiredViewAsType(source, R.id.show_restaurant_review_shape_recycler_txt_name, "field 'TxtName'", TextView.class);
    target.Txt_review = Utils.findRequiredViewAsType(source, R.id.show_restaurant_review_shape_recycler_txt_review, "field 'Txt_review'", TextView.class);
    target.ImgProfileImage = Utils.findRequiredViewAsType(source, R.id.show_restaurant_review_shape_recycler_img_review_image, "field 'ImgProfileImage'", CircleImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RestaurantReviewsAdapter.ViewHolderr target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.TxtName = null;
    target.Txt_review = null;
    target.ImgProfileImage = null;
  }
}
