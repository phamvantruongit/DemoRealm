package com.jspvt.demorealm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm realm=Realm.getDefaultInstance();


        final Student student=new Student();
        student.id= String.valueOf(UUID.randomUUID());
        student.name="Dev Android";
        student.age=20;

        final Student student1=new Student();
        student1.id= String.valueOf(UUID.randomUUID());
        student1.name="Pham van truong";
        student1.age=20;


        final Student student2=new Student();
        student2.id= String.valueOf(UUID.randomUUID());
        student2.name="Pham van hung";
        student2.age=20;


        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
//                    realm.insertOrUpdate(student);
//                    realm.insertOrUpdate(student1);
//                    realm.insertOrUpdate(student2);
                    Toast.makeText(MainActivity.this, "Add success", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });


        final RealmResults<Student> results = realm.where(Student.class).findAll();
        for(Student data: results){
            Log.d("PPPP",data.id + data.name +data.money+"");
        }



        //get Data by id
        Student find=realm.where(Student.class).beginsWith("id","2d8a7c87-6790-4bcd-be42-787cd29aa6a").findFirst();







        //Edit data
    /*    realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                final Student student=new Student();
                student.id= "c0a49774-0f75-4897-999e-9a61d2832faf";
                student.name="Pham Van Truong";
                student.age=20;
                realm.copyToRealmOrUpdate(student);
            }
        });
        */



      /*  realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Student data=realm.where(Student.class).equalTo("id","a98d57a2-bfce-48b2-b4e1-a2066f38274a").findFirst();
                data.deleteFromRealm();
            }
        });
        */




    /* realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    RealmResults<Student> students=realm.where(Student.class).findAll();
                    students.deleteAllFromRealm();
                    Toast.makeText(MainActivity.this, "Delete success", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Delete error", Toast.LENGTH_SHORT).show();
                }

            }
        });
        */


    }
}
