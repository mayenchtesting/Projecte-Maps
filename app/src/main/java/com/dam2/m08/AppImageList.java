package com.dam2.m08;

import com.dam2.m08.Llamadas.AppImageCRUD;
import com.dam2.m08.Objects.AppImage;

import java.util.ArrayList;
import java.util.Comparator;

public class AppImageList {
    public static ArrayList<AppImage> imageList;

    public static void getImageList(AppImageCRUD db) {
        db.get(task -> {
            if (task.isSuccessful()) {
                imageList = db.collectionToAppImageList(task.getResult());
            }
        });
    }
}
