package com.dam2.m08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dam2.m08.Llamadas.AppImageCRUD;
import com.dam2.m08.Objects.AppImage;
import com.example.projecte_maps.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.time.LocalDateTime;

public class MainActivity extends AppCompatActivity
{
    Button btnLogOut;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogOut = findViewById(R.id.btnLogout);
        mAuth = FirebaseAuth.getInstance();

        btnLogOut.setOnClickListener(view ->
        {
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        } else {
            CurrentUser.user = user;
            AppImageCRUD db = new AppImageCRUD(user.getEmail());
            TextView txt = findViewById(R.id.txt);
            ImageView img = findViewById(R.id.img);
            findViewById(R.id.crear).setOnClickListener(l -> db.insert(new AppImage(
                            BitmapFactory.decodeResource(this.getResources(), R.drawable.firebase_image),
                            13,
                            31,
                            LocalDateTime.now(),
                            user.getEmail()),
                    task -> {
                        if (task.isSuccessful()) {
                            Messages.showMessage(MainActivity.this, "insert correcto");
                        } else {
                            Messages.showMessage(MainActivity.this, "error en insert");
                        }
                    }));
            findViewById(R.id.update).setOnClickListener(l -> db.update(new AppImage(
                            "a",
                            BitmapFactory.decodeResource(this.getResources(), R.drawable.firebase_image),
                            //Utils.getThumbnail(BitmapFactory.decodeResource(this.getResources(), R.drawable.firebase_image)),
                            7777,
                            7777,
                            LocalDateTime.now(),
                            user.getEmail()),
                    task -> {
                        if (task.isSuccessful()) {
                            Messages.showMessage(MainActivity.this, "update correcto");
                        } else {
                            Messages.showMessage(MainActivity.this, "error en update");
                        }
                    }));
            findViewById(R.id.delete).setOnClickListener(l -> db.delete("a",
                    task -> {
                        if (task.isSuccessful()) {
                            Messages.showMessage(MainActivity.this, "delete correcto");
                        } else {
                            Messages.showMessage(MainActivity.this, "error en delete");
                        }
                    }));
            findViewById(R.id.getAll).setOnClickListener(l -> db.get(task -> {
                        if (task.isSuccessful()) {
                            AppImage appImage = db.collectionToAppImageList(task.getResult()).get(0);
                            MainActivity.this.runOnUiThread(() -> {
                                txt.setText(appImage.getId() + " " + appImage.getUser());
                                img.setImageBitmap(appImage.getImage());
                            });
                        } else {
                            Messages.showMessage(MainActivity.this, "error en getAll");
                        }
                    }));
            findViewById(R.id.get).setOnClickListener(l -> db.get("a",
                                                                  task -> {
                if (task.isSuccessful()) {
                    AppImage appImage = db.documentToAppImage(task.getResult());
                    MainActivity.this.runOnUiThread(() -> {
                        txt.setText(appImage.getId() + " " + appImage.getUser());
                        img.setImageBitmap(appImage.getImage());
                    });
                } else {
                    Messages.showMessage(MainActivity.this, "error en getAll");
                }
            }));
        }
    }
}