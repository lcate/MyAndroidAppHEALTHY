package com.example.startactivityproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    ImageView mImageView;
    TextView mTextView;

    TextView mTextView1;
    TextView mTextView2;
    TextView mTextView3;
    TextView mTextView4;
    TextView mTextView5;
    TextView mTextView6;
    ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mImageView=findViewById(R.id.IV);
        mTextView=findViewById(R.id.TV);
        mTextView1=findViewById(R.id.TV2);
        mTextView2=findViewById(R.id.TV3);
        mTextView3=findViewById(R.id.TV4);
        mTextView4=findViewById(R.id.TV5);
        mTextView5=findViewById(R.id.TV6);
        mTextView6=findViewById(R.id.TV7);


        Bundle bundle=getIntent().getExtras();
        if(getIntent().hasExtra("image")) {
            int src = bundle.getInt("image");
            mImageView.setImageResource(src);
        }
        if(getIntent().hasExtra("img")) {
            byte[] src=bundle.getByteArray("img");
            Bitmap bmp= BitmapFactory.decodeByteArray(src,0,src.length);
            mImageView.setImageBitmap(bmp);
        }
        if(getIntent().hasExtra("title")) {
            String title = bundle.getString("title");
            mTextView.setText(title);
        }
        if(getIntent().hasExtra("list")) {
            list = bundle.getStringArrayList("list");
            if (list.get(0) != null)
                mTextView1.setText(list.get(0));
            if (list.get(1) != null)
                mTextView2.setText(list.get(1));
            if (list.get(2) != null)
                mTextView3.setText(list.get(2));
            if (list.get(3) != null)
                mTextView4.setText(list.get(3));
            if (list.get(4) != null)
                mTextView5.setText(list.get(4));
            if (list.get(5) != null)
                mTextView6.setText(list.get(5));
        }



    }
    //kopcinjata u toolbar
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
