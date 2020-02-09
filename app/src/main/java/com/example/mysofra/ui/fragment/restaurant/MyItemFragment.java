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
import com.example.mysofra.adapter.MyItemAdapter;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.restaurantMyItem.RestaurantMyItem;
import com.example.mysofra.data.model.restaurantMyItem.RestaurantMyItemDatum;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.helper.InternetState;
import com.example.mysofra.helper.OnEndLess;
import com.example.mysofra.ui.fragment.BaseFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
public class MyItemFragment extends BaseFragment {


    @BindView(R.id.fragment_my_item_rcy_recycler)
    RecyclerView rcyRecycler;
    @BindView(R.id.fragment_my_item_sypf_swipefresh)
    SwipeRefreshLayout sypfSwipefresh;
    @BindView(R.id.fragment_my_item_fbtn_Button_add_new_item)
    FloatingActionButton fbtnButtonAddNewItem;
    private Unbinder nubind;
    public String api_token = RESTAURANT_API_TOKEN;
    public int category_id = 19;
    private MyItemAdapter myItemAdapter;
    private List<RestaurantMyItemDatum> iList = new ArrayList<>();
    private OnEndLess onEndLess;
    private int max;

    public MyItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_item, container, false);
        nubind = ButterKnife.bind(this, view);
        setUpActivity();
        myItemAdapter = new MyItemAdapter(getContext(), iList, api_token);
        initRec();
        myItemAdapter.setMYOnItemClickListener(new MyItemAdapter.OnMYItemClickListener() {
            @Override
            public void onImgEditclick(RestaurantMyItemDatum my_itemlist) {
                HelperMethod.ReplaceFragment(getChildFragmentManager(), new UpdateItemFragment(my_itemlist.getDescription(),
                        my_itemlist.getPrice(), my_itemlist.getName(), my_itemlist.getPhotoUrl(), my_itemlist.getId(), api_token,
                        my_itemlist.getOfferPrice(), category_id), R.id.activity_restaurant_home_frame_fragment, null, null);
            }
        });
        return view;
    }

    private void initRec() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcyRecycler.setLayoutManager(linearLayoutManager);
        onEndLess = new OnEndLess(linearLayoutManager, 1) {
            @Override
            public void onLoadMore(int current_page) {
                if (current_page <= max) {
                    if (max != 0 && current_page != 1) {
                        getMyItem(api_token, category_id, current_page);
                    } else {
                        onEndLess.current_page = onEndLess.previous_page;
                    }
                }

            }
        };
        rcyRecycler.addOnScrollListener(onEndLess);
        myItemAdapter = new MyItemAdapter(getContext(), iList, api_token);
        rcyRecycler.setAdapter(myItemAdapter);
        sypfSwipefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onEndLess.previous_page = 1;
                onEndLess.current_page = 1;
                onEndLess.previousTotal = 0;
                max = 0;

                iList.clear();
                myItemAdapter = new MyItemAdapter(getContext(), iList, api_token);
                rcyRecycler.setAdapter(myItemAdapter);
                getMyItem(api_token, category_id, 1);
            }
        });
        getMyItem(api_token, category_id, 1);
    }

    private void getMyItem(String api_token, int category_id, int current_page) {
        Log.e("ggggg", "in get my offer oreder");
        if (InternetState.isConnected(getContext())) {
            showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().getMyItemRestaurant(api_token, category_id, current_page).enqueue(new Callback<RestaurantMyItem>() {
                @Override
                public void onResponse(Call<RestaurantMyItem> call, Response<RestaurantMyItem> response) {
                    try {
                        dismissProgressDialog();
                        if (response.body().getStatus() == 1) {
                            sypfSwipefresh.setRefreshing(false);
                            iList.addAll(response.body().getData().getData());
                            max = response.body().getData().getLastPage();
                            myItemAdapter.notifyDataSetChanged();
                            Toast.makeText(getActivity(), iList.size() + "new order restauratn", Toast.LENGTH_LONG).show();
                            Log.e("new order restauratn", "in try" + iList.size());

                        }
                    } catch (Exception e) {
                        dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), false);
                    }
                }

                @Override
                public void onFailure(Call<RestaurantMyItem> call, Throwable t) {
                    Log.e("new order restauratn", "in failure");
                    dismissProgressDialog();
                    customToast(getActivity(), getResources().getString(R.string.error), true);
                }
            });

        } else {
            customToast(getActivity(), getResources().getString(R.string.offline), false);
        }
    }


    @OnClick(R.id.fragment_my_item_fbtn_Button_add_new_item)
    public void onViewClicked() {
        HelperMethod.ReplaceFragment(getChildFragmentManager(), new AddItemFragment(api_token, category_id)
                , R.id.activity_restaurant_home_frame_fragment, null, null);
    }

}
