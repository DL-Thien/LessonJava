package com.longthien.lesson.Homework;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.longthien.lesson.R;

import java.util.Random;

public class HolderActivity extends AppCompatActivity {

    int width = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holder);

        View view1 = findViewById(R.id.view_1);
        ImageView iconTriangle = findViewById(R.id.iconTriangle);
        Button btnRandom = findViewById(R.id.btnRandom);

        btnRandom.setOnClickListener(view -> {
            Random random = new Random();
            int randomX = random.nextInt(101);
            iconTriangle.setTranslationX((float) (randomX * width) / 100);
            Log.d("Thienaaaa", "onCreate: " + width);
            Log.d("Thienaaaa", "onCreate: " + randomX);
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View view1 = findViewById(R.id.view_1);
        width = view1.getWidth();
        Log.d("Thienaaaa", "onWindowFocusChanged: " + width);
    }
}
