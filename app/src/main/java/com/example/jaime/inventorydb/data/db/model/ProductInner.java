package com.example.jaime.inventorydb.data.db.model;

import android.os.Parcel;

/**
 * Created by mamorky on 2/02/18.
 */

public class ProductInner{

    Product product;
    String categoryName;
    String productName;

    public ProductInner(Product product,String categoryName,String productName) {
        this.product = product;
        this.categoryName = categoryName;
        this.productName = productName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        productName = productName;
    }
}
