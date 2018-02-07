package com.example.jaime.inventorydb.data.provider.dao;

import com.example.jaime.inventorydb.data.DependencyDao;
import com.example.jaime.inventorydb.data.db.model.Dependency;

import java.util.ArrayList;

/**
 * Created by mamorky on 7/02/18.
 */

public class DependencyDaoImp implements DependencyDao{
    @Override
    public ArrayList<Dependency> loadAll() {
        return null;
    }

    @Override
    public long add(Dependency dependency) {
        return 0;
    }

    @Override
    public int delete(Dependency dependency) {
        return 0;
    }

    @Override
    public int update(Dependency dependency) {
        return 0;
    }

    @Override
    public boolean exists(String name, String shortName) {
        return false;
    }
}
