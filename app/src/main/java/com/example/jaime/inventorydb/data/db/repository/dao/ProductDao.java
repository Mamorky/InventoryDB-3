package com.example.jaime.inventorydb.data.db.repository.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteQueryBuilder;
import android.provider.BaseColumns;
import android.util.Log;

import com.example.jaime.inventorydb.data.db.InventoryContract;
import com.example.jaime.inventorydb.data.db.InventoryOpenHelper;
import com.example.jaime.inventorydb.data.db.model.Dependency;
import com.example.jaime.inventorydb.data.db.model.Product;
import com.example.jaime.inventorydb.data.db.model.ProductInner;

import java.util.ArrayList;

/**
 * Created by mamorky on 1/02/18.
 */

public class ProductDao {
    ArrayList<Product> mProducts;

    public ArrayList<Product> loadAll() {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        mProducts = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.query(InventoryContract.ProductEntry.TABLE_NAME,InventoryContract.ProductEntry.ALL_COLUMNS,
                null,null,null,null,InventoryContract.ProductEntry.COLUMN_SERIAL,null);

        if(cursor.moveToFirst()){
            do{
                Product product = new Product(cursor.getInt(0),cursor.getString(1),
                        cursor.getString(2), cursor.getString(3),
                        cursor.getString(4),cursor.getInt(5),
                        cursor.getInt(6),cursor.getInt(7),
                        cursor.getInt(8),cursor.getInt(9),
                        cursor.getDouble(10),cursor.getString(11),
                        cursor.getString(12),cursor.getString(13),
                        cursor.getString(14),cursor.getString(15),
                        cursor.getString(16));
                mProducts.add(product);
            } while(cursor.moveToNext());
        }

        InventoryOpenHelper.getInstance().closeDatabase();
        return mProducts;
    }

    public long add(Product dependency) {
        return 0;
    }

    public ProductInner search(int id){
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();
        sqLiteQueryBuilder.setTables(InventoryContract.ProductInnerEntry.PRODUCT_INNER);
        sqLiteQueryBuilder.setProjectionMap(InventoryContract.ProductInnerEntry.sProductProjectionMap);

        //Vamos a mostrar si la consulta es correcta
        String sql = sqLiteQueryBuilder.buildQuery(InventoryContract.ProductInnerEntry.ALL_COLUMNS,null,null,null,null,null);

        Log.i("inventoryfragmentdb",sql);
        String selecttion = InventoryContract.ProductInnerEntry.TABLE_NAME+"."+ BaseColumns._ID+"=?";
        String[] selectionArgs = {id+""};
        Cursor cursor = sqLiteQueryBuilder.query(sqLiteDatabase,InventoryContract.ProductInnerEntry.ALL_COLUMNS,
                null,null,null,null,null);

        ProductInner product = null;

        /**
         * public static final String[] ALL_COLUMNS = new String[] {
         _ID, SERIAL, 3COLUMN_MODELCODE, SORTNAME, DESCRIPTION, 6COLUMN_CATEGORY,7COLUMN_CATEGORYNAME,
         PRODUCT_CLASS,9COLUMN_PRODUCTCLASSDESCRIPTION, SECTOR, QUANTITY, VALUE, VENDOR,
         BITMAP, IMAGE_NAME, URL, DATE_PURCHASE, NOTES
         };
         * */

        /**
         * private int _id;
         private String serial;
         private String modelCode;
         private String sortname;
         private String description;
         private int category;
         private int subcategory;
         private int productClass;
         private int sector;
         private int quantity;
         private double value;
         private String vendor;
         private String bitmap;
         private String imageName;
         private String url;
         private String datePurchase;
         private String note;
         * */

        if(cursor.moveToFirst()){
            do{
                Product productTmp = new Product(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                        cursor.getString(3),cursor.getString(4),cursor.getInt(5),0,cursor.getInt(7),
                        cursor.getInt(9),cursor.getInt(10),cursor.getDouble(11),cursor.getString(12),
                        cursor.getString(13),cursor.getString(14),cursor.getString(15),cursor.getString(16),cursor.getString(17));

                product = new ProductInner(productTmp,cursor.getString(6),cursor.getString(8));
            } while(cursor.moveToNext());
        }

        InventoryOpenHelper.getInstance().closeDatabase();
        return product;
    }
}
