package com.example.mysofra.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysofra.R;
import com.example.mysofra.data.model.restaurntCategories.RestaurntCategoriesDatum;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class RestaurantCategoriesAdapter extends RecyclerView.Adapter<RestaurantCategoriesAdapter.Holder> {
    public OnCategoryClickListener categoryClickListener;
    private Context context;
    private List<RestaurntCategoriesDatum> listCategory = new ArrayList<>();
    // RestaurntCategoriesDatum list = new RestaurntCategoriesDatum("all", String.valueOf(R.drawable.all));

    public RestaurantCategoriesAdapter(Context context, List<RestaurntCategoriesDatum> listCategory) {
        //    listCategory.add(0,1,null,null,"all",null,null, String.valueOf(R.drawable.all));

        this.context = context;
        this.listCategory.add(new RestaurntCategoriesDatum(-1,"all", String.valueOf(R.drawable.all)));
        this.listCategory .addAll(listCategory) ;

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_restaurant_category_shape_recycler, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        RestaurntCategoriesDatum data = listCategory.get(position);
        Picasso.with(context).load(data.getPhotoUrl()).error(R.drawable.rror_black_24dp)
                .placeholder(R.drawable.upload_24dp).fit().into(holder.CategoryShapeImageCateogyr);
        holder.CategoryShapeTxtCategoryName.setText(data.getName());


    }

    @Override
    public int getItemCount() {
        return listCategory.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.show_restaurant_category_shape_image_cateogyr)
        CircleImageView CategoryShapeImageCateogyr;
        @BindView(R.id.show_restaurant_category_shape_txt_category_name)
        TextView CategoryShapeTxtCategoryName;
        private View view;

        public Holder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (categoryClickListener != null && getAdapterPosition() != RecyclerView.NO_POSITION)
                        categoryClickListener.onMyCategoryClick(listCategory.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface OnCategoryClickListener {
        void onMyCategoryClick(RestaurntCategoriesDatum supDatum);
    }

    public void setOnCategrylistener(OnCategoryClickListener onCategoryClickListener) {
        this.categoryClickListener = onCategoryClickListener;
    }
}
