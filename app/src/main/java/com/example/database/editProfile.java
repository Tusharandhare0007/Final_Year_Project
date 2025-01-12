package com.example.database;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class editProfile extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_edit_profile);

            ListView listView = findViewById(R.id.listView);
            TextView tvSelectedItem = findViewById(R.id.tvSelectedItem);

            // Array of items to display in the ListView
            String[] languages = {"English", "Hindi"};

            // ArrayAdapter to bind data to the ListView
            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1, // Predefined layout for list items
                    languages
            );

            listView.setAdapter(adapter);

            // Set listener for item clicks
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String selectedItem = languages[position];
                    tvSelectedItem.setText("Selected language: " + selectedItem);
                }
            });
        }
    }

}
