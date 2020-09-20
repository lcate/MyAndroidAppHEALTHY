package com.example.startactivityproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

public class LoggedinActivity extends AppCompatActivity {
    ImageView mDrinks;
    ImageView mFood;
    ImageView mDiets;
    ImageView mBmi;
    ImageView mMaps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggedin);

        mDrinks=findViewById(R.id.drinks);
        mFood=findViewById(R.id.food);
        mDiets=findViewById(R.id.diet);
        mBmi=findViewById(R.id.bmi);
        mMaps=findViewById(R.id.maps);

        mDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDrinks=new Intent(getApplicationContext(),HealthyDrinks.class);
                startActivity(intentDrinks);

            }
        });

        mFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFood=new Intent(getApplicationContext(),HealthyFood.class);
                startActivity(intentFood);
            }
        });

        mDiets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFood=new Intent(getApplicationContext(), CustomDrink.class);
                startActivity(intentFood);
            }
        });
        mBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBmi=new Intent(getApplicationContext(),BMI.class);
                startActivity(intentBmi);
            }
        });

        mMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intentMaps=new Intent(getApplicationContext(),MapsActivity.class);
            startActivity(intentMaps);


            }
        });

    }


    @Override
    public void onBackPressed() {
        logOut();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.ILogOut:
                logOut();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logOut() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.alert_dark_frame)
                .setTitle("Logout Alert").setMessage("Are you sure you want to logout?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                LoginManager.getInstance().logOut();
            }
        }).setNegativeButton("NO",null).show();



    }
}
