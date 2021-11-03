package com.example.konversinilai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    EditText input_nilai_uts, input_nilai_uas, input_nilai_tugas, input_nama, input_nim, input_kelas;
    Button btn_konversi, btn_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_konversi =(Button) findViewById(R.id.btn_konversi);
        btn_reset =(Button) findViewById(R.id.btn_reset);

        input_nilai_uts =(EditText) findViewById(R.id.input_nilai_uts);
        input_nilai_uas =(EditText) findViewById(R.id.input_nilai_uas);
        input_nilai_tugas =(EditText) findViewById(R.id.input_nilai_tugas);
        input_nama =(EditText) findViewById(R.id.input_nama);
        input_nim =(EditText) findViewById(R.id.input_nim);
        input_kelas =(EditText) findViewById(R.id.input_kelas);


        btn_konversi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                konversi();
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input_nama.setText("");
                input_nim.setText("");
                input_kelas.setText("");
                input_nilai_tugas.setText("");
                input_nilai_uas.setText("");
                input_nilai_uts.setText("");
            }
        });

    }

    public void konversi(){
        try {
            int nilai_uts = Integer.parseInt(input_nilai_uts.getText().toString());
            int nilai_tugas = Integer.parseInt(input_nilai_uas.getText().toString());
            int nilai_uas = Integer.parseInt(input_nilai_tugas.getText().toString());

            String nama = input_nama.getText().toString();
            String nim = input_nim.getText().toString();
            String kelas = input_kelas.getText().toString();

            char hasil[]= {'A','B','C','D','E'};
            char hasil_mahasiswa;
            String keterangan[] = {"Selamat anda lulus","Maaf anda tidak lulus"};
            String keterangan_mahasiswa;

            int total_nilai = (int) ((0.35*nilai_uts)+(0.35*nilai_uas)+(0.30*nilai_tugas));

            if ((total_nilai >= 80) && (total_nilai <= 100)){
                hasil_mahasiswa= hasil[0];
                keterangan_mahasiswa=keterangan[0];
            }
            else if((total_nilai >= 70) && (total_nilai < 80)){
                hasil_mahasiswa= hasil[1];
                keterangan_mahasiswa=keterangan[0];
            }
            else if((total_nilai >= 60) && (total_nilai < 70)){
                hasil_mahasiswa= hasil[2];
                keterangan_mahasiswa=keterangan[0];
            }
            else if((total_nilai >= 40) && (total_nilai < 60)){
                hasil_mahasiswa= hasil[3];
                keterangan_mahasiswa=keterangan[1];
            }
            else {
                hasil_mahasiswa= hasil[4];
                keterangan_mahasiswa=keterangan[1];
            }

            Intent intent = new Intent(MainActivity.this, tampil_hasil.class);
            Bundle bundle = new Bundle();

            //Data yang sudah dikonversikan dan akan dikirimkan antar layout
            bundle.putString("nama",nama);
            bundle.putString("nim",nim);
            bundle.putString("kelas",kelas);

            bundle.putString("nilai_tugas", String.valueOf(nilai_tugas));
            bundle.putString("nilai_uts",String.valueOf(nilai_uts));
            bundle.putString("nilai_uas",String.valueOf(nilai_uas));
            bundle.putString("total_nilai", String.valueOf(total_nilai));
            bundle.putString("hasil", String.valueOf(hasil_mahasiswa));
            bundle.putString("keterangan", keterangan_mahasiswa);

            //proses pindah layout dan menyertakan data yang akan dikirim
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
}