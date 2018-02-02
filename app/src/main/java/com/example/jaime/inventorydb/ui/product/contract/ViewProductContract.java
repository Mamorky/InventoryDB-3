package com.example.jaime.inventorydb.ui.product.contract;

import com.example.jaime.inventorydb.data.db.model.Product;
import com.example.jaime.inventorydb.data.db.model.ProductInner;
import com.example.jaime.inventorydb.ui.base.BasePresenter;
import com.example.jaime.inventorydb.ui.base.BaseView;

/**
 * Created by mamorky on 2/02/18.
 */

public interface ViewProductContract {
    interface View extends BaseView{
        void showProduct(ProductInner product);
    }

    interface Presenter extends BasePresenter{
        void loadProduct(Product product);
    }

    interface Interactor{
        void loadProduct(Product product);

        interface OnLoadProduct{
            void loadProduct(ProductInner product);
            void loadError(String error);
        }
    }
}
