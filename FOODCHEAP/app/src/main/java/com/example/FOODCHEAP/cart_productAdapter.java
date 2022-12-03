package com.example.FOODCHEAP;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cart_productAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<product> ProductList;
    DecimalFormat decFormat = new DecimalFormat("###,###");

    public interface OnItemClickEventListener {
        void onItemClick(View v, int position);
    }

    public cart_productAdapter.OnItemClickEventListener itemClickListener;

    public void setOnItemClickListener (cart_productAdapter.OnItemClickEventListener listener) {
        itemClickListener = listener;
    }

    public cart_productAdapter(List<product> list) {
        ProductList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.product_in_cart, parent, false);
        cart_productAdapter.ViewHolder viewHolder = new cart_productAdapter.ViewHolder(view, itemClickListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ((cart_productAdapter.ViewHolder) viewHolder).image.setImageResource(ProductList.get(position).getImageID());
        ((cart_productAdapter.ViewHolder) viewHolder).name.setText(ProductList.get(position).getName());
        ((cart_productAdapter.ViewHolder) viewHolder).price.setText(decFormat.format(ProductList.get(position).getPrice2()) + "원");

        /* ((cart_productAdapter.ViewHolder) viewHolder).delete.setTag(position);
        ((cart_productAdapter.ViewHolder) viewHolder).delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int pos = (int)v.getTag();
                ProductList.remove(pos);
                notifyDataSetChanged();
            }
        });  */
    }

    @Override
    public int getItemCount() {
        return ProductList.size();
    }

    public int getTotalPrice() {
        int TotalPrice = 0;

        for (int i = 0; i < ProductList.size(); i++) {
            TotalPrice += ProductList.get(i).getPrice2();
        }

        return TotalPrice;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView price;
        Button delete;

        ViewHolder(View itemView, final cart_productAdapter.OnItemClickEventListener itemClickListener) {
            super(itemView);

            image = itemView.findViewById(R.id.productInCartImageView);
            name = itemView.findViewById(R.id.CartName);
            price = itemView.findViewById(R.id.CartPrice);
            delete = itemView.findViewById(R.id.delete_button);
        }
    }
}
