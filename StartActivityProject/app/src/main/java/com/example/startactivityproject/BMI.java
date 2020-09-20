package com.example.startactivityproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

public class BMI extends AppCompatActivity {

    Button mCalculate;
    TextView mResult;
    EditText mWeight,mHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        mCalculate=findViewById(R.id.calculate);
        mResult=findViewById(R.id.result);
        mWeight=findViewById(R.id.weight);
        mHeight=findViewById(R.id.height);


        mCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result=0;
                double weight,height;
                weight = Double.parseDouble(mWeight.getText().toString());
                height = Double.parseDouble(mHeight.getText().toString());
                if(weight!=0 && height!=0) {
                    double heightM = height / 100;
                    result = weight / (heightM * heightM);
                    String nekoj = Double.toString(result);
                    mResult.setText(nekoj);

                    if (result < 18.5) {
                        mResult.setTextColor(Color.parseColor("#33FFD8"));
                    } else if (result > 18.5 && result < 24.9) {
                        mResult.setTextColor(Color.parseColor("#28D524"));
                    } else if (result > 24.9 && result < 29.9) {
                        mResult.setTextColor(Color.parseColor("#FFD040"));
                    } else if (result > 29.9 && result < 34.9) {
                        mResult.setTextColor(Color.parseColor("#FF6600"));
                    } else if (result >= 35) {
                        mResult.setTextColor(Color.parseColor("#FF0000"));
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"Your weight and height can't be 0!",Toast.LENGTH_SHORT).show();
                }
            }

        });

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
            case R.id.IHome:
                Intent intentHome=new Intent(getApplicationContext(),LoggedinActivity.class);
                startActivity(intentHome);
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
