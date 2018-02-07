package com.example.jaime.inventorydb.data.db.repository;

import com.example.jaime.inventorydb.data.db.model.Product;
import com.example.jaime.inventorydb.data.db.model.ProductInner;
import com.example.jaime.inventorydb.data.db.repository.dao.ProductDao;

import java.util.ArrayList;

/**
 * Clase repositorio que contiene todos los datos de Product.
 */

public class ProductRepository {
    private static ProductRepository mInstance;
    private ProductDao mDao;


    private ProductRepository() {
        this.mDao = new ProductDao();
    }


    public static ProductRepository getInstance() {
        if (mInstance == null)
            mInstance = new ProductRepository();

        return mInstance;
    }


    public ArrayList<Product> getProducts() {
        return mDao.loadAll();
    }

    public ProductInner getProductInner(Product product){
        return mDao.search(0);
    }


    /**public ArrayList<Dependency> getDependenciesOrderByName() {
        ArrayList<Product> products = mDao.loadAll();
        Collections.sort(products,Product);
        return dependencies;
    }


    public ArrayList<Dependency> getDependenciesOrderByID() {
        ArrayList<Dependency> dependencies = mDao.loadAll();
        Collections.sort(dependencies, Dependency.COMPARATOR_ID);
        return dependencies;
    }


    public void addDependency(Dependency dependency,  InteractorCallback callback) {
        long id = mDao.add(dependency);
        Error error = new Error();

        if (id == -1)
            callback.onError(error);
        else
            callback.onSuccess();
    }


    public boolean validateDependency(String name, String sortname) {
        return mDao.exists(name, sortname);
    }


    public void editDependency(Dependency dependency, InteractorCallback callback) {
        int rows = mDao.update(dependency);
        Error error = new Error();

        if (rows == 0)
            callback.onError(error);
        else
            callback.onSuccess();
    }


    public void deleteDependency(Dependency dependency, InteractorCallback callback) {
        int rows = mDao.delete(dependency);
        Error error = new Error();

        if (rows == 0)
            callback.onError(error);
        else
            callback.onSuccess();
    }**/
}
