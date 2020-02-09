package com.example.mysofra.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysofra.R;
import com.example.mysofra.data.model.restaurantNotification.RestaurantNotificationDatum;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationRestaurantAdapter extends RecyclerView.Adapter<NotificationRestaurantAdapter.RestauratnNotiViewHolder> {
  private Context context;
    private List<RestaurantNotificationDatum> nList = new ArrayList<>();


    public NotificationRestaurantAdapter(Context context, List<RestaurantNotificationDatum> nList) {
        this.context = context;
        this.nList = nList;
    }


    @NonNull
    @Override
    public RestauratnNotiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shape_notification_recyclerview_client, parent, false);
        return new RestauratnNotiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestauratnNotiViewHolder holder, int position) {
        holder.txtNotification.setText(nList.get(position).getTitle());
/////////////////////
    }

    @Override
    public int getItemCount() {
        return nList.size();
    }


public class RestauratnNotiViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.shape_notification_recyclerview_client_txt_time)
    TextView txtTime;
    @BindView(R.id.shape_notification_recyclerview_client_txt_notification)
    TextView txtNotification;
    private View view;

    public RestauratnNotiViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
        ButterKnife.bind(this, view);
    }
}

}
