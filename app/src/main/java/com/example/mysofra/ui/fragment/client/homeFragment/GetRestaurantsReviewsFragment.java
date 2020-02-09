package com.example.mysofra.ui.fragment.client.homeFragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mysofra.R;
import com.example.mysofra.adapter.RestaurantReviewsAdapter;
import com.example.mysofra.data.api.RetrofitSofra;

import com.example.mysofra.data.model.restaurntreviewe.RestaurntReviewe;
import com.example.mysofra.data.model.restaurntreviewe.RestaurntRevieweDatum;
import com.example.mysofra.helper.InternetState;
import com.example.mysofra.helper.OnEndLess;
import com.example.mysofra.ui.ClientAddCommientDialogBox;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mysofra.helper.HelperMethod.customToast;
import static com.example.mysofra.helper.HelperMethod.dismissProgressDialog;


public class GetRestaurantsReviewsFragment extends Fragment {

    @BindView(R.id.fragment_get_restaurants_reviews_btn_addreview)
    Button BtnAddreview;
    @BindView(R.id.fragment_get_restaurants_reviews_rcycler_show_review)
    RecyclerView RcyclerShowReview;
    @BindView(R.id.fragment_get_restaurants_reviews_swip_swipeRefreshLayout)
    SwipeRefreshLayout SwipSwipeRefreshLayout;
    private OnEndLess onEndLess;
    private List<RestaurntRevieweDatum> reviewList;
    RestaurantReviewsAdapter restaurantReviewsAdapter;
    public int restaurant_iddd = 1;
    private int max;
    private Unbinder unbinder;

    public GetRestaurantsReviewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_get_restaurants_reviews, container, false);
        unbinder = ButterKnife.bind(this, view);
        reviewList = new ArrayList<>();
        //restaurantReviewsAdapter = new RestaurantReviewsAdapter(getContext(), reviewList);
        initRec();

        return view;
    }


    private void initRec() {

//        RcyclerShowReview.addItemDecoration(new RecyclerView.ItemDecoration() {
//            @Override
//            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
//                outRect.bottom = 10;
//            }
//        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        RcyclerShowReview.setLayoutManager(linearLayoutManager);
        onEndLess = new OnEndLess(linearLayoutManager, 1) {
            @Override
            public void onLoadMore(int current_page) {

                if (current_page <= max) {
                    if (max != 0 && current_page != 1) {
                        onEndLess.previous_page = current_page;


                        getReviews(restaurant_iddd, current_page);


                    } else {
                        onEndLess.current_page = onEndLess.previous_page;
                    }

                }
            }
        };
        RcyclerShowReview.addOnScrollListener(onEndLess);
        restaurantReviewsAdapter = new RestaurantReviewsAdapter(getContext(), reviewList);
        RcyclerShowReview.setAdapter(restaurantReviewsAdapter);

        SwipSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onEndLess.current_page = 1;
                onEndLess.previous_page = 1;
                onEndLess.previousTotal = 0;
                max = max;


                reviewList.clear();
                RcyclerShowReview.setLayoutManager(new LinearLayoutManager(getContext()));
                restaurantReviewsAdapter = new RestaurantReviewsAdapter(getContext(), reviewList);
                RcyclerShowReview.setAdapter(restaurantReviewsAdapter);
                getReviews(restaurant_iddd, 1);

            }
        });
        getReviews(restaurant_iddd, 1);
    }

    private void getReviews(int i, int page) {
        if (InternetState.isConnected(getContext())) {

            // showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().getRestaurnReviews(i, page).enqueue(new Callback<RestaurntReviewe>() {
                @Override
                public void onResponse(Call<RestaurntReviewe> call, Response<RestaurntReviewe> response) {
                    try {
                        dismissProgressDialog();
                        SwipSwipeRefreshLayout.setRefreshing(false);
                        if (response.body().getStatus() == 1) {
                            reviewList.addAll(response.body().getData().getData());
                            Log.e("size review", reviewList.size() + "");
                            if (reviewList.size() == 0) {
                                Toast.makeText(getActivity(), "no reviews", Toast.LENGTH_LONG).show();
                            }
                            // Toast.makeText(getActivity(),s+"    gfgfgfgf",Toast.LENGTH_LONG).show();
                            max = response.body().getData().getLastPage();
                            restaurantReviewsAdapter.notifyDataSetChanged();
                        }

                    } catch (Exception e) {
                        SwipSwipeRefreshLayout.setRefreshing(false);
                        dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), false);
                    }
                }

                @Override
                public void onFailure(Call<RestaurntReviewe> call, Throwable t) {

                }
            });


        } else
            customToast(getActivity(), getResources().getString(R.string.offline), false);
    }


    @OnClick(R.id.fragment_get_restaurants_reviews_btn_addreview)
    public void onViewClicked() {
        ClientAddCommientDialogBox db = new ClientAddCommientDialogBox(getContext());
        // int id_res=reviewList.get(1).getRestaurantId();
        // db.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        db.restaurant_id = restaurant_iddd;
        db.setCanceledOnTouchOutside(true);
        db.show();
    }
}