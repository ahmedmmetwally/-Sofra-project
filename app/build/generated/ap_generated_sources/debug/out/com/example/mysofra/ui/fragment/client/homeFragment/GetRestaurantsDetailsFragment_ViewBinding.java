// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.client.homeFragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GetRestaurantsDetailsFragment_ViewBinding implements Unbinder {
  private GetRestaurantsDetailsFragment target;

  @UiThread
  public GetRestaurantsDetailsFragment_ViewBinding(GetRestaurantsDetailsFragment target,
      View source) {
    this.target = target;

    target.DetailsTxtStatus = Utils.findRequiredViewAsType(source, R.id.fragment_get_restaurants_details_txt_status, "field 'DetailsTxtStatus'", TextView.class);
    target.DetailsTxtCity = Utils.findRequiredViewAsType(source, R.id.fragment_get_restaurants_details_txt_city, "field 'DetailsTxtCity'", TextView.class);
    target.DetailsTxtDistrict = Utils.findRequiredViewAsType(source, R.id.fragment_get_restaurants_details_txt_district, "field 'DetailsTxtDistrict'", TextView.class);
    target.DetailsTxtMinimum = Utils.findRequiredViewAsType(source, R.id.fragment_get_restaurants_details_txt_minimum, "field 'DetailsTxtMinimum'", TextView.class);
    target.DetailsTxtCost = Utils.findRequiredViewAsType(source, R.id.fragment_get_restaurants_details_txt_cost, "field 'DetailsTxtCost'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GetRestaurantsDetailsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.DetailsTxtStatus = null;
    target.DetailsTxtCity = null;
    target.DetailsTxtDistrict = null;
    target.DetailsTxtMinimum = null;
    target.DetailsTxtCost = null;
  }
}
