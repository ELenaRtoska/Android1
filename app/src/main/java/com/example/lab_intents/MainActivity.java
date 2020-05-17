package com.example.lab_intents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mPrikaz = findViewById(R.id.prikazhiVrednost);
        Button btn1 = findViewById(R.id.btnOne);
        Button btn2 = findViewById(R.id.btnTwo);
        Button btn3 = findViewById(R.id.btnThree);
        Button btn4 = findViewById(R.id.btnFour);


        //ZA PRVOTO KOPCE:
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExplicitIntent();
            }
        });
        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            if (extra != null) {
                String extraVrednost = extra.getString("extraString");
                mPrikaz.setText(extraVrednost);

            } else {
                Toast.makeText(this, "Nema vrednost!!!", Toast.LENGTH_SHORT).show();
            }


            //ZA VTOROTO KOPCE:
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openImplicitIntent();
                }
            });

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    metodTri();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    metodCetiri();
                }
            });


        }
    }

    private void metodCetiri() {
        Intent firstIntent = new Intent(Intent.ACTION_GET_CONTENT);
        firstIntent.setType("image/*");
        Intent secondIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        secondIntent.setType("image/*");

        Intent threeIntent = Intent.createChooser(firstIntent, "Chose image");
        threeIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{secondIntent});

        startActivity(threeIntent);
    }

    private void metodTri() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TITLE, "MPiP Send Title");
        intent.putExtra(Intent.EXTRA_TEXT, "Content sent from MainActivity ");
        startActivity(intent);
    }


    private void openExplicitIntent() {
        Intent prvIntent = new Intent(this, ExplicitActivity.class);
        startActivity(prvIntent);
        finish();
    }

    private void openImplicitIntent() {
        Intent intent = new Intent();
        intent.setAction("com.example.lab_intents.IMPLICIT_ACTION");
        intent.setType("text/plain");
        startActivity(intent);
    }
}
