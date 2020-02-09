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
import com.example.mysofra.adapter.RestaurantCategoriesAdapter;
import com.example.mysofra.adapter.RestaurntItemAdapter;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.restaurntCategories.RestaurntCategories;
import com.example.mysofra.data.model.restaurntCategories.RestaurntCategoriesDatum;
import com.example.mysofra.data.model.restaurntItem.RestaurntItem;
import com.example.mysofra.data.model.restaurntItem.RestaurntItemDatum;
import com.example.mysofra.helper.HelperMethod;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class GetRestaurantsItemAndCategoryFoodFragment extends Fragment {


    @BindView(R.id.fragment_get_restaurants_itemfood_rcy_category)
    RecyclerView RcyCategory;
    @BindView(R.id.fragment_get_restaurants_itemfood_rcy_item)
    RecyclerView RcyItem;
    @BindView(R.id.fragment_get_restaurants_itemfood_swip_fresh_item)
    SwipeRefreshLayout SwipFreshItem;
    private RestaurntItemAdapter restaurntItemAdapter;
    private RestaurantCategoriesAdapter restaurantCategoriesAdapter;
    private List<RestaurntItemDatum> itemList = new ArrayList<>();
    private OnEndLess onEndLess;
    private int max;
    private List<RestaurntCategoriesDatum> categoryList = new ArrayList<>();
    public int restaurantId = 1;
    private int category_id = -1;
    private Unbinder unbinder;

    public GetRestaurantsItemAndCategoryFoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_get_restaurants_itemfood, container, false);
        unbinder = ButterKnife.bind(this, view);
        restaurntItemAdapter = new RestaurntItemAdapter(getContext(), itemList);
        restaurantCategoriesAdapter = new RestaurantCategoriesAdapter(getContext(), categoryList);

        initRecycleCategory();
        initRcyclItem();

        restaurantCategoriesAdapter.setOnCategrylistener(new RestaurantCategoriesAdapter.OnCategoryClickListener() {
            @Override
            public void onMyCategoryClick(RestaurntCategoriesDatum supDatum) {
                category_id = supDatum.getId();
                HelperMethod.customToast(getActivity(), "++++++catergory_id=" + category_id + "+++++", true);
                Log.e("rest_id_Clicked is:", "++++++catergory_id=" + category_id + "");
                initRecycleCategory();
                initRcyclItem();

            }
        });
        restaurntItemAdapter.setOnCategoryClickListener(new RestaurntItemAdapter.OnCategoryClickListener() {
            @Override
            public void onItemclick(RestaurntItemDatum note) {
                MakeOrder4Fragment makeOrder4Fragment = new MakeOrder4Fragment();
                makeOrder4Fragment.data = note;
                HelperMethod.ReplaceFragment(getActivity().getSupportFragmentManager()
                        , makeOrder4Fragment, R.id.activity_home_client_frame_fragment, null, null);
            }
        });
        return view;
    }


    private void initRecycleCategory() {
        LinearLayoutManager layoutManagerr = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, true);
        RcyCategory.setLayoutManager(layoutManagerr);
        restaurantCategoriesAdapter = new RestaurantCategoriesAdapter(getContext(), categoryList);
        RcyCategory.setAdapter(restaurantCategoriesAdapter);

        getCategoires(restaurantId);
    }


    private void initRcyclItem() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RcyItem.setLayoutManager(layoutManager);

        onEndLess = new OnEndLess(layoutManager, 1) {
            @Override
            public void onLoadMore(int current_page) {

                if (current_page <= max) {
                    if (max != 0 && current_page != 1) {
                        onEndLess.previous_page = current_page;

                        getItem(restaurantId, category_id, current_page);


                    } else {
                        onEndLess.current_page = onEndLess.previous_page;
                    }

                }
            }
        };
        RcyItem.addOnScrollListener(onEndLess);
        restaurntItemAdapter = new RestaurntItemAdapter(getContext(), itemList);
        RcyItem.setAdapter(restaurntItemAdapter);
        SwipFreshItem.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onEndLess.current_page = 1;
                onEndLess.previous_page = 1;
                onEndLess.previousTotal = 0;
                max = 0;
                itemList.clear();
                RcyItem.setLayoutManager(layoutManager);
                restaurntItemAdapter = new RestaurntItemAdapter(getContext(), itemList);
                RcyItem.setAdapter(restaurntItemAdapter);
                getCategoires(restaurantId);
                getItem(restaurantId, category_id, 1);
            }
        });

        getItem(restaurantId, category_id, 1);
    }

    private void getCategoires(int res_id) {
        if (InternetState.isConnected(getContext())) {
            Log.i("ttttttttttttt", "getcccatttttt");
            //  showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().getRestaurantCategories(res_id).enqueue(new Callback<RestaurntCategories>() {
                @Override
                public void onResponse(Call<RestaurntCategories> call, Response<RestaurntCategories> response) {
                    try {
                        Log.i("ttttttttttttt", "getcccatttttt222222222222");
                        dismissProgressDialog();
                        if (response.body().getStatus() == 1) {
                            categoryList = response.body().getData();
                            restaurantCategoriesAdapter.notifyDataSetChanged();
                            Log.i("ttttttttttttt", "getcccatttttt222222222222size" + categoryList.size());
                        }
                    } catch (Exception e) {
                        dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), false);
                    }
                }

                @Override
                public void onFailure(Call<RestaurntCategories> call, Throwable t) {
                    dismissProgressDialog();
                    Toast.makeText(getActivity(), "getCategoires failure", Toast.LENGTH_LONG).show();


                }
            });
        } else customToast(getActivity(), getResources().getString(R.string.offline), false);
    }

    private void getItem(int restaurantIId, int ccategory_id, int page) {
        Log.i("ttttttttttttt", "getiiiiiiiitttttt");
        if (InternetState.isConnected(getContext())) {
            //showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().getRestaurantsItems(1, -1, page).enqueue(new Callback<RestaurntItem>() {
                @Override
                public void onResponse(Call<RestaurntItem> call, Response<RestaurntItem> response) {
                    try {
                        Log.i("ttttttttttttt", "getiiiiiiiitttttt222222222");
                        dismissProgressDialog();
                        SwipFreshItem.setRefreshing(false);
                        if (response.body().getStatus() == 1) {
                            itemList = response.body().getData().getData();
                            //  max = response.body().getData().getLastPage();
                            restaurntItemAdapter.notifyDataSetChanged();
                        }
                    } catch (Exception e) {
                        dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), false);

                    }
                }

                @Override
                public void onFailure(Call<RestaurntItem> call, Throwable t) {
                    dismissProgressDialog();
                    Toast.makeText(getActivity(), "getItem failuer", Toast.LENGTH_LONG).show();
                }
            });

        } else {

            try {
                SwipFreshItem.setRefreshing(false);
                customToast(getActivity(), getResources().getString(R.string.offline), false);
            } catch (Exception e) {


            }
        }
    }

}
