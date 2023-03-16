package com.example.realmtestingjava.data.repository;

import com.example.realmtestingjava.data.api.Product;
import com.example.realmtestingjava.data.db.ProductEntity;
import com.example.realmtestingjava.mapper.ProductMapper;

import io.realm.Realm;
import io.realm.RealmResults;

public class ProductRepository {

    private static ProductRepository instance;

    private ProductRepository () {}

    public void create(Product product) {
        ProductEntity productEntity = ProductMapper.INSTANCE.toEntity(product);
        //save
        try (Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(productEntity));

        }
    }

    public void delete() {
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.delete(ProductEntity.class));
        }
    }

    public static ProductRepository getInstance() {
        if(instance == null) {
            instance = new ProductRepository();
        }
        return instance;
    }
}
