package com.example.mysofra.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysofra.R;
import com.example.mysofra.data.model.restaurantNewOrder.RestaurantNewOrderDatum;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.mysofra.helper.HelperMethod.checkWriteExternalPermission;
import static com.example.mysofra.helper.HelperMethod.onPermission;

public class PreviousOrderRestaurantAdapter extends RecyclerView.Adapter<PreviousOrderRestaurantAdapter.previousViewHolder> {


    private Context context;
    private List<RestaurantNewOrderDatum> mlist = new ArrayList<>();

    public PreviousOrderRestaurantAdapter(Context context, List<RestaurantNewOrderDatum> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public previousViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_restaurant_previous_order_shape_recycler
                , parent, false);


        return new previousViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull previousViewHolder holder, int position) {
        RestaurantNewOrderDatum sup = mlist.get(position);
        String imgurl = sup.getClient().getPhotoUrl();
        Picasso.with(context).load(imgurl).placeholder(R.drawable.upload_24dp)
                .error(R.drawable.rror_black_24dp).fit().into(holder.imgCustomer);
        holder.txtCustomerName.setText(sup.getClient().getName());
        holder.txtOrderNumber.setText(String.valueOf(sup.getId()));
        holder.txtOrderTotal.setText(sup.getTotal());
        holder.txtAdr.setText(sup.getAddress());
holder.txtButton.setText(sup.getState());

    }




    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class previousViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.show_restaurant_new_order_shape_recycler_img_customer)
        ImageView imgCustomer;
        @BindView(R.id.show_restaurant_new_order_shape_recycler_txt_customer_name)
        TextView txtCustomerName;
        @BindView(R.id.show_restaurant_new_order_shape_recycler_txt_order_number)
        TextView txtOrderNumber;
        @BindView(R.id.show_restaurant_new_order_shape_recycler_order_total)
        TextView txtOrderTotal;
        @BindView(R.id.show_restaurant_new_order_shape_recycler_order_adress)
        TextView txtAdr;
        @BindView(R.id.show_restaurant_new_order_shape_recycler_rl_call)
        RelativeLayout RlCall;
        @BindView(R.id.show_restaurant_new_order_shape_recycler_txt_button)
        TextView txtButton;
        private View view;

        public previousViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }
    }
}
