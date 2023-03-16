package com.example.realmtestingjava.data.repository;

import com.example.realmtestingjava.data.api.User;
import com.example.realmtestingjava.data.db.ProductEntity;
import com.example.realmtestingjava.data.db.UserEntity;

import com.example.realmtestingjava.mapper.UserMapper;

import io.realm.Realm;

public class UserRepository {

    private static UserRepository instance;

    private UserRepository () {}

    public void create(User user) {
        UserEntity userEntity = UserMapper.INSTANCE.toEntity(user);
        //save
        try (Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(userEntity));

        }
    }

    public void delete() {
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.delete(UserEntity.class));
        }
    }

    public static UserRepository getInstance() {
        if(instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }
}
