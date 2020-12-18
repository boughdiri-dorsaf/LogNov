package com.ds.novlag.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ds.novlag.global.Constant;
import com.ds.novlag.data.MyListData;
import com.ds.novlag.R;
import com.ds.novlag.adapter.MyListAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyListData[] myListData = new MyListData[] {
                new MyListData(R.drawable.js, "JavaScript", "JavaScript est un langage de programmation de scripts principalement employé dans les pages web interactives et à ce titre est une partie essentielle des applications web. "),
                new MyListData(R.drawable.python, "Python", "Python est un langage de programmation interprété, multi-paradigme et multiplateformes."),
                new MyListData(R.drawable.java, "Java", "Java est une technique informatique développée initialement par Sun Microsystems puis acquise par Oracle suite au rachat de l'entreprise."),
                new MyListData(R.drawable.php, "PHP", "PHP: Hypertext Preprocessor18, plus connu sous son sigle PHP (sigle auto-référentiel), est un langage de programmation libre19, principalement utilisé pour produire des pages Web dynamiques via un serveur HTTP18, mais pouvant également fonctionner comme n'importe quel langage interprété de façon locale. PHP est un langage impératif orienté objet."),
                new MyListData( R.drawable.c_charp, " C#","C# est un langage de programmation orientée objet, commercialisé par Microsoft depuis 20023 et destiné à développer sur la plateforme Microsoft .NET."),
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.disconnect, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                logout();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void logout(){
        SharedPreferences preferences =getSharedPreferences(Constant.MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(Constant.PREF_IS_CONNECT);
        editor.commit();

        finish();

        startActivity(new Intent(MainActivity.this,LoginActivity.class));
        finish();
    }
}
