package com.example.mysofra.ui.fragment.restaurant;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mysofra.R;
import com.example.mysofra.adapter.RestaurantMyCategoriesnAdapter;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.restaurantMYCategories.RestaurantMYCategories;
import com.example.mysofra.data.model.restaurantMYCategories.RestaurantMYCategoriesDatum;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.helper.InternetState;
import com.example.mysofra.helper.OnEndLess;
import com.example.mysofra.ui.RestaurantNewCategoryCustomDialog;
import com.example.mysofra.ui.activity.RestaurantHomeActivity;
import com.example.mysofra.ui.activity.StartUpActivity;
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
public class RestaurantMyCategoriesFragmet extends BaseFragment {


    @BindView(R.id.fragment_home_restaurt_fragmetn_rcy_recycler)
    RecyclerView recyRecycler;
    @BindView(R.id.fragment_home_restaurt_fragmetn_sypf_swipFresh)
    SwipeRefreshLayout SypfSwipFresh;
    @BindView(R.id.fragment_home_restaurt_fragmetn_fbtn_btnnnew)
    FloatingActionButton fragmentHomeRestaurtFragmetnFbtnBtnnnew;
    private String api_token = RESTAURANT_API_TOKEN;
    Unbinder unbinder;
    private OnEndLess onEndLess;
    private int max;
    private List<RestaurantMYCategoriesDatum> listMyCategoris;
    private RestaurantMyCategoriesnAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_categories_restaurt_fragmetn, container, false);
        unbinder = ButterKnife.bind(this, view);
        setUpActivity();
        listMyCategoris = new ArrayList<>();
        mAdapter = new RestaurantMyCategoriesnAdapter(getContext(), getActivity(), listMyCategoris, api_token);
        mAdapter.setMYOnCategoryClickListener(new RestaurantMyCategoriesnAdapter.OnMYCategoryClickListener() {
            @Override
            public void goToMyItem(RestaurantMYCategoriesDatum my_Cat_ist) {
                MyItemFragment myItemFragment = new MyItemFragment();
                myItemFragment.api_token = api_token;
                myItemFragment.category_id = my_Cat_ist.getId();
                HelperMethod.ReplaceFragment(getChildFragmentManager()
                        , myItemFragment, R.id.activity_restaurant_home_frame_fragment
                        , null, null);
            }
        });
        intRecyler();
        return view;
    }

    private void intRecyler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyRecycler.setLayoutManager(linearLayoutManager);
        recyRecycler.setHasFixedSize(true);
        onEndLess = new OnEndLess(linearLayoutManager, 1) {
            @Override
            public void onLoadMore(int current_page) {
                if (current_page <= max) {
                    if (max != 0 && current_page != 1) {
                        onEndLess.previous_page = current_page;


                    } else {
                        onEndLess.current_page = onEndLess.previous_page;
                    }

                }

            }
        };
        recyRecycler.addOnScrollListener(onEndLess);
        mAdapter = new RestaurantMyCategoriesnAdapter(getContext(), getActivity(), listMyCategoris, api_token);
        recyRecycler.setAdapter(mAdapter);
        SypfSwipFresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onEndLess.current_page = 1;
                onEndLess.previous_page = 1;
                onEndLess.previousTotal = 0;
                max = 0;
                listMyCategoris.clear();
                mAdapter = new RestaurantMyCategoriesnAdapter(getContext(), getActivity(), listMyCategoris, api_token);
                recyRecycler.setAdapter(mAdapter);
                getMyCategorisRestaurant();

            }
        });
        getMyCategorisRestaurant();

    }

    private void getMyCategorisRestaurant() {
        if (InternetState.isConnected(getContext())) {
            showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().getMyCategoriesRestauratn(api_token,
                    1).enqueue(new Callback<RestaurantMYCategories>() {
                @Override
                public void onResponse(Call<RestaurantMYCategories> call, Response<RestaurantMYCategories> response) {
                    try {
                        dismissProgressDialog();
                        if (response.body().getStatus() == 1) {
                            SypfSwipFresh.setRefreshing(false);
                            listMyCategoris.addAll(response.body().getData().getData());
                            mAdapter.notifyDataSetChanged();
                            Log.e("my categries restauratn", "in try: " + listMyCategoris.size());


                        }
                    } catch (Exception e) {
                        dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), false);


                    }

                }

                @Override
                public void onFailure(Call<RestaurantMYCategories> call, Throwable t) {
                    dismissProgressDialog();
                    customToast(getActivity(), getResources().getString(R.string.error), true);


                }
            });
        } else {
            customToast(getActivity(), getResources().getString(R.string.offline), false);
        }

    }


    @OnClick({R.id.fragment_home_restaurt_fragmetn_fbtn_btnnnew, R.id.fragment_home_restaurt_fragmetn_rcy_recycler})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_home_restaurt_fragmetn_fbtn_btnnnew:
                RestaurantNewCategoryCustomDialog restaurantNewCategoryCustomDialog = new RestaurantNewCategoryCustomDialog(getContext());
                restaurantNewCategoryCustomDialog.setCanceledOnTouchOutside(true);
                restaurantNewCategoryCustomDialog.show();

                break;
            case R.id.fragment_home_restaurt_fragmetn_rcy_recycler:

                break;
        }
    }

    @Override
    public void onBack() {
        Intent intent1 = new Intent(this.baseActivity, StartUpActivity.class);
        startActivity(intent1);
    }
}
