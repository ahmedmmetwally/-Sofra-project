package com.example.mysofra.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mysofra.R;
import com.example.mysofra.data.local.SharedPreferencesManger;
import com.example.mysofra.data.model.Note;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.mysofra.helper.constant.TOTAL_PRICE_cons;

public class ConfirmOrderFromRoomAdater extends RecyclerView.Adapter<ConfirmOrderFromRoomAdater.RoomViewHolder> {
    public int room_Quantity;

    private List<Note> notes = new ArrayList<>();
    private OnItemClickListener listener;

    private Context context;

    public ConfirmOrderFromRoomAdater(Context context) {

        this.context = context;
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_recycler_confirem_order_from_room, parent
                , false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        // TOTAL_PRICE_cons=notes.get(notes.size()-1).getTotal_price();

        //TOTAL_PRICE_cons += notes.get(position).getPrice();


        Note note = notes.get(position);
//        TOTAL_PRICE_cons=note.getTotal_price();
        Log.e("adapter tota price", TOTAL_PRICE_cons + "");
        Glide.with(context)
                .load(note.getPhoto_url()).placeholder(R.drawable.search_black_24dp)
                .error(R.drawable.rror_black_24dp)
                .into(holder.imgPhotoItem);
        holder.txtItemName.setText(note.getItmeName());
        holder.txtItemPrice.setText(note.getPrice() + "");
        holder.txtQuantity.setText(note.getQuantity() + "");


        holder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (note.getQuantity() == 1) {
                    return;
                } else {
                    room_Quantity = notes.get(position).getQuantity();
                    int quantity = room_Quantity;
                    room_Quantity--;
                    holder.txtQuantity.setText(room_Quantity + "");
                    TOTAL_PRICE_cons -= ((quantity - room_Quantity) * notes.get(position).getPrice());
                    listener.onItemclick(note, TOTAL_PRICE_cons, room_Quantity, "update");
                    SharedPreferencesManger.saveTotalPrice((Activity) context, TOTAL_PRICE_cons);
                    Log.e("adapter---------", notes.get(position).getPrice() + "");
                    Log.e("adapter--------", TOTAL_PRICE_cons + "");
                    Log.e("adapter=====", "=================================");
                }
            }
        });
        holder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room_Quantity = notes.get(position).getQuantity();
                int quantity = room_Quantity;
                room_Quantity++;
                holder.txtQuantity.setText(room_Quantity + "");
                TOTAL_PRICE_cons += ((room_Quantity - quantity) * notes.get(position).getPrice());
                listener.onItemclick(note, TOTAL_PRICE_cons, room_Quantity, "update");
                SharedPreferencesManger.saveTotalPrice((Activity) context, TOTAL_PRICE_cons);
                Log.e("adapter++++++", notes.get(position).getPrice() + "");
                Log.e("adapter++++++", TOTAL_PRICE_cons + "");
                Log.e("adapter=======", "=================================");
            }
        });
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TOTAL_PRICE_cons -= (((float) room_Quantity) * note.getPrice());
                listener.onItemclick(note, TOTAL_PRICE_cons, room_Quantity, "delete");

            }
        });

    }

    @Override
    public int getItemCount() {
        return notes.size();

    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    public class RoomViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.show_recycler_confirem_order_from_room_img_photo_item)
        ImageView imgPhotoItem;
        @BindView(R.id.show_recycler_confirem_order_from_room_txt_item_name)
        TextView txtItemName;
        @BindView(R.id.show_recycler_confirem_order_from_room_txt_item_Price)
        TextView txtItemPrice;
        @BindView(R.id.show_recycler_confirem_order_from_room_btn_plus)
        Button btnPlus;
        @BindView(R.id.show_recycler_confirem_order_from_room_txt_quantity)
        TextView txtQuantity;
        @BindView(R.id.show_recycler_confirem_order_from_room_btn_minus)
        Button btnMinus;
        @BindView(R.id.show_restaurant_my_item_shape_recycler_btn_delete)
        Button btnDelete;

        private View view;

        public RoomViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }
    }

    public interface OnItemClickListener {
        void onItemclick(Note note, Float total_price, int quantity, String status);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
