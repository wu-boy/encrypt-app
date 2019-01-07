package com.wu.encryptapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.apache.shiro.crypto.hash.Sha256Hash;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    void init(){
        final TextView firstNameTextView = findViewById(R.id.et_first_name);
        final TextView lastNameTextView = findViewById(R.id.et_last_name);
        final TextView passwordTextView = findViewById(R.id.et_password);
        final TextView passTextView = findViewById(R.id.et_pass);
        Button btn = findViewById(R.id.btn_encrypt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameTextView.getText().toString();
                String lastName = lastNameTextView.getText().toString();
                String password = passwordTextView.getText().toString();
                Sha256Hash sha256Hash = new Sha256Hash(firstName + lastName + password);
                passTextView.setText(sha256Hash.toHex());
            }
        });

    }
}
