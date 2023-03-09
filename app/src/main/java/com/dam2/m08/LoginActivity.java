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

import com.dam2.m08.Camera.CameraActivity;
import com.example.projecte_maps.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
            //AuthCRUD auth = new AuthCRUD();

            btnLogin.setOnClickListener(view -> loginUser());
            tvRegisterHere.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, SignupActivity.class)));
            //boolean hasMaxUsers = auth.hasMaxUsers();
            tvRegisterHere.setVisibility(View.VISIBLE);
            //tvRegisterHere.setEnabled(!hasMaxUsers);

            etLoginEmail.setText("jmarinlluset@gmail.com");
            etLoginPassword.setText("Jmll20192020");
        } catch (Exception e) {
            Messages.showMessage(this, e.getMessage());
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
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                    if (task.isSuccessful())
                    {
                        Messages.showMessage(LoginActivity.this, "L'usuari ha iniciat sessió correctament");
                        CurrentUser.user = mAuth.getCurrentUser();
                        startActivity(new Intent(LoginActivity.this, CameraActivity.class));
                    }
                    else{ Messages.showMessage(LoginActivity.this, "Error d'inici de sessió: " + task.getException().getMessage()); }
                });
            }
        }
        catch (Exception e) { Messages.showMessage(this, e.getMessage()); }
    }

}