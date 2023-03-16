package com.example.realmtestingjava.data.db;

import java.util.UUID;

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
public class ProductEntity extends RealmObject {

    @PrimaryKey
    private String uuid = UUID.randomUUID().toString();

    private String productName = "";

}
