package com.example.FOODCHEAP;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class cardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<card> CardList;

    public interface OnItemClickEventListener {
        void onItemClick(View v, int position);
    }

    public OnItemClickEventListener itemClickEventListener;

    public void setOnItemClickListener (OnItemClickEventListener listener) {
        itemClickEventListener = listener;
    }

    public cardAdapter(List<card> list) {
        CardList = list;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.bluecard_detail, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, itemClickEventListener);

        return viewHolder;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ((ViewHolder) viewHolder).cardnumber.setText(CardList.get(position).getCardNumber());
        ((ViewHolder) viewHolder).validthru.setText(CardList.get(position).getValidThru());
    }

    public int getItemCount() {
        return CardList.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        TextView cardnumber;
        TextView validthru;

        ViewHolder(View itemView, final OnItemClickEventListener itemClickEventListener) {
            super(itemView);

            cardnumber = itemView.findViewById(R.id.bluecardNumber);
            validthru = itemView.findViewById(R.id.bluecardValid);

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
