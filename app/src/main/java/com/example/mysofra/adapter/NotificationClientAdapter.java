package com.example.mysofra.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysofra.R;
import com.example.mysofra.data.model.clientNotification.ClientNotificationDatum;
import com.example.mysofra.helper.GetTimeAgo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NotificationClientAdapter extends RecyclerView.Adapter<NotificationClientAdapter.ClientNotiViewHolder> {

    private Context context;
    private List<ClientNotificationDatum> nList = new ArrayList<>();


    public NotificationClientAdapter(Context context, List<ClientNotificationDatum> nList) {
        this.context = context;
        this.nList = nList;
    }


    @NonNull
    @Override
    public ClientNotiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shape_notification_recyclerview_client, parent, false);
        return new ClientNotiViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ClientNotiViewHolder holder, int position) {
        holder.txtNotification.setText(nList.get(position).getTitle());
        String date1 = nList.get(position).getCreatedAt();

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dddd HH:mm:ss");
//        try {
//            Date d = simpleDateFormat.parse(date1);
//            Date date11 = new SimpleDateFormat("yyyy-MM-dddd HH:mm:ss").parse(date1);
//            GetTimeAgo.getTimeAgo(date1, context);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


//        ///////////////////
        Log.e("notificatio adapter", nList.size() + "");
    }

    @Override
    public int getItemCount() {
        return nList.size();
    }


    public class ClientNotiViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.shape_notification_recyclerview_client_txt_time)
        TextView txtTime;
        @BindView(R.id.shape_notification_recyclerview_client_txt_notification)
        TextView txtNotification;
        private View view;

        public ClientNotiViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }
    }
}
