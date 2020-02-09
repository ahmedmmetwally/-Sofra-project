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

import com.example.mysofra.R;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.restaurantDeleteCategory.RestaurantDeleteCategory;
import com.example.mysofra.data.model.restaurantMYCategories.RestaurantMYCategoriesDatum;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.ui.RestaurantUpdateCategoryCustumDialog;
import com.example.mysofra.ui.activity.RestaurantHomeActivity;
import com.example.mysofra.ui.fragment.restaurant.RestaurantMyCategoriesFragmet;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mysofra.helper.HelperMethod.customToast;

public class RestaurantMyCategoriesnAdapter extends RecyclerView.Adapter<RestaurantMyCategoriesnAdapter.MyCategorisHolder> {

    private OnMYCategoryClickListener listener;
    private String api_token;
    private Context context;
    private Activity activity;
    private List<RestaurantMYCategoriesDatum> mList=new ArrayList<>();
    private RestaurantHomeActivity restaurantHomeActivit = (RestaurantHomeActivity) activity;
    private String imgUrl;

    public RestaurantMyCategoriesnAdapter(Context context, Activity activity, List<RestaurantMYCategoriesDatum> mList, String api_token) {
        this.context = context;
        this.mList = mList;
        this.activity = activity;
        this.api_token = api_token;


    }

    @NonNull
    @Override
    public MyCategorisHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.restauratn_my_category_recycler_shap, parent, false);
        return new MyCategorisHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCategorisHolder holder, int position) {
        RestaurantMYCategoriesDatum mm = mList.get(position);
        int id = mm.getId();
        imgUrl = mm.getPhotoUrl();
        Picasso.with(context).load(imgUrl).error(R.drawable.rror_black_24dp)
                .placeholder(R.drawable.upload_24dp).fit().into(holder.imgContaner);
        holder.txtCategoryname.setText(mm.getName());
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RetrofitSofra.getInstance().deleteCategoryRestaurant(api_token, id).enqueue(new Callback<RestaurantDeleteCategory>() {
                    @Override
                    public void onResponse(Call<RestaurantDeleteCategory> call, Response<RestaurantDeleteCategory> response) {
                        try {
                            if (response.body().getStatus() == 1) {
                                mList.remove(position);

                                Toast.makeText(restaurantHomeActivit, context.getString(R.string.deletee), Toast.LENGTH_LONG).show();

                            }

                        } catch (Exception e) {
                            customToast(restaurantHomeActivit, response.body().getMsg(), false);
                        }
                    }

                    @Override
                    public void onFailure(Call<RestaurantDeleteCategory> call, Throwable t) {

                    }
                });
            }
        });
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RestaurantUpdateCategoryCustumDialog alertDialoug = new RestaurantUpdateCategoryCustumDialog(context);
               // RestaurantHomeActivity restaurantHomeActivity = (RestaurantHomeActivity) context;
                alertDialoug.id = id;
                alertDialoug.categoryName = mm.getName();
                alertDialoug.imgUrl = imgUrl;
                alertDialoug.setCanceledOnTouchOutside(true);
                alertDialoug.show();


            }
        });

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.goToMyItem(mm);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class MyCategorisHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.my_category_recycler_shap_img_delete)
        ImageView imgDelete;
        @BindView(R.id.my_category_recycler_shap_img_edit)
        ImageView imgEdit;
        @BindView(R.id.my_category_recycler_shap_img_contaner)
        ImageView imgContaner;
        @BindView(R.id.my_category_recycler_shap_txt_categoryname)
        TextView txtCategoryname;
        private View view;

        public MyCategorisHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }
    }

    public interface OnMYCategoryClickListener {
        void goToMyItem(RestaurantMYCategoriesDatum my_Cat_ist);
    }

    public void setMYOnCategoryClickListener(OnMYCategoryClickListener listener) {
        this.listener = listener;
    }
}
