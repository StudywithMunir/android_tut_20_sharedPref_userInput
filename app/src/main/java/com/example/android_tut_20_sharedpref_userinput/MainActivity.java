package com.example.android_tut_20_sharedpref_userinput;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private TextView usernameTextView;
    private TextView ageTextView;
    private EditText usernameEditText, ageEditText;
    private Button showButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Step 2: Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        // Step 6: Get references to XML elements
        usernameTextView = findViewById(R.id.usernameTextView);
        ageTextView = findViewById(R.id.ageTextView);
        usernameEditText = findViewById(R.id.usernameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        showButton = findViewById(R.id.showButton);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayData();
            }
        });
    }

    private void displayData() {
        // Step 7: Displaying SharedPreferences data in XML Layout
        String username = usernameEditText.getText().toString();
        String ageText = ageEditText.getText().toString();

        // Check if the username and age are not empty
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(ageText)) {
            int age = Integer.parseInt(ageText);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", username);
            editor.putInt("age", age);
            editor.apply();

            usernameTextView.setText(username);
            ageTextView.setText(String.valueOf(age));
        }
    }
}
