package com.rujirakongsomran.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import com.rujirakongsomran.spinthebottle.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private Random random = new Random();
    private int lastDir;
    private boolean spinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //setContentView(R.layout.activity_main);

    }

    public void spinBottle(View view) {
        if (!spinning) {
            int newDir = random.nextInt(1800);
            float pivotX = binding.ivBottle.getWidth() / 2;
            float pivotY = binding.ivBottle.getHeight() / 2;

            Animation rotate = new RotateAnimation(lastDir, newDir, pivotX, pivotY);
            rotate.setDuration(2500);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            lastDir = newDir;
            binding.ivBottle.startAnimation(rotate);
        }
    }

}