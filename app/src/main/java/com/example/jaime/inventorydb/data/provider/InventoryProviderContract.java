package com.example.jaime.inventorydb.data.provider;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.jaime.inventorydb.data.db.InventoryContract;

import java.util.HashMap;

/**
 * Created by mamorky on 5/02/18.
 */

public final class InventoryProviderContract {
    
    public static final String AUTHORITY="com.example.jaime.inventorydbprovider";
    public static final Uri AUTHORITY_URI = Uri.parse("content://"+AUTHORITY);
    
    private InventoryProviderContract(){
    
    }
    
    public static class Dependency implements BaseColumns{
        public static final String CONTENT_PATH="dependency";
        public static final Uri CONTENT_URI=Uri.withAppendedPath(AUTHORITY_URI,CONTENT_PATH);

        public static final String NAME = "name";
        public static final String SORTNAME = "sortname";
        public static final String DESCRIPTION = "description";
        public static final String IMAGE = "imageName";

        public static final String[] PROYECTION = new String[] {
                _ID, NAME, SORTNAME, DESCRIPTION, IMAGE
        };
    }

    public static class Sector implements BaseColumns{
        public static final String CONTENT_PATH="sector";
        public static final Uri CONTENT_URI=Uri.withAppendedPath(AUTHORITY_URI,CONTENT_PATH);
        
        public static final String DEPENDENCY_ID = "dependencyId";
        public static final String NAME = "name";
        public static final String SORTNAME = "sortName";
        public static final String DESCRIPTION = "description";
        public static final String ENABLE = "isEnable";
        public static final String SECTOR_DEFAULT = "isSectorDeafault";

        public static final String[] ALL_COLUMNS = new String[] {
                _ID, DEPENDENCY_ID, NAME, SORTNAME, DESCRIPTION,
                ENABLE, SECTOR_DEFAULT
        };
    }

    public static class Product implements BaseColumns{
        public static final String CONTENT_PATH="product";
        public static final Uri CONTENT_URI=Uri.withAppendedPath(AUTHORITY_URI,CONTENT_PATH);
        
        public static final String SERIAL = "serial";
        public static final String MODEL_CODE = "modelCode";
        public static final String SORTNAME = "sortname";
        public static final String DESCRIPTION = "description";
        public static final String CATEGORY = "category";
        public static final String CATEGORYNAME = "categoryname";
        public static final String PRODUCT_CLASS = "productClass";
        public static final String PRODUCT_CLASS_DESCRIPTION = "productClassDescription";
        public static final String SECTOR = "sector";
        public static final String QUANTITY = "quantity";
        public static final String VALUE = "value";
        public static final String VENDOR = "vendor";
        public static final String BITMAP = "bitmap";
        public static final String IMAGE_NAME = "imageName";
        public static final String URL = "url";
        public static final String DATE_PURCHASE = "datePurchase";
        public static final String NOTES = "notes";

        public static final String[] PROYECTION = new String[] {
                _ID, SERIAL, MODEL_CODE, SORTNAME, DESCRIPTION, CATEGORY, CATEGORYNAME,
                PRODUCT_CLASS, PRODUCT_CLASS_DESCRIPTION, SECTOR, QUANTITY, VALUE, VENDOR,
                BITMAP, IMAGE_NAME, URL, DATE_PURCHASE, NOTES
        };

        public static HashMap<String,String> sProductProjectionMap;
        static {
            sProductProjectionMap = new HashMap<>();
            sProductProjectionMap.put(BaseColumns._ID, InventoryContract.ProductInnerEntry.TABLE_NAME+"."+ InventoryContract.ProductInnerEntry._ID);
            sProductProjectionMap.put(SERIAL,InventoryContract.ProductInnerEntry.COLUMN_SERIAL);
            sProductProjectionMap.put(MODEL_CODE,InventoryContract.ProductInnerEntry.COLUMN_MODELCODE);
            sProductProjectionMap.put(SORTNAME,InventoryContract.ProductInnerEntry.COLUMN_SORTNAME);
            sProductProjectionMap.put(DESCRIPTION,InventoryContract.ProductInnerEntry.COLUMN_DESCRIPTION);
            sProductProjectionMap.put(CATEGORY,InventoryContract.ProductInnerEntry.COLUMN_SERIAL);
            sProductProjectionMap.put(CATEGORYNAME,InventoryContract.CategoryEntry.TABLE_NAME+"."+ InventoryContract.CategoryEntry.COLUMN_NAME);
            sProductProjectionMap.put(PRODUCT_CLASS,InventoryContract.ProductInnerEntry.COLUMN_SERIAL);
            sProductProjectionMap.put(PRODUCT_CLASS_DESCRIPTION, InventoryContract.ProductClassEntry.TABLE_NAME+"."+ InventoryContract.ProductClassEntry.COLUMN_DESCRIPTION);
            sProductProjectionMap.put(SECTOR,InventoryContract.ProductInnerEntry.COLUMN_SECTOR);
            sProductProjectionMap.put(QUANTITY,InventoryContract.ProductInnerEntry.COLUMN_QUANTITY);
            sProductProjectionMap.put(VALUE,InventoryContract.ProductInnerEntry.COLUMN_VALUE);
            sProductProjectionMap.put(VENDOR,InventoryContract.ProductInnerEntry.COLUMN_VENDOR);
            sProductProjectionMap.put(BITMAP,InventoryContract.ProductInnerEntry.COLUMN_BITMAP);
            sProductProjectionMap.put(IMAGE_NAME,InventoryContract.ProductInnerEntry.COLUMN_IMAGENAME);
            sProductProjectionMap.put(URL,InventoryContract.ProductInnerEntry.COLUMN_URL);
            sProductProjectionMap.put(DATE_PURCHASE,InventoryContract.ProductInnerEntry.COLUMN_DATEPURCHASE);
            sProductProjectionMap.put(NOTES,InventoryContract.ProductInnerEntry.COLUMN_NOTES);
        }
    }
}
