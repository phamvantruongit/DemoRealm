package com.jspvt.demorealm;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmObject;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

public class RealmMigrations implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        final RealmSchema schema=realm.getSchema();
        if(oldVersion==2){
            RealmObjectSchema data=schema.get("Student");
            data.addField(" money",int.class);
        }
    }
}
