package com.example.poet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class Forgotpassword extends AppCompatActivity {

    Button resetbtn;
    FirebaseAuth mAuth;
    ProgressBar pbar;
    String email;
    EditText forgotemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        resetbtn = findViewById(R.id.resetbtn);
        forgotemail = findViewById(R.id.forgotEmail);
        mAuth = FirebaseAuth.getInstance();
        pbar = findViewById(R.id.forgotpbar);

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = forgotemail.getText().toString().trim();
                pbar.setVisibility(View.GONE);
                if (!TextUtils.isEmpty(email)) {
                    ResetPassword();
                } else {
                    Toast.makeText(getApplicationContext(), "Email can't be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void ResetPassword(){
        pbar.setVisibility(View.VISIBLE);

        mAuth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

                resetbtn.setVisibility(View.INVISIBLE);
                Toast.makeText(Forgotpassword.this, "Reset Password link has been sent to your given email", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();

            }
        }) .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pbar.setVisibility(View.INVISIBLE);
                Toast.makeText(Forgotpassword.this, "Error :- "+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });




    }
}