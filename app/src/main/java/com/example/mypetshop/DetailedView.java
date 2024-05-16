package com.example.mypetshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mypetshop.databinding.ActivityMainBinding;

public class DetailedView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detailed_view);

        // Retrieve the data passed from the previous activity
        Intent intent = getIntent();
        String selectedItemName = intent.getStringExtra("selectedItemName");
        int selectedImageResource = intent.getIntExtra("selectedItemImage", -1);
        String additionalData = intent.getStringExtra("additionalData");
        String titleData = intent.getStringExtra("titleData");

        // Use the retrieved data to populate views or perform actions
        TextView itemNameTextView = findViewById(R.id.detailTitle);
        itemNameTextView.setText(selectedItemName);

        ImageView itemImageView = findViewById(R.id.detailImg);
        itemImageView.setImageResource(selectedImageResource);

        TextView additionalDataTextView = findViewById(R.id.detailTxt);
        additionalDataTextView.setText(additionalData);

        TextView titleTxt = findViewById(R.id.title);
        titleTxt.setText(titleData);

        // Set up back button click listener
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Simulate back button press
            }
        });
    }
}

