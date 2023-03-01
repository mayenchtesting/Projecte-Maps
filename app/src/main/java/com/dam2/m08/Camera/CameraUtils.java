package com.dam2.m08.Camera;

import android.content.Context;
import android.util.Size;

import java.io.File;
import java.util.ArrayList;

public class CameraUtils {
    public static String FOLDER_NAME = "FotosCamera2";

    public static Size THUBNAIL_SIZE = new Size(75, 100);

    public static ArrayList<String> getImagePaths(Context context) {
        ArrayList<String> paths = new ArrayList<>();
        File file = new File(context.getExternalFilesDir(CameraUtils.FOLDER_NAME), "/");
        if (file.isDirectory()) {
            File[] fileList = file.listFiles();
            if (fileList != null) {
                for (File f : fileList) {
                    paths.add(f.getAbsolutePath());
                }
            }
        }
        paths.sort(((o1, o2) -> {
            String a = o1.substring(o1.lastIndexOf("/") + 1);
            a = a.substring(a.indexOf("_") + 1);
            String b = o2.substring(o2.lastIndexOf("/") + 1);
            b = b.substring(b.indexOf("_") + 1);
            return b.compareTo(a);
        }));
        return paths;
    }
}
