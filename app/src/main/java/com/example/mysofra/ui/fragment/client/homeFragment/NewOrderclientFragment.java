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
import com.example.mysofra.adapter.NewOrderclientAdpter;
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
import static com.example.mysofra.helper.HelperMethod.dismissProgressDialog;
import static com.example.mysofra.helper.HelperMethod.showProgressDialog;
import static com.example.mysofra.helper.constant.CLIENT_API_TOKEN;
import static com.example.mysofra.helper.constant.USER_TYPE;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewOrderclientFragment extends Fragment {
    public NewOrderclientAdpter mAdapter;
    @BindView(R.id.fragment_new_orderclient_rc_rcyclerview)
    RecyclerView RcRcyclerview;
    @BindView(R.id.fragment_new_orderclient_swprf_swiprefresh)
    SwipeRefreshLayout SwprfSwiprefresh;
    Unbinder unbinder;
    private OnEndLess onEndLess;
    private int max;
    private List<ClientMyOrderDatum> mlist = new ArrayList<>();

    String apiToken = CLIENT_API_TOKEN;
    private String STATE = "pending";
    private LinearLayoutManager layoutManager;

    public NewOrderclientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_orderclient, container, false);
        unbinder = ButterKnife.bind(this, view);
        mlist = new ArrayList<>();

        mAdapter = new NewOrderclientAdpter(getContext(), mlist);
        initRec();
        return view;
    }

    private void initRec() {
        layoutManager = new LinearLayoutManager(getActivity());
        RcRcyclerview.setLayoutManager(layoutManager);
        onEndLess = new OnEndLess(layoutManager, 1) {
            @Override
            public void onLoadMore(int current_page) {
                if (current_page <= max) {
                    if (max != 0 && current_page != 1) {
                        onEndLess.previous_page = current_page;
                        getNewOrder(apiToken, STATE, current_page);

                    } else {
                        onEndLess.current_page = onEndLess.previous_page;
                    }

                }

            }
        };
        RcRcyclerview.addOnScrollListener(onEndLess);
        mAdapter = new NewOrderclientAdpter(getContext(), mlist);
        RcRcyclerview.setAdapter(mAdapter);
        SwprfSwiprefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onEndLess.current_page = 1;
                onEndLess.previous_page = 1;
                onEndLess.previousTotal = 0;
                max = 0;

                mlist.clear();
                mAdapter = new NewOrderclientAdpter(getContext(), mlist);
                RcRcyclerview.setAdapter(mAdapter);
                getNewOrder(apiToken, STATE, 1);
            }
        });

        getNewOrder(apiToken, STATE, 1);
    }

    private void getNewOrder(String apiToken, String state, int page) {
        Log.e("ggggg", "in get new oreder");
        if (InternetState.isConnected(getContext())) {
            showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().getMyOredrClient(apiToken, state, page).enqueue(new Callback<ClientMyOrder>() {
                @Override
                public void onResponse(Call<ClientMyOrder> call, Response<ClientMyOrder> response) {
                    try {
                        dismissProgressDialog();
                        if (response.body().getStatus() == 1) {
                            SwprfSwiprefresh.setRefreshing(false);
                            mlist.addAll(response.body().getData().getData());
                            max = response.body().getData().getLastPage();
                            mAdapter.notifyDataSetChanged();
                            Toast.makeText(getActivity(), mlist.size() + "    gfgfgfgf", Toast.LENGTH_LONG).show();
                            Log.e("ggggg", "in try");

                        }
                    } catch (Exception e) {
                        dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), false);
                    }
                }

                @Override
                public void onFailure(Call<ClientMyOrder> call, Throwable t) {
                    Log.e("ggggg", "in failure new oreder");
                    dismissProgressDialog();
                    customToast(getActivity(), getResources().getString(R.string.error), true);
                }
            });
        } else {
            customToast(getActivity(), getResources().getString(R.string.offline), false);
        }
    }


}
