package com.example.volumeareaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Prism extends AppCompatActivity {

    EditText prism_length, prism_height, prism_width;
    TextView title, result;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prism);

        prism_length = findViewById(R.id.editText_prism);
        prism_height = findViewById(R.id.editText_prism_height);
        prism_width = findViewById(R.id.editText_prism_width);
        title = findViewById(R.id.textViewPrism2);
        result = findViewById(R.id.textViewPrism3);
        btn = findViewById(R.id.btnCube1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String length = prism_length.getText().toString();
                String height = prism_height.getText().toString();
                String width = prism_width.getText().toString();

                int l = Integer.parseInt(length);
                int h = Integer.parseInt(height);
                int w = Integer.parseInt(width);

                // V = l * h * w

                double volume = l * h * w;
                result.setText("V = " + volume + " m^3");
            }
        });
    }
}