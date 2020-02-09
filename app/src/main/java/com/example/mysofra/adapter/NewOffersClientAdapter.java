package com.example.mysofra.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mysofra.R;
import com.example.mysofra.data.model.clientOffers.ClientOffersDatum;
import com.example.mysofra.data.model.restaurantMyItem.RestaurantMyItemDatum;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.ui.activity.ClientHomeActivity;
import com.example.mysofra.ui.fragment.client.homeFragment.OfferDetailsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class NewOffersClientAdapter extends RecyclerView.Adapter<NewOffersClientAdapter.NewOfferViewHolder> {

private OnOffersClickListener listener;
    private Context context;
    private List<ClientOffersDatum> oList = new ArrayList<>();

    public NewOffersClientAdapter(Context context, List<ClientOffersDatum> oList) {
        this.context = context;
        this.oList = oList;
    }

    @NonNull
    @Override
    public NewOfferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_client_newt_offer_shape_recycler, parent, false);
        return new NewOfferViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewOfferViewHolder holder, int position) {
        ClientOffersDatum list=oList.get(position);
        Glide.with(context)
                .load(list.getPhotoUrl()).placeholder(R.drawable.search_black_24dp)
                .error(R.drawable.rror_black_24dp)
                .into(holder.cimgCircleImage);
        holder.txtTextview.setText(list.getDescription());
        holder.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClientHomeActivity clientHomeActivity = (ClientHomeActivity) context;
                OfferDetailsFragment offerDetailsFragment = new OfferDetailsFragment();
                offerDetailsFragment.offersData = oList.get(position);
                HelperMethod.ReplaceFragment(clientHomeActivity.getSupportFragmentManager(), offerDetailsFragment
                        , R.id.activity_home_client_frame_fragment  , null, null);
            }
        });


    }

    @Override
    public int getItemCount() {
        return oList.size();
    }

    public class NewOfferViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.show_client_newt_offer_shape_recycler_cimg_circle_image)
        CircleImageView cimgCircleImage;
        @BindView(R.id.show_client_newt_offer_shape_recycler_txt_textview)
        TextView txtTextview;
        @BindView(R.id.show_client_newt_offer_shape_recycler_btn_details)
        Button btnDetails;
        private View view;

        public NewOfferViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }
    }
    public interface OnOffersClickListener {
        void onImgEditclick(ClientOffersDatum my_Offers);
    }
    public void setOffersClickListener(OnOffersClickListener listener){
        this.listener=listener;
    }
}
