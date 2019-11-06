package com.sagar.awosmedarktheme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    boolean isDark;
    String[] array = {"Android","Name","Satsang","Honey","Comb","Android","Name","Satsang"
            ,"Honey","Comb","Android","Name","Satsang","Honey","Comb","Android","Name"
            ,"Satsang","Honey","Comb","Android","Name","Satsang","Honey","Comb","Android"
            ,"Name","Satsang","Honey","Comb","Android","Name","Satsang","Honey","Comb","Android"
            ,"Name","Satsang","Honey","Comb"};
    FloatingActionButton floatingActionButton;
    ConstraintLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isDark=getThemeState();

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new Adapter(this,array,isDark);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        floatingActionButton = findViewById(R.id.fabSwitcher);
        rootLayout=findViewById(R.id.rootLayout);

        if (isDark){
            rootLayout.setBackgroundColor(getResources().getColor(R.color.black));

        }else {
            rootLayout.setBackgroundColor(getResources().getColor(R.color.white));
        }
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isDark = !isDark;
                if (isDark){
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.black));
                }else{
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.white));
                }
                adapter = new Adapter(MainActivity.this,array,isDark);
                recyclerView.setAdapter(adapter);
                saveThemeStatepref(isDark);
            }
        });


    }

    private void saveThemeStatepref(boolean isDark){
        SharedPreferences preferences = getApplication().getSharedPreferences("mypref",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isDark",isDark);
        editor.commit();
    }

    private boolean getThemeState(){
        SharedPreferences preferences = getApplication().getSharedPreferences("mypref",MODE_PRIVATE);
        boolean isDark = preferences.getBoolean("isDark",false);
        return isDark;
    }


}
