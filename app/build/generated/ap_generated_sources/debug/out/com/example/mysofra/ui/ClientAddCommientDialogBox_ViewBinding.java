// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ClientAddCommientDialogBox_ViewBinding implements Unbinder {
  private ClientAddCommientDialogBox target;

  private View view7f080214;

  private View view7f080215;

  private View view7f080216;

  private View view7f080217;

  private View view7f080218;

  private View view7f080212;

  @UiThread
  public ClientAddCommientDialogBox_ViewBinding(ClientAddCommientDialogBox target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ClientAddCommientDialogBox_ViewBinding(final ClientAddCommientDialogBox target,
      View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.shape_add_review_dialogbox_img_rate1, "field 'imgRate1' and method 'onViewClicked'");
    target.imgRate1 = Utils.castView(view, R.id.shape_add_review_dialogbox_img_rate1, "field 'imgRate1'", ImageView.class);
    view7f080214 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.shape_add_review_dialogbox_img_rate2, "field 'imgRate2' and method 'onViewClicked'");
    target.imgRate2 = Utils.castView(view, R.id.shape_add_review_dialogbox_img_rate2, "field 'imgRate2'", ImageView.class);
    view7f080215 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.shape_add_review_dialogbox_img_rate3, "field 'imgRate3' and method 'onViewClicked'");
    target.imgRate3 = Utils.castView(view, R.id.shape_add_review_dialogbox_img_rate3, "field 'imgRate3'", ImageView.class);
    view7f080216 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.shape_add_review_dialogbox_img_rate4, "field 'imgRate4' and method 'onViewClicked'");
    target.imgRate4 = Utils.castView(view, R.id.shape_add_review_dialogbox_img_rate4, "field 'imgRate4'", ImageView.class);
    view7f080217 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.shape_add_review_dialogbox_img_rate5, "field 'imgRate5' and method 'onViewClicked'");
    target.imgRate5 = Utils.castView(view, R.id.shape_add_review_dialogbox_img_rate5, "field 'imgRate5'", ImageView.class);
    view7f080218 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.edtCommint = Utils.findRequiredViewAsType(source, R.id.shape_add_review_dialogbox_edt_commint, "field 'edtCommint'", EditText.class);
    view = Utils.findRequiredView(source, R.id.shape_add_review_dialogbox_btn_add, "field 'btnAdd' and method 'onViewClicked'");
    target.btnAdd = Utils.castView(view, R.id.shape_add_review_dialogbox_btn_add, "field 'btnAdd'", Button.class);
    view7f080212 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ClientAddCommientDialogBox target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgRate1 = null;
    target.imgRate2 = null;
    target.imgRate3 = null;
    target.imgRate4 = null;
    target.imgRate5 = null;
    target.edtCommint = null;
    target.btnAdd = null;

    view7f080214.setOnClickListener(null);
    view7f080214 = null;
    view7f080215.setOnClickListener(null);
    view7f080215 = null;
    view7f080216.setOnClickListener(null);
    view7f080216 = null;
    view7f080217.setOnClickListener(null);
    view7f080217 = null;
    view7f080218.setOnClickListener(null);
    view7f080218 = null;
    view7f080212.setOnClickListener(null);
    view7f080212 = null;
  }
}
