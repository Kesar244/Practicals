package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class exActivity extends AppCompatActivity {

    EditText etName;
    EditText etAge;
    EditText etCno;
    EditText etPass;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ex);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etName=findViewById(R.id.etName);
        etAge=findViewById(R.id.etAge);
        etCno=findViewById(R.id.etCno);
        etPass=findViewById(R.id.etPass);
        btnNext=findViewById(R.id.btnNext);

        btnNext.setOnClickListener(v -> {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("DISPLAY")
                    .setMessage("Are You Sure?")
                    .setPositiveButton("YES",(dialog, which) -> {
                        finish();
                        Toast.makeText(this,"Yes Button Clicked",Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("NO",(dialog, which) -> {
                        Toast.makeText(this,"No Button Clicked",Toast.LENGTH_SHORT).show();
                    })
                    .show();
            String name=etName.getText().toString().trim();
            String strAge=etAge.getText().toString().trim();
            int age=Integer.parseInt(strAge);
            String strCno=etCno.getText().toString().trim();
            int cno=Integer.parseInt(strCno);
            String pass=etPass.getText().toString().trim();

            Intent i1=new Intent(this, ex2Activity.class);
            i1.putExtra("NAME",name);
            i1.putExtra("AGE",age);
            i1.putExtra("CONTACTNO",cno);
            i1.putExtra("PASSWORD",pass);
            startActivity(i1);
            finish();
        });
    }
}