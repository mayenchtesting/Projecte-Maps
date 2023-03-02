package com.dam2.m08;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projecte_maps.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity
{
    TextInputEditText etLoginEmail;
    TextInputEditText etLoginPassword;
    TextView tvRegisterHere;
    Button btnLogin;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        try
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            etLoginEmail = findViewById(R.id.etLoginEmail);
            etLoginPassword = findViewById(R.id.etLoginPass);
            tvRegisterHere = findViewById(R.id.tvRegisterHere);
            btnLogin = findViewById(R.id.btnLogin);

            mAuth = FirebaseAuth.getInstance();

            btnLogin.setOnClickListener(view -> { loginUser(); });
            tvRegisterHere.setOnClickListener(view ->{
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            });
            tvRegisterHere.setVisibility(View.VISIBLE);

        } catch (Exception e) {
            ShowError.showError(this, e.getMessage());
        }
    }

    private void loginUser()
    {
        try
        {
            String email = etLoginEmail.getText().toString();
            String password = etLoginPassword.getText().toString();

            if (TextUtils.isEmpty(email))
            {
                etLoginEmail.setError("L'email no pot estar buit");
                etLoginEmail.requestFocus();
            }
            else if (TextUtils.isEmpty(password))
            {
                etLoginPassword.setError("La contrasenya no pot estar buida");
                etLoginPassword.requestFocus();
            }
            else
            {
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(LoginActivity.this, "L'usuari ha iniciat sessió correctament", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        }
                        else{ Toast.makeText(LoginActivity.this, "Error d'inici de sessió: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show(); }
                    }
                });
            }
        }
        catch (Exception e) { ShowError.showError(this, e.getMessage()); }
    }

}