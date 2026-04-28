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

public class Cylinder extends AppCompatActivity {

    EditText cylinder_radius, cylinder_height;
    TextView title, result;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder);

        cylinder_radius = findViewById(R.id.editText_cylinder);
        cylinder_height = findViewById(R.id.editText_cylinder_height);
        title = findViewById(R.id.textViewCylinder2);
        result = findViewById(R.id.textViewCylinder3);
        btn = findViewById(R.id.btnCube1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius = cylinder_radius.getText().toString();
                String height = cylinder_height.getText().toString();

                int r = Integer.parseInt(radius);
                int h = Integer.parseInt(height);

                // V = pi * r^2 * h

                double volume = 3.14159 * r * r * h;
                result.setText("V = " + volume + " m^3");
            }
        });
    }
}