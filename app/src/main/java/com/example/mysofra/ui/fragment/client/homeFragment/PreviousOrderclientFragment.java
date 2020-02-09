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
import com.example.mysofra.adapter.CurrentOrderclientAdapter;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.clientModel.clientMyOrder.ClientMyOrder;
import com.example.mysofra.data.model.clientModel.clientMyOrder.ClientMyOrderDatum;
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
import static com.example.mysofra.helper.constant.CLIENT_API_TOKEN;


public class PreviousOrderclientFragment extends Fragment {


    Unbinder unbinder;
    @BindView(R.id.fragment_previous_orderclient_rc_rcyclerview)
    RecyclerView PreviousOrderclientRcRcyclerview;
    @BindView(R.id.fragment_previous_orderclient_swprf_swiprefresh)
    SwipeRefreshLayout fragPreviousOrderclientSwprfSwiprefresh;
    private OnEndLess onEndLess;
    private CurrentOrderclientAdapter pAdapter;
    private int max;
    private List<ClientMyOrderDatum> plist = new ArrayList<>();

    String apiToken = CLIENT_API_TOKEN;
    private String STATE = "pending";

    public PreviousOrderclientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_previous_orderclient, container, false);
        unbinder = ButterKnife.bind(this, view);
        plist = new ArrayList<>();

        pAdapter = new CurrentOrderclientAdapter(getContext(), plist);
        initiRecyy();
        return view;
    }

    private void initiRecyy() {
        LinearLayoutManager li = new LinearLayoutManager(getContext());
        PreviousOrderclientRcRcyclerview.setLayoutManager(li);
        onEndLess = new OnEndLess(li, 1) {
            @Override
            public void onLoadMore(int current_page) {
                if (current_page <= max) {
                    if (max != 0 && current_page != 1) {
                        onEndLess.previous_page = current_page;
                        getCurrentOrder(apiToken, STATE, current_page);

                    } else {
                        onEndLess.current_page = onEndLess.previous_page;
                    }

                }
            }
        };
        PreviousOrderclientRcRcyclerview.addOnScrollListener(onEndLess);
        pAdapter = new CurrentOrderclientAdapter(getContext(), plist);
        PreviousOrderclientRcRcyclerview.setAdapter(pAdapter);
        fragPreviousOrderclientSwprfSwiprefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onEndLess.current_page = 1;
                onEndLess.previous_page = 1;
                onEndLess.previousTotal = 0;
                max = 0;
                plist = new ArrayList<>();

                PreviousOrderclientRcRcyclerview.setLayoutManager(li);
                pAdapter = new CurrentOrderclientAdapter(getContext(), plist);
                PreviousOrderclientRcRcyclerview.setAdapter(pAdapter);
                getCurrentOrder(apiToken, STATE, 1);
            }
        });
        getCurrentOrder(apiToken, STATE, 1);
    }

    private void getCurrentOrder(String apiToken, String state, int page) {
        Log.e("previous order", "in get new oreder");
        if (InternetState.isConnected(getContext())) {
            //  showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().getMyOredrClient(apiToken, state, page).enqueue(new Callback<ClientMyOrder>() {
                @Override
                public void onResponse(Call<ClientMyOrder> call, Response<ClientMyOrder> response) {
                    try {
                        //   dismissProgressDialog();
                        if (response.body().getStatus() == 1) {
                            fragPreviousOrderclientSwprfSwiprefresh.setRefreshing(false);
                            plist.addAll(response.body().getData().getData());
                            max = response.body().getData().getLastPage();
                            pAdapter.notifyDataSetChanged();
                            Toast.makeText(getActivity(), plist.size() + "    gfgfgfgf", Toast.LENGTH_LONG).show();
                            Log.e("previous order", "in try");

                        }
                    } catch (Exception e) {
                        //   dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), false);
                    }
                }

                @Override
                public void onFailure(Call<ClientMyOrder> call, Throwable t) {
                    Log.e("previous order", "in failure");
                    // dismissProgressDialog();
                    customToast(getActivity(), getResources().getString(R.string.error), true);
                }
            });
        } else
            customToast(getActivity(), getResources().getString(R.string.offline), false);
    }


}
