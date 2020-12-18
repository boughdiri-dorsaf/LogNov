package com.ds.novlag.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ds.novlag.R;

public class DetailActivity extends AppCompatActivity {
    TextView txtTitre;
    ImageView imgLang;
    TextView txtDesc;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        
        txtTitre = findViewById(R.id.txt_name_detail);
        imgLang = findViewById(R.id.img_detail);
        txtDesc = findViewById(R.id.txt_desc_detail);

        intent = getIntent();

        remplirData();
    }

    public void remplirData(){
        txtTitre.setText(intent.getStringExtra("langTitre"));
        txtDesc.setText(intent.getStringExtra("langDesc"));
        imgLang.setImageResource(intent.getIntExtra("langImg", R.drawable.icon));
    }
}