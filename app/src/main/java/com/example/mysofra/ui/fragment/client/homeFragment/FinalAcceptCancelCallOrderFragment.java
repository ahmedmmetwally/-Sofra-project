package com.example.mysofra.ui.fragment.client.homeFragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mysofra.R;
import com.example.mysofra.adapter.FinalAcceptCancelCallOrderAdapter;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.Note;
import com.example.mysofra.data.model.clientConfirmOreder.ClientConfirmOreder;
import com.example.mysofra.data.model.clientDeclineOreder.ClientDeclineOreder;
import com.example.mysofra.data.model.clientModel.clientMyOrder.ClientMyOrder;
import com.example.mysofra.data.model.clientModel.clientMyOrder.ClientMyOrderDatum;
import com.example.mysofra.data.model.clientModel.clientMyOrder.ClientMyOrderItem;
import com.example.mysofra.data.model.clientNewOrder.ClientNewOrderData;
import com.example.mysofra.data.model.clientOrderById.ClientOrderById;
import com.example.mysofra.data.model.clientOrderById.ClientOrderByIdData;
import com.example.mysofra.data.model.clientOrderById.ClientOrderByIdItem;
import com.example.mysofra.data.model.restaurntDetails.RestaurntDetails;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.helper.InternetState;

import java.util.ArrayList;
import java.util.List;

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
import static com.example.mysofra.helper.HelperMethod.onPermission;
import static com.example.mysofra.helper.HelperMethod.showProgressDialog;
import static com.example.mysofra.helper.constant.CLIENT_API_TOKEN;
import static com.example.mysofra.helper.constant.TOTAL_PRICE_cons;
import static com.example.mysofra.helper.constant.USER_TYPE;

/**
 * A simple {@link Fragment} subclass.
 */
public class FinalAcceptCancelCallOrderFragment extends Fragment {


    public ClientNewOrderData order;
    @BindView(R.id.fragment_final_accept_cancel_call_order_cimg_restaurant_image)
    CircleImageView imgRestaurantImage;
    @BindView(R.id.fragment_final_accept_cancel_call_order_txt_restaurant_name)
    EditText txtRestaurantName;
    @BindView(R.id.fragment_final_accept_cancel_call_order_txt_actual_adress)
    TextView txtActualAdress;
    @BindView(R.id.fragment_final_accept_cancel_call_order_txt_price)
    TextView txtPrice;
    @BindView(R.id.fragment_final_accept_cancel_call_order_txt_charg_delivery)
    TextView txtChargDelivery;
    @BindView(R.id.fragment_final_accept_cancel_call_order_txt_total_amount)
    TextView txtTotalAmount;
    @BindView(R.id.fragment_final_accept_cancel_call_order_txt_total_paying)
    TextView txtTotalPaying;
    @BindView(R.id.fragment_final_accept_cancel_call_order_rl_call)
    RelativeLayout rlCall;
    @BindView(R.id.fragment_final_accept_cancel_call_order_accept)
    RelativeLayout rlccept;
    @BindView(R.id.fragment_final_accept_cancel_call_order_rl_cancel)
    RelativeLayout rlCancel;
    @BindView(R.id.fragment_final_accept_cancel_call_order_rec_recycler_view)
    RecyclerView recRecyclerView;
    @BindView(R.id.fragment_final_accept_cancel_call_order_txt_date)
    EditText txtDate;
    private Unbinder unbind;

    private FinalAcceptCancelCallOrderAdapter mAdapter;

    public int order_id;
    private ClientOrderByIdData clist = new ClientOrderByIdData();
    List<ClientOrderByIdItem> list = new ArrayList<>();
    private String user_apiToken = CLIENT_API_TOKEN;
    private static String FINALACCEPT = "FINAL_ACCEPT";

    public FinalAcceptCancelCallOrderFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_final_accept_cancel_call_order, container, false);
        unbind = ButterKnife.bind(this, view);
        initRecycler();
        getCurrentOrder(user_apiToken, 209);

        return view;
    }


    private void initRecycler() {
        mAdapter = new FinalAcceptCancelCallOrderAdapter(getContext(), list);
        recRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recRecyclerView.setAdapter(mAdapter);
    }


    private void getCurrentOrder(String apiToken, int order_id) {
        Log.e(FINALACCEPT, "in_get_new_oreder");
        if (InternetState.isConnected(getContext())) {
            // showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().getClientOrderById(apiToken, order_id).enqueue(new Callback<ClientOrderById>() {
                @Override
                public void onResponse(Call<ClientOrderById> call, Response<ClientOrderById> response) {
                    try {
                        dismissProgressDialog();
                        if (response.body().getStatus() == 1) {

                            clist = (response.body().getData());
                            list.addAll(response.body().getData().getItems());
                            mAdapter.notifyDataSetChanged();
                            //  Log.e(FINALACCEPT, clist.size() + "");
                            setData();
                        }
                    } catch (Exception e) {
                        dismissProgressDialog();
                        // Log.e(FINALACCEPT, "in catch");
                        customToast(getActivity(), response.body().getMsg(), false);
                    }
                }

                @Override
                public void onFailure(Call<ClientOrderById> call, Throwable t) {
                    Log.e(FINALACCEPT, "in failure");
                    dismissProgressDialog();
                    customToast(getActivity(), getResources().getString(R.string.error), true);
                }
            });
        } else {
            dismissProgressDialog();
            Log.e(FINALACCEPT, "else internet");
            customToast(getActivity(), getResources().getString(R.string.offline), false);
        }
    }

    private void setData() {
        if (!clist.equals(null)) {

            txtPrice.setText(TOTAL_PRICE_cons + "");
            txtActualAdress.setText(clist.getAddress());
            String deliveryCost = clist.getDeliveryCost();
            txtChargDelivery.setText(deliveryCost);

            if ((clist.getPaymentMethodId()).equals((1)))
                txtTotalPaying.setText(R.string.cash_on_delivery);
            else txtTotalPaying.setText(R.string.online_payment);

            txtTotalAmount.setText(Float.valueOf(deliveryCost) + TOTAL_PRICE_cons + "");

            String photo_url = clist.getRestaurant().getPhotoUrl();
            Glide.with(getContext()).load(photo_url).error(R.drawable.rror_black_24dp)
                    .placeholder(R.drawable.upload_24dp).into(imgRestaurantImage);
            txtRestaurantName.setText(clist.getRestaurant().getName());

        }
    }

    @OnClick({R.id.fragment_final_accept_cancel_call_order_rl_call, R.id.fragment_final_accept_cancel_call_order_accept
            , R.id.fragment_final_accept_cancel_call_order_rl_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_final_accept_cancel_call_order_rl_call:


                onPermission((getActivity()));


                //Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + clist.get(2).getRestaurant().getPhone()));
                // getContext().startActivity(callIntent);
                getActivity().startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", clist.getRestaurant().getPhone(), null)));

                break;
            case R.id.fragment_final_accept_cancel_call_order_accept:

                RetrofitSofra.getInstance().confirmOrderClient(order_id, user_apiToken)
                        .enqueue(new Callback<ClientConfirmOreder>() {
                            @Override
                            public void onResponse(Call<ClientConfirmOreder> call, Response<ClientConfirmOreder> response) {
                                try {
                                    if (response.body().getStatus() == 1) {
                                        Toast.makeText(getContext(), response.body().getMsg(), Toast.LENGTH_LONG).show();
                                    }

                                } catch (Exception e) {
                                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<ClientConfirmOreder> call, Throwable t) {
                                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
                break;
            case R.id.fragment_final_accept_cancel_call_order_rl_cancel:

                RetrofitSofra.getInstance().declineOrderClient(order_id, user_apiToken)
                        .enqueue(new Callback<ClientDeclineOreder>() {
                            @Override
                            public void onResponse(Call<ClientDeclineOreder> call, Response<ClientDeclineOreder> response) {
                                try {
                                    if (response.body().getStatus() == 1) {
                                        Toast.makeText(getContext(), response.body().getMsg(), Toast.LENGTH_LONG).show();
                                    }

                                } catch (Exception e) {
                                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<ClientDeclineOreder> call, Throwable t) {
                                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });

                break;
        }
    }
}
//    private void getDetails(int restaurantId) {
//
//        if (InternetState.isConnected(getContext())) {
//
//            // showProgressDialog(getActivity(), getString(R.string.registerr));
//            RetrofitSofra.getInstance().getRestaurntDetails(restaurantId).enqueue(new Callback<RestaurntDetails>() {
//                @Override
//                public void onResponse(Call<RestaurntDetails> call, Response<RestaurntDetails> response) {
//                    try {
//                        if (response.body().getStatus() == 2) {
//                            dismissProgressDialog();
//                            photo_url = response.body().getData().getPhotoUrl();
//                            restaurant_name = response.body().getData().getName();
//                            restaurant_phone = response.body().getData().getPhone();
//                        }
//                    } catch (Exception e) {
//                        dismissProgressDialog();
//                        customToast(getActivity(), response.body().getMsg(), true);
//                    }
//
//                }
//
//                @Override
//                public void onFailure(Call<RestaurntDetails> call, Throwable t) {
//                    dismissProgressDialog();
//                    customToast(getActivity(), getResources().getString(R.string.error), true);
//                }
//            });
//
//
//        } else customToast(getActivity(), getResources().getString(R.string.offline), false);
//    }