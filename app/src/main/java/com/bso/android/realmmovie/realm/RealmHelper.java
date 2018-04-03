package com.bso.android.realmmovie.realm;

import android.util.Log;

import io.realm.Realm;
import io.realm.RealmModel;

/**
 * Created by Lu'lu' on 02/04/2018.
 */

public class RealmHelper{

    Realm realm;

    public RealmHelper(Realm realm) {
        this.realm = realm;
    }

    public void save(final MovieRealmModel movieRealmModel){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if(realm != null){
                    Log.e("e","database was created");
                    Number currentIdNum = realm.where(MovieRealmModel.class).max("id");
                    int nextId;
                    if(currentIdNum == null){
                        nextId = 1;
                    }else{
                        nextId = currentIdNum.intValue() + 1;
                    }

                    movieRealmModel.setId(nextId);
                    MovieRealmModel p = realm.copyToRealm(movieRealmModel);
                }else{
                    Log.e("e", "database not exist");
                }
            }
        });
    }
}
