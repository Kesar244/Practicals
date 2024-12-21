package com.example.intent;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AlertDialogActivity2 extends AppCompatActivity {

    Button btnShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alert_dialog2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnShow=findViewById(R.id.btnShow);
        btnShow.setOnClickListener(v ->{
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("EXIT")
                    .setMessage("Are You Sure?")
                    .setPositiveButton("YES",(dialog, which) -> {
                        finish();
                        Toast.makeText(this,"Yes Button Clicked",Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("NO",(dialog, which) -> {
                        Toast.makeText(this,"No Button Clicked",Toast.LENGTH_SHORT).show();
                    })
                    .show();
        });
    }
}