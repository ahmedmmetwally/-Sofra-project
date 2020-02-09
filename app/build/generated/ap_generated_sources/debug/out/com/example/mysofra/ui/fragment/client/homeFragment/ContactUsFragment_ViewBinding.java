// Generated code from Butter Knife. Do not modify!
package com.example.mysofra.ui.fragment.client.homeFragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mysofra.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ContactUsFragment_ViewBinding implements Unbinder {
  private ContactUsFragment target;

  private View view7f0800f1;

  @UiThread
  public ContactUsFragment_ViewBinding(final ContactUsFragment target, View source) {
    this.target = target;

    View view;
    target.edtFullname = Utils.findRequiredViewAsType(source, R.id.fragment_contact_us_edt_fullname, "field 'edtFullname'", EditText.class);
    target.edtEmail = Utils.findRequiredViewAsType(source, R.id.fragment_contact_us_edt_email, "field 'edtEmail'", EditText.class);
    target.edtPhone = Utils.findRequiredViewAsType(source, R.id.fragment_contact_us_edt_phone, "field 'edtPhone'", EditText.class);
    target.edtMessage = Utils.findRequiredViewAsType(source, R.id.fragment_contact_us_edt_message, "field 'edtMessage'", EditText.class);
    target.radioQuery = Utils.findRequiredViewAsType(source, R.id.fragment_contact_us_radio_query, "field 'radioQuery'", RadioButton.class);
    target.radioSuggest = Utils.findRequiredViewAsType(source, R.id.fragment_contact_us_radio_suggest, "field 'radioSuggest'", RadioButton.class);
    target.radioComplaint = Utils.findRequiredViewAsType(source, R.id.fragment_contact_us_radio_complaint, "field 'radioComplaint'", RadioButton.class);
    view = Utils.findRequiredView(source, R.id.fragment_contact_us_btn_send, "field 'btnSend' and method 'onViewClicked'");
    target.btnSend = Utils.castView(view, R.id.fragment_contact_us_btn_send, "field 'btnSend'", Button.class);
    view7f0800f1 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.rdgRadiogroup = Utils.findRequiredViewAsType(source, R.id.fragment_contact_us_rdg_radiogroup, "field 'rdgRadiogroup'", RadioGroup.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ContactUsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edtFullname = null;
    target.edtEmail = null;
    target.edtPhone = null;
    target.edtMessage = null;
    target.radioQuery = null;
    target.radioSuggest = null;
    target.radioComplaint = null;
    target.btnSend = null;
    target.rdgRadiogroup = null;

    view7f0800f1.setOnClickListener(null);
    view7f0800f1 = null;
  }
}
