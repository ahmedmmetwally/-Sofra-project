// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NewOffersClientAdapter$NewOfferViewHolder_ViewBinding implements Unbinder {
  private NewOffersClientAdapter.NewOfferViewHolder target;

  @UiThread
  public NewOffersClientAdapter$NewOfferViewHolder_ViewBinding(
      NewOffersClientAdapter.NewOfferViewHolder target, View source) {
    this.target = target;

    target.cimgCircleImage = Utils.findRequiredViewAsType(source, R.id.show_client_newt_offer_shape_recycler_cimg_circle_image, "field 'cimgCircleImage'", CircleImageView.class);
    target.txtTextview = Utils.findRequiredViewAsType(source, R.id.show_client_newt_offer_shape_recycler_txt_textview, "field 'txtTextview'", TextView.class);
    target.btnDetails = Utils.findRequiredViewAsType(source, R.id.show_client_newt_offer_shape_recycler_btn_details, "field 'btnDetails'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NewOffersClientAdapter.NewOfferViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.cimgCircleImage = null;
    target.txtTextview = null;
    target.btnDetails = null;
  }
}
