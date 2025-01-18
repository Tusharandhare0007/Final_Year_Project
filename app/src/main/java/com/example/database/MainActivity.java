package com.example.database;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etEmailContact, etPassword, etBirthdate;
    private Spinner spinnerRole, spinnerLanguage;
    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        etEmailContact = findViewById(R.id.etEmailContact);
        etPassword = findViewById(R.id.etPassword);
        etBirthdate = findViewById(R.id.etBirthdate);
        spinnerRole = findViewById(R.id.spinnerRole);
        spinnerLanguage = findViewById(R.id.spinnerLanguage);
        btnSignIn = findViewById(R.id.btnSignIn);

        // Set button click listener
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmailContact.getText().toString();
                String password = etPassword.getText().toString();
                String birthdate = etBirthdate.getText().toString();
                String role = spinnerRole.getSelectedItem().toString();
                String language = spinnerLanguage.getSelectedItem().toString();

                // Simple validation
                if (email.isEmpty() || password.isEmpty() || birthdate.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Signed Up Successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}