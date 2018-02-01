package com.example.jaime.inventorydb.ui.product.interactor;

import com.example.jaime.inventorydb.data.db.repository.ProductRepository;
import com.example.jaime.inventorydb.ui.product.contract.ListProductContract;
import com.example.jaime.inventorydb.ui.product.presenter.ListProductPresenter;

/**
 * Created by mamorky on 1/02/18.
 */

public class ListProductInteractor implements ListProductContract.Interactor {
    OnLoadSucess onLoadSucess;

    public ListProductInteractor(OnLoadSucess onLoadSucess) {
        this.onLoadSucess = onLoadSucess;
    }

    @Override
    public void loadProduct() {
        onLoadSucess.OnSucess(ProductRepository.getInstance().getProducts());
    }
}
