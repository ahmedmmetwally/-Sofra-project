package com.example.mysofra.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.restaurantConfiremOreder.RestaurantConfirmDeliveryOreder;
import com.example.mysofra.data.model.restaurantNewOrder.RestaurantNewOrderDatum;
import com.example.mysofra.data.model.restaurantRejectOreder.RestaurantRejectOreder;
import com.example.mysofra.helper.InternetState;
import com.example.mysofra.ui.activity.RestaurantHomeActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mysofra.helper.HelperMethod.customToast;

public class CurentOrderRestaurantAdapter extends RecyclerView.Adapter<CurentOrderRestaurantAdapter.CurrentViewHolder> {

    private String api_Token = "Jptu3JVmDXGpJEaQO9ZrjRg5RuAVCo45OC2AcOKqbVZPmu0ZJPN3T1sm0cWx";
    private Activity activity;
    RestaurantHomeActivity homeActivity = (RestaurantHomeActivity) activity;
    private Context context;
    private List<RestaurantNewOrderDatum> mlist = new ArrayList<>();
    private Integer id;


    public CurentOrderRestaurantAdapter(Activity activity, Context context, List<RestaurantNewOrderDatum> mlist) {

        this.context = context;
        this.mlist = mlist;

        this.activity = activity;


    }

    @NonNull
    @Override
    public CurrentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_restaurant_current_order_shape_recycler, parent, false);


        return new CurrentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrentViewHolder holder, int position) {
        RestaurantNewOrderDatum sup = mlist.get(position);
        String imgurl = sup.getClient().getPhotoUrl();
        Picasso.with(context).load(imgurl).placeholder(R.drawable.upload_24dp)
                .error(R.drawable.rror_black_24dp).fit().into(holder.imgCustomer);
        holder.txtCustomerName.setText(sup.getClient().getName());
        id = sup.getId();
        holder.txtOrderNumber.setText(String.valueOf(id));
        holder.txtOrderTotal.setText(sup.getTotal());
        holder.txtOrderAdress.setText(sup.getAddress());
        holder.rlConfirmOredr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (InternetState.isConnected(homeActivity)) {
                    RetrofitSofra.getInstance().confirmOrderDeliveryRestaurant(id, api_Token).enqueue(new Callback<RestaurantConfirmDeliveryOreder>() {
                        @Override
                        public void onResponse(Call<RestaurantConfirmDeliveryOreder> call, Response<RestaurantConfirmDeliveryOreder> response) {
                            try {


                                if (response.body().getStatus() == 1) {
                                    Toast.makeText(homeActivity,  context.getString(R.string.order_is_confirm), Toast.LENGTH_LONG).show();

                                    Log.e("my categries restauratn", "in try :acceptOrederRestaurant");


                                }
                            } catch (Exception e) {
                                customToast(homeActivity, response.body().getMsg(), false);


                            }
                        }

                        @Override
                        public void onFailure(Call<RestaurantConfirmDeliveryOreder> call, Throwable t) {

                        }
                    });
                } else {
                    customToast(homeActivity, context.getString(R.string.error), false);
                }
            }
        });
        holder.rlCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.edtRefuseResion.setVisibility(View.VISIBLE);
                String feruse_reason = holder.edtRefuseResion.getText().toString().trim();
                if (InternetState.isConnected(homeActivity)) {
                    RetrofitSofra.getInstance().rejectOrederRestaurant(api_Token, id, feruse_reason).enqueue(new Callback<RestaurantRejectOreder>() {
                        @Override
                        public void onResponse(Call<RestaurantRejectOreder> call, Response<RestaurantRejectOreder> response) {
                            try {
                                if (response.body().getStatus() == 1) {
                                    Toast.makeText(homeActivity, context.getString(R.string.cancel), Toast.LENGTH_LONG).show();

                                    Log.e("my categries restauratn", "in try :acceptOrederRestaurant");
                                }
                            } catch (Exception e) {
                        //        customToast(homeActivity, e.getMessage(), false);
                                Log.e("my categries restauratn", "in catch:cancelOrederRestaurant");
                            }
                        }

                        @Override
                        public void onFailure(Call<RestaurantRejectOreder> call, Throwable t) {
                            customToast(homeActivity, t.getMessage(), false);
                        }
                    });

                } else {
                    customToast(homeActivity, context.getString(R.string.error), false);

                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class CurrentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.show_restaurant_new_order_shape_recycler_img_customer)
        ImageView imgCustomer;
        @BindView(R.id.show_restaurant_new_order_shape_recycler_txt_customer_name)
        TextView txtCustomerName;
        @BindView(R.id.show_restaurant_new_order_shape_recycler_txt_order_number)
        TextView txtOrderNumber;
        @BindView(R.id.show_restaurant_new_order_shape_recycler_order_total)
        TextView txtOrderTotal;
        @BindView(R.id.show_restaurant_new_order_shape_recycler_order_adress)
        TextView txtOrderAdress;
        @BindView(R.id.show_restaurant_new_order_shape_recycler_rl_confirm_oredr)
        RelativeLayout rlConfirmOredr;
        @BindView(R.id.show_restaurant_new_order_shape_recycler_rl_cancel)
        RelativeLayout rlCancel;
        @BindView(R.id.show_restaurant_new_order_shape_recycler_edt_refuse_resion)
        EditText edtRefuseResion;

        private View view;

        public CurrentViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }
    }

}
