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
import com.example.mysofra.data.model.restaurantNewItem.RestaurantNewItem;
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

import static com.example.mysofra.helper.HelperMethod.convertFileToMultipart;
import static com.example.mysofra.helper.HelperMethod.convertToRequestBody;
import static com.example.mysofra.helper.HelperMethod.customToast;
import static com.example.mysofra.helper.HelperMethod.dismissProgressDialog;
import static com.example.mysofra.helper.HelperMethod.showProgressDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddItemFragment extends BaseFragment {


    @BindView(R.id.fragment_add_item_img_offerimage)
    ImageView imgOfferimage;
    @BindView(R.id.fragment_add_item_edt_offer_name)
    EditText edtOfferName;
    @BindView(R.id.fragment_add_item_edt_descriptin)
    EditText edtDescriptin;
    @BindView(R.id.fragment_add_item_edt_price)
    EditText edtPrice;
    @BindView(R.id.fragment_add_item_edt_price_in_offer)
    EditText edtPriceInOffer;
    @BindView(R.id.fragment_add_item_btn_add)
    Button fragmentAddItemBtnAdd;
    private Unbinder unbind;
    private String api_token;
    private int category_id;
    private String photo_url;
    private String description;
    private String name;
    private String price;
    private String offer_price;

    public AddItemFragment(String api_token, int category_id) {
        this.api_token = api_token;
        this.category_id = category_id;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_item, container, false);
        unbind = ButterKnife.bind(this, view);
        setUpActivity();
        getData();
        return view;
    }

    private void getData() {
        if (photo_url == null) {
            HelperMethod.customToast(getActivity(), getString(R.string.please_select_image), false);
            return;
        }
        description = edtDescriptin.getText().toString().trim();
        name = edtOfferName.getText().toString().trim();
        price = edtPrice.getText().toString().trim();
        offer_price = edtPriceInOffer.getText().toString().trim();
        if (description == null) {
            edtDescriptin.setFocusable(true);
            customToast(getActivity(), getContext().getString(R.string.enter_prief_description), false);
            return;
        }
        if (name == null) {
            edtOfferName.setFocusable(true);
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
    }

    @OnClick({R.id.fragment_add_item_img_offerimage, R.id.fragment_add_item_btn_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_add_item_img_offerimage:
                HelperMethod.selectImage(getContext(), 3, new Action<ArrayList<AlbumFile>>() {
                    @Override
                    public void onAction(@NonNull ArrayList<AlbumFile> result) {
                        photo_url = result.get(0).getPath();
                        Glide.with(getContext())
                                .load(photo_url).placeholder(R.drawable.search_black_24dp)
                                .error(R.drawable.rror_black_24dp)
                                .into(imgOfferimage);

                    }
                });
                break;
            case R.id.fragment_add_item_btn_add:
                if (InternetState.isConnected(getContext())) {
                    showProgressDialog(getActivity(), getContext().getString(R.string.waiit));
                    RetrofitSofra.getInstance().newItemRestaurant(convertToRequestBody(description), convertToRequestBody(price), convertToRequestBody(name), convertFileToMultipart(photo_url, "newItemPhoto")
                            , convertToRequestBody(api_token), convertToRequestBody(offer_price), convertToRequestBody(String.valueOf(category_id))).enqueue(new Callback<RestaurantNewItem>() {
                        @Override
                        public void onResponse(Call<RestaurantNewItem> call, Response<RestaurantNewItem> response) {
                            try {
                                dismissProgressDialog();
                                if (response.body().getStatus() == 1) {
                                    customToast(getActivity(), getActivity().getString(R.string.add_is_made), false);

                                }
                            } catch (Exception e) {
                                dismissProgressDialog();
                                customToast(getActivity(), response.body().getMsg(), false);
                            }
                        }

                        @Override
                        public void onFailure(Call<RestaurantNewItem> call, Throwable t) {
                            customToast(getActivity(), t.getMessage(), false);
                            dismissProgressDialog();
                        }
                    });
                } else {
                    dismissProgressDialog();
                    customToast(getActivity(), getActivity().getString(R.string.offline), false);
                }
                HelperMethod.ReplaceFragment(getFragmentManager(), new MyItemFragment()
                        , R.id.activity_home_client_frame_fragment, null, null);
                break;
        }
    }

}
