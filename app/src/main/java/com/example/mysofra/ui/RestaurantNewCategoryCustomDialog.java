package com.example.mysofra.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.restaurantNewCategory.RestauranNewCategory;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.helper.InternetState;
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

import static com.example.mysofra.helper.HelperMethod.convertFileToMultipart;
import static com.example.mysofra.helper.HelperMethod.convertToRequestBody;
import static com.example.mysofra.helper.HelperMethod.customToast;
import static com.example.mysofra.helper.HelperMethod.dismissProgressDialog;
import static com.example.mysofra.helper.HelperMethod.selectImage;
import static com.example.mysofra.helper.constant.RESTAURANT_API_TOKEN;

public class RestaurantNewCategoryCustomDialog extends Dialog {
    @BindView(R.id.shape_update_category_alertdialoug_cimg_category_img)
    CircleImageView img;
    @BindView(R.id.shape_update_category_alertdialoug_edt_categoryname)
    EditText edtname;
    @BindView(R.id.shape_update_category_alertdialoug_btn_addbutton)
    Button addbutton;
    private Context context;
    public String imgUrl;
    public String api_token = RESTAURANT_API_TOKEN;
    private Unbinder unbinder;
    private String name;


    public RestaurantNewCategoryCustomDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shape_update_and_new_category_alertdialoug);
        unbinder = ButterKnife.bind(this);

    }


    @OnClick({R.id.shape_update_category_alertdialoug_cimg_category_img,
            R.id.shape_update_category_alertdialoug_btn_addbutton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shape_update_category_alertdialoug_cimg_category_img:
                HelperMethod.selectImage(getContext(), 3, new Action<ArrayList<AlbumFile>>() {
                    @Override
                    public void onAction(@NonNull ArrayList<AlbumFile> result) {
                        imgUrl = result.get(0).getPath();
                        Glide.with(img.getContext())
                                .load(imgUrl)
                                .error(R.drawable.rror_black_24dp)
                                .placeholder(R.drawable.upload_24dp)
                                .crossFade()
                                .into(img);
                    }
                });

                break;

            case R.id.shape_update_category_alertdialoug_btn_addbutton:
                name = edtname.getText().toString().trim();
                if (name.isEmpty()) {
                    edtname.setFocusable(true);
                    HelperMethod.customToast((Activity) context, context.getResources().getString(R.string.enter_name), false);
                    return;
                }
//                RestaurntLoginUser restaurantData = SharedPreferencesManger.loadRestaurantData((Activity) context);
//                 api_Token = restaurantData.getApiToken();
                if (InternetState.isConnected(context)) {
                    RetrofitSofra.getInstance().newCategoryRestaurnt(convertToRequestBody(name), convertFileToMultipart(imgUrl, "photo"), convertToRequestBody(api_token)).enqueue(new Callback<RestauranNewCategory>() {
                        @Override
                        public void onResponse(Call<RestauranNewCategory> call, Response<RestauranNewCategory> response) {
                            try {
                                if (response.body().getStatus() == 1) {
                                    HelperMethod.customToast((Activity) context, response.body().getMsg(), true);
                                    dismiss();
                                }
                            } catch (Exception e) {
                                dismissProgressDialog();
                                customToast((Activity) context, response.body().getMsg(), false);

                            }
                        }

                        @Override
                        public void onFailure(Call<RestauranNewCategory> call, Throwable t) {
                            Log.e("ggggg", "in failure  in add new Category" + t.toString());
                            customToast((Activity) context, context.getResources().getString(R.string.error), true);
                        }
                    });

                } else {
                    customToast((Activity) context, context.getResources().getString(R.string.offline), false);
                }

                break;
        }
    }
}
