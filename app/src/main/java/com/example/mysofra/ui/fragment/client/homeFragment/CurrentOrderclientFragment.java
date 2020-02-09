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
import static com.example.mysofra.helper.constant.USER_TYPE;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentOrderclientFragment extends Fragment {


    @BindView(R.id.fragment_current_orderclient_rc_rcyclerview)
    RecyclerView CurrentOrderclientRcRcyclerview;
    @BindView(R.id.fragment_current_orderclient_swprf_swiprefresh)
    SwipeRefreshLayout CurrentOrderclientSwprfSwiprefresh;
    Unbinder unbinder;
    private OnEndLess onEndLess;
    private CurrentOrderclientAdapter cAdapter;
    private int max;
    private List<ClientMyOrderDatum> clist = new ArrayList<>();

    String apiToken = CLIENT_API_TOKEN;
    private String STATE = "current";

    public CurrentOrderclientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_current_orderclient, container, false);
        unbinder = ButterKnife.bind(this, view);
        cAdapter = new CurrentOrderclientAdapter(getContext(), clist);


        initiRecy();

        return view;
    }

    private void initiRecy() {
        LinearLayoutManager li = new LinearLayoutManager(getContext());
        CurrentOrderclientRcRcyclerview.setLayoutManager(li);
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
        CurrentOrderclientRcRcyclerview.addOnScrollListener(onEndLess);
        cAdapter = new CurrentOrderclientAdapter(getContext(), clist);
        CurrentOrderclientRcRcyclerview.setAdapter(cAdapter);
        CurrentOrderclientSwprfSwiprefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onEndLess.current_page = 1;
                onEndLess.previous_page = 1;
                onEndLess.previousTotal = 0;
                max = 0;
                clist = new ArrayList<>();

                CurrentOrderclientRcRcyclerview.setLayoutManager(li);
                cAdapter = new CurrentOrderclientAdapter(getContext(), clist);
                CurrentOrderclientRcRcyclerview.setAdapter(cAdapter);
                getCurrentOrder(apiToken, STATE, 1);
            }
        });
        getCurrentOrder(apiToken, STATE, 1);
    }

    private void getCurrentOrder(String apiToken, String state, int page) {
        Log.e("current order", "in get new oreder");
        if (InternetState.isConnected(getContext())) {
            //  showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().getMyOredrClient(apiToken, state, page).enqueue(new Callback<ClientMyOrder>() {
                @Override
                public void onResponse(Call<ClientMyOrder> call, Response<ClientMyOrder> response) {
                    try {
                        //   dismissProgressDialog();
                        if (response.body().getStatus() == 1) {
                            CurrentOrderclientSwprfSwiprefresh.setRefreshing(false);
                            clist.addAll(response.body().getData().getData());
                            max = response.body().getData().getLastPage();
                            cAdapter.notifyDataSetChanged();
                            Toast.makeText(getActivity(), clist.size() + "    gfgfgfgf", Toast.LENGTH_LONG).show();
                            Log.e("current order", "in try");

                        }
                    } catch (Exception e) {
                        //   dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), false);
                    }
                }

                @Override
                public void onFailure(Call<ClientMyOrder> call, Throwable t) {
                    Log.e("current order", "in failure");
                    // dismissProgressDialog();
                    customToast(getActivity(), getResources().getString(R.string.error), true);
                }
            });
        } else
            customToast(getActivity(), getResources().getString(R.string.offline), false);
    }


}


