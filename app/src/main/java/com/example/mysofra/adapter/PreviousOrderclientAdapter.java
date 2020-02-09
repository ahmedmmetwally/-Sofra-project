package com.example.mysofra.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysofra.R;
import com.example.mysofra.data.model.clientModel.clientMyOrder.ClientMyOrderDatum;
import com.example.mysofra.data.model.clientModel.clientMyOrder.ClientMyOrderRestaurant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class PreviousOrderclientAdapter extends RecyclerView.Adapter<PreviousOrderclientAdapter.ViewwHolderr> {

    private Context context;
    private List<ClientMyOrderDatum> p_list = new ArrayList<>();

    public PreviousOrderclientAdapter(Context context, List<ClientMyOrderDatum> p_list) {
        this.context = context;
        this.p_list = p_list;
    }

    @NonNull
    @Override
    public ViewwHolderr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_new_orderclient_recycler_shape, parent, false);
        return new ViewwHolderr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewwHolderr holder, int position) {
        ClientMyOrderDatum mlist = p_list.get(position);
        ClientMyOrderRestaurant res = p_list.get(position).getRestaurant();
        Picasso.with(context).load(res.getPhotoUrl())  .error(R.drawable.rror_black_24dp)
                .placeholder(R.drawable.upload_24dp).fit().into(holder.RecyclerShapeImgCustomer);
        //holder.RecyclerShapeTxtCustomerName.setText(res.getName());
        holder.RecyclerShapeOrderNumber.setText(String.valueOf(mlist.getId()));
        holder.RecyclerShapeOrderTotal.setText(mlist.getTotal());
        holder.RecyclerShapeOrderAdress.setText(mlist.getAddress());
    }

    @Override
    public int getItemCount() {
        return p_list.size();
    }

    public class ViewwHolderr extends RecyclerView.ViewHolder {
        @BindView(R.id.show_new_orderclient_recycler_shape_img_customer)
        CircleImageView RecyclerShapeImgCustomer;

        @BindView(R.id.show_new_orderclient_recycler_shape_order_number)
        TextView RecyclerShapeOrderNumber;
        @BindView(R.id.show_new_orderclient_recycler_shape_order_total)
        TextView RecyclerShapeOrderTotal;
        @BindView(R.id.show_new_orderclient_recycler_shape_order_adress)
        TextView RecyclerShapeOrderAdress;
        private View view;

        public ViewwHolderr(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }

    }
}
