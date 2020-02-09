package com.example.mysofra.ui.fragment.restaurant;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.restaurantUpdateItem.RestaurantUdateItem;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.helper.InternetState;
import com.example.mysofra.ui.fragment.BaseFragment;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.AlbumFile;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mysofra.helper.HelperMethod.customToast;
import static com.example.mysofra.helper.HelperMethod.dismissProgressDialog;
import static com.example.mysofra.helper.HelperMethod.showProgressDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateItemFragment extends BaseFragment {
    @BindView(R.id.fragment_update_item_img_item_image)
    ImageView imgItemimage;
    @BindView(R.id.fragment_update_item_edt_item_name)
    EditText edtItemName;
    @BindView(R.id.fragment_update_item_edt_descriptin)
    EditText edtDescriptin;
    @BindView(R.id.fragment_update_item_edt_price)
    EditText edtPrice;
    @BindView(R.id.fragment_update_item_edt_price_in_offer)
    EditText edtPriceInOffer;
    @BindView(R.id.fragment_update_item_btn_update)
    Button btnUpdate;
    private String description;
    private String price;
    private String name;
    private String photo;
    private int item_id;
    private String api_token;
    private String offer_price;
    private int category_id;

    private Unbinder unbind;

    public UpdateItemFragment(String description,
                              String price, String name, String photo, int item_id,
                              String api_token, String offer_price, int category_id) {
        this.description = description;
        this.price = price;
        this.name = name;
        this.photo = photo;
        this.item_id = item_id;
        this.api_token = api_token;
        this.offer_price = offer_price;
        this.category_id = category_id;
    }

    public UpdateItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_item, container, false);
        unbind = ButterKnife.bind(this, view);
        setUpActivity();
        fillView();


        return view;
    }

    private void fillView() {
        Glide.with(getContext())
                .load(photo).placeholder(R.drawable.search_black_24dp)
                .error(R.drawable.rror_black_24dp)
                .into(imgItemimage);
        edtDescriptin.setText(description);
        edtItemName.setText(name);
        edtPrice.setText(price);
        edtPriceInOffer.setText(offer_price);
    }

    @OnClick({R.id.fragment_update_item_img_item_image, R.id.fragment_update_item_btn_update})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_update_item_img_item_image:
                HelperMethod.selectImage(getContext(), 3, new Action<ArrayList<AlbumFile>>() {
                    @Override
                    public void onAction(@NonNull ArrayList<AlbumFile> result) {
                        photo = result.get(0).getPath();
                        Glide.with(imgItemimage.getContext())
                                .load(photo)
                                .error(R.drawable.rror_black_24dp)
                                .placeholder(R.drawable.upload_24dp)
                                .crossFade()
                                .into(imgItemimage);
                    }
                });
                break;
            case R.id.fragment_update_item_btn_update:
                description = edtDescriptin.getText().toString().trim();
                name = edtItemName.getText().toString().trim();
                price = edtPrice.getText().toString().trim();
                offer_price = edtPriceInOffer.getText().toString().trim();
                if (description == null) {
                    edtDescriptin.setFocusable(true);
                    customToast(getActivity(), getContext().getString(R.string.enter_prief_description), false);
                    return;
                }
                if (name == null) {
                    edtItemName.setFocusable(true);
                    customToast(getActivity(), getContext().getString(R.string.enter_name), false);
                    return;
                }
                if (price == null) {
                    edtPrice.setFocusable(true);
                    customToast(getActivity(), getContext().getString(R.string.enter_price), false);
                    return;
                }
                if (offer_price == null) {
                    edtPriceInOffer.setFocusable(true);
                    customToast(getActivity(), getContext().getString(R.string.enter_price_inoffer), false);
                    return;
                }
                getUpdate();
                HelperMethod.ReplaceFragment(getFragmentManager(), new MyItemFragment()
                        , R.id.activity_home_client_frame_fragment, null, null);
                break;
        }
    }

    private void getUpdate() {
        if (InternetState.isConnected(getContext())) {
            showProgressDialog(getActivity(), getContext().getString(R.string.waiit));
            RetrofitSofra.getInstance().updateItemRestaurant(description, price, name, photo, item_id, api_token, offer_price, category_id).enqueue(new Callback<RestaurantUdateItem>() {
                @Override
                public void onResponse(Call<RestaurantUdateItem> call, Response<RestaurantUdateItem> response) {
                    try {
                        dismissProgressDialog();
                        if (response.body().getStatus() == 1) {
                            customToast(getActivity(), getActivity().getString(R.string.update_is_done), false);

                        }
                    } catch (Exception e) {
                        dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), false);
                    }
                }

                @Override
                public void onFailure(Call<RestaurantUdateItem> call, Throwable t) {
                    customToast(getActivity(), t.getMessage(), false);
                    dismissProgressDialog();
                }
            });
        } else {
            dismissProgressDialog();
            customToast(getActivity(), getActivity().getString(R.string.offline), false);
        }
    }


}
