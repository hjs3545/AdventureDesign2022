package com.example.FOODCHEAP;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class user_productAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<product> ProductList;
    DecimalFormat decFormat = new DecimalFormat("###,###");

    user_productAdapter(List<product> list) {
        ProductList = list;
    }

    public interface OnItemClickEventListener {
        void onItemClick(View v, int position);
    }

    public OnItemClickEventListener itemClickListener;

    public void setOnItemClickListener (OnItemClickEventListener listener) {
        itemClickListener = listener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.product_userpage, parent, false);
        user_productAdapter.ViewHolder viewHolder = new user_productAdapter.ViewHolder(view, itemClickListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ((ViewHolder)viewHolder).image.setImageResource(ProductList.get(position).getImageID());
        ((ViewHolder)viewHolder).name.setText(ProductList.get(position).getName());
        ((ViewHolder)viewHolder).price1.setText(decFormat.format(ProductList.get(position).getPrice1()) + "원");
        ((ViewHolder)viewHolder).price2.setText(decFormat.format(ProductList.get(position).getPrice2()) + "원");
        ((ViewHolder)viewHolder).date.setText(ProductList.get(position).getDate());
        ((ViewHolder)viewHolder).discountRate.setText(ProductList.get(position).getDiscountRate());
    }

    @Override
    public int getItemCount() {
        return ProductList.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView price1;
        TextView price2;
        TextView date;
        TextView discountRate;

        ViewHolder(View itemView, final user_productAdapter.OnItemClickEventListener itemClickListener) {
            super(itemView);

            image = itemView.findViewById(R.id.user_product_image);
            name = itemView.findViewById(R.id.user_product_name);
            price1 = itemView.findViewById(R.id.user_product_price1);
            price2 = itemView.findViewById(R.id.user_product_price2);
            date = itemView.findViewById(R.id.user_product_date);
            discountRate = itemView.findViewById(R.id.user_product_discountrate);

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
