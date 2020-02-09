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

public class ChangPasswordFragment_ViewBinding implements Unbinder {
  private ChangPasswordFragment target;

  private View view7f0800e4;

  @UiThread
  public ChangPasswordFragment_ViewBinding(final ChangPasswordFragment target, View source) {
    this.target = target;

    View view;
    target.edtOldPassward = Utils.findRequiredViewAsType(source, R.id.fragment_chang_password_edt_old_passward, "field 'edtOldPassward'", EditText.class);
    target.edtNewPassword = Utils.findRequiredViewAsType(source, R.id.fragment_chang_password_edt_new_password, "field 'edtNewPassword'", EditText.class);
    target.edtConfirmPassword = Utils.findRequiredViewAsType(source, R.id.fragment_chang_password_edt_confirm_password, "field 'edtConfirmPassword'", EditText.class);
    view = Utils.findRequiredView(source, R.id.fragment_chang_passwordbtn_continue, "field 'btnContinue' and method 'onViewClicked'");
    target.btnContinue = Utils.castView(view, R.id.fragment_chang_passwordbtn_continue, "field 'btnContinue'", Button.class);
    view7f0800e4 = view;
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
    ChangPasswordFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edtOldPassward = null;
    target.edtNewPassword = null;
    target.edtConfirmPassword = null;
    target.btnContinue = null;

    view7f0800e4.setOnClickListener(null);
    view7f0800e4 = null;
  }
}
