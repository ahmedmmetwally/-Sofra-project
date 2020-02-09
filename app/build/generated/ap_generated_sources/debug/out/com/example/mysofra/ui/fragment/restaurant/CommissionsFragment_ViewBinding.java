// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.restaurant;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CommissionsFragment_ViewBinding implements Unbinder {
  private CommissionsFragment target;

  @UiThread
  public CommissionsFragment_ViewBinding(CommissionsFragment target, View source) {
    this.target = target;

    target.tvDescription = Utils.findRequiredViewAsType(source, R.id.fragment_commission_tv_description, "field 'tvDescription'", TextView.class);
    target.tvRestaurantSale = Utils.findRequiredViewAsType(source, R.id.fragment_commission_tv_restaurant_sale, "field 'tvRestaurantSale'", TextView.class);
    target.tvApplicationCommissions = Utils.findRequiredViewAsType(source, R.id.fragment_commission_tv_application_commissions, "field 'tvApplicationCommissions'", TextView.class);
    target.tvWhatIsPaid = Utils.findRequiredViewAsType(source, R.id.fragment_commission_tv_what_is_paid, "field 'tvWhatIsPaid'", TextView.class);
    target.tvResidual = Utils.findRequiredViewAsType(source, R.id.fragment_commission_tv_residual, "field 'tvResidual'", TextView.class);
    target.tvAccount1 = Utils.findRequiredViewAsType(source, R.id.fragment_commission_tv_account1, "field 'tvAccount1'", TextView.class);
    target.tvAccount2 = Utils.findRequiredViewAsType(source, R.id.fragment_commission_tv_account2, "field 'tvAccount2'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CommissionsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvDescription = null;
    target.tvRestaurantSale = null;
    target.tvApplicationCommissions = null;
    target.tvWhatIsPaid = null;
    target.tvResidual = null;
    target.tvAccount1 = null;
    target.tvAccount2 = null;
  }
}
