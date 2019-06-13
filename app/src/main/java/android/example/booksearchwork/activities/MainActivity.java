package android.example.booksearchwork.activities;

import android.content.Intent;

import android.example.booksearchwork.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button actButton1 = (Button) findViewById(R.id.button_act1);
        Button actButton2 = (Button) findViewById(R.id.button_act3);
        Button actButton3 = (Button) findViewById(R.id.button_act2);
        Button actButton4 = (Button) findViewById(R.id.button_act4);


        actButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), TopAuthorsActivity.class);
                startActivity(intent);
            }
        });

        actButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), TopBooksActivity.class);
                startActivity(intent);
            }
        });

        actButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), CitatesActivity.class);
                startActivity(intent);
            }
        });

        actButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), MainSearchActivity.class);
                startActivity(intent);
            }
        });

    }
    public void onPreferencesBtnClick (View view) {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), PreferencesListActivity.class);
        startActivity(intent);
    }
}

