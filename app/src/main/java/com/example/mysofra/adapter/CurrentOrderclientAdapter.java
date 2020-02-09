package com.example.mysofra.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.clientConfirmOreder.ClientConfirmOreder;
import com.example.mysofra.data.model.clientModel.clientMyOrder.ClientMyOrderDatum;
import com.example.mysofra.data.model.clientModel.clientMyOrder.ClientMyOrderRestaurant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrentOrderclientAdapter extends RecyclerView.Adapter<CurrentOrderclientAdapter.ViewwHolder> {


    private String api_Tolen = "HRbqKFSaq5ZpsOKITYoztpFZNylmzL9elnlAThxZSZ52QWqVBIj8Rdq7RhoB";
    private Context context;
    private List<ClientMyOrderDatum> c_list = new ArrayList<>();

    public CurrentOrderclientAdapter(Context context, List<ClientMyOrderDatum> c_list) {
        this.context = context;
        this.c_list = c_list;
    }

    @NonNull
    @Override
    public ViewwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_new_orderclient_recycler_shape, parent, false);

        return new ViewwHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewwHolder holder, int position) {
        ClientMyOrderDatum mlist = c_list.get(position);
        ClientMyOrderRestaurant res = c_list.get(position).getRestaurant();
        Picasso.with(context).load(res.getPhotoUrl()).error(R.drawable.rror_black_24dp)
                .placeholder(R.drawable.upload_24dp).fit().into(holder.ShapeImgCustomer);
        //holder.TxtCustomerName.setText(res.getName());
        holder.ShapeOrderNumber.setText(String.valueOf(mlist.getId()));
        holder.ShapeOrderTotal.setText(mlist.getTotal());
        holder.ShapeOrderAdress.setText(mlist.getAddress());
        holder.lnconfiremDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = c_list.get(position).getId();
                RetrofitSofra.getInstance().confirmOrderClient(id, api_Tolen).enqueue(new Callback<ClientConfirmOreder>() {
                    @Override
                    public void onResponse(Call<ClientConfirmOreder> call, Response<ClientConfirmOreder> response) {
                        try {
                            if (response.body().getStatus()==1){
                                Toast.makeText(context,response.body().getMsg(),Toast.LENGTH_LONG).show();
                            }

                        } catch (Exception e) {
                            Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ClientConfirmOreder> call, Throwable t) {
                        Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

    }

    @Override
    public int getItemCount() {
        return c_list.size();
    }

    public class ViewwHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.show_new_orderclient_recycler_shape_img_customer)
        CircleImageView ShapeImgCustomer;
        @BindView(R.id.show_new_orderclient_recycler_shape_order_number)
        TextView ShapeOrderNumber;
        @BindView(R.id.show_new_orderclient_recycler_shape_order_total)
        TextView ShapeOrderTotal;
        @BindView(R.id.show_new_orderclient_recycler_shape_order_adress)
        TextView ShapeOrderAdress;
        @BindView(R.id.show_new_orderclient_recycler_shape_rl_all)
        RelativeLayout lnconfiremDelivery;
        private View view;

        public ViewwHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }

    }
}
