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
import com.example.mysofra.data.model.restaurantDeleteOffer.RestauranDeleteOffer;
import com.example.mysofra.data.model.restaurantMyOffer.RestaurantMyOfferDatum;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.helper.InternetState;
import com.example.mysofra.ui.activity.RestaurantHomeActivity;
import com.example.mysofra.ui.fragment.restaurant.EditOfferFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mysofra.helper.HelperMethod.customToast;
import static com.example.mysofra.helper.HelperMethod.dismissProgressDialog;
import static com.example.mysofra.helper.HelperMethod.showProgressDialog;

public class MyOfferRestaurantAdapter extends RecyclerView.Adapter<MyOfferRestaurantAdapter.MyOfferHolder> {
    private String api_token;
    private Context context;
    private List<RestaurantMyOfferDatum> olist = new ArrayList<>();
    private Integer id;
    private RestaurantMyOfferDatum cList;

    public MyOfferRestaurantAdapter(Context context, List<RestaurantMyOfferDatum> olist, String api_token) {
        this.context = context;
        this.olist = olist;
        this.api_token = api_token;
    }

    @NonNull
    @Override
    public MyOfferHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_restaurant_my_offer_shape_recycler,
                parent, false);
        return new MyOfferHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOfferHolder holder, int position) {
        cList = olist.get(position);
        id = cList.getId();
        Glide.with(context)
                .load(olist.get(position).getPhotoUrl()).placeholder(R.drawable.search_black_24dp)
                .error(R.drawable.rror_black_24dp)
                .into(holder.cimgCircleImage);
        holder.txtTextview.setText(olist.get(position).getDescription());
        holder.ImgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (InternetState.isConnected(context)) {
                    showProgressDialog((Activity) context, context.getString(R.string.waiit));
                    RetrofitSofra.getInstance().deleteOfferRestaurant(id, api_token).enqueue(new Callback<RestauranDeleteOffer>() {
                        @Override
                        public void onResponse(Call<RestauranDeleteOffer> call, Response<RestauranDeleteOffer> response) {
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
                        public void onFailure(Call<RestauranDeleteOffer> call, Throwable t) {
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
        holder.ImgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RestaurantHomeActivity restaurantHomeActivity=(RestaurantHomeActivity)context;
                EditOfferFragment editOfferFragment = new EditOfferFragment();
                editOfferFragment.description = cList.getDescription();
                editOfferFragment.api_token = api_token;
                editOfferFragment.photo_url = cList.getPhotoUrl();
                editOfferFragment.starting_at = cList.getStartingAt();
                editOfferFragment.name = cList.getName();
                editOfferFragment.ending_at = cList.getEndingAt();
                editOfferFragment.price = cList.getPrice();
                editOfferFragment.id = id;
                HelperMethod.ReplaceFragment(restaurantHomeActivity.getSupportFragmentManager()
                        ,editOfferFragment,R.id.activity_restaurant_home_frame_fragment,null,null);

            }
        });

    }

    @Override
    public int getItemCount() {
        return olist.size();
    }


    public class MyOfferHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.show_restaurant_my_offer_shape_recycler_img_delete)
        ImageView ImgDelete;
        @BindView(R.id.show_restaurant_my_offer_shape_recycler_img_edit)
        ImageView ImgEdit;
        @BindView(R.id.show_restaurant_my_offer_shape_recycler_cimg_circle_image)
        CircleImageView cimgCircleImage;
        @BindView(R.id.show_restaurant_my_offer_shape_recycler_txt_textview)
        TextView txtTextview;
        private View view;

        public MyOfferHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }
    }
}
