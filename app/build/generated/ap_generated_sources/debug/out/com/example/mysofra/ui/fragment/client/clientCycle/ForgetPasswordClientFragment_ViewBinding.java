// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.client.clientCycle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ForgetPasswordClientFragment_ViewBinding implements Unbinder {
  private ForgetPasswordClientFragment target;

  private View view7f0800fe;

  @UiThread
  public ForgetPasswordClientFragment_ViewBinding(final ForgetPasswordClientFragment target,
      View source) {
    this.target = target;

    View view;
    target.EdtEmail = Utils.findRequiredViewAsType(source, R.id.fragment_creat_new_password_edt_email, "field 'EdtEmail'", EditText.class);
    view = Utils.findRequiredView(source, R.id.fragment_creat_new_password_btn_send, "field 'BtnSend' and method 'onViewClicked'");
    target.BtnSend = Utils.castView(view, R.id.fragment_creat_new_password_btn_send, "field 'BtnSend'", Button.class);
    view7f0800fe = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ForgetPasswordClientFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.EdtEmail = null;
    target.BtnSend = null;

    view7f0800fe.setOnClickListener(null);
    view7f0800fe = null;
  }
}
