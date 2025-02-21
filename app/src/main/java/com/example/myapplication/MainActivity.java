package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void login(View view){
        Intent next = new Intent(this, MainActivity2.class);
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        String user = username.getText().toString();
        String pw = password.getText().toString();

        if (!user.equals("Aprek") || !pw.equals("Aprek123")) {
            Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show();
            return;
        }
        next.putExtra("user_name", user);
        next.putExtra("pw", pw);
        startActivity(next);
    }
}