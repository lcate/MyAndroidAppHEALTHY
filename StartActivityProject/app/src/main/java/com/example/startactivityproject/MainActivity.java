package com.example.startactivityproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GithubAuthProvider;
import com.google.firebase.auth.GoogleAuthProvider;


public class MainActivity extends AppCompatActivity {
    public CallbackManager callbackManager;
    EditText mEmail;
    EditText mPassword;
    Button mRegister;
    Button mLogin;
    FirebaseAuth mFirebaseAuth;

    SignInButton mGoogle;
    GoogleSignInClient mGoogleSignInClient;
    public static final int GOOGLE_CODE=1;

    LoginButton mFacebook;
    FirebaseAuth.AuthStateListener mAuthStateListener;
    AccessTokenTracker mAccessTokenTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i=new Intent(getApplicationContext(),LoggedinActivity.class);
        startActivity(i);

        callbackManager=CallbackManager.Factory.create();
        mRegister=findViewById(R.id.ButtonRegister);

        mFirebaseAuth=FirebaseAuth.getInstance();

        mEmail=findViewById(R.id.ETEmail);
        mPassword=findViewById(R.id.ETPassword);
        mRegister=findViewById(R.id.ButtonRegister);
        mLogin=findViewById(R.id.ButtonLogin);

        mGoogle=findViewById(R.id.ButtonGoogle);

        mFacebook=findViewById(R.id.ButtonFacebook);
        FacebookSdk.sdkInitialize(getApplicationContext());


        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString();
                String pass = mPassword.getText().toString();
                if (email.isEmpty()) {
                    mEmail.setError("Please Enter an email");
                    mEmail.requestFocus();

                } else if (pass.isEmpty()) {
                    mPassword.setError("Please Enter a password");
                    mPassword.requestFocus();
                }
                else {
                    mFirebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(MainActivity.this,"Invalid email or password",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent intent=new Intent(getApplicationContext(),LoggedinActivity.class);
                                startActivity(intent);
                            }
                        }
                    });
                }
            }
        });


        /*GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();

        mGoogleSignInClient= GoogleSignIn.getClient(this,gso);
        mGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });*/


        mFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handleFacebookToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Toast.makeText(MainActivity.this,"CANCEL",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(MainActivity.this,"ERROR",Toast.LENGTH_SHORT).show();            }
        });

        mAuthStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser();
                if(user!=null){
                    startActivity(new Intent(getApplicationContext(),LoggedinActivity.class));
                }
            }
        };

        mAccessTokenTracker=new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                if(currentAccessToken==null){
                    mFirebaseAuth.signOut();
                }
            }
        };

    }

    private void signIn() {
        Intent intent=mGoogleSignInClient.getSignInIntent();
        startActivityForResult(intent,GOOGLE_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GOOGLE_CODE){
            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInRequest(task);
        }
    }

    private void handleSignInRequest(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount acc=completedTask.getResult(ApiException.class);
            FirebaseGoogleAuth(acc);
        }
        catch (ApiException e){
            Toast.makeText(MainActivity.this,"Sign In failed",Toast.LENGTH_SHORT).show();
        }
    }

    private void FirebaseGoogleAuth(GoogleSignInAccount acc) {
        AuthCredential authCredential= GoogleAuthProvider.getCredential(acc.getIdToken(),null);
        mFirebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this,"Google logIn successful",Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(getApplicationContext(),LoggedinActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this,"GOOGLE logIn failed",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    private void handleFacebookToken(AccessToken accessToken) {
        AuthCredential credential= FacebookAuthProvider.getCredential(accessToken.getToken());
        mFirebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user=mFirebaseAuth.getCurrentUser();
                    Toast.makeText(MainActivity.this,"Facebook logIn successful",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),LoggedinActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"Facebook logIn failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mAuthStateListener!=null)
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
    }


}
