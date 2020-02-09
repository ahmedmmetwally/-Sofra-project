package com.example.mysofra.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.local.SharedPreferencesManger;
import com.example.mysofra.data.model.clientAddCommit.ClientAddCommit;
import com.example.mysofra.data.model.clientlogin.ClientloginUser;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.helper.InternetState;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mysofra.helper.HelperMethod.customToast;
import static com.example.mysofra.helper.HelperMethod.dismissProgressDialog;
import static com.example.mysofra.helper.constant.RESTAURANT_API_TOKEN;

public class ClientAddCommientDialogBox extends Dialog {

    @BindView(R.id.shape_add_review_dialogbox_img_rate1)
    ImageView imgRate1;
    @BindView(R.id.shape_add_review_dialogbox_img_rate2)
    ImageView imgRate2;
    @BindView(R.id.shape_add_review_dialogbox_img_rate3)
    ImageView imgRate3;
    @BindView(R.id.shape_add_review_dialogbox_img_rate4)
    ImageView imgRate4;
    @BindView(R.id.shape_add_review_dialogbox_img_rate5)
    ImageView imgRate5;
    @BindView(R.id.shape_add_review_dialogbox_edt_commint)
    EditText edtCommint;
    @BindView(R.id.shape_add_review_dialogbox_btn_add)
    Button btnAdd;
    private Unbinder unbind;
    private Context context;
    public int rate = 1;
    public String comment = "emara";
    public int restaurant_id = 1;
    public int restaurant_idd = 1;
    public String api_token =RESTAURANT_API_TOKEN;
    public ClientloginUser clientloginUser;

    public ClientAddCommientDialogBox(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shape_add_review_dialogbox);
        unbind = ButterKnife.bind(this);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);//make error
        //take allWidth for dialog
        this.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


        clientloginUser = SharedPreferencesManger.loadUserData((Activity) context);
        api_token = clientloginUser.getApiToken();


    }


    @OnClick({R.id.shape_add_review_dialogbox_img_rate1, R.id.shape_add_review_dialogbox_img_rate2
            , R.id.shape_add_review_dialogbox_img_rate3, R.id.shape_add_review_dialogbox_img_rate4
            , R.id.shape_add_review_dialogbox_img_rate5, R.id.shape_add_review_dialogbox_btn_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shape_add_review_dialogbox_img_rate1:
                rate = 1;
                break;
            case R.id.shape_add_review_dialogbox_img_rate2:
                rate = 2;
                break;
            case R.id.shape_add_review_dialogbox_img_rate3:
                rate = 3;
                break;
            case R.id.shape_add_review_dialogbox_img_rate4:
                rate = 4;
                break;
            case R.id.shape_add_review_dialogbox_img_rate5:
                rate = 5;
                break;
            case R.id.shape_add_review_dialogbox_btn_add:
                getData();

                break;
        }


    }

    private void getData() {

        comment = edtCommint.getText().toString().trim();
        if (comment.isEmpty()) {
            customToast((Activity) context, context.getResources().getString(R.string.add_comment), false);
            return;
        }
        addComment();

    }

    private void addComment() {
        if (InternetState.isConnected(context)) {
            Log.e("addcommit", "in internetState addcommit   " + restaurant_id + "----" + rate);
            RetrofitSofra.getInstance().addCommit(rate, comment, restaurant_idd, api_token).enqueue(new Callback<ClientAddCommit>() {
                @Override
                public void onResponse(Call<ClientAddCommit> call, Response<ClientAddCommit> response) {
                    try {
                        if (response.body().getStatus() == 1) {
                            Log.e("addcommit", "in response addcommit" + response.body().getMsg());
                            HelperMethod.customToast((Activity) context, response.body().getMsg(), true);
                            dismiss();
                        }
                    } catch (Exception e) {
                        dismissProgressDialog();
                        customToast((Activity) context, response.body().getMsg(), false);
                    }
                }

                @Override
                public void onFailure(Call<ClientAddCommit> call, Throwable t) {
                    Log.e("addcommit", "in failure addcommit" + t.toString());
                    customToast((Activity) context, context.getResources().getString(R.string.error), true);
                }
            });

        } else {
            customToast((Activity) context, context.getResources().getString(R.string.offline), false);
        }

    }
}
