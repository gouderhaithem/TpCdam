package com.example.myapplication2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterPage extends AppCompatActivity {
    private EditText etFirstName, etLastName, etEmail, etPassword, etPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);

        Button contentButton = findViewById(R.id.contentPage);
        contentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input values
                String firstName = etFirstName.getText().toString();
                String lastName = etLastName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String phoneNumber = etPhoneNumber.getText().toString();
                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || phoneNumber.isEmpty()){
                    // First name is empty, show a popup or alert dialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterPage.this);
                    builder.setTitle("Error");
                    builder.setMessage("Please fill in all the inputs ");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // You can optionally do something when the user clicks "OK"
                        }
                    });
                    builder.show();

                }else{

                // Create an intent and pass the input values to ShowDataPage
                Intent intent = new Intent(RegisterPage.this, ShowDataPage.class);
                intent.putExtra("firstName", firstName);
                intent.putExtra("lastName", lastName);
                intent.putExtra("email", email);
                intent.putExtra("password", password);
                intent.putExtra("phoneNumber", phoneNumber);
                startActivity(intent);
                }
            }
        });
    }
}
