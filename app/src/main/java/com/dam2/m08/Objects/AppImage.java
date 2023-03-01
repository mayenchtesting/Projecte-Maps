package com.dam2.m08.Objects;

import android.graphics.Bitmap;
import android.location.Location;

import java.time.LocalDateTime;

public class AppImage {
    private String id;
    private Bitmap image;
    private Bitmap tumbnail;
    private Location location;
    private LocalDateTime date;

    public AppImage() {
    }

    public AppImage(String id, Bitmap image, Bitmap tumbnail, Location location, LocalDateTime date) {
        this.id = id;
        this.image = image;
        this.tumbnail = tumbnail;
        this.location = location;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Bitmap getTumbnail() {
        return tumbnail;
    }

    public void setTumbnail(Bitmap tumbnail) {
        this.tumbnail = tumbnail;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
