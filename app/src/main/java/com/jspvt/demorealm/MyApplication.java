package com.jspvt.demorealm;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());

//        final RealmConfiguration configuration =  new RealmConfiguration.Builder()
//                .name("demorealm.db")
//                .schemaVersion(1)
//                .build();
//                Realm.setDefaultConfiguration(configuration);
//                Realm.getInstance(configuration);


        final RealmConfiguration configuration =  new RealmConfiguration.Builder()
                .name("demorealm.db")
                .schemaVersion(2)
                .migration(new RealmMigrations())
                .build();
        Realm.setDefaultConfiguration(configuration);
    }
    @Override
    public void onTerminate() {
        Realm.getDefaultInstance().close();
        super.onTerminate();
    }
}
