package com.dam2.m08.Camera.Gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.dam2.m08.Objects.AppImage;
import com.example.projecte_maps.R;

import java.util.ArrayList;

public class GalleryPagerAdapter extends PagerAdapter {
    Context context;
    ArrayList<AppImage> images;
    LayoutInflater layoutInflater;

    public GalleryPagerAdapter(Context context, ArrayList<AppImage> images) {
        this.context = context;
        this.images = images;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        View itemView = layoutInflater.inflate(R.layout.gallery_item, container, false);
//        AppImage appimage = images.get(position);
//        ImageView imageView = itemView.findViewById(R.id.galleryImage);
//        Bitmap bitmap;
//        if (appimage.endsWith(".mp4")) {
//            ImageButton btnPlay = itemView.findViewById(R.id.btnPlay);
//            btnPlay.setVisibility(View.VISIBLE);
//            btnPlay.setOnClickListener(l -> {
//                Intent i = new Intent(context, VideoActivity.class);
//                i.putExtra("path", path);
//                context.startActivity(i);
//            });
//            bitmap = ThumbnailUtils.createVideoThumbnail(path, MediaStore.Images.Thumbnails.FULL_SCREEN_KIND);
//        } else {
//            Bitmap img = BitmapFactory.decodeFile(path);
//            Matrix matrix = new Matrix();
//            matrix.postRotate(90);
//            bitmap = Bitmap.createBitmap(img, 0, 0, img.getWidth(), img.getHeight(), matrix, true);
//        }
//        imageView.setImageBitmap(bitmap);
//        imageView.setContentDescription(path);
//        container.addView(itemView);
//        return itemView;
        return layoutInflater.inflate(R.layout.gallery_item, container, false); // borrar
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
