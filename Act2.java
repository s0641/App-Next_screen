package com.app.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Act2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);
        TextView tv = findViewById(R.id.textView5);
        tv.setText("Welcome ,"+getIntent().getExtras().getString("username"));

    }
}
