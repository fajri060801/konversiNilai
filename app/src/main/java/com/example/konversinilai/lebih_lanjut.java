package com.example.konversinilai;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

public class lebih_lanjut extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        TextView Tnama, Tnim, Tkelas, Thasil, Tketerangan, Tnilai_tugas, Tnilai_uts, Tnilai_uas, Ttotal_nilai;
        ActionBar actionBar;
        ImageView profile, hitler1, hitler2, hitler3, hitler4, hitler5, hitler6;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lebih_lanjut);
        try {
            profile = (ImageView) findViewById(R.id.gambar_profil);

            //meme gambar
            hitler1 = (ImageView) findViewById(R.id.hitler1);
            hitler2 = (ImageView) findViewById(R.id.hitler2);
            hitler3 = (ImageView) findViewById(R.id.hitler3);
            hitler4 = (ImageView) findViewById(R.id.hitler4);
            hitler5 = (ImageView) findViewById(R.id.hitler5);
            hitler6 = (ImageView) findViewById(R.id.hitler6);

            actionBar= getSupportActionBar();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            Picasso.get()
                    .load("https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Adolf_Hitler_42_Pfennig_stamp.jpg/800px-Adolf_Hitler_42_Pfennig_stamp.jpg")
                    .into(profile);

            Picasso.get()
                    .load("https://i.kym-cdn.com/photos/images/newsfeed/001/218/045/522.jpg")
                    .into(hitler1);

            Picasso.get()
                    .load("https://i.kym-cdn.com/photos/images/newsfeed/001/176/693/e18.jpg")
                    .into(hitler2);

            Picasso.get()
                    .load("https://i.kym-cdn.com/photos/images/original/001/170/903/c83.jpg")
                    .into(hitler3);

            Picasso.get()
                    .load("https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Hitler_portrait_crop_%28colorized%29.jpg/675px-Hitler_portrait_crop_%28colorized%29.jpg")
                    .into(hitler4);

            Picasso.get()
                    .load("https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Bundesarchiv_B_145_Bild-F051673-0059%2C_Adolf_Hitler_und_Eva_Braun_auf_dem_Berghof.jpg/1280px-Bundesarchiv_B_145_Bild-F051673-0059%2C_Adolf_Hitler_und_Eva_Braun_auf_dem_Berghof.jpg")
                    .into(hitler5);

            Picasso.get()
                    .load("https://upload.wikimedia.org/wikipedia/commons/7/7f/Bundesarchiv_Bild_101I-771-0366-02A%2C_Russland%2C_Lagebesprechung_mit_Hitler.jpg")
                    .into(hitler6);

            Bundle bundle = getIntent().getExtras();

            Tnama = (TextView) findViewById(R.id.nama);
            Tnim = (TextView) findViewById(R.id.nim);
            Tkelas = (TextView) findViewById(R.id.kelas);
            Thasil = (TextView) findViewById(R.id.hasil);
            Tketerangan= (TextView) findViewById(R.id.keterangan);
            Tnilai_tugas = (TextView) findViewById(R.id.nilai_tugas);
            Tnilai_uts = (TextView) findViewById(R.id.nilai_uts);
            Tnilai_uas = (TextView) findViewById(R.id.nilai_uas);
            Ttotal_nilai = (TextView) findViewById(R.id.total_nilai);

            Tnama.setText(bundle.getString("nama"));
            Tnim.setText(bundle.getString("nim"));
            Tkelas.setText(bundle.getString("kelas"));
            Thasil.setText(bundle.getString("hasil"));
            Tketerangan.setText(bundle.getString("keterangan"));
            Tnilai_tugas.setText(bundle.getString("nilai_tugas"));
            Tnilai_uts.setText(bundle.getString("nilai_uts"));
            Tnilai_uas.setText(bundle.getString("nilai_uas"));
            Ttotal_nilai.setText(bundle.getString("total_nilai"));
        }

        catch (NumberFormatException e){
            SpannableStringBuilder text = new SpannableStringBuilder();
            text.append(e.toString());

            Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinatorLayout),text, BaseTransientBottomBar.LENGTH_LONG).setDuration(8000);
            snackbar.show();
        }


    }

    //button kembali di navbar
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
