package com.example.jaime.inventorydb.ui.product.presenter;

import com.example.jaime.inventorydb.data.db.model.Product;
import com.example.jaime.inventorydb.data.db.model.ProductInner;
import com.example.jaime.inventorydb.ui.product.ViewProductFragment;
import com.example.jaime.inventorydb.ui.product.contract.ViewProductContract;
import com.example.jaime.inventorydb.ui.product.interactor.ViewProductInteractor;

import java.util.ArrayList;

/**
 * Created by mamorky on 2/02/18.
 */

public class ViewProductPresenter implements ViewProductContract.Presenter,ViewProductContract.Interactor.OnLoadProduct{
    ViewProductFragment view;
    ViewProductInteractor interactor;

    public ViewProductPresenter(ViewProductFragment view){
        this.view = view;
        this.interactor = new ViewProductInteractor(this);
    }

    @Override
    public void onDestroy() {
        view = null;
        interactor = null;
    }

    @Override
    public void loadProduct(Product product) {
        interactor.loadProduct(product);
    }

    @Override
    public void loadProduct(ProductInner product) {

    }

    @Override
    public void loadError(String error) {

    }
}
