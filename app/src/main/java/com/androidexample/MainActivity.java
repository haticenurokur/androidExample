package com.androidexample;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Yeni Fragment aşağıdaki 4 satır kod ile açılır

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // hangi fragmenta gitmek istiyorsan onu buraya yazıyorsun
        transaction.replace(R.id.content_frame, new ExampleFragment());

        transaction.disallowAddToBackStack(); // bu geri dönme stack'ine eklemez
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {

        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) { // eğer en başa geldiyse uygulamadan çıkar
            super.onBackPressed();

        } else { // eğer daha geri gelecek fragment varsa bir öncekine döner.
            getSupportFragmentManager().popBackStack();
        }

    }
}
