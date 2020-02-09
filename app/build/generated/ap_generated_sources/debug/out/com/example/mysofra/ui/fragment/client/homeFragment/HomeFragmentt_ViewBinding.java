// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.client.homeFragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class HomeFragmentt_ViewBinding implements Unbinder {
  private HomeFragmentt target;

  private View view7f08013e;

  @UiThread
  public HomeFragmentt_ViewBinding(final HomeFragmentt target, View source) {
    this.target = target;

    View view;
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.homeFragment_recycler_view, "field 'recyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.fragment_home_btn_search, "field 'fragmentHomeBtnSearch' and method 'onViewClicked'");
    target.fragmentHomeBtnSearch = Utils.castView(view, R.id.fragment_home_btn_search, "field 'fragmentHomeBtnSearch'", Button.class);
    view7f08013e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.homeEdtLWord = Utils.findRequiredViewAsType(source, R.id.fragment_home_edtL_word, "field 'homeEdtLWord'", EditText.class);
    target.HomeSpnCity = Utils.findRequiredViewAsType(source, R.id.fragment_home_spn_city, "field 'HomeSpnCity'", Spinner.class);
    target.homeFragmentSwipeFresh = Utils.findRequiredViewAsType(source, R.id.homeFragment_swipe_fresh, "field 'homeFragmentSwipeFresh'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeFragmentt target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;
    target.fragmentHomeBtnSearch = null;
    target.homeEdtLWord = null;
    target.HomeSpnCity = null;
    target.homeFragmentSwipeFresh = null;

    view7f08013e.setOnClickListener(null);
    view7f08013e = null;
  }
}
