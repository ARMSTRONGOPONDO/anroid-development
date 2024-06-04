package com.example.bottom_nav;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    home_fragment home_fragment= new home_fragment();
    notification_fragment notificationFragment= new notification_fragment();
    settings_fragment settings_fragment =new settings_fragment();
    profile_fragment profile_fragment=new profile_fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottomNavigationView= findViewById(R.id.bottom_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, home_fragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemID = item.getItemId();

                if (itemID ==R.id.home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, home_fragment).commit();
                }
                else if (itemID ==R.id.profile){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, profile_fragment).commit();

                }

                else if (itemID ==R.id.notification){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, notificationFragment).commit();

                }

                else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, settings_fragment).commit();

                }

                  return false;
            }

        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}