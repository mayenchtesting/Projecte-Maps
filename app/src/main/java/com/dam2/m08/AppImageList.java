package com.dam2.m08;

import androidx.annotation.NonNull;

import com.dam2.m08.CurrentUser;
import com.dam2.m08.Llamadas.AppImageCRUD;
import com.dam2.m08.Objects.AppImage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class AppImageList
{
    public static ArrayList<AppImage> list = new ArrayList<>();

    public static void getImageList()
    {
        AppImageCRUD image = new AppImageCRUD(CurrentUser.user.getEmail());
        image.get(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    list = image.collectionToAppImageList(task.getResult());
                }
            }
        });

    }
}
