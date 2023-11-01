package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ShowDataPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_second);

        // Receive the input values from the intent
        String firstName = getIntent().getStringExtra("firstName");
        String lastName = getIntent().getStringExtra("lastName");
        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");
        String phoneNumber = getIntent().getStringExtra("phoneNumber");

        // Find the TextView in content_second.xml and set the text
        TextView textView = findViewById(R.id.textFullName);
        textView.setText(" "+firstName + " " + lastName);
        TextView textView2 = findViewById(R.id.textEmail);
        textView2.setText(" "+email);
        TextView textView3 = findViewById(R.id.textPhone);
        textView3.setText(" "+phoneNumber);
        Button returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // When the "Register" button is clicked, navigate to ActivitySecond
                Intent intent = new Intent(ShowDataPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
