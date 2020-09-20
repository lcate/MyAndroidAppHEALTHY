package com.example.startactivityproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class FoodDetails extends AppCompatActivity {
    ImageView mImageView;
    TextView mTextView;
    RecyclerView mRecyclerView;
    ArrayList<String> lista;
    RecyclerView.LayoutManager mLayoutManager;
    FoodAdapter mAdapter;
    TextView mSteps;
    ArrayList<String> steps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        mImageView=findViewById(R.id.IView);
        mTextView=findViewById(R.id.TView);
        mRecyclerView=findViewById(R.id.foodRecyclerView);
        mSteps=findViewById(R.id.steps);

        Bundle bundle=getIntent().getExtras();

        if(getIntent().hasExtra("image")) {
            int src = bundle.getInt("image");
            mImageView.setImageResource(src);
        }
        if(getIntent().hasExtra("title")) {
            String title = bundle.getString("title");
            mTextView.setText(title);
        }
        if(getIntent().hasExtra("list")) {
            lista=bundle.getStringArrayList("list");

            mRecyclerView.setHasFixedSize(true);
            mLayoutManager=new LinearLayoutManager(this);
            mAdapter=new FoodAdapter(lista);
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mAdapter);
        }
        if(getIntent().hasExtra("steps")){
            steps=bundle.getStringArrayList("steps");
        }
        else {
            steps=new ArrayList<>();
        }

        mSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),StepByStep.class);
                intent.putExtra("steps",steps);
                startActivity(intent);
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
