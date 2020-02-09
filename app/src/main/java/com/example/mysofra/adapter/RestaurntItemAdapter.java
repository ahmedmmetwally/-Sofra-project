package com.example.mysofra.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysofra.R;
import com.example.mysofra.data.model.restaurntItem.RestaurntItemDatum;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurntItemAdapter extends RecyclerView.Adapter<RestaurntItemAdapter.VeiwHiolder> {
    private OnCategoryClickListener listener;

    private Context context;
    private List<RestaurntItemDatum> itemList = new ArrayList<>();

    public RestaurntItemAdapter(Context context, List<RestaurntItemDatum> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public VeiwHiolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_restaurant_items_shape_recycler,
                parent, false);

        return new VeiwHiolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VeiwHiolder holder, int position) {
        RestaurntItemDatum datum = itemList.get(position);
        // String url = datum.getPhotoUrl();
        Picasso.with(context).load(datum.getPhotoUrl()).error(R.drawable.rror_black_24dp)
                .placeholder(R.drawable.upload_24dp).fit().into(holder.ImgItemImage);
        holder.TxtItemName.setText(datum.getName());
        holder.TxtItemDescription.setText(datum.getDescription());
        holder.TxtItemPrice.setText(datum.getPrice());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemclick(datum);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class VeiwHiolder extends RecyclerView.ViewHolder {
        @BindView(R.id.show_restaurant_items_shape_recycler_img_item_image)
        ImageView ImgItemImage;
        @BindView(R.id.show_restaurant_items_shape_recycler_txt_item_name)
        TextView TxtItemName;
        @BindView(R.id.show_restaurant_items_shape_recycler_txt_item_description)
        TextView TxtItemDescription;
        @BindView(R.id.show_restaurant_items_shape_recycler_txt_item_price)
        TextView TxtItemPrice;
        private View view;

        public VeiwHiolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }
    }

    public interface OnCategoryClickListener {
        void onItemclick(RestaurntItemDatum note);
    }

    public void setOnCategoryClickListener(OnCategoryClickListener listener) {
        this.listener = listener;
    }
}
