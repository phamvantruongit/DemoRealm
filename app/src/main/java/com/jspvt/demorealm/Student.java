package com.jspvt.demorealm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Student extends RealmObject {
    @PrimaryKey
    public String id;
    public String name;
    public int age;
    public int money;
}
