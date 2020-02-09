// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.client.homeFragment;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GetRestaurantsReviewsFragment_ViewBinding implements Unbinder {
  private GetRestaurantsReviewsFragment target;

  private View view7f08013b;

  @UiThread
  public GetRestaurantsReviewsFragment_ViewBinding(final GetRestaurantsReviewsFragment target,
      View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.fragment_get_restaurants_reviews_btn_addreview, "field 'BtnAddreview' and method 'onViewClicked'");
    target.BtnAddreview = Utils.castView(view, R.id.fragment_get_restaurants_reviews_btn_addreview, "field 'BtnAddreview'", Button.class);
    view7f08013b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.RcyclerShowReview = Utils.findRequiredViewAsType(source, R.id.fragment_get_restaurants_reviews_rcycler_show_review, "field 'RcyclerShowReview'", RecyclerView.class);
    target.SwipSwipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.fragment_get_restaurants_reviews_swip_swipeRefreshLayout, "field 'SwipSwipeRefreshLayout'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GetRestaurantsReviewsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.BtnAddreview = null;
    target.RcyclerShowReview = null;
    target.SwipSwipeRefreshLayout = null;

    view7f08013b.setOnClickListener(null);
    view7f08013b = null;
  }
}
