package com.example.bytes;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AgeActivity extends AppCompatActivity {

    EditText etAge;
    Button btnAge;
    TextView tvAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_age);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etAge=findViewById(R.id.etAge);
        tvAge=findViewById(R.id.tvAge);
        btnAge.setOnClickListener(v -> {
            int age = etAge.getText().length();
            tvAge.setText("Your Age is :"+age);
            Toast.makeText(this,age,Toast.LENGTH_SHORT).show();
            etAge.setText("");
        });
    }
}