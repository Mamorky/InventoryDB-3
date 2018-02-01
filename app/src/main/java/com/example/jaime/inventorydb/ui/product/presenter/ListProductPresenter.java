package com.example.jaime.inventorydb.ui.product.presenter;

import com.example.jaime.inventorydb.data.db.model.Product;
import com.example.jaime.inventorydb.ui.product.ListProductFragment;
import com.example.jaime.inventorydb.ui.product.contract.ListProductContract;
import com.example.jaime.inventorydb.ui.product.interactor.ListProductInteractor;

import java.util.ArrayList;

/**
 * Created by mamorky on 1/02/18.
 */

public class ListProductPresenter implements ListProductContract.Presenter,ListProductContract.Interactor.OnLoadSucess {

    ListProductFragment view;
    ListProductInteractor interactor;

    public ListProductPresenter(ListProductFragment view){
        this.view = view;
        this.interactor = new ListProductInteractor(this);
    }

    @Override
    public void loadProduct() {
        interactor.loadProduct();
    }

    @Override
    public void onDestroy() {
        view = null;
        interactor = null;
    }

    @Override
    public void OnError(String error) {

    }

    @Override
    public void OnSucess(ArrayList<Product> products) {
        view.showProduct(products);
    }
}
