package com.example.mysofra.ui.fragment.client.homeFragment;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mysofra.R;
import com.example.mysofra.adapter.HomeFragmentAdapter;
import com.example.mysofra.data.api.RetrofitSofra;
import com.example.mysofra.data.model.city.City;
import com.example.mysofra.data.model.city.CityDatum;
import com.example.mysofra.data.model.listOfRestaurants.ListOfRestaurants;
import com.example.mysofra.data.model.listOfRestaurants.ListOfRestaurantsDatum;

import com.example.mysofra.data.model.restaurantsWithFiltre.RestaurantsWithFiltre;
import com.example.mysofra.helper.InternetState;
import com.example.mysofra.helper.OnEndLess;
import com.example.mysofra.ui.activity.StartUpActivity;
import com.example.mysofra.ui.fragment.BaseFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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


public class HomeFragmentt extends BaseFragment {

    @BindView(R.id.homeFragment_recycler_view)
    RecyclerView recyclerView;
    Unbinder unbinder;
    @BindView(R.id.fragment_home_btn_search)
    Button fragmentHomeBtnSearch;
    @BindView(R.id.fragment_home_edtL_word)
    EditText homeEdtLWord;
    @BindView(R.id.fragment_home_spn_city)
    Spinner HomeSpnCity;
    @BindView(R.id.homeFragment_swipe_fresh)
    SwipeRefreshLayout homeFragmentSwipeFresh;

    private OnEndLess onEndLess;
    //  private List<RestaurantsWithFiltreDatum> listOfRestaurantsFilter;
    private List<ListOfRestaurantsDatum> listOfRestaurantsData;
    private List<CityDatum> cityDataa;
    public ArrayList<String> cityName;
    private ArrayList<String> cityId;
    private String city_idd;
    private HomeFragmentAdapter mAdapter;
    private int max;
    public boolean filterRestaurantt = false;
    public boolean returnFromFilter;
    private String keyword;
    private LinearLayoutManager linearLayoutManager;


    public HomeFragmentt() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_homee, container, false);
        unbinder = ButterKnife.bind(this, view);
        // listOfRestaurantsFilter=new ArrayList<>();
        setUpActivity();


        listOfRestaurantsData = new ArrayList<>();
        cityId = new ArrayList<>();
        cityDataa = new ArrayList<>();
        cityName = new ArrayList<>();
        if (cityDataa.isEmpty()) {
            fillCity();
        }

        initRecycler();

//        methodCall(1, keyword, city_idd);
        getRestaurant(1);

        return view;
    }


    private void initRecycler() {
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.bottom = 10;
            }
        });
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        onEndLess = new OnEndLess(linearLayoutManager, 1) {
            @Override
            public void onLoadMore(int current_page) {

                if (current_page <= max) {
                    if (max != 0 && current_page != 1) {
                        onEndLess.previous_page = current_page;


                        methodCall(current_page, keyword, city_idd);


                    } else {
                        onEndLess.current_page = onEndLess.previous_page;
                    }

                } else onEndLess.current_page = onEndLess.previous_page;
            }
        };
        recyclerView.addOnScrollListener(onEndLess);
        mAdapter = new HomeFragmentAdapter(getContext(), getActivity(), listOfRestaurantsData);
        recyclerView.setAdapter(mAdapter);

        homeFragmentSwipeFresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onEndLess.current_page = 1;
                onEndLess.previous_page = 1;
                onEndLess.previousTotal = 0;
                max = 0;


                listOfRestaurantsData.clear();
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                mAdapter = new HomeFragmentAdapter(getContext(), getActivity(), listOfRestaurantsData);
                recyclerView.setAdapter(mAdapter);
                methodCall(1, keyword, city_idd);
            }
        });
    }

    private void fillCity() {
        cityDataa = new ArrayList<>();
        if (InternetState.isConnected(getContext())) {
            RetrofitSofra.getInstance().getCity().enqueue(new Callback<City>() {
                @Override
                public void onResponse(Call<City> call, Response<City> response) {

                    if (response.body().getStatus() == 1) {
                        cityDataa = response.body().getData().getData();
                        cityId.add("0");
                        cityName.add(getResources().getString(R.string.cityName));

                        for (int i = 1; i < cityDataa.size(); i++) {
                            cityName.add(cityDataa.get(i).getName());
                            cityId.add(String.valueOf(i));
                        }
                        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, cityName);
                        HomeSpnCity.setAdapter(arrayAdapter);
                        HomeSpnCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                city_idd = cityId.get(position);
                                getRegoinId(city_idd);

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });


                    }
                }

                @Override
                public void onFailure(Call<City> call, Throwable t) {
                    customToast(getActivity(), t.getMessage(), false);
                }
            });
        } else
            customToast(getActivity(), getResources().getString(R.string.offline), false);

    }

    private void getRegoinId(String city_idd) {

    }

    @OnClick(R.id.fragment_home_btn_search)
    public void onViewClicked() {
        filterRestaurantt = true;
        if (homeEdtLWord.getText() == null) {
            customToast(getActivity(), getResources().getString(R.string.please_fill_search_field), false);
            return;
        }
        if (city_idd.equals("0")) {
            customToast(getActivity(), getResources().getString(R.string.cityName), false);
            return;
        }
        keyword = homeEdtLWord.getText().toString().trim();
        methodCall(1, keyword, city_idd);

    }

    private void methodCall(int key, String keyword, String city_idd) {
        listOfRestaurantsData.clear();
        if (filterRestaurantt) {
            filterRestaurant(keyword, city_idd);
        } else {
            getRestaurant(key);
        }

    }


    private void filterRestaurant(String keyword, String city_idd) {
        if (InternetState.isConnected(getContext())) {

            showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().getRestaurantsWithfilter(keyword, city_idd).enqueue(new Callback<RestaurantsWithFiltre>() {
                @Override
                public void onResponse(Call<RestaurantsWithFiltre> call, Response<RestaurantsWithFiltre> response) {
                    try {
                        Log.e("ggggg", "in try  in get restaurant list");
                        dismissProgressDialog();
                        homeFragmentSwipeFresh.setRefreshing(false);
                        if (response.body().getStatus() == 1) {
                            listOfRestaurantsData.addAll(response.body().getData().getData());
                            max = response.body().getData().getLastPage();
                            mAdapter.notifyDataSetChanged();

                        }
                    } catch (Exception e) {
                        dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), false);
                        Log.e("ggggg", "in catch  in get restaurant list");
                    }


                }

                @Override
                public void onFailure(Call<RestaurantsWithFiltre> call, Throwable t) {
                    dismissProgressDialog();
                    customToast(getActivity(), getResources().getString(R.string.error) + "in failure", true);

                }
            });
        } else customToast(getActivity(), getResources().getString(R.string.offline), false);

    }

    private void getRestaurant(int page) {
        if (InternetState.isConnected(getContext())) {
            Log.e("ggggg", "in internetState  in get restaurant list");
            showProgressDialog(getActivity(), getResources().getString(R.string.waiit));
            RetrofitSofra.getInstance().getRestaurants(page).enqueue(new Callback<ListOfRestaurants>() {
                @Override
                public void onResponse(Call<ListOfRestaurants> call, Response<ListOfRestaurants> response) {
                    try {
                        Log.e("ggggg", "in try  in get restaurant list");
                        dismissProgressDialog();
                        homeFragmentSwipeFresh.setRefreshing(false);
                        if (response.body().getStatus() == 1) {
                            dismissProgressDialog();
                            listOfRestaurantsData.addAll(response.body().getData().getData());
                            max = response.body().getData().getLastPage();
                            mAdapter.notifyDataSetChanged();
                        } else
                            dismissProgressDialog();
                    } catch (Exception e) {
                        dismissProgressDialog();
                        customToast(getActivity(), response.body().getMsg(), false);
                        Log.e("ggggg", "in catch  in get restaurant list");
                    }
                }

                @Override
                public void onFailure(Call<ListOfRestaurants> call, Throwable t) {
                    Log.e("ggggg", "in failure  in get restaurant list" + t.toString());
                    dismissProgressDialog();
                    customToast(getActivity(), getResources().getString(R.string.error), true);
                }
            });

        } else {
            customToast(getActivity(), getResources().getString(R.string.offline), false);
            try {
                homeFragmentSwipeFresh.setRefreshing(false);
            } catch (Exception e) {


            }
        }
    }

    @Override
    public void onBack() {
        Intent intent1 = new Intent(this.baseActivity, StartUpActivity.class);
        startActivity(intent1);
    }
}



