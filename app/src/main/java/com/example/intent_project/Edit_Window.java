package com.example.intent_project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Edit_Window extends AppCompatActivity {

    EditText editTextName, editTextFood;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_window);

        editTextName = findViewById(R.id.editTextName);
        editTextFood = findViewById(R.id.editTextFood);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(view -> {
            String newName = editTextName.getText().toString();
            String newFood = editTextFood.getText().toString();
            Intent returnIntent = new Intent();
            returnIntent.putExtra("newName", newName);
            returnIntent.putExtra("newFood", newFood);
            setResult(RESULT_OK, returnIntent);
            finish();
        });
    }
}