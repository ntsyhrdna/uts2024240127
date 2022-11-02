package com.si5b.uts2024240127;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
EditText etNamaLengkap, etNomorPendaftaran;
CheckBox cbIg, cbFb, cbWeb;
Button btnDaftar;
String socmed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNamaLengkap = findViewById(R.id.et_nama_lengkap);
        etNomorPendaftaran = findViewById(R.id.et_nomor_pendaftaran);
        cbIg = findViewById(R.id.cb_ig);
        cbFb = findViewById(R.id.cb_fb);
        cbWeb = findViewById(R.id.cb_web);
        btnDaftar = findViewById(R.id.btn_daftar);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaLengkap, nomorPendaftaran, check, fb, ig, web;

                namaLengkap = etNamaLengkap.getText().toString();
                nomorPendaftaran = etNomorPendaftaran.getText().toString();
                fb = cbFb.getText().toString();
                ig = cbIg.getText().toString();
                web = cbWeb.getText().toString();

                HashSet<String> hashSocmed = new HashSet<String>();

                if(namaLengkap.trim().equals("")){
                    etNamaLengkap.setError("Nama wajib di inputkan!");
                }

                if(nomorPendaftaran.trim().equals("")){
                    etNomorPendaftaran.setError("Nomor pendaftaran wajib di inputkan!");
                }

                if(cbFb.isChecked()){
                    hashSocmed.add(fb);
                }

                if(cbIg.isChecked()){
                    hashSocmed.add(ig);
                }

                if(cbWeb.isChecked()){
                    hashSocmed.add(web);
                }

                if(!(cbWeb.isChecked() || cbIg.isChecked() || cbFb.isChecked())){
                    Toast.makeText(MainActivity.this, "Pilih minimal satu info pendaftaran anda!", Toast.LENGTH_SHORT).show();
                }

                if(namaLengkap.trim().equals("") && nomorPendaftaran.trim().equals("")){
                    Toast.makeText(MainActivity.this, "Isi terlebih dahulu!", Toast.LENGTH_SHORT).show();
                }

                if(!(namaLengkap.trim().equals("")) && !(nomorPendaftaran.trim().equals("")) && (cbFb.isChecked()) || (cbWeb.isChecked()) || cbIg.isChecked()){
                    socmed = String.join(", ", hashSocmed);
                    Intent go = new Intent(MainActivity.this, MainActivity2.class);
                    go.putExtra("vNama", namaLengkap);
                    go.putExtra("vNoDaftar", nomorPendaftaran);
                    go.putExtra("vCheckbox", "Informasi Pendaftaran Dari : \n" +  socmed);
                    startActivity(go);
                }
            }
        });

    }
}