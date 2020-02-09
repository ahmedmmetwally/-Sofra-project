package com.example.mysofra.ui.fragment.restaurant;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mysofra.R;
import com.example.mysofra.adapter.NotificationRestaurantAdapter;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.restaurantNotification.RestaurantNotification;
import com.example.mysofra.data.model.restaurantNotification.RestaurantNotificationDatum;
import com.example.mysofra.helper.InternetState;
import com.example.mysofra.helper.OnEndLess;
import com.example.mysofra.ui.fragment.BaseFragment;

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

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationRestaurant extends BaseFragment {


    @BindView(R.id.fragment_notification_client_recy_recycler)
    RecyclerView recyRecycler;
    @BindView(R.id.fragment_notification_client_syp_swipe_refresh)
    SwipeRefreshLayout sypSwipeRefresh;
    private String api_token = "Jptu3JVmDXGpJEaQO9ZrjRg5RuAVCo45OC2AcOKqbVZPmu0ZJPN3T1sm0cWx";
    private OnEndLess onEndLess;
    private int max;
    private List<RestaurantNotificationDatum> nList = new ArrayList<>();
    private NotificationRestaurantAdapter mAdapter;
    private Unbinder unbind;

    public NotificationRestaurant() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification_client, container, false);
        unbind = ButterKnife.bind(this, view);
        setUpActivity();
        initRec();
        return view;
    }

    private void initRec() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyRecycler.setLayoutManager(linearLayoutManager);
        onEndLess = new OnEndLess(linearLayoutManager, 1) {
            @Override
            public void onLoadMore(int current_page) {
                if (current_page <= max) {
                    if (max != 0 && current_page != 1) {
                        onEndLess.previous_page = current_page;
                        getNotification(api_token, current_page);
                    } else {
                        onEndLess.current_page = onEndLess.previous_page;
                    }
                }

            }
        };
        recyRecycler.addOnScrollListener(onEndLess);
        mAdapter = new NotificationRestaurantAdapter(getContext(), nList);
        recyRecycler.setAdapter(mAdapter);
        sypSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onEndLess.current_page = 1;
                onEndLess.previous_page = 1;
                onEndLess.previousTotal = 0;
                max = 0;
                nList = new ArrayList<>();
                mAdapter = new NotificationRestaurantAdapter(getContext(), nList);
                recyRecycler.setAdapter(mAdapter);
                getNotification(api_token, 1);
            }
        });
        getNotification(api_token, 1);
    }

    private void getNotification(String api_token, int i) {
        Log.e("previous order", "notificatior");
        if (InternetState.isConnected(getContext())) {
            showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().getNotificationRestaurant(api_token, i).enqueue(new Callback<RestaurantNotification>() {
                @Override
                public void onResponse(Call<RestaurantNotification> call, Response<RestaurantNotification> response) {
                    try {
                        dismissProgressDialog();
                        if (response.body().getStatus() == 1) {
                            Log.e("notificatio res", response.body().getMsg() + "in try");
                            sypSwipeRefresh.setRefreshing(false);
                            nList.addAll(response.body().getData().getData());
                            max = response.body().getData().getLastPage();
                            mAdapter.notifyDataSetChanged();
                            Toast.makeText(getActivity(), nList.size() + "    notificatio", Toast.LENGTH_LONG).show();
                            Log.e("notificatio", "in try");

                        }
                    } catch (Exception e) {
                        dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), false);
                    }
                }

                @Override
                public void onFailure(Call<RestaurantNotification> call, Throwable t) {
                    Log.e("notificatio res failure", t + "in failure");
                    dismissProgressDialog();
                    customToast(getActivity(), getResources().getString(R.string.error), true);
                }
            });
        } else
            customToast(getActivity(), getResources().getString(R.string.offline), false);
    }

}

