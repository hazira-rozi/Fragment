package com.rpl.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomHomeNav = findViewById(R.id.bottomNavigationView);
        bottomHomeNav.setOnItemSelectedListener(botNavListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                    new HomeFragment()).commit();
//            navigationView.setCheckedItem(R.id.nav_home);

        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Home");
        }
    }

    private NavigationBarView.OnItemSelectedListener botNavListener =
            item -> {
                Fragment selectedFragment = null;
                int title = R.string.title_home;
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        title = R.string.title_home;
                        break;
                    case R.id.nav_help:
                        selectedFragment = new HelpFragment();
                        title = R.string.title_help;
                        break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                        selectedFragment).commit();

                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(title);
                }

                return true;
            };
}