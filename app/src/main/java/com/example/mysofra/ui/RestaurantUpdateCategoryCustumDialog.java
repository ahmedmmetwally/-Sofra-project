package com.example.mysofra.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.restaurantUpdateCategory.RestaurantUpdateCategory;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.helper.InternetState;
import com.squareup.picasso.Picasso;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.AlbumFile;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import static com.example.mysofra.helper.HelperMethod.customToast;
import static com.example.mysofra.helper.HelperMethod.dismissProgressDialog;
import static com.example.mysofra.helper.HelperMethod.selectImage;
import static com.example.mysofra.helper.constant.RESTAURANT_API_TOKEN;

public class RestaurantUpdateCategoryCustumDialog extends Dialog {

    private Context context;

    public int id;
    public String imgUrl;
    public String categoryName;
    public String api_token =RESTAURANT_API_TOKEN;
    @BindView(R.id.shape_update_category_alertdialoug_cimg_category_img)
    CircleImageView img;
    @BindView(R.id.shape_update_category_alertdialoug_edt_categoryname)
    EditText txtName;
    @BindView(R.id.shape_update_category_alertdialoug_btn_addbutton)
    Button button;
    Unbinder unbinder;
    private String api_Token;


    public RestaurantUpdateCategoryCustumDialog(@NonNull Context context) {

        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shape_update_and_new_category_alertdialoug);
        unbinder = ButterKnife.bind(this);
        // URL myURL = new URL(imgUrl);
        Picasso.with(getContext()).load(imgUrl).into(img);
        txtName.setText(categoryName);
    }


    @OnClick({R.id.shape_update_category_alertdialoug_cimg_category_img, R.id.shape_update_category_alertdialoug_btn_addbutton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shape_update_category_alertdialoug_cimg_category_img:

                selectImage(context, 3, new Action<ArrayList<AlbumFile>>() {
                    @Override
                    public void onAction(@NonNull ArrayList<AlbumFile> result) {
                        imgUrl = result.get(0).getPath();
                        Picasso.with(context).load(imgUrl).error(R.drawable.rror_black_24dp)
                                .placeholder(R.drawable.upload_24dp).fit().into(img);
                    }
                });

                break;
            case R.id.shape_update_category_alertdialoug_btn_addbutton:
               // RestaurntLoginUser restaurantData = SharedPreferencesManger.loadRestaurantData((Activity) context);
               // api_Token = restaurantData.getApiToken();
                String name = txtName.getText().toString().trim();
                if (name.isEmpty()) {
                    txtName.setFocusable(true);
                    HelperMethod.customToast((Activity) context, context.getResources().getString(R.string.enter_name), false);
                    return;
                }
                updateCategory(name, imgUrl, api_token, id);
                // Toast.makeText(getContext(), getContext().getResources().getString(R.string.enter_name),Toast.LENGTH_LONG).show();

                break;
        }
    }

    private void updateCategory(String name, String newUrl, String api_token, int id) {
        if (InternetState.isConnected(getContext())) {
            RetrofitSofra.getInstance().updateCategoryRestaurnt(name, newUrl, api_token, id).enqueue(new Callback<RestaurantUpdateCategory>() {
                @Override
                public void onResponse(Call<RestaurantUpdateCategory> call, Response<RestaurantUpdateCategory> response) {
                    try {
                        if(response.body().getStatus()==1){
                            HelperMethod.customToast((Activity) context, response.body().getMsg(), true);
                            dismiss();

                        }
                    } catch (Exception e) {
                        dismissProgressDialog();
                        customToast((Activity) context, response.body().getMsg(), false);
                    }
                }

                @Override
                public void onFailure(Call<RestaurantUpdateCategory> call, Throwable t) {
                    customToast((Activity)context,context.getResources().getString(R.string.error), true);
                }
            });
        } else {
            customToast((Activity) context, context.getResources().getString(R.string.offline), false);
        }
    }
}

