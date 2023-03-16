package com.example.realmtestingjava.data.repository;

import com.example.realmtestingjava.data.api.Sale;
import com.example.realmtestingjava.data.db.ProductEntity;
import com.example.realmtestingjava.data.db.SaleEntity;
import com.example.realmtestingjava.mapper.SaleMapper;

import io.realm.Realm;

public class SaleRepository {

    private static SaleRepository instance;

    private SaleRepository () {}

    public void create(Sale sale) {
        SaleEntity saleEntity = SaleMapper.INSTANCE.toEntity(sale);
        //save
        try (Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(saleEntity));

        }
    }

    public void delete() {
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.delete(SaleEntity.class));
        }
    }

    public static SaleRepository getInstance() {
        if(instance == null) {
            instance = new SaleRepository();
        }
        return instance;
    }
}
