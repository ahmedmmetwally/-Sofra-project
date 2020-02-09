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
import com.example.mysofra.data.model.restaurantUpdateOffer.RestauranUpdateOffer;
import com.example.mysofra.data.model.restaurantUpdateOffer.RestauranUpdateOfferData;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.helper.InternetState;
import com.example.mysofra.ui.fragment.BaseFragment;
import com.example.mysofra.ui.fragment.restaurant.restaurantCycle.MoreRestaurantFragment;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.AlbumFile;

import java.util.ArrayList;
import java.util.List;

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
public class EditOfferFragment extends BaseFragment {
    @BindView(R.id.fragment_edit_offer_img_offerimage)
    ImageView imgOfferimage;
    @BindView(R.id.fragment_edit_offer_edt_offer_name)
    EditText edtOfferName;
    @BindView(R.id.fragment_edit_offer_edt_descriptin)
    EditText edtDescriptin;
    @BindView(R.id.fragment_edit_offer_txt_date_to)
    TextView txtDateTo;
    @BindView(R.id.fragment_edit_offer_rl_date_to)
    RelativeLayout rinlDateTo;
    @BindView(R.id.fragment_edit_offer_txt_date_from)
    TextView txtDateFrom;
    @BindView(R.id.fragment_edit_offer_rl_date_from)
    RelativeLayout rinlDateFrom;
    @BindView(R.id.fragment_edit_offer_btn_update)
    Button btnUpdate;
    @BindView(R.id.fragment_add_new_offer_edt_price)
    EditText edtPrice;
    private Unbinder unbind;
    private DateTxt dateTo, dateFrom;
    public String starting_at;
    public String ending_at;
    public String name;
    public String description;
    public String price;
    public String photo_url;
    public String api_token;
    public int id;


    private List<RestauranUpdateOfferData> uList;

    public EditOfferFragment() {
        ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_offer, container, false);
        unbind = ButterKnife.bind(this, view);
        setUpActivity();

        Glide.with(getContext())
                .load(photo_url).placeholder(R.drawable.search_black_24dp)
                .error(R.drawable.rror_black_24dp)
                .into(imgOfferimage);
        dateTo = new DateTxt("1", "1", "1990", "01-01-1990");
        dateFrom = new DateTxt("1", "1", "1990", "01-01-1990");
        edtDescriptin.setText(description);
        txtDateFrom.setText(starting_at);
        txtDateTo.setText(ending_at);
        edtOfferName.setText(name);
        edtPrice.setText(price);
        return view;
    }


    @OnClick({R.id.fragment_edit_offer_img_offerimage, R.id.fragment_edit_offer_rl_date_to, R.id.fragment_edit_offer_rl_date_from, R.id.fragment_edit_offer_btn_update})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_edit_offer_img_offerimage:
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
            case R.id.fragment_edit_offer_rl_date_to:
                HelperMethod.showCalender(getContext(), getContext().getString(R.string.choose_date_end_offer), txtDateFrom, dateFrom);
                break;
            case R.id.fragment_edit_offer_rl_date_from:
                HelperMethod.showCalender(getContext(), getContext().getString(R.string.choose_date_start_offer), txtDateTo, dateTo);

                break;
            case R.id.fragment_edit_offer_btn_update:
                ending_at = txtDateTo.getText().toString();
                starting_at = txtDateFrom.getText().toString();
                name = edtOfferName.getText().toString().trim();
                if (name == null) {
                    edtOfferName.setFocusable(true);
                    customToast(getActivity(), getContext().getString(R.string.enter_name), false);
                    return;
                }

                description = edtDescriptin.getText().toString().trim();
                if (description == null) {
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
                upDate(ending_at, starting_at, name, price, photo_url, api_token, id, description);

                HelperMethod.ReplaceFragment(getFragmentManager(), new MyOfferRestaurantFragment()
                        , R.id.activity_home_client_frame_fragment, null, null);
                break;
        }
    }

    private void upDate(String ending_att, String starting_att, String namee,
                        String pricee, String photo_urll, String api_tokenn, int idd, String descriptionn) {
        if (InternetState.isConnected(getContext())) {
            showProgressDialog(getActivity(), getContext().getString(R.string.waiit));
            RetrofitSofra.getInstance().updateOfferRestaurant(descriptionn, pricee, starting_att,
                    namee, photo_urll, ending_att, idd, api_tokenn).enqueue(new Callback<RestauranUpdateOffer>() {
                @Override
                public void onResponse(Call<RestauranUpdateOffer> call, Response<RestauranUpdateOffer> response) {
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
                public void onFailure(Call<RestauranUpdateOffer> call, Throwable t) {
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
