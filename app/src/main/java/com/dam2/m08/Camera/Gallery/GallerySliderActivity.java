package com.dam2.m08.Camera.Gallery;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.dam2.m08.Objects.AppImage;
import com.example.projecte_maps.R;

import java.util.ArrayList;

public class GallerySliderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_slider);
        ArrayList<AppImage> images = new ArrayList<>();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            images = (ArrayList<AppImage>) extras.get("images");
        }
        ViewPager viewPager = findViewById(R.id.galleryViewPager);
        GalleryPagerAdapter viewPagerAdapter = new GalleryPagerAdapter(this, images);
        viewPager.setAdapter(viewPagerAdapter);
        findViewById(R.id.btnBack).setOnClickListener(l -> finish());
    }
}
