package com.example.mysofra.ui.fragment.client.homeFragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mysofra.R;
import com.example.mysofra.adapter.ConfirmOrderFromRoomAdater;
import com.example.mysofra.data.local.SharedPreferencesManger;
import com.example.mysofra.data.model.Note;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.ui.fragment.BaseFragment;
import com.example.mysofra.ui.fragment.client.homeFragment.roomm.NoteViewModel;
import com.example.mysofra.ui.fragment.client.clientCycle.LoginClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.mysofra.data.local.SharedPreferencesManger.TOTAL_PRICEE;
import static com.example.mysofra.helper.constant.TOTAL_PRICE_cons;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmOrderFromRoomFragment extends BaseFragment {


    public MakeOrder4Fragment makeOrder4Fragment;
    @BindView(R.id.fragment_confirm_order_from_room_recy_recycler_view)
    RecyclerView recyRecyclerView;
    @BindView(R.id.fragment_confirm_order_from_room_swip_fresh)
    SwipeRefreshLayout swipFresh;
    @BindView(R.id.fragment_confirm_order_from_room_txt_total)
    TextView txtTotal;
    @BindView(R.id.fragment_confirm_order_from_room_btn_add_more)
    Button btnAddMore;
    @BindView(R.id.fragment_confirm_order_from_room_btn_add_confirm)
    Button btnAddConfirm;
    private Unbinder unbind;
    private NoteViewModel noteViewModel;
    private Note note_update;
    private ConfirmOrderFromRoomAdater adapter;
    private NewOrderDetails7Fragment newOrderDetails7Fragment;
    private List<Note> notess = new ArrayList<>();
    private int restaurant_id;

    public ConfirmOrderFromRoomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirm_order_from_room, container, false);
        unbind = ButterKnife.bind(this, view);
        setUpActivity();
        TOTAL_PRICE_cons = SharedPreferencesManger.LoadFloatData(getActivity(), TOTAL_PRICEE);
        newOrderDetails7Fragment = new NewOrderDetails7Fragment();
        recyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ConfirmOrderFromRoomAdater(getContext());
        recyRecyclerView.setAdapter(adapter);
        recyRecyclerView.setHasFixedSize(true);
        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                adapter.setNotes(notes);
                //newOrderDetails7Fragment.nList = notes;
                notess.addAll(notes);

            }
        });


        adapter.setOnItemClickListener(new ConfirmOrderFromRoomAdater.OnItemClickListener() {
            @Override
            public void onItemclick(Note note, Float total_price, int quantity, String status) {
                restaurant_id = note.getRestaurant_id();
                TOTAL_PRICE_cons = total_price;
                int id = note.getId();
                String photo = note.getPhoto_url();
                String restaurant_name = note.getRestaurantName();
                String name = note.getItmeName();
                Float price = note.getPrice();
                String special_order = note.getSpecialOrder();
                Log.e("+++++++++++", total_price + "");
                txtTotal.setText(TOTAL_PRICE_cons + "");
                SharedPreferencesManger.saveTotalPrice(getActivity(), TOTAL_PRICE_cons);


                if (status.equals("delete")) {
                    noteViewModel.delete(note);
                }
                if (status.equals("update")) {
                    note_update = new Note(restaurant_id, photo, restaurant_name, name, price, special_order, quantity);
                    note_update.setId(id);
                    noteViewModel.update(note_update);

                }


            }
        });
        txtTotal.setText(TOTAL_PRICE_cons + "");
        return view;
    }


    @OnClick({R.id.fragment_confirm_order_from_room_btn_add_more, R.id.fragment_confirm_order_from_room_btn_add_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_confirm_order_from_room_btn_add_more:
                onBack();
                makeOrder4Fragment.onBack();
                break;
            case R.id.fragment_confirm_order_from_room_btn_add_confirm:
                if (SharedPreferencesManger.loadUserData(getActivity()) != null) {
                    newOrderDetails7Fragment.nList = notess;
                    HelperMethod.ReplaceFragment(getFragmentManager(), newOrderDetails7Fragment,
                            R.id.activity_home_client_frame_fragment, null, null);
                } else {
                    Toast.makeText(getContext(), getString(R.string.shoud_register), Toast.LENGTH_LONG).show();
                    HelperMethod.ReplaceFragment(getFragmentManager(), new LoginClient(),
                            R.id.activity_home_client_frame_fragment, null, null);

                }
                break;
        }
    }

}
