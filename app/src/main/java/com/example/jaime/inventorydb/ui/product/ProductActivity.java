package com.example.jaime.inventorydb.ui.product;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jaime.inventorydb.R;

/**
 * Clase que muestra la activity de Product.
 */
public class ProductActivity extends AppCompatActivity implements ListProductFragment.OnLoadViewProduct{

    ListProductFragment listProductFragment;
    ViewProductFragment viewProductFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        listProductFragment = (ListProductFragment) getSupportFragmentManager().findFragmentByTag(ListProductFragment.TAG);

        if (listProductFragment == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            listProductFragment = ListProductFragment.newInstance(null);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(android.R.id.content,listProductFragment,ListProductFragment.TAG).commit();
        }
    }

    @Override
    public void loadViewProduct(Bundle product) {
        viewProductFragment = (ViewProductFragment) getSupportFragmentManager().findFragmentByTag(ViewProductFragment.TAG);

        if (viewProductFragment == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            viewProductFragment = ViewProductFragment.newInstance(product);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(android.R.id.content,viewProductFragment,ListProductFragment.TAG).commit();
        }
    }
}
