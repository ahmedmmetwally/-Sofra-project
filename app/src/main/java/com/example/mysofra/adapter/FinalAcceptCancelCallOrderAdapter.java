package com.example.mysofra.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysofra.R;
import com.example.mysofra.data.model.Note;
import com.example.mysofra.data.model.clientModel.clientMyOrder.ClientMyOrderDatum;
import com.example.mysofra.data.model.clientModel.clientMyOrder.ClientMyOrderItem;
import com.example.mysofra.data.model.clientOrderById.ClientOrderByIdData;
import com.example.mysofra.data.model.clientOrderById.ClientOrderByIdItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FinalAcceptCancelCallOrderAdapter extends RecyclerView
        .Adapter<FinalAcceptCancelCallOrderAdapter.FinalRooomViewHolder> {


    private Context context;
    private List<ClientOrderByIdItem> nList = new ArrayList<>();

    public FinalAcceptCancelCallOrderAdapter(Context context, List<ClientOrderByIdItem> nList) {
        this.context = context;
        this.nList = nList;
    }

    @NonNull
    @Override
    public FinalRooomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.show_client_room_oreder_shap_recyclerview, parent, false);
        return new FinalRooomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FinalRooomViewHolder holder, int position) {
        // nList.get(position);
        holder.txtItemName.setText(nList.get(position).getName());
        holder.txtPrice.setText(nList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return nList.size();
    }

    public class FinalRooomViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.show_client_room_oreder_shap_recyclerview_txt_price)
        TextView txtPrice;
        @BindView(R.id.show_client_room_oreder_shap_recyclerview_txt_item_name)
        TextView txtItemName;
        private View view;

        public FinalRooomViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }
    }
}
