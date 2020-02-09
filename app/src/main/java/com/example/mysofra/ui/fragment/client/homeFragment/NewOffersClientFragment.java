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
import com.example.mysofra.adapter.NewOffersClientAdapter;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.clientOffers.ClientOffers;
import com.example.mysofra.data.model.clientOffers.ClientOffersDatum;
import com.example.mysofra.helper.HelperMethod;
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
public class NewOffersClientFragment extends BaseFragment {


    @BindView(R.id.fragment_new_offer_restaurant_recy_recycler_view)
    RecyclerView recyRecyclerView;
    @BindView(R.id.fragment_new_offer_restaurant_syp_swipe_fresh)

    SwipeRefreshLayout sypSwipeFresh;
    private Unbinder unbinder;
    private NewOffersClientAdapter mAdapter;
    private OnEndLess onEndLess;
    private List<ClientOffersDatum> oList = new ArrayList<>();
    private int max;

    public NewOffersClientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_offer_client, container, false);
        unbinder = ButterKnife.bind(this, view);
        setUpActivity();
        mAdapter = new NewOffersClientAdapter(getContext(), oList);
        initRec();

        return view;
    }

    private void initRec() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyRecyclerView.setLayoutManager(linearLayoutManager);
        onEndLess = new OnEndLess(linearLayoutManager, 1) {
            @Override
            public void onLoadMore(int current_page) {
                if (current_page <= max) {
                    onEndLess.previous_page = onEndLess.current_page;
                    if (max != 0 && current_page != 1) {
                        getOffers(current_page);
                    } else onEndLess.current_page = onEndLess.previous_page;

                }

            }
        };
        recyRecyclerView.addOnScrollListener(onEndLess);
        mAdapter = new NewOffersClientAdapter(getContext(), oList);
        recyRecyclerView.setAdapter(mAdapter);

        sypSwipeFresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onEndLess.current_page = 1;
                onEndLess.previous_page = 1;
                onEndLess.previousTotal = 0;
                max = 0;

                oList.clear();
                mAdapter = new NewOffersClientAdapter(getContext(), oList);
                recyRecyclerView.setAdapter(mAdapter);

                getOffers(1);

            }
        });
        getOffers(1);
    }

    private void getOffers(int i) {
        Log.e("ggggg", "in get new offers");
        if (InternetState.isConnected(getContext())) {
            Log.e("ggggg", "in internetState  in get new offers");
            showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().getOffersClient(i).enqueue(new Callback<ClientOffers>() {
                @Override
                public void onResponse(Call<ClientOffers> call, Response<ClientOffers> response) {
                    try {
                        dismissProgressDialog();
                        if (response.body().getStatus() == 1) {
                            sypSwipeFresh.setRefreshing(false);
                            oList.addAll(response.body().getData().getData());
                            max = response.body().getData().getLastPage();
                            mAdapter.notifyDataSetChanged();
                            Toast.makeText(getActivity(), oList.size() + " in get new offer   gfgfgfgf", Toast.LENGTH_LONG).show();
                            Log.e("in get new offer  ggggg", "in try");

                        }
                    } catch (Exception e) {
                        dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), false);
                    }
                }

                @Override
                public void onFailure(Call<ClientOffers> call, Throwable t) {
                    Log.e("ggggg", "in failure      in get new offer");
                    dismissProgressDialog();
                    customToast(getActivity(), getResources().getString(R.string.error), true);
                }
            });
        } else {
            customToast(getActivity(), getResources().getString(R.string.offline), false);
        }
    }


}
