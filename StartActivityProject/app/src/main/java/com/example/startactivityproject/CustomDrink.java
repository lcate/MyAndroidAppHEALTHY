package com.example.startactivityproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class CustomDrink extends AppCompatActivity implements CustomAdapter.customClickListener{
    DataBaseHelper mDatabaseHelper;
    SQLiteDatabase mDatabase;
    CustomAdapter customAdapter;
    RecyclerView nov;
    Button mCustom;
    ArrayList<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diets);

        mDatabaseHelper=new DataBaseHelper(getApplicationContext());
        mDatabase=mDatabaseHelper.getWritableDatabase();
        mCustom=findViewById(R.id.customDrink);

        mCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent customIntent=new Intent(getApplicationContext(), CreateCustomDrink.class);
                startActivityForResult(customIntent,2);

            }
        });

        nov=findViewById(R.id.nov);
        nov.setLayoutManager(new LinearLayoutManager(this));
        customAdapter=new CustomAdapter(this,mDatabase.query("tabela",null,null,null,null,null,null),this);
        nov.setAdapter(customAdapter);
    }


    @Override
    public void onCustomClick(int position) {
        Cursor cursor=mDatabase.rawQuery("select * from tabela",null);
        if(cursor.getCount()==0)
            Toast.makeText(getApplicationContext(),"NO DATA",Toast.LENGTH_SHORT).show();
        else{
            cursor.moveToPosition(position);
            String name=cursor.getString(1);
            lista=new ArrayList<>();
            lista.add(cursor.getString(2));
            lista.add(cursor.getString(3));
            lista.add(cursor.getString(4));
            lista.add(cursor.getString(5));
            lista.add(cursor.getString(6));
            lista.add(null);
            byte[] image=cursor.getBlob(7);
            Intent intentStart=new Intent(getApplicationContext(),DetailsActivity.class);
            intentStart.putExtra("title",name);
            intentStart.putExtra("list",lista);
            intentStart.putExtra("img",image);
            startActivity(intentStart);

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2 && resultCode==RESULT_OK){
            customAdapter.swapCursor(mDatabase.query("tabela", null, null, null, null, null, null));
        }
    }

    //kopcinjata od toolbar
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
