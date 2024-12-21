package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ex2Activity extends AppCompatActivity {

    TextView tvName;
    TextView tvAge;
    TextView tvCno;
    TextView tvPass;
    Button btnPrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ex2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //int i=getIntent().getIntExtra("AGE",0);

        tvName=findViewById(R.id.tvName);
        tvAge=findViewById(R.id.tvAge);
        tvCno=findViewById(R.id.tvCno);
        tvPass=findViewById(R.id.tvPass);
        btnPrev=findViewById(R.id.btnPrev);

        Intent i2=getIntent();
        tvName.setText(i2.getStringExtra("NAME"));
        tvAge.setText(i2.getIntExtra("AGE",0)+"");
        tvCno.setText(i2.getIntExtra("CONTACTNO",0)+"");
        tvPass.setText(i2.getStringExtra("PASSWORD"));

        btnPrev.setOnClickListener(v -> {
            Intent intent=new Intent(this, exActivity.class);
            startActivity(intent);
        });
    }
}