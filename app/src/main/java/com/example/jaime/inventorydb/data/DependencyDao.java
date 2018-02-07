package com.example.jaime.inventorydb.data;

import com.example.jaime.inventorydb.data.db.model.Dependency;

import java.util.ArrayList;

/**
 * Created by mamorky on 7/02/18.
 */

public interface DependencyDao {
    ArrayList<Dependency> loadAll();
    long add(Dependency dependency);
    int delete(Dependency dependency);
    int update(Dependency dependency);
    boolean exists (String name,String shortName);
}
