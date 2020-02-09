package com.example.mysofra.ui.fragment.client.homeFragment;


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
import com.example.mysofra.adapter.NotificationClientAdapter;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.clientNotification.ClientNotification;
import com.example.mysofra.data.model.clientNotification.ClientNotificationDatum;
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
import static com.example.mysofra.helper.constant.CLIENT_API_TOKEN;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationClientFragment extends BaseFragment {


    @BindView(R.id.fragment_notification_client_recy_recycler)
    RecyclerView recyRecycler;
    @BindView(R.id.fragment_notification_client_syp_swipe_refresh)
    SwipeRefreshLayout sypSwipeRefresh;
    private String api_token = CLIENT_API_TOKEN;
    private OnEndLess onEndLess;
    private int max;
    private List<ClientNotificationDatum> nList = new ArrayList<>();
    private NotificationClientAdapter mAdapter;
    private Unbinder unbind;

    public NotificationClientFragment() {
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
        mAdapter = new NotificationClientAdapter(getContext(), nList);
        recyRecycler.setAdapter(mAdapter);
        sypSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onEndLess.current_page = 1;
                onEndLess.previous_page = 1;
                onEndLess.previousTotal = 0;
                max = 0;
                nList = new ArrayList<>();
                mAdapter = new NotificationClientAdapter(getContext(), nList);
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
            RetrofitSofra.getInstance().getNotificationClient(api_token, i).enqueue(new Callback<ClientNotification>() {
                @Override
                public void onResponse(Call<ClientNotification> call, Response<ClientNotification> response) {
                    try {
                        dismissProgressDialog();
                        if (response.body().getStatus() == 1) {
                            sypSwipeRefresh.setRefreshing(false);
                            nList.addAll(response.body().getData().getData());
                            max = response.body().getData().getLastPage();
                            mAdapter.notifyDataSetChanged();
                      customToast(getActivity(),response.body().getMsg(),true);

                        }
                    } catch (Exception e) {
                        dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), false);
                    }
                }

                @Override
                public void onFailure(Call<ClientNotification> call, Throwable t) {
                    Log.e("notificatio", "in failure");
                    dismissProgressDialog();
                    Log.e("ggggg", "in failure  client noticfication" + t.toString());
                    customToast(getActivity(), getResources().getString(R.string.error), true);
                }
            });
        } else
            customToast(getActivity(), getResources().getString(R.string.offline), false);
    }

}
