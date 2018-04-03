package com.bso.android.realmmovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bso.android.realmmovie.realm.MovieRealmModel;
import com.bso.android.realmmovie.realm.RealmHelper;

import io.realm.Realm;

public class AddActivity extends AppCompatActivity {

    AutoCompleteTextView actjudul, acttahun, actproduksi;
    ImageButton imgbtnposter;
    TextView tvposter;
    String mJudul, mTahun, mProduksi, mPoster;
    Realm realm1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        actjudul = findViewById(R.id.tv_judul);
        acttahun = findViewById(R.id.tv_tahun);
        actproduksi = findViewById(R.id.tv_produksi);
        imgbtnposter = findViewById(R.id.btn_poster);
        tvposter = findViewById(R.id.tv_poster);

        imgbtnposter.setOnClickListener(add);
    }

    public View.OnClickListener add = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mJudul = actjudul.getText().toString();
            mTahun = acttahun.getText().toString();
            mProduksi = actproduksi.getText().toString();
            mPoster = tvposter.getText().toString();
            if(!mJudul.isEmpty() && !mTahun.isEmpty() && !mProduksi.isEmpty() && !mPoster.isEmpty()){
                MovieRealmModel movieRealmModel = new MovieRealmModel();
                movieRealmModel.setJudul(mJudul);
                movieRealmModel.setTahun(mTahun);
                movieRealmModel.setProduksi(mProduksi);
                movieRealmModel.setPoster(mPoster);

                RealmHelper realmhelper = new RealmHelper(realm1);
                realmhelper.save(movieRealmModel);

                Intent intent = new Intent(getApplicationContext(), Beranda.class);
                startActivity(intent);
            }
        }
    };
}
