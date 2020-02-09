package com.example.mysofra.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysofra.R;
import com.example.mysofra.data.model.restaurntreviewe.RestaurntRevieweDatum;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class RestaurantReviewsAdapter extends RecyclerView.Adapter<RestaurantReviewsAdapter.ViewHolderr> {

//    @BindView(R.id.fragment_show_restaurants_container_circleImage)
//    CircleImageView cccContainerCircleImage;
//    @BindView(R.id.fragment_show_restaurants_container_txt_restaurant_name)
//    TextView ContainerTxtRestaurantName;
//    @BindView(R.id.fragment_show_restaurants_container_rl_imagecontainer)
//    RelativeLayout ContainerRlImagecontainer;
    private Context context;
    private List<RestaurntRevieweDatum> reviewList;


    public RestaurantReviewsAdapter(Context context, List<RestaurntRevieweDatum> reviewList) {
        this.context = context;
        this.reviewList = reviewList;
    }

    @NonNull
    @Override
    public ViewHolderr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_restaurant_review_shape_recycler, parent, false);
//        View layoutview = LayoutInflater.from(context).inflate(R.layout.fragment_show_restaurants_container, null);
//        layoutview.setVisibility(View.VISIBLE);
        return new ViewHolderr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderr holder, int position) {
        fillData(holder,position);
    }

    private void fillData(ViewHolderr holder, int position) {
        RestaurntRevieweDatum datum = reviewList.get(position);
//        ContainerRlImagecontainer.setVisibility(View.VISIBLE);
//        String url=datum.getRestaurant().getPhotoUrl();
//        Picasso.with(context).load(url).error(R.drawable.rror_black_24dp)
//                .placeholder(R.drawable.upload_24dp).fit().into(cccContainerCircleImage);
//        ContainerTxtRestaurantName.setText(datum.getRestaurant().getName());
//
        Picasso.with(context).load(datum.getClient().getPhotoUrl()).error(R.drawable.rror_black_24dp)
                .placeholder(R.drawable.upload_24dp).fit().into(holder.ImgProfileImage);
        holder.TxtName.setText(datum.getClient().getName());
        holder.Txt_review.setText(datum.getComment());

    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    public class ViewHolderr extends RecyclerView.ViewHolder {
        @BindView(R.id.show_restaurant_review_shape_recycler_txt_name)
        TextView TxtName;
        @BindView(R.id.show_restaurant_review_shape_recycler_txt_review)
        TextView Txt_review;
        @BindView(R.id.show_restaurant_review_shape_recycler_img_review_image)
        CircleImageView ImgProfileImage;
        private View view;

        public ViewHolderr(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }
    }
}
