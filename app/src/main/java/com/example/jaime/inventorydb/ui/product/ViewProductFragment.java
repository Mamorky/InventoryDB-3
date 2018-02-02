package com.example.jaime.inventorydb.ui.product;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.jaime.inventorydb.R;
import com.example.jaime.inventorydb.data.db.model.Product;
import com.example.jaime.inventorydb.ui.product.contract.ListProductContract;
import com.example.jaime.inventorydb.ui.product.presenter.ViewProductPresenter;

import java.util.ArrayList;

/**
 * Created by mamorky on 2/02/18.
 */

public class ViewProductFragment extends Fragment implements ListProductContract.View{

    public static final String TAG = "ViewProductFragmentTag";

    EditText edtProductName,edtProductSerial,edtProductSeller,edtProductDescription,edtProductPrice,edtProductDate,edtProductUrl;
    Spinner spnProductCategory,spnProductSubcategory,spnProductType;

    ViewProductPresenter presenter;


    public static ViewProductFragment newInstance(Bundle bundle) {
        ViewProductFragment viewProductFragment = new ViewProductFragment();

        if (bundle != null)
            viewProductFragment.setArguments(bundle);

        return viewProductFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_info_product,container,false);

        edtProductName = (EditText) root.findViewById(R.id.edt_product_name);
        edtProductSerial = (EditText) root.findViewById(R.id.edt_product_serial);
        edtProductSeller = (EditText) root.findViewById(R.id.edt_product_seller);
        edtProductDescription = (EditText) root.findViewById(R.id.edt_product_description);
        edtProductPrice = (EditText) root.findViewById(R.id.edt_product_price);
        edtProductDate = (EditText) root.findViewById(R.id.edt_product_date);
        edtProductUrl = (EditText) root.findViewById(R.id.edt_product_url);

        spnProductCategory = (Spinner) root.findViewById(R.id.sp_product_category);
        spnProductSubcategory = (Spinner) root.findViewById(R.id.sp_product_subcategory);
        spnProductType = (Spinner) root.findViewById(R.id.sp_product_type);

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Product product = getArguments().getParcelable("product");

        presenter = new ViewProductPresenter(this);
        presenter.loadProduct(product);
    }

    @Override
    public void showProduct(ArrayList<Product> products) {

    }
}
