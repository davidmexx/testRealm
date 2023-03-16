package com.example.realmtestingjava.data.api;

import java.util.UUID;

import io.realm.annotations.PrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @PrimaryKey
    private String uuid = UUID.randomUUID().toString();

    private String userName = "";
}
