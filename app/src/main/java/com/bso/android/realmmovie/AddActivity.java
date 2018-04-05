package com.bso.android.realmmovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bso.android.realmmovie.realm.MovieRealmModel;
import com.bso.android.realmmovie.realm.RealmHelper;

import io.realm.Realm;

public class AddActivity extends AppCompatActivity {

    AutoCompleteTextView actjudul, acttahun, actproduksi, actposter;
    //ImageButton imgbtnposter;
    //TextView tvposter;
    String mJudul, mTahun, mProduksi;
    //mPoster;
    Button btnsimpan;
    Realm realm1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        actjudul = findViewById(R.id.tv_judul);
        acttahun = findViewById(R.id.tv_tahun);
        actproduksi = findViewById(R.id.tv_produksi);
        //actposter = findViewById(R.id.tv_poster);
        //imgbtnposter = findViewById(R.id.btn_poster);
        //tvposter = findViewById(R.id.tv_poster);
        btnsimpan = findViewById(R.id.btn_simpan);

        //imgbtnposter.setOnClickListener(pickposter);
        btnsimpan.setOnClickListener(add);
    }

    public View.OnClickListener pickposter = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivity(galleryIntent);
        }
    };

    public View.OnClickListener add = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mJudul = actjudul.getText().toString();
            mTahun = acttahun.getText().toString();
            mProduksi = actproduksi.getText().toString();
            //mPoster = tvposter.getText().toString();
            //mPoster = actposter.getText().toString();
            if(!mJudul.isEmpty() && !mTahun.isEmpty() && !mProduksi.isEmpty()){
                // && !mPoster.isEmpty()
                MovieRealmModel movieRealmModel = new MovieRealmModel();
                movieRealmModel.setJudul(mJudul);
                movieRealmModel.setTahun(mTahun);
                movieRealmModel.setProduksi(mProduksi);
                //movieRealmModel.setPoster(mPoster);

                RealmHelper realmhelper = new RealmHelper(realm1);
                realmhelper.save(movieRealmModel);

                Toast.makeText(AddActivity.this, "Berhasil di Input!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), Beranda.class);
                startActivity(intent);
            }else{
               Toast.makeText(AddActivity.this, "Pastikan semua kolom terisi!", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
