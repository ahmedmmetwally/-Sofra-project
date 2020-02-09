package com.example.mysofra.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.example.mysofra.data.model.restaurantAcceptOreder.RestaurantAcceptOreder;
import com.example.mysofra.data.model.restaurantNewOrder.RestaurantNewOrderDatum;
import com.example.mysofra.data.model.restaurantRejectOreder.RestaurantRejectOreder;
import com.example.mysofra.helper.HelperMethod;
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
import static com.example.mysofra.helper.HelperMethod.onPermission;

public class NewOrderRestaurantAdapter extends RecyclerView.Adapter<NewOrderRestaurantAdapter.NeewViewHolder> {
    Intent callIntent = new Intent(Intent.ACTION_CALL);
    private static final int REQUEST_PHONE_CALL = 1;


    private String num;

    private Activity activity;
    String api_token = "Jptu3JVmDXGpJEaQO9ZrjRg5RuAVCo45OC2AcOKqbVZPmu0ZJPN3T1sm0cWx";

    RestaurantHomeActivity homeActivity = (RestaurantHomeActivity) activity;
    private Context context;
    private List<RestaurantNewOrderDatum> mlist = new ArrayList<>();

    public NewOrderRestaurantAdapter(Activity activity, Context context,
                                     List<RestaurantNewOrderDatum> mlist) {
        this.activity = activity;
        this.context = context;
        this.mlist = mlist;

    }

    @NonNull
    @Override
    public NeewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_restaurant_new_order_shape_recycler, parent, false);

        return new NeewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NeewViewHolder holder, int position) {
        RestaurantNewOrderDatum sup = mlist.get(position);
        String imgurl = sup.getClient().getPhotoUrl();

        Picasso.with(context).load(imgurl).placeholder(R.drawable.upload_24dp)
                .error(R.drawable.rror_black_24dp).fit().into(holder.imgCustomer);
        holder.txtCustomerName.setText(sup.getClient().getName());
        int id = sup.getId();
        holder.txtOrderNumber.setText(String.valueOf(id));
        holder.txtOrderTotal.setText(sup.getTotal());
        holder.txtOrderAdress.setText(sup.getAddress());
        num = sup.getClient().getPhone();
        holder.txtCall.setText(num);
        holder.rlCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (HelperMethod.checkWriteExternalPermission(homeActivity)) {
                    onPermission((homeActivity));
                    return;
                }


                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(num));
                context.startActivity(callIntent);
            }

        });
        holder.rlAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (InternetState.isConnected(homeActivity)) {
                    RetrofitSofra.getInstance().acceptOrederRestaurant(api_token, id).enqueue(new Callback<RestaurantAcceptOreder>() {
                        @Override
                        public void onResponse(Call<RestaurantAcceptOreder> call, Response<RestaurantAcceptOreder> response) {
                            try {


                                if (response.body().getStatus() == 1) {
                                    Toast.makeText(homeActivity, context.getString(R.string.order_is_accept), Toast.LENGTH_LONG).show();

                                    Log.e("my categries restauratn", "in try :acceptOrederRestaurant");


                                }
                            } catch (Exception e) {
                                customToast(homeActivity, response.body().getMsg(), false);


                            }
                        }

                        @Override
                        public void onFailure(Call<RestaurantAcceptOreder> call, Throwable t) {
                            customToast((Activity) context, t.getMessage(), false);

                        }
                    });

                } else {
                    customToast(homeActivity, context.getResources().getString(R.string.error), false);
                }
            }
        });

        holder.rlCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.edtcancelResion.setVisibility(View.VISIBLE);
                String feruse_reason = holder.edtcancelResion.getText().toString().trim();
                if (feruse_reason.isEmpty()) {
                    return;
                }//shoud enter resion
                if (InternetState.isConnected(homeActivity)) {
                    RetrofitSofra.getInstance().rejectOrederRestaurant(api_token, id, feruse_reason).enqueue(new Callback<RestaurantRejectOreder>() {
                        @Override
                        public void onResponse(Call<RestaurantRejectOreder> call, Response<RestaurantRejectOreder> response) {
                            try {
                                if (response.body().getStatus() == 1) {
                                    Toast.makeText(homeActivity, context.getString(R.string.cancel_order), Toast.LENGTH_LONG).show();

                                    Log.e("my categries restauratn", "in try :acceptOrederRestaurant");
                                }
                            } catch (Exception e) {
                                customToast(homeActivity, response.body().getMsg(), false);
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
        holder.rlCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                           if (checkWriteExternalPermission((Activity) context)) {
//                    onPermission((Activity) context);
//                    Log.e("number is:" ,"checkPermission");
//                    return;
//                }
                onPermission((Activity)context);
                String number = "tel:" + sup.getClient().getPhone();
                Log.e("number is:" ,number);


                context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel"
                        ,  sup.getClient().getPhone(), null)));



            }
        });




    }


    @Override
    public int getItemCount() {
        return mlist.size();
    }

//    public void permissionCheck() {
//        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CALL);
//                return;
//            } else {
//                context.startActivity(callIntent);
//            }
//        }
//    }

//    @OnClick({R.id.show_restaurant_new_order_shape_recycler_accept, R.id.show_restaurant_new_order_shape_recycler_rl_cancel})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.show_restaurant_new_order_shape_recycler_accept:
//                break;
//            case R.id.show_restaurant_new_order_shape_recycler_rl_cancel:
//                break;
//        }
//    }

    public class NeewViewHolder extends RecyclerView.ViewHolder {
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
        @BindView(R.id.show_restaurant_new_order_shape_recycler_edt_refuse_resion)
        EditText edtcancelResion;
        @BindView(R.id.show_restaurant_new_order_shape_recycler_rl_call)
        RelativeLayout rlCall;
        @BindView(R.id.show_restaurant_new_order_shape_recycler_accept)
        RelativeLayout rlAccept;
        @BindView(R.id.show_restaurant_new_order_shape_recycler_rl_cancel)
        RelativeLayout rlCancel;
        @BindView(R.id.show_restaurant_new_order_shape_recycler_txt_call)
        TextView txtCall;
        private View view;

        public NeewViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }
    }
}
