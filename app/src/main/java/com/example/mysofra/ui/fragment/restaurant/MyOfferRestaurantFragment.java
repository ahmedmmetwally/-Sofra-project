package com.example.mysofra.ui.fragment.restaurant;


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
import com.example.mysofra.adapter.MyOfferRestaurantAdapter;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.restaurantMyOffer.RestaurantMyOffer;
import com.example.mysofra.data.model.restaurantMyOffer.RestaurantMyOfferDatum;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.helper.InternetState;
import com.example.mysofra.helper.OnEndLess;
import com.example.mysofra.ui.fragment.BaseFragment;
import com.example.mysofra.ui.fragment.restaurant.restaurantCycle.MoreRestaurantFragment;

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
import static com.example.mysofra.helper.HelperMethod.showProgressDialog;
import static com.example.mysofra.helper.constant.RESTAURANT_API_TOKEN;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyOfferRestaurantFragment extends BaseFragment {


    @BindView(R.id.fragment_new_offer_restaurant_rc_recycler_view)
    RecyclerView rcRecyclerView;
    @BindView(R.id.fragment_new_offer_restaurant_btn_add_new_offer)
    Button btnAddNewOffer;
    @BindView(R.id.fragment_new_offer_restaurant_sf_swipe_refresh)
    SwipeRefreshLayout sfSwipeRefresh;
    private Unbinder unbinder;
    private OnEndLess onEndLess;
    private int max;
    private MyOfferRestaurantAdapter myOfferRestaurantAdapter;
    private List<RestaurantMyOfferDatum> mlist;
    private String api_token = RESTAURANT_API_TOKEN;

    public MyOfferRestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_offer_restaurant, container, false);
        unbinder = ButterKnife.bind(this, view);
        setUpActivity();
        mlist = new ArrayList<>();
        initRec();
        return view;
    }

    private void initRec() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        onEndLess = new OnEndLess(layoutManager, 1) {
            @Override
            public void onLoadMore(int current_page) {
                if (current_page <= max) {
                    if (max != 0 && current_page != 1) {
                        onEndLess.previous_page = current_page;
                        getMyOffer(api_token, current_page);

                    } else {
                        onEndLess.current_page = onEndLess.previous_page;
                    }

                }

            }
        };
        rcRecyclerView.addOnScrollListener(onEndLess);
        myOfferRestaurantAdapter = new MyOfferRestaurantAdapter(getContext(), mlist, api_token);
        rcRecyclerView.setLayoutManager(layoutManager);
        rcRecyclerView.setAdapter(myOfferRestaurantAdapter);
        sfSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onEndLess.current_page = 1;
                onEndLess.previous_page = 1;
                onEndLess.previousTotal = 0;
                max = 0;

                mlist.clear();
                myOfferRestaurantAdapter = new MyOfferRestaurantAdapter(getContext(), mlist, api_token);
                rcRecyclerView.setLayoutManager(layoutManager);
                getMyOffer(api_token, 1);
            }
        });

        getMyOffer(api_token, 1);
    }

    private void getMyOffer(String api_token, int current_page) {
        Log.e("ggggg", "in get my offer oreder");
        if (InternetState.isConnected(getContext())) {
            showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().getMyOfferRestaurant(api_token, current_page).enqueue(new Callback<RestaurantMyOffer>() {
                @Override
                public void onResponse(Call<RestaurantMyOffer> call, Response<RestaurantMyOffer> response) {
                    try {
                        dismissProgressDialog();
                        if (response.body().getStatus() == 1) {
                            sfSwipeRefresh.setRefreshing(false);
                            mlist.addAll(response.body().getData().getData());
                            max = response.body().getData().getLastPage();
                            myOfferRestaurantAdapter.notifyDataSetChanged();
                            Toast.makeText(getActivity(), mlist.size() + "new order restauratn", Toast.LENGTH_LONG).show();
                            Log.e("new order restauratn", "in try" + mlist.size());

                        }
                    } catch (Exception e) {
                        dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), false);
                    }
                }

                @Override
                public void onFailure(Call<RestaurantMyOffer> call, Throwable t) {
                    Log.e("new order restauratn", "in failure" + t.toString());
                    dismissProgressDialog();
                    customToast(getActivity(), getResources().getString(R.string.error), true);
                }
            });

        } else {
            customToast(getActivity(), getResources().getString(R.string.offline), false);
        }
    }

    @OnClick(R.id.fragment_new_offer_restaurant_btn_add_new_offer)
    public void onViewClicked() {
        HelperMethod.ReplaceFragment(getFragmentManager(), new AddNewOfferFragment()
                , R.id.activity_restaurant_home_frame_fragment, null, null);
    }

}
