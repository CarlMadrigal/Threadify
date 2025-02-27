package org.mobileapp.madrigalgeroleovalenzuela.threed.gcash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    TextView login;
    EditText fullname, username, password, confirm_password;
    Button register;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        login = findViewById(R.id.loginBtn);
        fullname = findViewById(R.id.fullnameRegisterFld);
        username = findViewById(R.id.usernameRegisterFld);
        password = findViewById(R.id.passwordRegisterFld);
        confirm_password = findViewById(R.id.confirmpasswordRegisterFld);
        register = findViewById(R.id.registerBtn);
        db = new DatabaseHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(toLogin);
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }

    public void registerUser() {
        String full_name = fullname.getText().toString();
        String user_name = username.getText().toString().trim();
        String user_password = password.getText().toString().trim();
        String confirm_pass = confirm_password.getText().toString().trim();

        if (full_name.isEmpty() || user_name.isEmpty() || user_password.isEmpty() || confirm_pass.isEmpty()){
            Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!user_password.equals(confirm_pass)) {
            Toast.makeText(this, "Passwords do not match. Please re-enter.", Toast.LENGTH_SHORT).show();
            password.setText("");
            confirm_password.setText("");
            return;
        }


        if (db.addUser(full_name, user_name, user_password)){
            Intent toLogin = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(toLogin);
            finish();
        }



    }
}