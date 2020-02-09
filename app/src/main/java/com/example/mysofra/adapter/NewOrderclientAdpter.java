package com.example.mysofra.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.clientDeclineOreder.ClientDeclineOreder;
import com.example.mysofra.data.model.clientModel.clientMyOrder.ClientMyOrderDatum;
import com.example.mysofra.data.model.clientModel.clientMyOrder.ClientMyOrderRestaurant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewOrderclientAdpter extends RecyclerView.Adapter<NewOrderclientAdpter.ClientOrderViewHolder> {
    private String api_Tolen = "HRbqKFSaq5ZpsOKITYoztpFZNylmzL9elnlAThxZSZ52QWqVBIj8Rdq7RhoB";
    private Context context;
    private List<ClientMyOrderDatum> list = new ArrayList<>();

    public NewOrderclientAdpter(Context context, List<ClientMyOrderDatum> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ClientOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.show_new_orderclient_recycler_shape,
                parent, false);
        return new ClientOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientOrderViewHolder holder, int position) {
        ClientMyOrderDatum mlist = list.get(position);
        ClientMyOrderRestaurant res = list.get(position).getRestaurant();
        Picasso.with(context).load(res.getPhotoUrl()).error(R.drawable.rror_black_24dp)
                .placeholder(R.drawable.upload_24dp).fit().into(holder.ImgCustomer);
        holder.OrderNumber.setText(String.valueOf(mlist.getId()));
        holder.Total.setText(mlist.getTotal());
        holder.OrderAdress.setText(mlist.getAddress());
        holder.lndecline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // String order_id=list.get(position).getItems().get(position).getPivot().getOrderId();
                int order_id = list.get(position).getId();
                RetrofitSofra.getInstance().declineOrderClient(order_id, api_Tolen).enqueue(new Callback<ClientDeclineOreder>() {
                    @Override
                    public void onResponse(Call<ClientDeclineOreder> call, Response<ClientDeclineOreder> response) {
                        try {
                            if (response.body().getStatus()==1){
                                Toast.makeText(context,response.body().getMsg(),Toast.LENGTH_LONG).show();
                            }

                        } catch (Exception e) {
                            Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ClientDeclineOreder> call, Throwable t) {
                        Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ClientOrderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.show_new_orderclient_recycler_shape_img_customer)
        ImageView ImgCustomer;
        @BindView(R.id.show_new_orderclient_recycler_shape_order_number)
        TextView OrderNumber;
        @BindView(R.id.show_new_orderclient_recycler_shape_order_total)
        TextView Total;
        @BindView(R.id.show_new_orderclient_recycler_shape_order_adress)
        TextView OrderAdress;
        @BindView(R.id.show_new_orderclient_recycler_shape_rl_all)
        RelativeLayout lndecline;
        private View view;

        public ClientOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }
    }
}
