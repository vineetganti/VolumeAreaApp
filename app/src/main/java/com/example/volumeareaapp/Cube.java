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

public class Cube extends AppCompatActivity {

    EditText cube_side;
    TextView title, result;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);

        cube_side = findViewById(R.id.editText_cube);
        title = findViewById(R.id.textViewCube2);
        result = findViewById(R.id.textViewCube3);
        btn = findViewById(R.id.btnCube1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String side = cube_side.getText().toString();

                int s = Integer.parseInt(side);

                // V = s^3

                double volume = s * s * s;
                result.setText("V = " + volume + " m^3");
            }
        });
    }
}