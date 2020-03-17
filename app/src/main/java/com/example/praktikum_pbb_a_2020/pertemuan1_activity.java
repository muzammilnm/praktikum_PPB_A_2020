package com.example.praktikum_pbb_a_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class pertemuan1_activity extends AppCompatActivity implements View.OnClickListener {

    private EditText Et_tb, Et_bb, Et_name;
    private Button Btn_c;
    private TextView Tv_hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertemuan1_activity);

        Et_tb = findViewById(R.id.et_TB);
        Et_bb = findViewById(R.id.et_BB);
        Et_name = findViewById(R.id.et_name);
        Tv_hasil = findViewById(R.id.txt_hasil);
        Btn_c = findViewById(R.id.btn_klik);

        Btn_c.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_klik){
            String input_name = Et_name.toString().trim();
            String input_tb = Et_tb.toString().trim();
            String input_bb = Et_bb.toString().trim();

            Boolean isEmpttField = false;

            if(TextUtils.isEmpty(input_name)){
                isEmpttField = true;
                Et_name.setError("inputan ini tidak boleh kosong");
            }

            if(TextUtils.isEmpty(input_tb)){
                isEmpttField = true;
                Et_tb.setError("inputan ini tidak boleh kosong");
            }

            if(TextUtils.isEmpty(input_bb)){
                isEmpttField = true;
                Et_bb.setError("inputan ini tidak boleh kosong");
            }

            if(!isEmpttField){
                String category = "";
                Double ttb = toDouble(Et_tb.getText().toString());
                Double tbb = toDouble(Et_bb.getText().toString());
                Double has = ttb/tbb*ttb;

                if(has < 18.5){
                    category = "Underweight";
                }
                else if(has >= 18.5 && has <= 24.9){
                    category = "Normalweight";
                }
                else if(has >= 30 && has <= 34.9){
                    category = "Obesity 1";
                }
                else if(has >= 35 && has <= 39.9){
                    category = "Obesity 2";
                }
                else if(has >= 40){
                    category = "Obesity 3";
                }

                Tv_hasil.setText("nama : " + Et_name.getText().toString() + " dengan BMI : " + has.toString() + " Category " + category);
            }
        }
    }

    private Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        }catch (NumberFormatException e){
            return  null;
        }
    }
}
