package com.example.konversinilai;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class tampil_hasil extends AppCompatActivity {

    ActionBar actionBar;
    TextView Tnama, Tnim, Tkelas, Thasil, Tketerangan;
    Button detail;

    String nama, nim, kelas, hasil, keterangan;
    String total_nilai, nilai_uts, nilai_tugas, nilai_uas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampil_hasil);

        actionBar= getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();

        //Ubah objek ke variabel
        Tnama = (TextView) findViewById(R.id.nama);
        Tnim = (TextView) findViewById(R.id.nim);
        Tkelas = (TextView) findViewById(R.id.kelas);
        Thasil = (TextView) findViewById(R.id.hasil);
        Tketerangan= (TextView) findViewById(R.id.keterangan);

        detail=(Button) findViewById(R.id.detail);

        //Masukkan key data ke dalam string
        nama =bundle.getString("nama");
        nim =bundle.getString("nim");
        kelas =bundle.getString("kelas");
        hasil = bundle.getString("hasil");
        keterangan =bundle.getString("keterangan");

        nilai_tugas =bundle.getString("nilai_tugas");
        nilai_uts = bundle.getString("nilai_uts");
        nilai_uas =bundle.getString("nilai_uas");
        total_nilai = bundle.getString("total_nilai");

        //Set kan ke dalam textview
        Tnama.setText(nama);
        Tnim.setText(nim);
        Tkelas.setText(kelas);
        Thasil.setText(hasil);
        Tketerangan.setText(keterangan);

        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(tampil_hasil.this, lebih_lanjut.class);
                    Bundle bundle = new Bundle();

                    bundle.putString("nama",nama);
                    bundle.putString("nim",nim);
                    bundle.putString("kelas",kelas);
                    bundle.putString("hasil",hasil);
                    bundle.putString("keterangan",keterangan);

                    bundle.putString("nilai_tugas",nilai_tugas);
                    bundle.putString("nilai_uts",nilai_uts);
                    bundle.putString("nilai_uas",nilai_uas);
                    bundle.putString("total_nilai",total_nilai);

                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                catch (NumberFormatException e){
                    SpannableStringBuilder text = new SpannableStringBuilder();
                    text.append(e.toString());

                    Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinatorLayout),text, BaseTransientBottomBar.LENGTH_LONG).setDuration(8000);
                    snackbar.show();
                }

            }
        });

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
