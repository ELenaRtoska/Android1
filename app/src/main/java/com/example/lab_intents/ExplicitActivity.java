package com.example.lab_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExplicitActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);

        Button voRed = findViewById(R.id.pozitivno);
        Button otkazi = findViewById(R.id.negativno);


        voRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                povikajVoRed();

            }


        });

        otkazi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                povikajOtkazi();

            }
        });

    }


    private void povikajVoRed() {
        EditText vrednost = findViewById(R.id.value);
        String mVrednost = vrednost.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("extraString", mVrednost);
        startActivity(intent);
        finish();
    }

    private void povikajOtkazi() {
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
        finish();
    }
}
