package com.longthien.test_interface.demo_edit_text;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.longthien.test_interface.R;

public class ContainerActivity extends AppCompatActivity implements OnValidateListener {

    FragmentEditText fragmentEditText;
    TextView tvStatus;
    ImageView checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        fragmentEditText = FragmentEditText.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_edit_text, fragmentEditText)
                .commit();
        fragmentEditText.setOnValidationListener(this);

        tvStatus = findViewById(R.id.tv_status);
        checkbox = findViewById(R.id.img_checkbox);

        Button btnValidate = findViewById(R.id.btn_validate);
        btnValidate.setOnClickListener(v -> {
            fragmentEditText.validateInput(tvStatus, checkbox);
        });
    }

    @Override
    public void onValidated(boolean isValid) {
        if (isValid) {
            tvStatus.setText("Input Validate!");
            tvStatus.setTextColor(Color.GREEN);
            checkbox.setImageResource(R.drawable.baseline_check);
            Log.d("True", "onValidated: true");
        } else {
            tvStatus.setText("Input Invalidate!");
            tvStatus.setTextColor(Color.RED);
            checkbox.setImageResource(R.drawable.baseline_clear_24);
            Log.d("True", "onValidated: false");

        }
    }
}
