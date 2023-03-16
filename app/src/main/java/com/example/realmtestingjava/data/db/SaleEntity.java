package com.example.realmtestingjava.data.db;

import com.example.realmtestingjava.data.api.Product;

import java.util.ArrayList;
import java.util.UUID;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class SaleEntity extends RealmObject {

    @PrimaryKey
    private String uuid = UUID.randomUUID().toString();

    private RealmList<ProductEntity> product;

    private UserEntity user;
}