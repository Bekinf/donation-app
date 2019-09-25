package com.kawig.tourismapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText memail_editTxt;
    private EditText mpass_editTxt;

    private Button msign_btn;

    private ProgressBar mlod_bar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        memail_editTxt=(EditText)findViewById(R.id.email_editTxt);
        mpass_editTxt= (EditText)findViewById(R.id.pass_editTxt);

        msign_btn= (Button) findViewById(R.id.sign_btn);

        mlod_bar= (ProgressBar)findViewById(R.id.lod_bar);

        msign_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmpty()) return;
                inprogress(true);
                mAuth.signInWithEmailAndPassword(memail_editTxt.getText().toString(),mpass_editTxt.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(Login.this,"User Signned in",Toast.LENGTH_LONG).show();
                                Intent intent =new Intent( Login.this,AdHome.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();
                                return;
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        inprogress(false);
                        Toast.makeText(Login.this,"Sign in Failed"+e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });


            }


        });

    }
    private void inprogress (boolean x){
        if(x){
            mlod_bar.setVisibility(View.VISIBLE);
            msign_btn.setEnabled(false);
        }else{
            mlod_bar.setVisibility(View.GONE);
            msign_btn.setEnabled(true);
        }
    }

    private boolean isEmpty() {
        if (TextUtils.isEmpty(memail_editTxt.getText().toString())) {
            memail_editTxt.setError("REQUIRED");
            return true;

        }
        if (TextUtils.isEmpty(mpass_editTxt.getText().toString())) {
            mpass_editTxt.setError("REQUIRED");
            return true;

        }

        return false;
    }
}
