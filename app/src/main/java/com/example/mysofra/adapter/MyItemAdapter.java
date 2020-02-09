package com.example.mysofra.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.restaurantDeleteItem.RestauranDeleteItem;

import com.example.mysofra.data.model.restaurantMyItem.RestaurantMyItemDatum;
import com.example.mysofra.helper.InternetState;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mysofra.helper.HelperMethod.customToast;
import static com.example.mysofra.helper.HelperMethod.dismissProgressDialog;
import static com.example.mysofra.helper.HelperMethod.showProgressDialog;

public class MyItemAdapter extends RecyclerView.Adapter<MyItemAdapter.MyItemHolder> {

  public OnMYItemClickListener listener;
    private Context context;
    private List<RestaurantMyItemDatum> iList = new ArrayList<>();
    private String api_token;
    private Integer id;

    public MyItemAdapter(Context context, List<RestaurantMyItemDatum> iList,String api_token) {
        this.context = context;
        this.iList = iList;
        this.api_token=api_token;
    }

    @NonNull
    @Override
    public MyItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_restaurant_my_items_shape_recycler, parent, false);

        return new MyItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyItemHolder holder, int position) {
        RestaurantMyItemDatum list=iList.get(position);
     id=   list.getId();
holder.txtItemDescription.setText(list.getDescription());
holder.txtItemName.setText(list.getName());
        Glide.with(context)
                .load(list.getPhotoUrl()).placeholder(R.drawable.search_black_24dp)
                .error(R.drawable.rror_black_24dp)
                .into(holder.imgPhotoItem);
        holder.txtItemPriceNum.setText(list.getPrice());
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (InternetState.isConnected(context)) {
                    showProgressDialog((Activity) context, context.getString(R.string.waiit));
                    RetrofitSofra.getInstance().deleteItemRestaurant(id, api_token).enqueue(new Callback<RestauranDeleteItem>() {
                        @Override
                        public void onResponse(Call<RestauranDeleteItem> call, Response<RestauranDeleteItem> response) {
                            try {
                                dismissProgressDialog();
                                if (response.body().getStatus() == 1) ;
                                Toast.makeText(context, context.getString(R.string.deletee), Toast.LENGTH_LONG).show();

                            } catch (Exception e) {
                                dismissProgressDialog();
                                Toast.makeText(context, response.body().getMsg() + e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<RestauranDeleteItem> call, Throwable t) {
                            dismissProgressDialog();
                            Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

                } else {
                    dismissProgressDialog();
                    customToast((Activity) context, context.getString(R.string.offline), false);
                }
            }
        });
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               listener.onImgEditclick(list);
            }
        });
    }
    @Override
    public int getItemCount() {
        return iList.size();
    }

    public class MyItemHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.show_restaurant_my_items_shape_recycler_recycler_img_delete)
        ImageView imgDelete;
        @BindView(R.id.show_restaurant_my_item_shape_recycler_img_edit)
        ImageView imgEdit;
        @BindView(R.id.show_restaurant_my_item_shape_recycler_img_photo_item)
        ImageView imgPhotoItem;
        @BindView(R.id.show_restaurant_my_item_shape_recycler_txt_item_name)
        TextView txtItemName;
        @BindView(R.id.show_restaurant_my_item_shape_recycler_txt_item_description)
        TextView txtItemDescription;
        @BindView(R.id.show_restaurant_my_item_shape_recycler_txt_item_price_num)
        TextView txtItemPriceNum;
        private View view;

        public MyItemHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }
    }
    public interface OnMYItemClickListener {
        void onImgEditclick(RestaurantMyItemDatum my_itemlist);
    }
    public void setMYOnItemClickListener(OnMYItemClickListener listener){
        this.listener=listener;
    }
}
