package com.example.jaime.inventorydb.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jaime.inventorydb.R;
import com.example.jaime.inventorydb.data.db.model.Dependency;
import com.example.jaime.inventorydb.data.db.model.Product;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

/**
 * Created by mamorky on 1/02/18.
 */

public class ProductAdapter extends ArrayAdapter<Product> {
    public ProductAdapter(Context context) {
        super(context, R.layout.item_product, new ArrayList<Product>());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewRoot = convertView;
        ProductAdapter.ProductHolder holder;

        if (viewRoot == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            viewRoot = inflater.inflate(R.layout.item_product, null);
            holder = new ProductHolder();

            holder.txvName = (TextView) viewRoot.findViewById(R.id.txvProductName);
            holder.txvCategory = (TextView) viewRoot.findViewById(R.id.txvProductCategoria);
            holder.txvSerial = (TextView) viewRoot.findViewById(R.id.txvProductSerial);
            holder.txvPrice = (TextView) viewRoot.findViewById(R.id.txvProductPrecio);

            viewRoot.setTag(holder);
        } else
            holder = (ProductHolder) viewRoot.getTag();

        holder.txvName.setText(getItem(position).getSortname());
        holder.txvCategory.setText(String.valueOf(getItem(position).getCategory()));
        holder.txvSerial.setText(getItem(position).getSerial());
        holder.txvPrice.setText(String.valueOf(getItem(position).getValue()));

        return viewRoot;
    }


    private class ProductHolder {
        public TextView txvName;
        public TextView txvSerial;
        public TextView txvCategory;
        public TextView txvPrice;
    }
}
