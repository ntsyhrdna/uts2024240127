package com.si5b.uts2024240127;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView tvNamaLen, tvInfokan, tvNomorPend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvNamaLen = findViewById(R.id.tv_nama_len);
        tvNomorPend = findViewById(R.id.tv_nomor_pend);
        tvInfokan = findViewById(R.id.tv_infokan);

        Intent get = getIntent();
        tvNamaLen.setText(get.getStringExtra("vNama"));
        tvNomorPend.setText(get.getStringExtra("vNoDaftar"));
        tvInfokan.setText(get.getStringExtra("vCheckbox"));
    }
}