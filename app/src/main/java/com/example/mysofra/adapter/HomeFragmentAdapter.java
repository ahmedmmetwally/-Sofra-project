package com.example.mysofra.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysofra.R;
import com.example.mysofra.data.model.listOfRestaurants.ListOfRestaurantsDatum;

import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.ui.activity.ClientHomeActivity;
import com.example.mysofra.ui.fragment.client.homeFragment.ShowRestaurantsContainerFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragmentAdapter extends RecyclerView.Adapter<HomeFragmentAdapter.ViewHolderr> {

    // private  OnMYItemClickListener listener;
    private Context context;
    public List<ListOfRestaurantsDatum> mList;
    private Activity activity;

    public HomeFragmentAdapter(Context context, Activity activity, List<ListOfRestaurantsDatum> mList) {
        this.context = context;
        this.mList = mList;
        this.activity = activity;

    }

    @NonNull
    @Override
    public ViewHolderr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_recycler_shap, parent, false);
        return new ViewHolderr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderr holder, int position) {
        setData(holder, position);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowRestaurantsContainerFragment showRestaurantsContainerFragment = new ShowRestaurantsContainerFragment();


                //send restaurant id to other Frgment which depend on it
                ClientHomeActivity homeActivity =(ClientHomeActivity) activity;

                int id = mList.get(position).getId();
                showRestaurantsContainerFragment.id=id;
                HelperMethod.ReplaceFragment(homeActivity.getSupportFragmentManager(), showRestaurantsContainerFragment
                        , R.id.activity_home_client_frame_fragment, null, null);
                //HelperMethod.customToast(homeActivity,"====="+id+"=======",true);
                Log.e("rest_id_Clicked is:","..........."+id+"");
            }
        });

    }


    private void setData(ViewHolderr holder, int position) {
        ListOfRestaurantsDatum listt = mList.get(position);
        if (listt.getAvailability().equals("open")) {
            holder.ImgOnOff.setImageResource(R.drawable.circle_shape_on);
            holder.TxtOpenClose.setText(listt.getAvailability());

        } else {
            //  holder.ImgOnOff.setImageResource(R.drawable.circle14);
            holder.TxtOpenClose.setText(listt.getAvailability());
        }
        // holder.ImgRestaurntProfile.setImageURI(Uri.parse(listt.getPhoto());
        Picasso.with(context).load(listt.getPhotoUrl())
                .error(R.drawable.rror_black_24dp).placeholder(R.drawable.upload_24dp).fit().into(holder.ImgRestaurntProfile);
        holder.TxtRestaurntName.setText(listt.getName());
        holder.TxtDeleveryCost.setText(listt.getDeliveryCost());
        holder.TxtRequstNumber.setText(listt.getMinimumCharger());
        holder.rtbRatingBar.setRating((float)(listt.getRate()));

    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolderr extends RecyclerView.ViewHolder {

        @BindView(R.id.fragment_home_txt_open_close)
        TextView TxtOpenClose;
        @BindView(R.id.fragment_home_img_on_off)
        ImageView ImgOnOff;
        @BindView(R.id.fragment_home_txt_restaurnt_name)
        TextView TxtRestaurntName;
        @BindView(R.id.fragment_home_rtb_rating_bar)
        RatingBar rtbRatingBar;
        @BindView(R.id.fragment_home_txt_requst_number)
        TextView TxtRequstNumber;
        @BindView(R.id.fragment_home_txt_delevery_cost)
        TextView TxtDeleveryCost;
        @BindView(R.id.fragment_home_img_restaurnt_profile)
        ImageView ImgRestaurntProfile;
        private View view;

        public ViewHolderr(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(listener !=null &&getAdapterPosition() !=RecyclerView.NO_POSITION)
//                   listener.onMyClick(mList.get(getAdapterPosition()));
//                }
//            });
        }
    }
//    public interface OnMYItemClickListener{
//        void onMyClick(ListOfRestaurantsDatum supList);
//    }
//    public void setOnMyClickListener(OnMYItemClickListener listener){
//        this.listener=listener;
//    }
}
