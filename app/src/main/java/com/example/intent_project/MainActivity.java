package com.example.intent_project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    static final int EDIT_REQUEST = 1;
    private TextView textName, textFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName = findViewById(R.id.textName);
        textFood = findViewById(R.id.textFood);
        Button btnEdit = findViewById(R.id.btnEdit);

        btnEdit.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Edit_Window.class);
            startActivityForResult(intent, EDIT_REQUEST);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EDIT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String newName = data.getStringExtra("newName");
                String newFood = data.getStringExtra("newFood");
                textName.setText(newName);
                textFood.setText(newFood);
            }
        }
    }
}