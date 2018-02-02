package com.example.jaime.inventorydb.data.db.model;

import android.os.Parcel;

/**
 * Created by mamorky on 2/02/18.
 */

public class ProductInner{

    Product product;
    String CategoryName;
    String ProductName;

    public ProductInner(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }
}
