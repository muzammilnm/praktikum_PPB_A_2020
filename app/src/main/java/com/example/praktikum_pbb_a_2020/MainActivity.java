package com.example.praktikum_pbb_a_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_p1 = findViewById(R.id.btn_p1);
        btn_p1.setOnClickListener(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_p1:
                Intent pertemuan1 = new Intent(MainActivity.this, pertemuan1_activity.class);
                startActivity(pertemuan1);
                break;
        }
    }


}
