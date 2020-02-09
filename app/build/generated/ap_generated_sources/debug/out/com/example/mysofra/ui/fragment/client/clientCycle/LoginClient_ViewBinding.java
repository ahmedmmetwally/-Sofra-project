// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.client.clientCycle;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginClient_ViewBinding implements Unbinder {
  private LoginClient target;

  private View view7f08014f;

  private View view7f08014d;

  private View view7f08014e;

  @UiThread
  public LoginClient_ViewBinding(final LoginClient target, View source) {
    this.target = target;

    View view;
    target.EdtEmail = Utils.findRequiredViewAsType(source, R.id.fragment_login_edt_email, "field 'EdtEmail'", EditText.class);
    target.EdtPassword = Utils.findRequiredViewAsType(source, R.id.fragment_login_edt_password, "field 'EdtPassword'", EditText.class);
    view = Utils.findRequiredView(source, R.id.fragment_login_txtv_forgetpassword, "field 'TxtvForgetpassword' and method 'onViewClicked'");
    target.TxtvForgetpassword = Utils.castView(view, R.id.fragment_login_txtv_forgetpassword, "field 'TxtvForgetpassword'", TextView.class);
    view7f08014f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_login_rlt_register, "field 'RltRegister' and method 'onViewClicked'");
    target.RltRegister = Utils.castView(view, R.id.fragment_login_rlt_register, "field 'RltRegister'", RelativeLayout.class);
    view7f08014d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_login_txtv_creataccount, "field 'TxtvCreataccount' and method 'onViewClicked'");
    target.TxtvCreataccount = Utils.castView(view, R.id.fragment_login_txtv_creataccount, "field 'TxtvCreataccount'", TextView.class);
    view7f08014e = view;
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
    LoginClient target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.EdtEmail = null;
    target.EdtPassword = null;
    target.TxtvForgetpassword = null;
    target.RltRegister = null;
    target.TxtvCreataccount = null;

    view7f08014f.setOnClickListener(null);
    view7f08014f = null;
    view7f08014d.setOnClickListener(null);
    view7f08014d = null;
    view7f08014e.setOnClickListener(null);
    view7f08014e = null;
  }
}
