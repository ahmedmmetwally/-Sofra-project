package com.example.mysofra.ui.fragment.restaurant;


import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mysofra.R;
import com.example.mysofra.adapter.PreviousOrderRestaurantAdapter;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.restaurantNewOrder.RestaurantNewOrder;
import com.example.mysofra.data.model.restaurantNewOrder.RestaurantNewOrderDatum;
import com.example.mysofra.helper.InternetState;
import com.example.mysofra.helper.OnEndLess;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mysofra.helper.HelperMethod.customToast;
import static com.example.mysofra.helper.HelperMethod.dismissProgressDialog;
import static com.example.mysofra.helper.HelperMethod.showProgressDialog;
import static com.example.mysofra.helper.constant.RESTAURANT_API_TOKEN;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreviousOrderRestaurantFragment extends Fragment {


    @BindView(R.id.fragment_previous_order_restaurant_rcy_recycler)
    RecyclerView rcyRecycler;
    @BindView(R.id.fragment_previous_order_restaurant_sypf_swipfresh)
    SwipeRefreshLayout sypfSwipFresh;
    Unbinder unbinder;
    private OnEndLess onEndLess;
    private int max;
    private List<RestaurantNewOrderDatum> mlist = new ArrayList<>();
    String apiToken = RESTAURANT_API_TOKEN;
    private String STATE = "completed";
    private LinearLayoutManager layoutManager;
    private PreviousOrderRestaurantAdapter mAdapter;

    public PreviousOrderRestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_previous_order_restaurant, container, false);
        unbinder = ButterKnife.bind(this, view);
        mlist = new ArrayList<>();

        mAdapter = new PreviousOrderRestaurantAdapter(getContext(), mlist);
        rcyRecycler.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.bottom = 10;

            }
        });
        initRec();
        return view;

    }

    private void initRec() {
        layoutManager = new LinearLayoutManager(getActivity());
        rcyRecycler.setLayoutManager(layoutManager);
        onEndLess = new OnEndLess(layoutManager, 1) {
            @Override
            public void onLoadMore(int current_page) {
                if (current_page <= max) {
                    if (max != 0 && current_page != 1) {
                        onEndLess.previous_page = current_page;
                        getNewRestaurantOrder(apiToken, STATE, current_page);

                    } else {
                        onEndLess.current_page = onEndLess.previous_page;
                    }

                }

            }
        };
        rcyRecycler.addOnScrollListener(onEndLess);
        mAdapter = new PreviousOrderRestaurantAdapter(getContext(), mlist);
        rcyRecycler.setAdapter(mAdapter);
        sypfSwipFresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onEndLess.current_page = 1;
                onEndLess.previous_page = 1;
                onEndLess.previousTotal = 0;
                max = 0;

                mlist.clear();
                mAdapter = new PreviousOrderRestaurantAdapter(getContext(), mlist);
                rcyRecycler.setAdapter(mAdapter);
                getNewRestaurantOrder(apiToken, STATE, 1);
            }
        });

        getNewRestaurantOrder(apiToken, STATE, 1);
    }

    private void getNewRestaurantOrder(String apiToken, String state, int page) {
        //  Log.e("ggggg", "in get new oreder");
        if (InternetState.isConnected(getContext())) {
            showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().getMyOredrRestaurant(apiToken, state, page).enqueue(new Callback<RestaurantNewOrder>() {
                @Override
                public void onResponse(Call<RestaurantNewOrder> call, Response<RestaurantNewOrder> response) {
                    try {
                        dismissProgressDialog();
                        if (response.body().getStatus() == 1) {
                            sypfSwipFresh.setRefreshing(false);
                            mlist.addAll(response.body().getData().getData());
                            max = response.body().getData().getLastPage();
                            mAdapter.notifyDataSetChanged();
                            Toast.makeText(getActivity(), mlist.size() + "new order restauratn", Toast.LENGTH_LONG).show();
                            //   Log.e("new order restauratn", "in try" + mlist.size());

                        }
                    } catch (Exception e) {
                        dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), false);
                    }
                }

                @Override
                public void onFailure(Call<RestaurantNewOrder> call, Throwable t) {
                    // Log.e("new order restauratn", "in failure");
                    Log.e("ggggg", "in failure  in RestaurantPreviousOrder " + t.toString());
                    dismissProgressDialog();
                    customToast(getActivity(), getResources().getString(R.string.error), true);
                }
            });
        } else {
            customToast(getActivity(), getResources().getString(R.string.offline), false);
        }
    }


}

