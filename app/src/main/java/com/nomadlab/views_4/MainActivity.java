package com.nomadlab.views_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    MaterialToolbar topAppBar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topAppBar = findViewById(R.id.topAppBar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);

        addMenuEventListener();
    }

    @SuppressLint("NonConstantResourceId")
    private void addMenuEventListener() {
        topAppBar.setNavigationOnClickListener(view -> {
            // Drawer
            drawerLayout.openDrawer(Gravity.LEFT);
            Log.d("TAG", "get id : " + view.getId());
        });
        topAppBar.setOnMenuItemClickListener(item -> {
            selectedMenuItem(item);
            return true;
        });
        navigationView.setNavigationItemSelectedListener(item -> {
            selectedMenuItem(item);
            return true;
        });
    }

    @SuppressLint("NonConstantResourceId")
    private void selectedMenuItem(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favorite:
                Log.d("TAG", "favorite");
                changeActivity(this, FavoriteActivity.class);
                break;
            case R.id.search:
                Log.d("TAG", "search");
                changeActivity(this, SearchActivity.class);
                break;
            case R.id.more:
                Log.d("TAG", "more");
                changeActivity(this, MoreActivity.class);
                break;
        }
    }

    private void changeActivity(Context packageContext, Class<?> cls) {
        Intent intent = new Intent(packageContext, cls);
        startActivity(intent);
    }

//    @Override
//    public void onBackPressed() {
//        if(drawerLayout.isDrawerOpen(navigationView)) {
//            drawerLayout.closeDrawer(navigationView);
//        } else {
//            super.onBackPressed();
//        }
//
//    }
}