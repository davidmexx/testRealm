package com.example.realmtestingjava;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Application extends android.app.Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .name("testinRealm.realm")
                .build();
        Realm.setDefaultConfiguration(config);

        context = getApplicationContext();
    }
}
