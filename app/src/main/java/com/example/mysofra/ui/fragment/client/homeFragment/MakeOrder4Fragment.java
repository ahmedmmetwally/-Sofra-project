package com.example.mysofra.ui.fragment.client.homeFragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.mysofra.R;
import com.example.mysofra.data.local.SharedPreferencesManger;
import com.example.mysofra.data.model.Note;
import com.example.mysofra.data.model.restaurntItem.RestaurntItemDatum;
import com.example.mysofra.helper.HelperMethod;
import com.example.mysofra.ui.fragment.BaseFragment;
import com.example.mysofra.ui.fragment.client.homeFragment.roomm.NoteViewModel;

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
public class MakeOrder4Fragment extends BaseFragment {


    @BindView(R.id.fragment_make_order4_img_item_image)
    ImageView imgItemImage;
    @BindView(R.id.fragment_make_order4_txt_item_name)
    TextView txtItemName;
    @BindView(R.id.fragment_make_order4_txt_item_description)
    TextView txtItemDescription;
    @BindView(R.id.fragment_make_order4_txt_item_price)
    TextView txtItemPrice;
    @BindView(R.id.fragment_make_order4_edt_enter_order)
    EditText edtEnterOrder;
    @BindView(R.id.fragment_make_order4_btn_plus)
    Button btnPlus;
    @BindView(R.id.fragment_make_order4_txt_quantity)
    TextView txtQuantity;
    @BindView(R.id.fragment_make_order4_btn_minus)
    Button btnMinus;
    @BindView(R.id.fragment_make_order4_btn_save)
    Button btnSave;
    private Unbinder unbind;
    public RestaurntItemDatum data;
    private String specialOrder;
    private NoteViewModel noteViewModel;
    private int quantity;
    private int restaurantid;
    private int res_id;
    private SharedPreferences sharedPref;

    public MakeOrder4Fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_make_order4, container, false);
        unbind = ButterKnife.bind(this, view);
        setUpActivity();
        TOTAL_PRICE_cons = SharedPreferencesManger.LoadFloatData(getActivity(), TOTAL_PRICEE);
        quantity = Integer.parseInt(txtQuantity.getText().toString().trim());
        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                restaurantid = notes.get(1).getRestaurant_id();

            }
        });


        res_id = Integer.parseInt(data.getRestaurantId());
        if (restaurantid != res_id) {
            HelperMethod.customToast(getActivity(), getString(R.string.you_sure_delet_room_order), false);
        }

        Glide.with(getContext())
                .load(data.getPhotoUrl()).placeholder(R.drawable.search_black_24dp)
                .error(R.drawable.rror_black_24dp)
                .into(imgItemImage);
        txtItemName.setText(data.getName());
        txtItemDescription.setText(data.getDescription());
        String price = (data.getPrice());
        txtItemPrice.setText(price);
        specialOrder = edtEnterOrder.getText().toString().trim();
        return view;
    }


    @OnClick({R.id.fragment_make_order4_btn_plus, R.id.fragment_make_order4_btn_minus, R.id.fragment_make_order4_btn_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_make_order4_btn_plus:
                quantity = Integer.parseInt(txtQuantity.getText().toString().trim());
                quantity++;
                txtQuantity.setText(quantity + "");

                break;
            case R.id.fragment_make_order4_btn_minus:
                quantity = Integer.parseInt(txtQuantity.getText().toString().trim());
                if (quantity > 1) {
                    quantity--;
                    txtQuantity.setText(quantity + "");
                }


                break;
            case R.id.fragment_make_order4_btn_save:

                if (restaurantid != res_id){
                    noteViewModel.deleteAllNotes();
                   }


                //  noteViewModel.deleteAllNotes();

                float price = Float.valueOf(data.getPrice());
                noteViewModel.insert(new Note(res_id, data.getPhotoUrl(), data.getName(), data.getDescription()
                        , price, specialOrder, quantity));
                Log.e("eeee", price + "  quantity is :" + quantity);
                TOTAL_PRICE_cons += quantity * price;
                SharedPreferencesManger.saveTotalPrice(getActivity(), TOTAL_PRICE_cons);
                Log.e("TOTAL_PRICE_cons in 4=", TOTAL_PRICE_cons + " ");

                ConfirmOrderFromRoomFragment confirmOrderFromRoomFragment = new ConfirmOrderFromRoomFragment();
                confirmOrderFromRoomFragment.makeOrder4Fragment = MakeOrder4Fragment.this;

                HelperMethod.ReplaceFragment(getFragmentManager(), confirmOrderFromRoomFragment
                        , R.id.activity_home_client_frame_fragment, null, null);


                break;
        }
    }


}
