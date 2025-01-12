package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText email, pass;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.proceedButton);
        email = findViewById(R.id.emailInput);
        pass = findViewById(R.id.passwordInput);

        // Open or create the database
        db = openOrCreateDatabase("myDB", Context.MODE_PRIVATE, null);

        // Create the table if it does not exist
        db.execSQL("CREATE TABLE IF NOT EXISTS register (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "email VARCHAR(500) NOT NULL, " +
                "pass VARCHAR(500) NOT NULL)");

        // Set the button's onClickListener
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = email.getText().toString().trim();
                String str2 = pass.getText().toString().trim();

                // Validate inputs
                if (!isValidEmail(str1)) {
                    Toast.makeText(MainActivity.this, "Invalid Email Address!", Toast.LENGTH_SHORT).show();
                } else if (!isValidPassword(str2)) {
                    Toast.makeText(MainActivity.this, "Password must be at least 6 alphabetic characters, " +
                            "contain at least 1 special character, and 1 number!", Toast.LENGTH_LONG).show();
                } else {
                    // Insert into the database
                    ContentValues cv1 = new ContentValues();
                    cv1.put("email", str1);
                    cv1.put("pass", str2);

                    long result = db.insert("register", null, cv1);

                    if (result == -1) {
                        Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                    }

                    // Clear the input fields after registration
                    email.setText("");
                    pass.setText("");
                }
            }
        });
    }

    // Helper method to validate email
    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    // Helper method to validate password
    private boolean isValidPassword(String password) {
        // Regex for password: At least 6 alphabetic characters, 1 special character, and 1 number
        String passwordRegex = "^(?=.*[0-9])(?=.*[@#$%^&+=!])(?=.*[a-zA-Z].*[a-zA-Z].*[a-zA-Z].*[a-zA-Z].*[a-zA-Z].*[a-zA-Z])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        return pattern.matcher(password).matches();
    }
}
