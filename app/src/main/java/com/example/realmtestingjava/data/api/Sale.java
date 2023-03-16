package com.example.realmtestingjava.data.api;

import com.example.realmtestingjava.data.db.ProductEntity;
import com.example.realmtestingjava.data.db.UserEntity;

import java.util.ArrayList;
import java.util.UUID;

import io.realm.RealmList;
import io.realm.annotations.PrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    @PrimaryKey
    private String uuid = UUID.randomUUID().toString();

    private ArrayList<Product> product;

    private User user;
}
