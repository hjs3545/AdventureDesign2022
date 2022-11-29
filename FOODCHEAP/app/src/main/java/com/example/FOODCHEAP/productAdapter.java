package com.example.FOODCHEAP;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class productAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<product> ProductList;

    public interface OnItemClickEventListener {
        void onItemClick(View v, int position);
    }

    public OnItemClickEventListener itemClickListener;

    public void setOnItemClickListener (OnItemClickEventListener listener) {
        itemClickListener = listener;
    }

    public productAdapter(List<product> list) {
        ProductList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.product, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, itemClickListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ((ViewHolder) viewHolder).image.setImageResource(ProductList.get(position).getImageID());
        ((ViewHolder) viewHolder).name.setText(ProductList.get(position).getName());
        ((ViewHolder) viewHolder).price1.setText(ProductList.get(position).getPrice1());
        ((ViewHolder) viewHolder).price2.setText(ProductList.get(position).getPrice2());
    }

    @Override
    public int getItemCount() {
        return ProductList.size();
    }
    private class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView price1;
        TextView price2;

        ViewHolder(View itemView, final OnItemClickEventListener itemClickListener) {
            super(itemView);

            image = itemView.findViewById(R.id.productImageView);
            name = itemView.findViewById(R.id.productName);
            price1 = itemView.findViewById(R.id.productPrice1);
            price2 = itemView.findViewById(R.id.productPrice2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        itemClickListener.onItemClick(v, position);
                    }
                }
            });
        }
    }


}


