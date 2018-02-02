package com.example.jaime.inventorydb.ui.product.interactor;

import com.example.jaime.inventorydb.data.db.model.Product;
import com.example.jaime.inventorydb.data.db.repository.ProductRepository;
import com.example.jaime.inventorydb.ui.product.contract.ViewProductContract;
import com.example.jaime.inventorydb.ui.product.presenter.ViewProductPresenter;

/**
 * Created by mamorky on 2/02/18.
 */

public class ViewProductInteractor implements ViewProductContract.Interactor{
    ViewProductContract.Interactor.OnLoadProduct onLoadProduct;

    public ViewProductInteractor(ViewProductContract.Interactor.OnLoadProduct onLoadProduct) {
        this.onLoadProduct = onLoadProduct;
    }

    @Override
    public void loadProduct(Product product) {
        onLoadProduct.loadProduct(ProductRepository.getInstance().getProductInner(product));
    }
}
