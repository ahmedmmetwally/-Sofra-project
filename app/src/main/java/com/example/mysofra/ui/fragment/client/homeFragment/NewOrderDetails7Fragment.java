package com.example.mysofra.ui.fragment.client.homeFragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.local.SharedPreferencesManger;
import com.example.mysofra.data.model.Note;
import com.example.mysofra.data.model.clientNewOrder.ClientNewOrder;
import com.example.mysofra.data.model.clientNewOrder.ClientNewOrderData;
import com.example.mysofra.data.model.clientlogin.ClientloginUser;
import com.example.mysofra.data.model.restaurntDetails.RestaurntDetails;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.helper.InternetState;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mysofra.data.local.SharedPreferencesManger.TOTAL_PRICEE;
import static com.example.mysofra.helper.HelperMethod.customToast;
import static com.example.mysofra.helper.HelperMethod.dismissProgressDialog;
import static com.example.mysofra.helper.HelperMethod.showProgressDialog;
import static com.example.mysofra.helper.constant.TOTAL_PRICE_cons;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewOrderDetails7Fragment extends Fragment {
    private ClientloginUser userData;
    public List<Note> nList;

    //  private RestaurntDetailsData restaurntDetailsData;

    @BindView(R.id.fragment_new_order_details7_edt_add_notification)
    EditText edtAddNotification;
    @BindView(R.id.fragment_new_order_details7_edt_delivery_adress)
    TextView edtDeliveryAdress;
    @BindView(R.id.fragment_new_order_details7_rb_payin_on_delivery)
    RadioButton rbPayinOnDelivery;
    @BindView(R.id.fragment_new_order_details7_rb_online_pay)
    RadioButton rbOnlinePay;
    @BindView(R.id.fragment_new_order_details7_txt_total)
    TextView txtTotal;
    @BindView(R.id.fragment_new_order_details7_txt_charg_delivery)
    TextView txtChargDelivery;
    @BindView(R.id.fragment_new_order_details7_txt_total_amount)
    TextView txtTotalAmount;
    @BindView(R.id.fragment_new_order_details7rl_contain_button)
    RelativeLayout rlContainButton;
    @BindView(R.id.fragment_new_order_details7_rg_radio_group)
    RadioGroup rgRadioGroup;
    private Unbinder unbind;
    List<Integer> item_name = new ArrayList<>();
    List<String> notee = new ArrayList<>();
    List<Integer> quantityyy = new ArrayList<Integer>();
    private String notificatio;
    private String adress;
    private int paymentMehtod_id = 0;
    private int restaurant_id;
    private String deliveryCost;
    private Integer order_id;
    private String massage;
    private ClientNewOrderData orderData;

    public NewOrderDetails7Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_order_details7, container, false);
        unbind = ButterKnife.bind(this, view);
        TOTAL_PRICE_cons = SharedPreferencesManger.LoadFloatData(getActivity(), TOTAL_PRICEE);
        txtTotal.setText(TOTAL_PRICE_cons + "");

        userData = SharedPreferencesManger.loadUserData(getActivity());

        for (int i = 0; i < nList.size(); i++) {
            item_name.add(nList.get(i).getId());
            notee.add(nList.get(i).getSpecialOrder());
            quantityyy.add(nList.get(i).getQuantity());
            restaurant_id = nList.get(i).getRestaurant_id();

        }
        getDetails(restaurant_id);


        return view;
    }

    private void getDetails(int restaurantId) {

        if (InternetState.isConnected(getContext())) {

            // showProgressDialog(getActivity(), getString(R.string.registerr));
            RetrofitSofra.getInstance().getRestaurntDetails(restaurantId).enqueue(new Callback<RestaurntDetails>() {
                @Override
                public void onResponse(Call<RestaurntDetails> call, Response<RestaurntDetails> response) {
                    try {
                        if (response.body().getStatus() == 1) {
                            dismissProgressDialog();
                            deliveryCost = response.body().getData().getDeliveryCost();
                            txtChargDelivery.setText(deliveryCost);
                            txtTotalAmount.setText(deliveryCost + TOTAL_PRICE_cons);

                        }
                    } catch (Exception e) {
                        dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), true);
                    }

                }

                @Override
                public void onFailure(Call<RestaurntDetails> call, Throwable t) {
                    dismissProgressDialog();
                    customToast(getActivity(), getResources().getString(R.string.error), true);
                }
            });


        } else customToast(getActivity(), getResources().getString(R.string.offline), false);
    }


    @OnClick({R.id.fragment_new_order_details7rl_contain_button,
            R.id.fragment_new_order_details7_rb_payin_on_delivery, R.id.fragment_new_order_details7_rb_online_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_new_order_details7rl_contain_button:
                confirmNewOrder();
//        Log.e("notificatioooooooo", order_id + " send ");
//        Log.e("notificatioooooooo", massage + " send ");
            case R.id.fragment_new_order_details7_rb_payin_on_delivery:
                paymentMehtod_id = 1;
                Log.e("paymentMehtod_id", paymentMehtod_id + " payment_id ");
                break;
            case R.id.fragment_new_order_details7_rb_online_pay:
                paymentMehtod_id = 2;
                Log.e("paymentMehtod_id", paymentMehtod_id + " payment_id ");
                break;
        }
    }

    private void confirmNewOrder() {

        notificatio = edtAddNotification.getText().toString().trim();
        if (notificatio.isEmpty()) {
            edtAddNotification.setFocusable(true);
            Toast.makeText(getActivity(), getString(R.string.please_enter_adress), Toast.LENGTH_LONG).show();
            return;
        }
        adress = edtDeliveryAdress.getText().toString().trim();
        if (adress.isEmpty()) {
            edtDeliveryAdress.setFocusable(true);
            Toast.makeText(getActivity(), getString(R.string.please_enter_adress), Toast.LENGTH_LONG).show();
            return;
        }

//        rgRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//
//                switch (checkedId) {
//                    case R.id.fragment_new_order_details7_rb_payin_on_delivery:
//                        paymentMehtod_id = 1;
//                        break;
//                    case R.id.fragment_new_order_details7_rb_online_pay:
//                        paymentMehtod_id = 2;
//                        break;
//
//                }
//
//            }
//
//        });
        if (paymentMehtod_id == 0) {

        }

        Log.i("ddd", "confirmNewOrder: " + paymentMehtod_id);

        Log.e("previous order", "notificatior_in try");
        if (InternetState.isConnected(getContext())) {
            showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().newOrderClient(restaurant_id, notificatio, adress, 1, userData.getPhone()
                    , userData.getName(), userData.getApiToken(), item_name, quantityyy, notee).enqueue(new Callback<ClientNewOrder>() {
                @Override
                public void onResponse(Call<ClientNewOrder> call, Response<ClientNewOrder> response) {
                    try {
                        dismissProgressDialog();
                        if (response.body().getStatus() == 1) {
//                            orderData=(response.body().getData());
//                            order_id=orderData.getId();
//                            massage = response.body().getMsg();
//                            Toast.makeText(getActivity(), response.body().getData().getId(), Toast.LENGTH_LONG).show();
                            //    Log.e("order_id_in_try", ""+massage +"" + order_id);
                            Log.e("notificationsss", " " + response.body().getMsg());

                            customToast(getActivity(), getResources().getString(R.string.offline), false);

                            FinalAcceptCancelCallOrderFragment finalAcceptCancelCallOrderFragment = new FinalAcceptCancelCallOrderFragment();
                            //  finalAcceptCancelCallOrderFragment.order = response.body().getData();
                            finalAcceptCancelCallOrderFragment.order_id = response.body().getData().getId();
                            HelperMethod.ReplaceFragment(getFragmentManager(), finalAcceptCancelCallOrderFragment
                                    , R.id.activity_home_client_frame_fragment, null, null);

                        }
                    } catch (Exception e) {
                        dismissProgressDialog();
                        Log.e("order_id_in_catch", "in catch");
                        customToast(getActivity(), response.body().getMsg(), false);
                    }
                }

                @Override
                public void onFailure(Call<ClientNewOrder> call, Throwable t) {
                    Log.e("notificatio", t + "in failure");
                    dismissProgressDialog();
                    customToast(getActivity(), getResources().getString(R.string.error), true);
                }
            });
        }

    }


}