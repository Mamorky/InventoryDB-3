package com.example.jaime.inventorydb.ui.product.contract;

import com.example.jaime.inventorydb.data.db.model.Product;
import com.example.jaime.inventorydb.ui.base.BasePresenter;
import com.example.jaime.inventorydb.ui.base.BaseView;

import java.util.ArrayList;

/**
 * Created by mamorky on 1/02/18.
 */

public interface ListProductContract{
    interface View extends BaseView{
        void showProduct(ArrayList<Product> products);
    }

    interface Presenter extends BasePresenter{
        void loadProduct();
    }

    interface Interactor{
        void loadProduct();

        interface OnLoadSucess{
            void OnError(String error);
            void OnSucess(ArrayList<Product> products);
        }
    }
}
