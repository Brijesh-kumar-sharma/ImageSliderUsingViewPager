package com.example.swipeimageusingviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        ImagePagerAdapter adapter = new ImagePagerAdapter();
        viewPager.setAdapter(adapter);
    }

    private class ImagePagerAdapter extends PagerAdapter {
        private int[] mImages = new int[] {
                R.drawable.processedmeat,
                R.drawable.pullups,
                R.drawable.runnig,
                R.drawable.squats
        };

        @Override
        public int getCount() {
            return mImages.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((ImageView) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Context context = MainActivity.this;
            ImageView imageView = new ImageView(context);
            int padding = context.getResources().getDimensionPixelSize(
                    R.dimen.padding_medium);
            imageView.setPadding(padding, padding, padding, padding);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setImageResource(mImages[position]);
            ((ViewPager) container).addView(imageView, 0);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((ImageView) object);
        }
    }
}