package com.example.startactivityproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class StepByStep extends AppCompatActivity {
    ArrayList<String> lista;

    RecyclerView mRecyclerView;
    private FoodAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_by_step);
        mRecyclerView=findViewById(R.id.recycle);

        Bundle bundle=getIntent().getExtras();

        if(getIntent().hasExtra("steps")) {
            lista=bundle.getStringArrayList("steps");

            mRecyclerView.setHasFixedSize(true);
            mAdapter=new FoodAdapter(lista);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.setAdapter(mAdapter);
        }
    }
}
