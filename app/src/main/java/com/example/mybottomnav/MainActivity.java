package com.example.mybottomnav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
//import android.support.v4.app.FragmentActivity;
//import androidx.fragment.app.FragmentActivity;
import android.widget.Toast;

import com.example.mybottomnav.databinding.ActivityMainBinding;
import com.google.android.material.badge.BadgeDrawable;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater() );
        setContentView(binding.getRoot());

        //BadgeDrawable badgeDrawable = bottomNavigationView.getOncreate

        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.home:
                   replaceFragment(new HomeFragment());
                   break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment()); 
                    break;
                case R.id.post:
                    replaceFragment(new PostFragment());
                    break;
                case R.id.setting:
                    replaceFragment(new SettingFragment());
                    break;
                case R.id.notification:
                    replaceFragment(new NotificationFragment());
                    break;

            }

            return true;
        });


    }
    private void replaceFragment(Fragment fragment) {

        FragmentManager FragmentManager = getSupportFragmentManager();

        //BadgeDrawable badgeDrawable = bottomNavigationView.
        FragmentTransaction FragmentTransaction = FragmentManager.beginTransaction();
        FragmentTransaction.replace(R.id.frame_layout, fragment);

        FragmentTransaction.commit();
    }
}