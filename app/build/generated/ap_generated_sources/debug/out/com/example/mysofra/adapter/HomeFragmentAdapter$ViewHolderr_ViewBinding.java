// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeFragmentAdapter$ViewHolderr_ViewBinding implements Unbinder {
  private HomeFragmentAdapter.ViewHolderr target;

  @UiThread
  public HomeFragmentAdapter$ViewHolderr_ViewBinding(HomeFragmentAdapter.ViewHolderr target,
      View source) {
    this.target = target;

    target.TxtOpenClose = Utils.findRequiredViewAsType(source, R.id.fragment_home_txt_open_close, "field 'TxtOpenClose'", TextView.class);
    target.ImgOnOff = Utils.findRequiredViewAsType(source, R.id.fragment_home_img_on_off, "field 'ImgOnOff'", ImageView.class);
    target.TxtRestaurntName = Utils.findRequiredViewAsType(source, R.id.fragment_home_txt_restaurnt_name, "field 'TxtRestaurntName'", TextView.class);
    target.rtbRatingBar = Utils.findRequiredViewAsType(source, R.id.fragment_home_rtb_rating_bar, "field 'rtbRatingBar'", RatingBar.class);
    target.TxtRequstNumber = Utils.findRequiredViewAsType(source, R.id.fragment_home_txt_requst_number, "field 'TxtRequstNumber'", TextView.class);
    target.TxtDeleveryCost = Utils.findRequiredViewAsType(source, R.id.fragment_home_txt_delevery_cost, "field 'TxtDeleveryCost'", TextView.class);
    target.ImgRestaurntProfile = Utils.findRequiredViewAsType(source, R.id.fragment_home_img_restaurnt_profile, "field 'ImgRestaurntProfile'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeFragmentAdapter.ViewHolderr target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.TxtOpenClose = null;
    target.ImgOnOff = null;
    target.TxtRestaurntName = null;
    target.rtbRatingBar = null;
    target.TxtRequstNumber = null;
    target.TxtDeleveryCost = null;
    target.ImgRestaurntProfile = null;
  }
}
