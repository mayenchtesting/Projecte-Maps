package com.dam2.m08;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.media.ThumbnailUtils;
import android.util.Size;

import com.dam2.m08.Objects.AppImage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Comparator;

public class Utils {
    public static String FOLDER_NAME = "FotosCamera2";

    public static Size THUBNAIL_SIZE = new Size(75, 100);

    public static int GRID_SIZE_SMALL = 3;
    public static int GRID_SIZE_LARGE = 5;

    public static Bitmap getBitmap(String bytes) {
        return Utils.getBitmap(Base64.getDecoder().decode(bytes));
    }

    public static Bitmap getBitmap(byte[] bytes) {
        InputStream is = new ByteArrayInputStream(bytes);
        return BitmapFactory.decodeStream(is);
    }

    public static String getString(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String getString(Bitmap img) {
        return Base64.getEncoder().encodeToString(getByteArray(img));
    }

    public static byte[] getByteArray(Image img) {
        ByteBuffer buffer = img.getPlanes()[0].getBuffer();
        byte[] bytes = new byte[buffer.capacity()];
        buffer.get(bytes);
        return bytes;
    }

    public static byte[] getByteArray(Bitmap img) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        img.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    public static Bitmap getThumbnail(Bitmap image) {
        return ThumbnailUtils.extractThumbnail(image,
                Utils.THUBNAIL_SIZE.getWidth(),
                Utils.THUBNAIL_SIZE.getHeight());
    }

    public static Bitmap compress(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        int options = 100;
        while (baos.toByteArray().length / 1024 > 100) {
            baos.reset();
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);
            options -= 10;
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(
                baos.toByteArray());
        return BitmapFactory.decodeStream(isBm, null, null);
    }

    public static ArrayList<AppImage> orderAppImageList(ArrayList<AppImage> list) {
        list.sort(Comparator.comparing(AppImage::getDate).reversed());
        return list;
    }
}
