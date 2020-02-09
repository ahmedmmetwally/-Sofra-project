package com.example.mysofra.ui.fragment.restaurant;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.DateTxt;
import com.example.mysofra.data.model.restaurantNewOffer.RestauranNewOffer;
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
import static com.example.mysofra.helper.constant.RESTAURANT_API_TOKEN;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddNewOfferFragment extends BaseFragment {


    @BindView(R.id.fragment_add_new_offer_img_offerimage)
    ImageView imgOfferimage;
    @BindView(R.id.fragment_add_new_offer_edt_offer_name)
    EditText edtOfferName;
    @BindView(R.id.fragment_add_new_offer_edt_descriptin)
    EditText edtDescriptin;
    @BindView(R.id.fragment_add_new_offer_txt_date_to)
    TextView txtDateTo;
    @BindView(R.id.fragment_add_new_offer_rl_date_to)
    RelativeLayout llDateTo;
    @BindView(R.id.fragment_add_new_offer_txt_date_from)
    TextView txtDateFrom;
    @BindView(R.id.fragment_add_new_offer_rl_date_from)
    RelativeLayout llDateFrom;
    @BindView(R.id.fragment_add_new_offer_btn_update)
    Button btnUpdate;
    @BindView(R.id.fragment_add_new_offer_edt_price)
    EditText edtPrice;
    @BindView(R.id.fragment_add_new_offer_edt_price_in_offer)
    EditText edtPriceInOffer;
    private Unbinder unbind;
    private DateTxt dateFrom, dateTo;
    private String starting_at;
    private String ending_at;
    private String name;
    private String description;
    private String price;
    private String photo_url;
    private String api_token = RESTAURANT_API_TOKEN;
    private String offer_price;

    public AddNewOfferFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_new_offer, container, false);
        unbind = ButterKnife.bind(this, view);
        setUpActivity();
        return view;
    }

    @OnClick({R.id.fragment_add_new_offer_img_offerimage, R.id.fragment_add_new_offer_rl_date_to, R.id.fragment_add_new_offer_rl_date_from, R.id.fragment_add_new_offer_btn_update})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_add_new_offer_img_offerimage:
                HelperMethod.selectImage(getContext(), 3, new Action<ArrayList<AlbumFile>>() {
                    @Override
                    public void onAction(@NonNull ArrayList<AlbumFile> result) {
                        photo_url = result.get(0).getPath();
                        Glide.with(imgOfferimage.getContext())
                                .load(photo_url)
                                .error(R.drawable.rror_black_24dp)
                                .placeholder(R.drawable.upload_24dp)
                                .crossFade()
                                .into(imgOfferimage);
                    }
                });
                break;
            case R.id.fragment_add_new_offer_rl_date_to:
                HelperMethod.showCalender(getActivity(), getContext().getString(R.string.choose_date_end_offer), txtDateTo, dateTo);
                break;
            case R.id.fragment_add_new_offer_rl_date_from:
                HelperMethod.showCalender(getActivity(), getContext().getString(R.string.choose_date_end_offer), txtDateFrom, dateFrom);

                break;
            case R.id.fragment_add_new_offer_btn_update:
                ending_at = txtDateTo.getText().toString();
                starting_at = txtDateFrom.getText().toString();
                name = edtOfferName.getText().toString().trim();
                if (name == null) {
                    edtOfferName.setFocusable(true);
                    customToast(getActivity(), getContext().getString(R.string.enter_name), false);
                    return;
                }

                description = edtDescriptin.getText().toString().trim();
                if (name == null) {
                    edtDescriptin.setFocusable(true);
                    customToast(getActivity(), getContext().getString(R.string.enter_prief_description), false);
                    return;
                }
                price = edtPrice.getText().toString().trim();
                if (price == null) {
                    edtPrice.setFocusable(true);
                    customToast(getActivity(), getContext().getString(R.string.enter_price), false);
                    return;
                }
                offer_price = edtPriceInOffer.getText().toString().trim();
                if (price == null) {
                    edtPriceInOffer.setFocusable(true);
                    customToast(getActivity(), getContext().getString(R.string.enter_price_inoffer), false);
                    return;
                }
                newwOffer(ending_at, starting_at, name, photo_url, price, api_token, description, offer_price);

                HelperMethod.ReplaceFragment(getFragmentManager(), new MyOfferRestaurantFragment()
                        , R.id.activity_home_client_frame_fragment, null, null);
                break;
        }
    }

    private void newwOffer(String ending_att, String starting_att, String namee, String photo_urll,
                           String pricee, String api_tokenn, String descriptionn, String offer_pricee) {
        if (InternetState.isConnected(getContext())) {
            showProgressDialog(getActivity(), getContext().getString(R.string.waiit));
            RetrofitSofra.getInstance().newOfferRestaurant(convertToRequestBody(descriptionn), convertToRequestBody(pricee)
                    , convertToRequestBody(starting_att), convertToRequestBody(namee), convertFileToMultipart(photo_urll, "newOfferPhoto")
                    , convertToRequestBody(ending_att), convertToRequestBody(api_tokenn), convertToRequestBody(offer_pricee))
                    .enqueue(new Callback<RestauranNewOffer>() {
                        @Override
                        public void onResponse(Call<RestauranNewOffer> call, Response<RestauranNewOffer> response) {
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
                        public void onFailure(Call<RestauranNewOffer> call, Throwable t) {
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
