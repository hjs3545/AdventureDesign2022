package com.example.FOODCHEAP;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class cardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<card> CardList;
    private Context context;
    private CardDBHelper dbHelper;

    public interface OnItemClickEventListener {
        void onItemClick(View v, int position);
    }

    public OnItemClickEventListener itemClickEventListener;

    public void setOnItemClickListener (OnItemClickEventListener listener) {
        itemClickEventListener = listener;
    }

    public cardAdapter(List<card> list, CardDBHelper dbHelper) {
        CardList = list;
        this.dbHelper = dbHelper;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.bluecard_detail, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, itemClickEventListener);

        return viewHolder;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ((ViewHolder) viewHolder).bluecardnumber.setText(CardList.get(position).getCardNumber());
        ((ViewHolder) viewHolder).bluevalidthru.setText(CardList.get(position).getValidThru());

        ((ViewHolder) viewHolder).deletecardbutton.setTag(position);
        ((ViewHolder) viewHolder).deletecardbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int pos = (int)v.getTag();
                int id = CardList.get(pos).getID();
                dbHelper.delete(id);
                notifyDataSetChanged();
                Toast.makeText(context, "카드 제거됨", Toast.LENGTH_SHORT).show();
                Intent intent = ((Activity)context).getIntent();
                ((Activity)context).finish();
                ((Activity)context).overridePendingTransition(0, 0);
                ((Activity)context).startActivity(intent);
                ((Activity)context).overridePendingTransition(0, 0);
            }
        });
    }

    public int getItemCount() {
        return CardList.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        TextView bluecardnumber;
        TextView bluevalidthru;
        Button deletecardbutton;

        ViewHolder(View itemView, final OnItemClickEventListener itemClickEventListener) {
            super(itemView);

            bluecardnumber = itemView.findViewById(R.id.bluecardNumber);
            bluevalidthru = itemView.findViewById(R.id.bluecardValid);
            deletecardbutton = itemView.findViewById(R.id.delete_card_button);

            itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    final int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        itemClickEventListener.onItemClick(v, position);
                    }
                }
            });
        }
    }
}
