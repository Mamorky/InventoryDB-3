package com.example.jaime.inventorydb.ui.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jaime.inventorydb.R;
import com.example.jaime.inventorydb.adapters.ProductAdapter;
import com.example.jaime.inventorydb.data.db.model.Product;
import com.example.jaime.inventorydb.ui.dependency.ListDependencyFragment;
import com.example.jaime.inventorydb.ui.product.contract.ListProductContract;
import com.example.jaime.inventorydb.ui.product.presenter.ListProductPresenter;

import java.util.ArrayList;

/**
 * Created by mamorky on 1/02/18.
 */

public class ListProductFragment extends ListFragment implements ListProductContract.View {

    static final String TAG = "listProductFragmentTag";

    ProductAdapter mAdapter;
    ListProductPresenter mPresenter;

    public static ListProductFragment newInstance(Bundle bundle) {
        ListProductFragment listProductFragment = new ListProductFragment();

        if (bundle != null)
            listProductFragment.setArguments(bundle);

        return listProductFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list_product,container,false);

        mAdapter = new ProductAdapter(getActivity());

        mPresenter = new ListProductPresenter(this);

        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(mAdapter);

        mPresenter.loadProduct();

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = (Product) parent.getItemAtPosition(position);
                Toast.makeText(getActivity(),product.getSortname(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showProduct(ArrayList<Product> products) {
        mAdapter.clear();
        mAdapter.addAll(products);
    }
}
