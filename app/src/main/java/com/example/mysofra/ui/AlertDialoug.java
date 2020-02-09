package com.example.mysofra.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.mysofra.R;
import com.example.mysofra.data.local.SharedPreferencesManger;
import com.example.mysofra.helper.HelperMethod;
import static com.example.mysofra.helper.constant.USER_TYPE;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

public class AlertDialoug extends Dialog {
    @BindView(R.id.shape_sign_out_alterdialog_close)
    CircleImageView shapeSignOutAlterdialogClose;
    @BindView(R.id.shape_sign_out_alterdialog_sure)
    CircleImageView shapeSignOutAlterdialogSure;
    Unbinder unbinder;


    public AlertDialoug(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shape_sign_out_alterdialog);
        unbinder = ButterKnife.bind(this);
    }

    @OnClick({R.id.shape_sign_out_alterdialog_close, R.id.shape_sign_out_alterdialog_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shape_sign_out_alterdialog_close:
                Toast.makeText(getContext(), "tttttttttttttttt", Toast.LENGTH_LONG).show();
                dismiss();

                break;
            case R.id.shape_sign_out_alterdialog_sure:
                if(USER_TYPE.equals("client"))
                {  SharedPreferencesManger.deleteDate("USER_DATA");}else
                    SharedPreferencesManger.deleteDate("RESTAURANT_DATA");
                Toast.makeText(getContext(), "ffffffffffffff", Toast.LENGTH_LONG).show();
                dismiss();
                break;

        }
    }
}
