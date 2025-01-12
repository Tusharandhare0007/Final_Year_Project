package com.example.database;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ProfileActivity extends Activity {

    // Declare UI components
    private ImageView profileImage;
    private EditText nameInput, educationInput, skillsInput, experienceInput;
    private LinearLayout resumeLayout;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_creation);

        // Initialize UI components
        profileImage = findViewById(R.id.profileImage);
        nameInput = findViewById(R.id.nameInput);
        educationInput = findViewById(R.id.educationInput);
        skillsInput = findViewById(R.id.skillsInput);
        experienceInput = findViewById(R.id.experienceInput);
        resumeLayout = findViewById(R.id.resumeLayout);
        nextButton = findViewById(R.id.nextButton);

        // Set profile image click listener
        profileImage.setOnClickListener(v -> {
            // Simulate selecting a profile picture
            Toast.makeText(ProfileActivity.this, "Profile image clicked!", Toast.LENGTH_SHORT).show();
        });

        // Set resume upload click listener
        resumeLayout.setOnClickListener(v -> {
            // Simulate uploading a resume
            Toast.makeText(ProfileActivity.this, "Resume upload functionality", Toast.LENGTH_SHORT).show();
        });

        // Set next button click listener
        nextButton.setOnClickListener(v -> {
            // Collect user input
            String name = nameInput.getText().toString().trim();
            String education = educationInput.getText().toString().trim();
            String skills = skillsInput.getText().toString().trim();
            String experience = experienceInput.getText().toString().trim();

            // Validate input
            if (name.isEmpty() || education.isEmpty() || skills.isEmpty() || experience.isEmpty()) {
                Toast.makeText(ProfileActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                // Navigate to the next activity or perform the desired action
                Intent intent = new Intent(ProfileActivity.this, NextActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("education", education);
                intent.putExtra("skills", skills);
                intent.putExtra("experience", experience);
                startActivity(intent);
            }
        });
    }
}
