package android.example.booksearchwork.activities;

import android.example.booksearchwork.R;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class CitatesActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citates);
    }
    @Override
    public void onClick(View v) {
        v.setVisibility(View.INVISIBLE);
    }
}
