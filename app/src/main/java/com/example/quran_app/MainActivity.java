package com.example.quran_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavigationView navView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(getApplicationContext(),"Start",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"End",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer);


        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_SurahUrdu:
                        Toast.makeText(getApplicationContext(),"Surah (Urdu)",Toast.LENGTH_LONG).show();
                        Intent intent1 = new Intent(MainActivity.this,SurahInUrdu.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_Home:
                        Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_LONG).show();
                        Intent intent2 = new Intent(MainActivity.this,Home.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_SurahEng:
                        Toast.makeText(getApplicationContext(),"Surah (Eng)",Toast.LENGTH_LONG).show();
                        Intent intent3 = new Intent(MainActivity.this,SurahInEnglish.class);
                        startActivity(intent3);
                        break;
                    case R.id.nav_ParaUrdu:
                        Toast.makeText(getApplicationContext(),"Parah (Urdu)",Toast.LENGTH_LONG).show();
                        Intent intent4 = new Intent(MainActivity.this,ParahUrdu.class);
                        startActivity(intent4);
                        break;
                    case R.id.nav_ParaEng:
                        Toast.makeText(getApplicationContext(),"Parah (Eng)",Toast.LENGTH_LONG).show();
                        Intent intent5 = new Intent(MainActivity.this,ParahEng.class);
                        startActivity(intent5);
                        break;
                    case R.id.nav_Search:
                        Toast.makeText(getApplicationContext(),"Search",Toast.LENGTH_LONG).show();
                        Intent intent6 = new Intent(MainActivity.this,Search.class);
                        startActivity(intent6);
                        break;
                    case R.id.recSurah:
                        Intent surah = new Intent (MainActivity.this,RecycleSurah.class);
                        startActivity(surah);
                        break;
                    case R.id.recParah:
                        Intent para = new Intent (MainActivity.this,RecycleParah.class);
                        startActivity(para);
                        break;
                    case R.id.email:
                        Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:"));
                        startActivity(intent);
                        break;
                    case R.id.linkedin:
                        Uri linkedin_profile = Uri.parse("https://www.linkedin.com/in/ali-abbas-45331b246/");
                        Intent i = new Intent(Intent.ACTION_VIEW, linkedin_profile);
                        startActivity(i);
                        break;
                    case R.id.github:
                        Uri git_Profile = Uri.parse("https://github.com/BSEF19A525");
                        Intent j = new Intent(Intent.ACTION_VIEW, git_Profile);
                        startActivity(j);
                        break;
                }
                return true;
            }
        });
   }
}